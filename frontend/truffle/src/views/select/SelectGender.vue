<template>
  <div class="gender">
    <div class="tabs">
      <input id="gd1" type="radio" value="1" v-model="gender" @change="selectGender" checked />
      <!--디폴트 메뉴-->
      <label for="gd1">남성에게 인기많은</label>

      <input id="gd2" v-model="gender" type="radio" @change="selectGender" value="2" />
      <label for="gd2">여성에게 인기많은</label>

      <div id="gendercontent1" class="section">
        <div class="event-index" v-for="(event, idx) in GenderArray" ref="GenderArray" :key="idx">
          <div class="card">
            <div class="idx-box">{{ idx + 1 }}위</div>
            <figure>
              <img src="@/assets/img/women.jpg" alt="" />
              <img class="detail-image" :src="'data:image/jpeg;base64,' + detailImg" alt="" />
            </figure>

            <section class="details">
              <div class="product-detail">
                <div class="product">{{ event.product }}</div>
                <div class="price">{{ priceComma[idx] }}원</div>
              </div>
              <div class="min-details">
                <div>
                  <span>#{{ event.category }}</span>
                  <span v-show="event.gender == 1" outlined>#남성</span>
                  <span v-show="event.gender == 2" outlined>#여성</span>
                  <span>#{{ event.age }}대</span>
                </div>
                <div>
                  <v-chip color="#3D5AFE" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
                </div>
                <div>
                  <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
                </div>
                <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">응모현황</a>
              </div>
            </section>
          </div>
        </div>
      </div>

      <div id="gendercontent2" class="section">
        <div class="event-index" v-for="(event, idx) in GenderArray" ref="GenderArray" :key="idx">
          <div class="card">
            <div class="idx-box">{{ idx + 1 }}위</div>
            <figure>
              <img src="@/assets/img/women.jpg" alt="" />
              <img class="detail-image" :src="'data:image/jpeg;base64,' + detailImg" alt="" />
            </figure>

            <section class="details">
              <div class="product-detail">
                <div class="product">{{ event.product }}</div>
                <div class="price">{{ priceComma[idx] }}원</div>
              </div>
              <div class="min-details">
                <div>
                  <span>#{{ event.category }}</span>
                  <span v-show="event.gender == 1" outlined>#남성</span>
                  <span v-show="event.gender == 2" outlined>#여성</span>
                  <span>#{{ event.age }}대</span>
                </div>
                <div>
                  <v-chip color="#3D5AFE" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
                </div>
                <div>
                  <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
                </div>
                <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">응모현황</a>
              </div>
            </section>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { eventSelectGender } from '@/api/event';
export default {
  data() {
    return {
      gender: '',
      GenderArray: [],
      detailImg: '',
    };
  },
  computed: {
    priceComma: function() {
      return this.GenderArray.map(function(event) {
        return event.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      });
    },
  },
  async created() {
    const gender = '1';
    // console.log('성별확인', gender);
    const { data } = await eventSelectGender(gender);
    console.log('응답데이터', data);
    var GenderArray = data;
    GenderArray.sort(function(a, b) {
      if (a.join_num > b.join_num) {
        return 1;
      }
      if (a.join_num < b.join_num) {
        return -1;
      }
      return 0;
    });
    GenderArray.reverse();
    this.GenderArray = GenderArray.slice(0, 4);
    console.log('성별', this.GenderArray);
    $('#gendercontent1').addClass('display');
  },
  methods: {
    async selectGender() {
      $('#gendercontent1').removeClass('display');
      const gender = this.gender;
      // console.log('성별확인', gender);
      const { data } = await eventSelectGender(gender);
      console.log('응답데이터', data);
      var GenderArray = data;
      GenderArray.sort(function(a, b) {
        if (a.join_num > b.join_num) {
          return 1;
        }
        if (a.join_num < b.join_num) {
          return -1;
        }
        return 0;
      });
      GenderArray.reverse();
      this.GenderArray = GenderArray.slice(0, 4);
      console.log('성별', this.GenderArray);
    },
    eventDetailGo(event_id) {
      this.$router.push({ name: 'EventDetail', query: { event_id: event_id } });
    },
  },
};
</script>

<style scoped>
p {
  margin: 0 0 20px;
  line-height: 1.5;
}

.tabs {
  min-width: 100%;
  max-width: 100%;
  padding: 50px;
  margin: 0 auto;
  background: #ffffff;
}

.section {
  display: none;
  padding: 20px 0 0;
  border-top: 1px solid #ddd;
  margin-bottom: 200px;
}
.display {
  display: flex !important;
  justify-content: center !important;
  align-items: center !important;
  flex-wrap: wrap !important;
}

/*라디오버튼 숨김*/
input {
  display: none;
}

label {
  display: inline-block;
  margin: 0 0 -1px;
  padding: 15px 25px;
  font-weight: 600;
  text-align: center;
  color: #bbb;
  border: 1px solid transparent;
}

label:hover {
  color: #2e9cdf;
  cursor: pointer;
}

/*input 클릭시, label 스타일*/
input:checked + label {
  color: #555;
  border: 1px solid #ddd;
  border-top: 2px solid #f3118e;
  border-bottom: 1px solid #ffffff;
}

#gd1:checked ~ #gendercontent1,
#gd2:checked ~ #gendercontent2 {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}

.event {
  width: 15vw;
  margin-bottom: 50px;
  display: inline-table;
}
.event-index {
  display: flex;
  align-items: center;
  min-height: auto;
  font-family: 'Poppins', sans-serif;
}
h1 {
  font-size: 1.2rem;
  text-transform: capitalize;
}

.card {
  margin-right: 20px;
  position: relative;
  border-radius: 5px;
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3);
  height: 400px;
  overflow: hidden;
  width: 280px;
}
.card > figure {
  width: 90%;
  margin: 20px auto 0 auto;
}
.card > .idx-box {
  background: #000;
  color: #fff;
  text-align: center;
}
.card > figure > img {
  width: 100%;
}
.details {
  background-color: #fff;
  border-radius: 10px;
  padding: 20px;
  position: absolute;
  top: 60%;
  width: 100%;
  transition: box-shadow 0.3s ease-in-out, top 0.3s ease-in-out;
}
.card:hover .details {
  box-shadow: 0 -5px 10px rgba(0, 0, 0, 0.3);
  top: 30%;
}
.details > .min-details,
.details > .options,
.details > .options > .options-colors {
  margin: 5px 0;
}
.details > .min-details {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  font-weight: 900;
  font-size: 1rem;
}

.details > .options h1 {
  margin-bottom: 10px;
}
.details > .options-size {
  display: flex;

  justify-content: center;
  align-items: center;
}

.btn {
  background-color: #f3118e;
  border-radius: 5px;
  color: #fff;
  display: block;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  text-transform: capitalize;
  width: 100%;
  padding-bottom: 10px;
  transition: box-shadow 0.3s ease-in-out, transform 0.3s ease-in-out;
}
.btn:hover {
  box-shadow: 0 8px 10px rgba(0, 0, 0, 0.3);
  transform: translateY(-2px);
}
.product-detail > .product {
  margin: 3px 0;
  font-size: 1.5rem;
  font-weight: 900;
}
.product-detail > .price {
  display: flex;
  font-weight: 900;
  font-size: 1rem;
  color: #256eff;
  flex-direction: row-reverse;
}
</style>

<template>
  <div class="age">
    <div class="tabs">
      <input id="age1" type="radio" name="tabs" value="10" v-model="age" @change="selectAge" checked="checked" />
      <label for="age1">10대</label>

      <input id="age2" v-model="age" type="radio" @change="selectAge" value="20" name="tabs" />
      <label for="age2">20대</label>

      <input id="age3" v-model="age" type="radio" @change="selectAge" value="30" name="tabs" />
      <label for="age3">30대</label>

      <input id="age4" v-model="age" type="radio" value="40" @change="selectAge" name="tabs" />
      <label for="age4">40대</label>

      <input id="age5" v-model="age" type="radio" value="50" @change="selectAge" name="tabs" />
      <label for="age5">50대</label>

      <input id="age6" v-model="age" type="radio" value="60" @change="selectAge" name="tabs" />
      <label for="age6">60대이상</label>

      <div class="tab-content">
        <div id="agecontent1" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" ref="AgeArray" :key="idx">
            <div class="card">
              <div class="idx-box">{{ idx + 1 }}위</div>
              <figure>
                <img class="detail-image" :src="imgURL + event.event_id" />
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
                    <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
                  </div>
                  <div>
                    <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
                  </div>
                  <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
                </div>
              </section>
            </div>
          </div>
        </div>

        <div id="agecontent2" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" ref="AgeArray" :key="idx">
            <div class="card">
              <div class="idx-box">{{ idx + 1 }}위</div>
              <figure>
                <img class="detail-image" :src="imgURL + event.event_id" />
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
                    <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
                  </div>
                  <div>
                    <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
                  </div>
                  <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
                </div>
              </section>
            </div>
          </div>
        </div>

        <div id="agecontent3" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" ref="AgeArray" :key="idx">
            <div class="card">
              <div class="idx-box">{{ idx + 1 }}위</div>
              <figure>
                <img class="detail-image" :src="imgURL + event.event_id" />
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
                    <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
                  </div>
                  <div>
                    <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
                  </div>
                  <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
                </div>
              </section>
            </div>
          </div>
        </div>

        <div id="agecontent4" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" ref="AgeArray" :key="idx">
            <div class="card">
              <div class="idx-box">{{ idx + 1 }}위</div>
              <figure>
                <img class="detail-image" :src="imgURL + event.event_id" />
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
                    <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
                  </div>
                  <div>
                    <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
                  </div>
                  <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
                </div>
              </section>
            </div>
          </div>
        </div>
        <div id="agecontent5" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" ref="AgeArray" :key="idx">
            <div class="card">
              <div class="idx-box">{{ idx + 1 }}위</div>
              <figure>
                <img class="detail-image" :src="imgURL + event.event_id" />
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
                    <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
                  </div>
                  <div>
                    <div style="margin-top:20px;">이벤트종료일:{{ event.end_date }}</div>
                  </div>
                  <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
                </div>
              </section>
            </div>
          </div>
        </div>
        <div id="agecontent6" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" ref="AgeArray" :key="idx">
            <div class="card">
              <div class="idx-box">{{ idx + 1 }}위</div>
              <figure>
                <img class="detail-image" :src="imgURL + event.event_id" />
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
                    <v-chip style="background-color:#07b8ac;" class="join-win" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
                  </div>
                  <div>
                    <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
                  </div>
                  <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
                </div>
              </section>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { eventSelectAge } from '@/api/event';
export default {
  data() {
    return {
      age: '',
      AgeArray: [],
      imgURL: 'https://j4d110.p.ssafy.io/truffle/event/selectEventImgFileEventID?event_id=',
    };
  },
  computed: {
    priceComma: function() {
      return this.AgeArray.map(function(event) {
        return event.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      });
    },
  },
  async created() {
    const age = 10;
    // console.log('나이확인', age, '대');
    const { data } = await eventSelectAge(age);
    // console.log('응답데이터', data);
    var AgeArray = data;
    AgeArray.sort(function(a, b) {
      if (a.join_num > b.join_num) {
        return 1;
      }
      if (a.join_num < b.join_num) {
        return -1;
      }
      return 0;
    });
    AgeArray.reverse();
    const newAgeArray = [];
    for (let i = 0; i < AgeArray.length; i++) {
      if (new Date(AgeArray[i].end_date) < Date.now()) {
        continue;
      } else {
        newAgeArray.push(AgeArray[i]);
      }
    }
    this.AgeArray = newAgeArray.slice(0, 4);
    // console.log('나이', this.AgeArray);
    $('#agecontent1').addClass('display');
  },
  methods: {
    async selectAge() {
      $('#agecontent1').removeClass('display');
      const age = this.age;
      // console.log('나이확인', age, '대');
      const { data } = await eventSelectAge(age);
      // console.log('응답데이터', data);
      var AgeArray = data;
      AgeArray.sort(function(a, b) {
        if (a.join_num > b.join_num) {
          return 1;
        }
        if (a.join_num < b.join_num) {
          return -1;
        }
        return 0;
      });
      AgeArray.reverse();
      const newAgeArray = [];
      for (let i = 0; i < AgeArray.length; i++) {
        if (new Date(AgeArray[i].end_date) < Date.now()) {
          continue;
        } else {
          newAgeArray.push(AgeArray[i]);
        }
      }
      this.AgeArray = newAgeArray.slice(0, 4);
      // console.log('나이', this.AgeArray);
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
  margin: 0;
  background: #ffffff;
}

.section {
  display: none;
  padding: 20px 0 0;
  border-top: 1px solid #ddd;
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

.tabs #age1:checked ~ .tab-content #agecontent1,
.tabs #age2:checked ~ .tab-content #agecontent2,
.tabs #age3:checked ~ .tab-content #agecontent3,
.tabs #age4:checked ~ .tab-content #agecontent4,
.tabs #age5:checked ~ .tab-content #agecontent5,
.tabs #age6:checked ~ .tab-content #agecontent6 {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}
.tabs .tab-content #agecontent1,
.tabs .tab-content #agecontent2,
.tabs .tab-content #agecontent3,
.tabs .tab-content #agecontent4,
.tabs .tab-content #agecontent5,
.tabs .tab-content #agecontent6 {
  display: none;
}
.display {
  display: flex !important;
  justify-content: center !important;
  align-items: center !important;
  flex-wrap: wrap !important;
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
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.product-detail > .price {
  display: flex;
  font-weight: 900;
  font-size: 1rem;
  color: #256eff;
  flex-direction: row-reverse;
}
</style>

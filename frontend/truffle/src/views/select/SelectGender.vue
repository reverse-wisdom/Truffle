<template>
  <div class="gender">
    <div class="tabs">
      <input id="gd1" type="radio" value="1" v-model="gender" @change="selectGender" checked />
      <!--디폴트 메뉴-->
      <label for="gd1">남성에게 인기많은</label>

      <input id="gd2" v-model="gender" type="radio" @change="selectGender" value="2" />
      <label for="gd2">여성에게 인기많은</label>

      <div id="content1" class="section">
        <div class="event-index" v-for="(event, idx) in GenderArray" :key="idx">
          <div class="card">
            <figure>
              <img src="@/assets/img/women.jpg" alt="" />
            </figure>
            <section class="details">
              <div class="min-details">
                <h1>
                  {{ event.product }}
                  <span>카테고리:{{ event.category }}</span>
                  <span>성별:{{ event.gender }}</span>
                  <span>연령대:{{ event.age }}</span>
                </h1>
                <h1 class="price">{{ event.price }}</h1>
              </div>
              <div class="options">
                <div class="options-size">
                  <h1 class="">응모자수:{{ event.join_num }}</h1>
                </div>
                <div class="options-colors">
                  <h1>마감일:{{ event.end_date }}</h1>
                </div>
              </div>
              <a href="#" class="btn" @click="eventDetailGo">응모현황</a>
            </section>
          </div>
        </div>
      </div>

      <div id="content2" class="section">
        <div class="event-index" v-for="(event, idx) in GenderArray" :key="idx">
          <div class="card">
            <figure>
              <img src="@/assets/img/women.jpg" alt="" />
            </figure>
            <section class="details">
              <div class="min-details">
                <h1>
                  {{ event.product }}
                  <span>카테고리:{{ event.category }}</span>
                  <span>성별:{{ event.gender }}</span>
                  <span>연령대:{{ event.age }}</span>
                </h1>
                <h1 class="price">{{ event.price }}</h1>
              </div>
              <div class="options">
                <div class="options-size">
                  <h1 class="">응모자수:{{ event.join_num }}</h1>
                </div>
                <div class="options-colors">
                  <h1>마감일:{{ event.end_date }}</h1>
                </div>
              </div>
              <a href="#" class="btn" @click="eventDetailGo">응모현황</a>
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
    };
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
    $('#content1').addClass('display');
  },
  methods: {
    async selectGender() {
      $('#content1').removeClass('display');
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
    eventDetailGo() {},
  },
};
</script>

<style scoped>
.gender {
  /* color: #555; */
  /* background: #eeeeee; */
}

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
  border-top: 2px solid #2e9cdf;
  border-bottom: 1px solid #ffffff;
}

#gd1:checked ~ #content1,
#gd2:checked ~ #content2 {
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
  /* justify-content: space-around; */
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
  margin-bottom: 10px;
}
.details > .min-details {
  display: flex;
  justify-content: space-between;
}
.details > .min-details > h1 > span {
  color: #7b7b7b;
  display: block;
  font-size: 0.9rem;
  font-weight: 400;
}
.details > .options h1 {
  margin-bottom: 5px;
}
.details > .options ul {
  list-style-type: none;
  display: flex;
}
.details > .options ul li {
  border-radius: 50%;
  cursor: pointer;
  height: 20px;
  line-height: 30px;
  margin-left: 5px;
  text-align: center;
  width: 30px;
}
.options-size > ul > li {
  background-color: rgba(0, 0, 0, 0.3);
  color: #000;
  font-size: 0.7rem;
  font-weight: 900;
  text-transform: uppercase;
  transition: background-color 0.3s ease-in-out;
}
.options-size > ul > li:hover {
  background-color: #192a56;
}
.options-colors > ul > li {
  border: none;
}
.options-colors > ul > li:nth-child(1) {
  background-color: #ff1;
}
.options-colors > ul > li:nth-child(2) {
  background-color: #000;
}
.options-colors > ul > li:nth-child(3) {
  background-color: #fb0000;
}
.options-colors > ul > li:nth-child(4) {
  background-color: #ff69b4;
}
.options-colors > ul > li:nth-child(5) {
  background-color: #ff1;
}
.btn {
  background-color: #192a56;
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
</style>

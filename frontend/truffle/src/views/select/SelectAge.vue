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
          <div class="event-index" v-for="(event, idx) in AgeArray" :key="idx">
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

        <div id="agecontent2" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" :key="idx">
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

        <div id="agecontent3" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" :key="idx">
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

        <div id="agecontent4" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" :key="idx">
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
        <div id="agecontent5" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" :key="idx">
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
        <div id="agecontent6" class="section">
          <div class="event-index" v-for="(event, idx) in AgeArray" :key="idx">
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
  </div>
</template>

<script>
import { eventSelectAge } from '@/api/event';
export default {
  data() {
    return {
      age: '',
      AgeArray: [],
    };
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
    this.AgeArray = AgeArray.slice(0, 4);
    console.log('나이', this.AgeArray);
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
      this.AgeArray = AgeArray.slice(0, 4);
      console.log('나이', this.AgeArray);
    },
    eventDetailGo() {},
  },
};
</script>

<style scoped>
.age {
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
  border-top: 2px solid #2e9cdf;
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

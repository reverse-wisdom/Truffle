<template>
  <div class="category">
    <div class="tabs">
      <input id="ct1" type="radio" value="의류" v-model="category" @change="selectCategory" />
      <!--디폴트 메뉴-->
      <label for="ct1">의류</label>

      <input id="ct2" v-model="category" type="radio" @change="selectCategory" value="뷰티" />
      <label for="ct2">뷰티</label>

      <input id="ct3" v-model="category" type="radio" @change="selectCategory" value="잡화" />
      <label for="ct3">잡화</label>

      <input id="ct4" v-model="category" type="radio" value="신발" @change="selectCategory" />
      <label for="ct4">신발</label>

      <input id="ct5" v-model="category" type="radio" value="식품" @change="selectCategory" />
      <label for="ct5">식품</label>

      <input id="ct6" v-model="category" type="radio" value="디지털" @change="selectCategory" />
      <label for="ct6">디지털</label>

      <input id="ct6" v-model="category" type="radio" value="취미/문화" @change="selectCategory" />
      <label for="ct6">취미/문화</label>

      <input id="ct7" v-model="category" type="radio" value="기타" @change="selectCategory" />
      <label for="ct7">기타</label>

      <div id="categorycontent1" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" :key="idx">
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

      <div id="categorycontent2" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" :key="idx">
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

      <div id="categorycontent3" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" :key="idx">
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
              <a href="#" class="btn" @click="eventDetailGo(event.event_id)">응모현황</a>
            </section>
          </div>
        </div>
      </div>

      <div id="categorycontent4" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" :key="idx">
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
      <div id="categorycontent5" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" :key="idx">
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
      <div id="categorycontent6" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" :key="idx">
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
      <div id="categorycontent7" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" :key="idx">
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
import { eventSelectCategory } from '@/api/event';
export default {
  data() {
    return {
      category: '',
      CategoryArray: [],
    };
  },
  async created() {
    const category = '의류';
    // console.log('카테고리확인', category, '대');
    const { data } = await eventSelectCategory(category);
    // console.log('응답데이터', data);
    var CategoryArray = data;
    CategoryArray.sort(function(a, b) {
      if (a.join_num > b.join_num) {
        return 1;
      }
      if (a.join_num < b.join_num) {
        return -1;
      }
      return 0;
    });
    CategoryArray.reverse();
    this.CategoryArray = CategoryArray.slice(0, 4);
    console.log('카테고리', this.CategoryArray);
    $('#categorycontent1').addClass('display');
  },
  methods: {
    async selectCategory() {
      $('#categorycontent1').removeClass('display');
      const category = this.category;
      // console.log('카테고리확인', category, '대');
      const { data } = await eventSelectCategory(category);
      // console.log('응답데이터', data);
      var CategoryArray = data;
      CategoryArray.sort(function(a, b) {
        if (a.join_num > b.join_num) {
          return 1;
        }
        if (a.join_num < b.join_num) {
          return -1;
        }
        return 0;
      });
      CategoryArray.reverse();
      this.CategoryArray = CategoryArray.slice(0, 4);
      console.log('카테고리', this.CategoryArray);
    },
    eventDetailGo(event_id) {
      this.$router.push({ name: 'EventDetail', query: { event_id: event_id } });
    },
  },
};
</script>

<style scoped>
.category {
  /* color: #555; */
  /* background: #eeeeee; */
  /* margin: 0;
  padding: 0;
  box-sizing: border-box; */
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
.display {
  display: flex !important;
  justify-content: center !important;
  align-items: center !important;
  flex-wrap: wrap !important;
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

#ct1:checked ~ #categorycontent1,
#ct2:checked ~ #categorycontent2,
#ct3:checked ~ #categorycontent3,
#ct4:checked ~ #categorycontent4,
#ct5:checked ~ #categorycontent5,
#ct6:checked ~ #categorycontent6,
#ct7:checked ~ #categorycontent7 {
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
  margin-bottom: 10px;
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
  background-color: #f3118e;
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
</style>

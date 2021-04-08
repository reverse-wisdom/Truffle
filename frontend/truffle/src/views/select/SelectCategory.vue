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

      <input id="ct7" v-model="category" type="radio" value="취미/문화" @change="selectCategory" />
      <label for="ct7">취미/문화</label>

      <input id="ct8" v-model="category" type="radio" value="기타" @change="selectCategory" />
      <label for="ct8">기타</label>

      <div id="categorycontent1" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" ref="CategoryArray" :key="idx">
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
                <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
              </div>
            </section>
          </div>
        </div>
      </div>

      <div id="categorycontent2" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" ref="CategoryArray" :key="idx">
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
                <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
              </div>
            </section>
          </div>
        </div>
      </div>

      <div id="categorycontent3" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" ref="CategoryArray" :key="idx">
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
                <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
              </div>
            </section>
          </div>
        </div>
      </div>

      <div id="categorycontent4" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" ref="CategoryArray" :key="idx">
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
                <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
              </div>
            </section>
          </div>
        </div>
      </div>
      <div id="categorycontent5" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" ref="CategoryArray" :key="idx">
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
                <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
              </div>
            </section>
          </div>
        </div>
      </div>
      <div id="categorycontent6" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" ref="CategoryArray" :key="idx">
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
                <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
              </div>
            </section>
          </div>
        </div>
      </div>
      <div id="categorycontent7" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" ref="CategoryArray" :key="idx">
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
                <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
              </div>
            </section>
          </div>
        </div>
      </div>

      <div id="categorycontent8" class="section">
        <div class="event-index" v-for="(event, idx) in CategoryArray" ref="CategoryArray" :key="idx">
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
                <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
              </div>
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
      imgURL: 'https://j4d110.p.ssafy.io/truffle/event/selectEventImgFileEventID?event_id=',
    };
  },
  computed: {
    priceComma: function() {
      return this.CategoryArray.map(function(event) {
        return event.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      });
    },
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
    const newCategoryArray = [];
    for (let i = 0; i < CategoryArray.length; i++) {
      if (new Date(CategoryArray[i].end_date) < Date.now()) {
        continue;
      } else {
        newCategoryArray.push(CategoryArray[i]);
      }
    }
    this.CategoryArray = newCategoryArray.slice(0, 4);
    // '카테고리', this.CategoryArray;
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
      const newCategoryArray = [];
      for (let i = 0; i < CategoryArray.length; i++) {
        if (new Date(CategoryArray[i].end_date) < Date.now()) {
          continue;
        } else {
          newCategoryArray.push(CategoryArray[i]);
        }
      }
      this.CategoryArray = newCategoryArray.slice(0, 4);
      // console.log('카테고리', this.CategoryArray);
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
  border-top: 2px solid #f3118e;
  border-bottom: 1px solid #ffffff;
}

#ct1:checked ~ #categorycontent1,
#ct2:checked ~ #categorycontent2,
#ct3:checked ~ #categorycontent3,
#ct4:checked ~ #categorycontent4,
#ct5:checked ~ #categorycontent5,
#ct6:checked ~ #categorycontent6,
#ct7:checked ~ #categorycontent7,
#ct8:checked ~ #categorycontent8 {
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
#agecontent1 > div:nth-child(4) > div > section > div.min-details > div:nth-child(2) > span:nth-child(1) {
  background-color: #07b8ac;
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

<template>
  <!-- 현재 Home은 테스트 페이지 입니다. -->
  <div class="home">
    <!-- 캐러셀 -->
    <!-- <v-carousel hide-delimiters class="">
        <v-carousel-item v-for="(item, i) in items" :key="i" :src="item.src"></v-carousel-item>
      </v-carousel> -->
    <div class="container1">
      <div class="left-col">
        <div class="cover"></div>

        <div class="data">
          <div class="left-name">
            <p id="name">공정한 기회와 편의를 제공해드리는.</p>
          </div>

          <div class="left-title">
            <h1>truffle MAKER</h1>
          </div>
        </div>
        <div class="block-cover"></div>
      </div>

      <div class="right-col">
        <div class="upper"></div>
        <div class="upper-block">
          <div class="wrapper">
            <div class="left">
              <div class="inner">
                <div class="post">
                  <img src="1.jpg" alt="" />
                  <div class="post-s">
                    <h2 @click="category">
                      EVENTS
                    </h2>
                  </div>
                </div>
              </div>
            </div>
            <div class="right">
              <div class="inner"></div>
            </div>
          </div>
        </div>
        <div class="bottom">
          <div class="data2"></div>

          <div class="more"></div>
        </div>
        <div class="block-bottom"></div>
      </div>
    </div>
    <div class="space"></div>

    <div>
      <div class="box">
        <h1 class="title-search" style="">관심있는 상품을 검색해보세요!</h1>
        <v-row class="text-center" style="height: 10px">
          <div class="text-center searchRank">
            <v-card color="dark" max-height="100px">
              <Ranking></Ranking>
            </v-card>
          </div>
        </v-row>
        <div>
          <input type="text" placeholder="검색" id="searchWord" v-model="word" />
          <input type="button" name="" value="Search" @click="detailSearch" />
        </div>
      </div>
    </div>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <div>
      <div class="linestyle"></div>
      <h1 id="deadline"># 응모 마감이 얼마 남지 않은 이벤트</h1>
      <EndEventList></EndEventList>
    </div>
    <div class="mid-content">
      <h1 id="deadline"># 연령대별 인기 이벤트</h1>
      <SelectAge></SelectAge>
      <h1 id="deadline"># 카테고리별 인기 이벤트</h1>
      <SelectCategory></SelectCategory>
      <h1 id="deadline"># 성별 인기이벤트</h1>
      <SelectGender></SelectGender>
    </div>
  </div>
</template>

<script>
import EventAll from '@/views/event/EventAll.vue';
import SelectAge from '@/views/select/SelectAge.vue';
import SelectCategory from '@/views/select/SelectCategory.vue';
import SelectGender from '@/views/select/SelectGender.vue';
import EndEventList from '@/views/select/EndEventList.vue';
import { eventAll, searchProduct } from '@/api/event';
import Ranking from './Ranking.vue';

TweenMax.from('.left-col', 2, {
  width: '0%',
  ease: Expo.easeInOut,
});

TweenMax.from('.logo', 2, {
  delay: 2.5,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.buy', 2, {
  delay: 2.8,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.year', 2, {
  delay: 3.1,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.left-name', 2, {
  delay: 2.4,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.left-title', 2, {
  delay: 2.6,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.about h1', 2, {
  delay: 3,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.left-name2', 2, {
  delay: 3.2,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.left-title2', 2, {
  delay: 3.4,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.album-genre2', 2, {
  delay: 3.6,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.staggerFrom(
  '.media ul li',
  2,
  {
    delay: 3.8,
    opacity: 0,
    y: 20,
    ease: Expo.easeInOut,
  },
  0.1
);

TweenMax.from('.left-name3', 2, {
  delay: 4,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.left-title3', 2, {
  delay: 4.2,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.next', 2, {
  delay: 4.4,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

TweenMax.from('.more', 2, {
  delay: 4.6,
  y: 20,
  opacity: 0,
  ease: Expo.easeInOut,
});

export default {
  name: 'Main',
  components: { EventAll, SelectAge, SelectCategory, SelectGender, EndEventList, Ranking },
  data() {
    return {
      word: '',
      eventlist: [],
    };
  },
  async created() {
    const { data } = await eventAll();
    // console.log(data);
    for (let i = 0; i < data.length; i++) {
      this.eventlist.push({
        event_id: data[i].event_id,
        age: data[i].age,
        category: data[i].category,
        gender: data[i].gender,
        join_num: data[i].join_num,
        price: data[i].price,
        product: data[i].product,
        win_num: data[i].win_num,
        end_date: data[i].end_date,
        open_date: data[i].open_date,
      });
    }
    // console.log('이벤트리스트', this.eventlist);
  },
  methods: {
    async detailSearch() {
      var product = document.getElementById('searchWord').value;
      this.$router.push({ name: 'Search', query: { product: product } });
    },
    category() {
      this.$router.push('/categoryall');
    },
  },
};
</script>
<style scoped>
@font-face {
  font-family: 'KOTRA_BOLD-Bold';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10-21@1.1/KOTRA_BOLD-Bold.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
.space {
  margin-top: 60rem;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppipns' sans-serif;
}

section {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  /* background: #232323; */
  overflow: hidden;
  z-index: 0;
}
section::before {
  content: '';
  position: fixed;
  /* top: 0; */
  left: 0;
  width: 100%;
  height: 80%;
  z-index: 0;
}
section::after {
  content: '';
  position: fixed;
  /* top: 0; */
  left: 0;
  width: 100%;
  height: 80%;
  z-index: 0;
}

.container {
  position: relative;
  z-index: 3;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  padding-top: 2rem;
  width: 100%;
}
.container .card {
  position: relative;
  width: 200px;
  height: 400px;
  margin: 20px 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background: rgba(255, 255, 255);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
  backdrop-filter: blur(15px);
}
.container .card .imgBx {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 20px;
  transition: 0.5s ease-in-out;
}
.container .card:hover .imgBx {
  transform: translateY(-100px);
}
.container .card .imgBx img {
  max-width: 100%;
  margin: 0 0 20px;
  transition: 0.5s ease-in-out;
}
.container .card:hover .imgBx img {
  transform: translate(-20px, -40px) rotate(-25deg) scale(1.4);
}
.container .card .imgBx h4 {
  color: #fff;
  font-weight: 600;
}
.container .card .content {
  position: absolute;
  bottom: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  transition: 0.5s ease-in-out;
  opacity: 0;
  visibility: hidden;
}
.container .card:hover .content {
  opacity: 1;
  visibility: visible;
  transform: translateY(-50px);
}
.container .card .content .size {
  /* display: flex; */
  justify-content: center;
  align-items: center;
  padding: 8px 20px;
}
.container .card .content .size h3,
.container .card .color .size h3 {
  color: #fff;
  font-weight: 300;
  font-size: 14px;
  text-transform: uppercase;
  letter-spacing: 2px;
  margin-right: 10px;
}
.container .card .content .size span {
  widows: 26px;
  height: 26px;
  text-align: center;
  line-height: 24px;
  display: inline-block;
  color: #fff;
  /* background: #fff; */
  border-radius: 4px;
  font-size: 14px;
  margin: 0 5px;
  font-weight: 500;
  transition: 0.5s;
  cursor: pointer;
}
.container .card .content .size span:hover {
  background: #9bdc28;
}
.container .card .content .color span {
  width: 20px;
  height: 20px;
  background: #f00;
  border-radius: 50%;
  margin: 0 5px;
  border: 2px solid #fff;
  box-sizing: border-box;
  cursor: pointer;
}
.container .card .content .color span:nth-child(2) {
  background: #9bdc28;
}
.container .card .content .color span:nth-child(2) {
  background: #03a94f;
}
.container .card .content .color span:nth-child(2) {
  background: #f3118e;
}
.container .card .content a {
  position: relative;
  top: 10px;
  display: inline-block;
  padding: 10px 30px;
  background: #fff;
  border-radius: 40px;
  font-weight: 600;
  letter-spacing: 1px;
  color: #111;
  text-decoration: none;
  text-transform: uppercase;
}
.left-col,
.right-col {
  position: absolute;
  width: 50%;
  height: 100vh;
}
.title-search {
  text-align: center;
  height: auto;
  margin-bottom: 2rem;
  letter-spacing: 0.2rem;
  font-size: 2rem;
  /* font-weight: bold; */
  font-family: 'KOTRA_BOLD-Bold';
}
/* .left-col {
  background: #d45b48;
} */

.right-col {
  left: 50%;
}

.upper {
  position: absolute;
  top: 8%;
  width: 100%;
  height: 42.1vh;
  background: url(../assets/img/sunglass1.jpg) no-repeat 50% 50%;
  background-size: cover;
  opacity: 0;
  animation: appear-text 0.0001s linear forwards;
  animation-delay: 3s;
}

.bottom {
  position: absolute;
  top: 50%;
  height: 40vh;
  width: 100%;
  background: url(../assets/img/bottom.jpg) no-repeat 50% 50%;
  background-size: cover;
  opacity: 0;
  animation: appear-text 0.0001s linear forwards;
  animation-delay: 4.2s;
}

@media (max-width: 900px) {
  .left-col {
    width: 100%;
  }
  .right-col {
    top: 100%;
    left: 0%;
    width: 100%;
  }
}

.logo {
  font-family: Poppins;
  color: #fff;
  position: fixed;
  margin: 1.4em;
  font-weight: bolder;
  z-index: 1;
}

.cover {
  position: absolute;
  top: 50%;
  left: 70%;
  transform: translate(-50%, -50%);
  width: 60%;
  height: 70%;
  background: url(../assets/img/women.jpg) no-repeat 50% 50%;
  background-size: cover;
  opacity: 0;
  animation: appear-text 0.0001s linear forwards;
  animation-delay: 2.6s;
}

.data {
  position: absolute;
  top: 36%;
  left: 30%;
  transform: translate(-50%, -50%);
  color: #000;
  font-family: Poppins;
  text-transform: uppercase;
  letter-spacing: 4px;
}

#name {
  font-weight: bolder;
}

#artist {
  font-size: 10px;
}

.about {
  position: absolute;
  top: 40%;
  left: 26%;
  transform: translate(-50%, -50%);
}

.about h1 {
  font-weight: bolder;
  color: #e1ea35;
  font-family: Poppins;
  text-transform: uppercase;
}

.about p {
  color: #fff;
  font-family: Poppins;
  text-transform: uppercase;
  letter-spacing: 4px;
  font-size: 1rem;
  cursor: pointer;
}

.block-cover {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 100%;
  height: 100%;
}

.block-cover::after {
  content: '';
  top: 0;
  left: 0;
  position: absolute;
  width: 0%;
  height: 90%;
  background: #de1761;
  animation: rev-block 1.5s cubic-bezier(0.19, 1, 0.22, 1) forwards;
  animation-delay: 2s;
}
/* button */

@keyframes rev-block {
  0% {
    left: 0;
    width: 0%;
  }
  50% {
    left: 0;
    width: 100%;
  }
  100% {
    left: 100%;
    width: 0%;
  }
}

@keyframes appear-text {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}

.upper-block {
  position: absolute;
  width: 100%;
  height: 50vh;
}

.upper-block::after {
  content: '';
  top: 0;
  left: 0;
  position: absolute;
  width: 0%;
  height: 100%;
  background: #65d5e8;
  animation: rev-block 1.5s cubic-bezier(0.19, 1, 0.22, 1) forwards;
  animation-delay: 2.4s;
}

.block-bottom {
  position: absolute;
  top: 50%;
  height: 40vh;
  width: 100%;
}

.block-bottom::after {
  content: '';
  top: 0;
  left: 0;
  position: absolute;
  width: 0%;
  height: 100%;
  background: #6b4ee6;
  animation: rev-block 1.5s cubic-bezier(0.19, 1, 0.22, 1) forwards;
  animation-delay: 3.6s;
}

/* button */
.wrapper {
  width: 100%;
  height: 100%;
  position: relative;
}
.left,
.right {
  width: 60%;
  height: 100%;
  top: 0;
  transform: skewX(-8deg);
  overflow: hidden;
}

.left {
  position: relative;
  left: -5%;
  color: #fff;
  animation: appear-text 0.0001s linear forwards;
  animation-delay: 2.6s;
  opacity: 0;
  transition: 0.5s ease-in-out;
  z-index: 3;
}

.right {
  position: absolute;
  right: -5%;
}
.left .inner,
.right .inner {
  width: 100%;
  height: 100%;
  background-size: cover;
  background-repeat: no-repeat;
  transform: skewX(8deg);
  color: #fff;
  font-weight: bolder;
}
.left .inner {
  transition: 0.5s ease-in-out;
  background-color: #2bbef2;
  color: #fff;
  margin-left: 8.5%;
}
.left .inner:hover {
  background-color: #2bbef2;
  color: #fff;
  margin-left: 8.5%;
}
.left .inner p {
  position: relative;
  top: 55%;
  color: #fff;
}

.post {
  width: 600px;
  height: 100%;
  position: relative;
  cursor: pointer;
  top: 15%;
}
.post:hover .post-s {
  width: 600px;
}
.post img {
  display: block;
  width: 600px;
  height: 100%;
  z-index: 0;
}
.post-s {
  width: 0px;
  height: 400px;
  background: #ea37a3;
  position: absolute;
  top: 0;
  display: flex;
  /* justify-content: center; */
  align-items: center;
  overflow: hidden;
  transition: 0.7s ease;
  background-size: cover;
}
.post-s h2 {
  color: white;
  font-size: auto;
  border: 6px solid white;
  padding: 10px 10px;
  margin-left: 10vw;
}
.mid-content {
  margin-top: 10%;
  z-index: 0;
}

#deadline {
  margin: 40px 0 20px 50px;
  font-size: 20px;
  font-weight: bold;
  color: #111;
  justify-content: center;
  /* position: absolute; */
}

.linestyle {
  width: 100vw;
  height: 10px;
  /* margin-top: 10rem; */
  background-color: #f9f9f9;
}

.searchRank {
  margin-top: 7%;
  width: 300%;
  height: 50%;
}

/* 검색창 */
h1 {
  margin: 0 0 10px;
  padding: 0;
  color: #000;
  font-size: 24px;
}
.box {
  margin-bottom: 200px;
  position: absolute;
  /* top: 25%; */
  left: 20%;
  width: auto;
  margin: 0 auto;
}
input {
  position: relative;
  display: inline-block;
  font-size: 20px;
  box-sizing: border-box;
}
input[type='text'] {
  /* border: #000; */
  background: #eaeaea;
  width: 50vw;
  height: 50px;
  border: none;
  border-radius: 25px 0 0 25px;
  padding: 0 25px;
  outline: none;
  color: #fff;
}
input[type='button'] {
  position: relative;
  /* left: -5px; */
  border-radius: 0 25px 25px 0;
  height: 50px;
  width: 11vw;
  border: none;
  outline: none;
  cursor: pointer;
  background: #381dfc;
  color: #fff;
}
input[type='button'] :hover {
  background: #ff5722;
}
</style>

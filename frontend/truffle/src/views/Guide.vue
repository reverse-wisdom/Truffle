<template>
  <div class="guide">
    <input type="checkbox" class="checkbox" v-model="checked" />
    <a class="a2" @click="gohome" v-show="checked == true">바로가기</a>
    <a class="a1" @click="gohome" v-show="checked == false">바로가기</a>
    <div id="user" v-if="checked == true">User</div>
    <div id="retailer" v-else>Retailer</div>

    <div id="section1" class="section1">
      <div v-show="checked == false">
        <div class="guide-title"></div>
        <div class="left1">
          <div class="retailer-detail_1">한정판 상품을</div>
          <div class="retailer-detail_1">어떻게 판매할지</div>
          <div class="retailer-detail_1">고민하고 계시나요?</div>
        </div>
        <div class="right1">
          <div class="retailer-detail_1">고객의</div>
          <div class="retailer-detail_1">흥미와 이목을</div>
          <div class="retailer-detail_1">끌고 싶은데</div>
        </div>
      </div>
      <div v-show="checked == true" class="guide-title">
        <div class="left1-user">
          <div class="retailer-detail_2">한정판 물건을 살려고</div>
          <div class="retailer-detail_2">이른 아침에</div>
          <div class="retailer-detail_2">줄서서 기다리거나,</div>
        </div>
        <div class="right1-user">
          <div class="retailer-detail_3">줄서기 아르바이트</div>
          <div class="retailer-detail_3">구한 적이 있으신가요?</div>
        </div>
      </div>
    </div>

    <div id="section2" class="section2">
      <div class="guide-title" v-show="checked == false">
        <div class="right2">
          <div class="retailer-detail_1">마땅한 마케팅 방안이나,</div>
          <div class="retailer-detail_1">판매방안이</div>
          <div class="retailer-detail_1">떠오르지 않으시다구요?</div>
        </div>
      </div>
      <div v-show="checked == true" class="guide-title">
        <div class="left2-user">
          <div class="retailer-detail_1">한정판이 가지는</div>
          <div class="retailer-detail_1">희소성의 가치로</div>
          <div class="retailer-detail_1"></div>
        </div>
        <div class="right2-user">
          <div class="retailer-detail_1">톡톡한 이익을</div>
          <div class="retailer-detail_1">보고 싶으신가요?</div>
        </div>
      </div>
    </div>

    <div id="section3" class="section3">
      <div class="guide-title" v-show="checked == false">
        <div class="right3">
          <div class="retailer-detail_1">트러플이 여러분과</div>
          <div class="retailer-detail_1">소비자간의 니즈를</div>
          <div class="retailer-detail_1">이어드리겠습니다.</div>
        </div>
      </div>

      <div v-show="checked == true" class="guide-title">
        <div class="left3-user">
          <div class="retailer-detail_4">모든 래플이벤트만</div>
          <div class="retailer-detail_4">모아서 볼 수 있고, 응모할수 있도록</div>
          <div class="retailer-detail_4">트러플이 도와드리겠습니다.</div>
        </div>
        <div class="right3-user">
          <div class="retailer-detail_4">적시 적소한 기회,</div>
          <div class="retailer-detail_4">이젠 맘껏 누리세요!</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const buttons = document.querySelectorAll('a');

import FullPage from 'vue-fullpage.js';
export default {
  name: 'guide',
  components: {
    FullPage,
  },
  data() {
    return {
      checked: false,
      options: {
        paddingTop: '30px',
        navigation: true,
        sectionsColor: ['#f2f2f2', '#4BBFC3', '#7BAABE'],
      },
    };
  },
  watch: {
    checked() {
      const elm1 = document.querySelector('#section1');
      const elm2 = document.querySelector('#section2');
      const elm3 = document.querySelector('#section3');

      if (this.checked == true) {
        console.log('true');

        elm1.classList.add('section1-false');
        elm2.classList.add('section2-false');
        elm3.classList.add('section3-false');
      } else {
        console.log('false');
        elm1.classList.remove('section1-false');
        elm2.classList.remove('section2-false');
        elm3.classList.remove('section3-false');
      }
    },
  },
  methods: {
    gohome() {
      this.$router.push('/main');
    },
  },
};
</script>
<style scoped>
@font-face {
  font-family: 'Recipekorea';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Recipekorea.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
.checkbox {
  position: fixed;
  top: 40px;
  right: 40px;
  -webkit-appearance: none;
  width: 10rem;
  height: 40px;
  background-color: #07b8ac;
  border-radius: 20px;
  cursor: pointer;
  outline: none;
  z-index: 2;
  outline: none;
}

.checkbox:checked {
  background-color: #f3118e;
  outline: none;
}

.checkbox::before {
  content: '';
  position: absolute;
  width: 3rem;
  height: 32px;
  background-color: #fff;
  border-radius: 20px;
  top: 4px;
  left: 0.5rem;
  transition: 0.3s linear;
}

.checkbox:checked::before {
  left: 6rem;
  content: '';
}
.guide {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  font: #ffff;
}
.section1 {
  background: url(../assets/img/vividgirl.jpg) no-repeat;
  background-size: cover;
  width: 100%;
  height: 100%;
  overflow: hidden;
  background-attachment: fixed;
  /* display: flex;
  justify-content: center;
  align-content: center; */
}
.section1-false {
  background: url(../assets/img/redgirl.jpg) no-repeat fixed;
  background-size: cover;
}
.section2 {
  background: url(../assets/img/yellow_red.jpg) no-repeat;
  background-size: cover;
  width: 100%;
  height: 100%;
  overflow: hidden;
  background-attachment: fixed;
  display: flex;
  justify-content: center;
  align-content: center;
}

.section2-false {
  background: url(../assets/img/vividpainting.jpg) no-repeat fixed;
  background-size: cover;
}
.section3 {
  background: url(../assets/img/bluemen.jpg) no-repeat;
  background-size: cover;
  width: 100%;
  height: 100%;
  overflow: hidden;
  background-attachment: fixed;
  display: flex;
  justify-content: center;
  align-content: center;
}

.section3-false {
  background: url(../assets/img/yellowmodel.jpg) no-repeat fixed;
  background-size: cover;
}

#retailer {
  position: fixed;
  top: 43px;
  right: 60px;
  /* transform: translateY(-50%); */
  color: #fff;
  font-size: 20px;
  font-weight: bold;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  margin-left: px;
  outline: none;
  z-index: 3;
}
#user {
  position: fixed;
  outline: none;
  top: 43px;
  right: 130px;
  /* transform: translateY(-50%); */
  color: #fff;
  font-size: 20px;
  font-weight: bold;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  margin-left: px;
  z-index: 3;
}

.section1 .guide-title {
  /* background: white; */
  color: #fff;
  padding: 10px 20px;
  font-size: 40px;
  text-transform: uppercase;
  text-align: center;
}
.retailer-detail_1 {
  width: auto;
  color: #fff;
  font-family: 'Recipekorea';
  font-size: 3rem;
  margin-top: 5%;
  margin-left: 2%;
  font-weight: 2000;
}
.retailer-detail_4 {
  width: auto;
  color: #fff;
  font-family: 'Recipekorea';
  font-size: 2.5rem;
  margin-top: 5%;
  margin-left: 2%;
  font-weight: 2000;
}
.retailer-detail_2 {
  color: #060606;
  font-family: 'Recipekorea';
  font-size: 2.5rem;
  margin-top: 5%;
  margin-left: 2%;
  font-weight: 2000;
}
.retailer-detail_3 {
  color: #060606;
  font-family: 'Recipekorea';
  font-size: 2.5rem;
  margin-top: 5%;
  margin-left: 2%;
  font-weight: 2000;
}

.left1 {
  position: absolute;
  top: 10%;
  width: 500px;
  text-align: center;
  line-height: 50px;
}
.right1 {
  position: absolute;
  top: 60%;
  width: 600px;
  text-align: center;
  line-height: 50px;
  right: 0%;
}
.right2 {
  position: absolute;
  width: 700px;
  text-align: center;
  right: 0%;
  line-height: 50px;
  top: 135%;
}
.right3 {
  position: absolute;
  width: 700px;
  text-align: center;
  right: 4%;
  line-height: 50px;
  top: 230%;
}
.left1-user {
  position: absolute;
  top: 10%;
  width: 500px;
  text-align: center;
  line-height: 30px;
}
.right1-user {
  position: absolute;
  top: 65%;
  width: 600px;
  text-align: center;
  line-height: 50px;
  right: 0%;
}

.left2-user {
  position: absolute;
  width: 500px;
  text-align: center;
  line-height: 50px;
  top: 140%;
  left: 0%;
}

.right2-user {
  position: absolute;
  width: 500px;
  text-align: center;
  right: 0%;
  line-height: 50px;
  top: 140%;
}
.left3-user {
  position: absolute;
  width: 800px;
  text-align: center;
  line-height: 20px;
  top: 210%;
  left: 0%;
  font-size: 1rem;
  /* font-weight: 1000; */
}

.right3-user {
  position: absolute;
  width: 600px;
  text-align: center;
  right: 0%;
  line-height: 20px;
  top: 270%;
}

.a1 {
  position: fixed;
  bottom: 2%;
  display: inline-block;
  padding: 12px 36px;
  margin: 10px 0;
  color: #fff;
  text-decoration: none;
  text-transform: uppercase;
  font-size: 18px;
  letter-spacing: 2px;
  border-radius: 40px;
  background-color: #07b8ac;
  /* top: 285%; */
  right: 3%;
}
.a1:hover {
  position: fixed;
  bottom: 2%;
  display: inline-block;
  padding: 12px 36px;
  margin: 10px 0;
  color: #fff;
  text-decoration: none;
  text-transform: uppercase;
  font-size: 18px;
  letter-spacing: 2px;
  border-radius: 40px;
  background-color: #f3118e;
  /* top: 285%; */
  right: 3%;
}
.a2 {
  position: fixed;
  bottom: 2%;
  display: inline-block;
  padding: 12px 36px;
  margin: 10px 0;
  color: #fff;
  text-decoration: none;
  text-transform: uppercase;
  font-size: 18px;
  letter-spacing: 2px;
  border-radius: 40px;
  background: #f3118e;
  /* top: 285%; */
  right: 3%;
}
.a2:hover {
  position: fixed;
  bottom: 2%;
  display: inline-block;
  padding: 12px 36px;
  margin: 10px 0;
  color: #fff;
  text-decoration: none;
  text-transform: uppercase;
  font-size: 18px;
  letter-spacing: 2px;
  border-radius: 40px;
  background: #07b8ac;
  /* top: 285%; */
  right: 3%;
}
</style>

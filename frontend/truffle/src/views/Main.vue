<template>
  <!-- 현재 Home은 테스트 페이지 입니다. -->
  <div class="home">
    <!-- 캐러셀 -->
    <!-- <v-carousel hide-delimiters class="">
        <v-carousel-item ></v-carousel-item>
      </v-carousel> -->
    <div class="container1">
      <div class="left-col">
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
                    <h2>
                      HOVER TEST
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

    <v-container class="">
      <section>
        <div class="container">
          <div class="card" v-for="(item, i) in items" :key="i">
            <div class="imgBx">
              <img :src="item.src" alt="" />
              <h2>{{ item.brand }}</h2>
            </div>
            <div class="content">
              <div class="size">
                <h4>{{ item.name }}</h4>
                <span>{{ item.price }}</span>
              </div>
              <a @click="detail(item.id)">Detail</a>
            </div>
          </div>
        </div>
      </section>
    </v-container>
  </div>
</template>

<script>
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
  name: 'Home',
  components: {},
  data() {
    return {
      items: [
        {
          name: '구찌 홀스빗 카드지갑',
          brand: '구찌',
          src: require('@/assets/img/상품1.png'),
          price: '537,000원',
          id: 0,
        },
        {
          name: '모노그램 마틀라세 클러치백 뉴미디움 블랙 금장',
          brand: '생로랑',
          src: require('@/assets/img/상품2.png'),
          price: '923,000원',
          id: 1,
        },
        {
          name: '여성 슈퍼스타 로우탑 스니커즈',
          brand: '골드구스',
          src: require('@/assets/img/상품3.png'),
          price: '377,000원',
          id: 2,
        },
        {
          name: '구찌 홀스빗 카드지갑',
          brand: '구찌',
          src: require('@/assets/img/상품1.png'),
          price: '537,000원',
          id: 3,
        },
      ],
    };
  },
  methods: {
    detail(id) {
      this.$router.push({ name: 'ItemDetail', query: { id: id } });
    },
  },
};
</script>
<style scoped>
.space {
  margin-top: 35rem;
}
@import url('http://font.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&dispaly=swap');
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
  z-index: 5;
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
  background: #e91e63;
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

.year {
  position: absolute;
  color: #000;
  font-family: Poppins;
  bottom: 8%;
  font-weight: bolder;
  transform: rotate(-90deg);
  left: 0%;
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

/* #artist {
  font-size: 10px;
} */

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
.right .inner {
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
</style>

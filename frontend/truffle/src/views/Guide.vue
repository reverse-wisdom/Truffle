<template>
  <div class="guide">
    <input type="checkbox" class="checkbox" v-model="checked" />

    <div id="user" v-if="checked == true">User</div>
    <div id="retailer" v-else>Retailer</div>

    <div id="section1" class="section1">
      <h1 v-if="checked == false">
        Welcome To Retailer
      </h1>
      <h1 v-else>Welcome To custumer</h1>
    </div>
    <div id="section2" class="section2">
      <h1 v-if="checked == false">
        Welcome To Retailer
      </h1>
      <h1 v-else>Welcome To custumer</h1>
    </div>
    <div id="section3" class="section3">
      <h1 v-if="checked == false">
        Welcome To Retailer
      </h1>
      <h1 v-else>Welcome To custumer</h1>
    </div>
  </div>
</template>

<script>
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
  methods: {},
};
</script>
<style scoped>
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
}

.checkbox:checked {
  background-color: #f3118e;
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
  display: flex;
  justify-content: center;
  align-content: center;
}
.section1-false {
  background: url(../assets/img/redgirl.jpg) no-repeat fixed;
  background-size: cover;
}
.section2 {
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

.section2-false {
  background: url(../assets/img/vividpainting.jpg) no-repeat fixed;
  background-size: cover;
}
.section3 {
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

.section3-false {
  background: url(../assets/img/yellowmodel.jpg) no-repeat fixed;
  background-size: cover;
}

h1 {
  /* background: white; */
  color: #fff;
  padding: 10px 20px;
  font-size: 40px;
  text-transform: uppercase;
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
  z-index: 3;
}
#user {
  position: fixed;
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
</style>

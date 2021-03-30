<template>
  <div class="guide">
    <input type="checkbox" class="checkbox" />
    <!-- <full-page :options="options">
      <div class="section">Section1</div>
      <div class="section">Section2</div>
      <div class="section">Section3</div>
    </full-page> -->
    <div class="section1">
      <h1>Welcome To Retailer</h1>
    </div>
    <div class="section2">
      <h1>Welcome To Retailer</h1>
    </div>
    <div class="section3">
      <h1>Welcome To Retailer</h1>
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
      options: {
        paddingTop: '30px',
        navigation: true,
        sectionsColor: ['#f2f2f2', '#4BBFC3', '#7BAABE'],
      },
    };
  },
  destroyed() {
    $.fn.fullpage.destroy('all');
  },
};
</script>
<style scoped>
.checkbox {
  position: fixed;
  top: 40px;
  right: 40px;
  -webkit-appearance: none;
  width: 80px;
  height: 40px;
  background-color: #07b8ac;
  border-radius: 20px;
  cursor: pointer;
  outline: none;
}

.checkbox:checked {
  background-color: #f3118e;
}

.checkbox::before {
  content: '';
  position: absolute;
  width: 32px;
  height: 32px;
  background-color: #fff;
  border-radius: 20px;
  top: 4px;
  left: 4px;
  transition: 0.3s linear;
}

.checkbox:checked::before {
  left: 44px;
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

h1 {
  /* background: white; */
  color: #fff;
  padding: 10px 20px;
  font-size: 40px;
  text-transform: uppercase;
}
</style>

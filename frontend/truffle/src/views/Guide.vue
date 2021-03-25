<template>
  <div class="guide">
    <!-- <input type="checkbox" class="checkbox" /> -->
    <full-page :options="options">
      <div class="section">Section1</div>
      <div class="section">Section2</div>
      <div class="section">Section3</div>
      <!-- <div class="section pb-0" :style="image_1" data-width="1200" data-height="730">Section1</div>
      <div class="section pb-0" :style="image_2" data-width="1200" data-height="730">Section2</div>
      <div class="section pb-0" :style="image_3" data-width="1200" data-height="730">Section3</div>
      <div class="section pb-0" :style="image_4" data-width="1200" data-height="730">Section4</div> -->
    </full-page>
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
  background-color: #e1ea35;
  border-radius: 20px;
  cursor: pointer;
  outline: none;
}

.checkbox:checked {
  background-color: #3756ff;
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
/* .color1 { color: #f3118e}
.color3 { color: #10004d}
.color4 { color: #612cbe}
.color6 { color: #7ed5bd}
.color9 { color: #07b8ac}
.color14 { color: #f2fbf8} */
.guide > div:nth-child(1) {
  background: gray;
}
.guide > div:nth-child(2) {
  background: yellow;
}
.guide > div:nth-child(3) {
  background: green;
}
.section {
  width: 100vw;
  height: 100vh;
  z-index: -1;
}
</style>

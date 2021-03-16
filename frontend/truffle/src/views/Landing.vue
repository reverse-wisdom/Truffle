<template>
  <div class="landing">
    <full-page :options="options">
      <div class="section">Section1</div>
      <div class="section">Section2</div>
      <div class="section">Section3</div>
    </full-page>
  </div>
</template>

<script>
import FullPage from 'vue-fullpage.js';
export default {
  name: 'landing',
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

<template>
  <div>
    <h1>이벤트탭</h1>
    <div class="tab-container">
      <div class="tabs">
        <label class="tab tab01" @click="tab01()">
          <p id="tab1-title">Detail</p>
        </label>
        <label class="tab tab02" @click="tab02()">
          <p id="tab2-title">Q&amp;A</p>
        </label>
        <span class="border"></span>
        <span class="background"></span>
      </div>
    </div>

    <div v-if="tabcheck == true" class="img-tab1">
      <EventQnA></EventQnA>
    </div>
    <div v-else>
      <img src="@/assets/img/tombrown3.jpg" alt="" />
    </div>
  </div>
</template>

<script>
import EventQnA from '../event/EventQnA';
export default {
  name: 'EventDetailTab',
  data() {
    return {
      tabcheck: false,
    };
  },
  components: {
    EventQnA,
  },
  methods: {
    tab01() {
      var border = document.querySelector('.tabs .border');
      var background = document.querySelector('.tabs .background');
      var tabtitle_1 = document.querySelector('#tab1-title');
      var tabtitle_2 = document.querySelector('#tab2-title');
      border.style.transform = 'translateX(0)';
      background.style.transform = 'translateX(0)';
      tabtitle_1.style.color = '#fff';
      tabtitle_2.style.color = '#000';
    },
    tab02() {
      this.tabcheck = true;
      var border = document.querySelector('.tabs .border');
      var background = document.querySelector('.tabs .background');
      var tabtitle_1 = document.querySelector('#tab1-title');
      var tabtitle_2 = document.querySelector('#tab2-title');
      var imgtab1 = document.querySelector('.img-tab1');
      border.style.transform = 'translateX(100%)';
      background.style.transform = 'translateX(100%)';
      tabtitle_1.style.color = '#000';
      tabtitle_2.style.color = '#fff';
      imgtab1.style.display = 'none';
      // this.$router.push({ name: 'EventQnA' });
    },
  },
};
</script>

<style scoped>
.tab-container {
  height: 50vh;
  display: flex;
  justify-content: center;
  align-items: center;
  user-select: none;
}
.tabs {
  display: flex;
  position: relative;
  text-align: center;
  width: 80%;
  height: 4rem;
  background-color: #fff;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}
.tabs .tab {
  width: 50%;
  height: 100%;
  margin-top: 0.5rem;
  text-align: center;
  color: #fff;
  cursor: pointer;
  z-index: 2;
}
.tabs .border {
  position: absolute;
  width: 50%;
  height: 1rem;
  background: #256eff;
  bottom: 0;
  z-index: 2;
  transition: 0.4s;
}
.tabs .background {
  z-index: 1;
  position: absolute;
  width: 50%;
  height: 100%;
  background: #f3118e;
  bottom: 0;
  transition: 0.4s;
}
#tab1-title {
  color: #fff;
  font-size: 1.2rem;
}
#tab2-title {
  color: #000;
  font-size: 1.2rem;
}
</style>

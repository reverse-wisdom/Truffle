<template>
  <v-container class="winneritem">
    <div class="tabs">
      <div class="tab-header">
        <div class="active" @click="tabclick()" id="tab1">결제전</div>
        <div @click="tabclick()" id="tab2">결제완료</div>
        <div @click="tabclick()" id="tab3">배송준비중</div>
        <div @click="tabclick()" id="tab4">배송중</div>
        <div @click="tabclick()" id="tab5">배송완료</div>
      </div>
      <div class="tab-content">
        <div class="active">
          <h2>결제전</h2>
          <p>결제전상품</p>
        </div>
        <div>
          <h2>결제완료</h2>
          <p>결제전상품</p>
        </div>
        <div>
          <h2>배송준비중</h2>
          <p>결제전상품</p>
        </div>
        <div>
          <h2>배송중</h2>
          <p>결제전상품</p>
        </div>
        <div>
          <h2>배송완료</h2>
          <p>결제전상품</p>
        </div>
      </div>
    </div>
  </v-container>
</template>

<script>
export default {
  async created() {},
  methods: {
    tabclick() {
      let tabPanes = document.getElementsByClassName('tab-header')[0].getElementsByTagName('div');

      for (let i = 0; i < tabPanes.length; i++) {
        tabPanes[i].addEventListener('click', function() {
          document
            .getElementsByClassName('tab-header')[0]
            .getElementsByClassName('active')[0]
            .classList.remove('active');
          tabPanes[i].classList.add('active');

          document
            .getElementsByClassName('tab-content')[0]
            .getElementsByClassName('active')[0]
            .classList.remove('active');
          document
            .getElementsByClassName('tab-content')[0]
            .getElementsByTagName('div')
            [i].classList.add('active');
        });
      }
    },
  },
};
</script>

<style scoped>
.winneritem {
  background: #fff;
  width: 100vw;
  height: 500px;
  position: relative;
  /* border-radius: 20px; */
  box-shadow: 2px 5px 20px rgba(119, 119, 119, 0.5);
  /* margin-bottom: 50px; */
  left: 0%;
  padding: 30px;
  top: 20%;
}
* {
  box-sizing: border-box;
}
/* body {
  background: #00acee;
  font-family: 'Raleway';
} */
.tabs {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 80%;
  height: 350px;
}
.tabs .tab-header {
  display: flex;
  height: 80px;
}
.tabs .tab-header > div {
  position: relative;
  width: calc(100% / 4);
  height: 100%;
  text-align: center;
  line-height: 80px;
  font-weight: 600;
  color: #f5f5f5;
  cursor: pointer;
  z-index: 2;
}
.tabs .tab-header > div:before {
  content: '';
  position: absolute;
  bottom: 0px;
  left: 0px;
  width: 100%;
  height: 0%;
  background: #f5f5f5;
  z-index: -1;
}
.tabs .tab-header > div:hover:before {
  transition: all 300ms ease-in-out;
  height: 5%;
}
.tabs .tab-header > div.active {
  color: #00acee;
}
.tabs .tab-header > div.active:before {
  transition: all 300ms ease-in-out;
  height: 100%;
}
.tabs .tab-content {
  position: relative;
  background: #f5f5f5;
  height: calc(100% - 80px);
  overflow: hidden;
}
.tabs .tab-content > div {
  position: absolute;
  transform: scale(0.5);
  opacity: 0;
  top: 200%;
  padding: 20px;
  transition: all 500ms ease-in-out;
}
.tabs .tab-content > div.active {
  transform: scale(1);
  opacity: 1;
  top: 0%;
}
</style>

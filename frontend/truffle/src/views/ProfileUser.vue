<template>
  <div class="container">
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="10">
        <h1 class="profile">프로필</h1>
        <hr />
      </v-col>
    </v-row>
    <br />
    <h2>나의 활동</h2>

    <div class="vtabs">
      <input type="radio" name="vtab" id="tab1" checked="checked" />
      <label for="tab1">기본정보</label>

      <input type="radio" name="vtab" id="tab2" />
      <label for="tab2">래플 응모내역</label>

      <input type="radio" name="vtab" id="tab3" />
      <label for="tab3">찜한이벤트</label>

      <input type="radio" name="vtab" id="tab4" />
      <label for="tab4">구매후기</label>

      <input type="radio" name="vtab" id="tab5" />
      <label for="tab5">주문내역조회</label>

      <div class="vtab-content">
        <div id="content1">
          <h2>공사중1</h2>
          <p>공사중 내용1</p>
        </div>
        <div id="content2">
          <h2>공사중2</h2>
          <img src="" alt="" />
          <p>공사중 내용2</p>
        </div>
        <div id="content3">
          <h2>공사중3</h2>
          <p>공사중 내용3</p>
        </div>
        <div id="content4">
          <h2>공사중4</h2>
          <p>공사중 내용4</p>
        </div>
        <div id="content5">
          <Order></Order>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Order from '../views/profileuser/Order';

export default {
  name: 'ProfileUser',
  components: {
    Order,
  },
  methods: {},
};
</script>

<style scoped>
.profile {
  text-align: center;
}
.container {
  margin-top: 62px;
  font-family: 'Open Sans', sans-serif;
  color: #404040;
}
p {
  line-height: 1.5;
}
.vtabs {
  width: 100%;
  /* padding: 20px; */
  margin: 10px 0 0 0;
  position: relative;
}
.vtabs input {
  display: none;
}
.vtabs label {
  display: block;
  width: 20%;
  padding: 15px;
  color: #a2a2a2;
  font-weight: 700;
  font-size: 15px;
  border-radius: 5px solid #dcdcdc;
  transition: 0.3s ease;
}
.vtabs label:hover {
  cursor: pointer;
  color: #404040;
}
.vtabs input:checked + label {
  color: #404040;
  border-left: 5px solid #00c4ff;
}
.vtabs #tab1:checked ~ .vtab-content #content1,
.vtabs #tab2:checked ~ .vtab-content #content2,
.vtabs #tab3:checked ~ .vtab-content #content3,
.vtabs #tab4:checked ~ .vtab-content #content4,
.vtabs #tab5:checked ~ .vtab-content #content5 {
  display: block;
}
.vtabs .vtab-content {
  position: absolute;
  top: 0%;
  max-width: 100%;
  left: 20%;
}
.vtabs .vtab-content div {
  display: none;
}
.vtabs img {
  max-width: 550px;
  width: 100%;
  border-radius: 15px;
}
</style>

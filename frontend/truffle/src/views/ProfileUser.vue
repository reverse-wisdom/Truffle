<template>
  <div class="container">
    <v-row>
      <v-img :src="url" max-height="300" max-width="1800"></v-img>
    </v-row>
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="10">
        <!-- <h1 class="profile">프로필</h1> -->
        <!-- <hr /> -->
      </v-col>
    </v-row>
    <br />
    <h2>나의 활동</h2>

    <div class="vtabs" v-if="this.$store.state.type == '1'">
      <input type="radio" name="vtab" id="tab1" checked="checked" />
      <label for="tab1">기본정보</label>

      <input type="radio" name="vtab" id="tab2" />
      <label for="tab2">래플 응모내역</label>

      <input type="radio" name="vtab" id="tab3" />
      <label for="tab3">당첨된 이벤트</label>

      <input type="radio" name="vtab" id="tab4" />
      <label for="tab4">주문내역조회</label>

      <div class="vtab-content">
        <div id="content1">
          <Basic></Basic>
        </div>
        <div id="content2">
          <Event v-for="(event, idx) in events" :key="idx" :event="event"></Event>
        </div>
        <div id="content3">
          <Win v-for="(win, idx) in wins" :key="idx" :win="win"></Win>
        </div>
        <div id="content4">
          <Order></Order>
        </div>
      </div>
    </div>
    <div class="vtabs" v-else>
      <input type="radio" name="vtab" id="tab1" checked="checked" />
      <label for="tab1">기본정보</label>

      <input type="radio" name="vtab" id="tab2" />
      <label for="tab2">등록 상품</label>

      <input type="radio" name="vtab" id="tab3" />
      <label for="tab3">응모마감 상품</label>

      <input type="radio" name="vtab" id="tab4" />
      <label for="tab4">배송관리</label>

      <div class="vtab-content">
        <div id="content1">
          <Basic></Basic>
        </div>
        <div id="content2">
          <Event v-for="(event, idx) in events" :key="idx" :event="event"></Event>
        </div>
        <div id="content3">
          <Win v-for="(win, idx) in wins" :key="idx" :win="win"></Win>
        </div>
        <div id="content4">
          <Order></Order>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Order from '../views/profile/Order';
import Basic from '../views/profile/Basic';
import Event from '../views/profile/Event';
import Win from '../views/profile/Win';
import { retailerAllEvent, userJoinEvent, userWinEvent } from '@/api/auth';

export default {
  name: 'ProfileUser',
  data() {
    return {
      events: [],
      wins: [],
      url: require('@/assets/img/profile.png'),
    };
  },
  components: {
    Order,
    Basic,
    Event,
    Win,
  },
  methods: {},
  async created() {
    if (this.$store.state.type == '2') {
      const { data } = await retailerAllEvent(this.$store.state.retailuuid);
      console.log('등록한 래플', data);
      this.events = data;
      for (let i = 0; i < data.length; i++) {
        if (new Date(data[i].end_date) < Date.now()) {
          this.wins.push(data[i]);
        }
      }
      console.log(this.wins);
    } else {
      const { data } = await userJoinEvent(this.$store.state.email);
      // console.log('응모', data);
      this.events = data;

      {
        const { data } = await userWinEvent(this.$store.state.email);
        // console.log('당첨상품', data);
        this.wins = data;
      }
    }
  },
};
</script>

<style scoped>
.profile {
  text-align: center;
}
.container {
  margin-top: 8rem;
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
  border-left: 5px solid #381dfc;
}
.vtabs #tab1:checked ~ .vtab-content #content1,
.vtabs #tab2:checked ~ .vtab-content #content2,
.vtabs #tab3:checked ~ .vtab-content #content3,
.vtabs #tab4:checked ~ .vtab-content #content4,
.vtabs #tab5:checked ~ .vtab-content #content5 {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}
.vtabs .vtab-content {
  position: absolute;
  top: 0%;
  max-width: 100%;
  left: 20%;
}
.vtabs .vtab-content #content1,
.vtabs .vtab-content #content2,
.vtabs .vtab-content #content3,
.vtabs .vtab-content #content4,
.vtabs .vtab-content #content5 {
  display: none;
}
.vtabs img {
  max-width: 550px;
  width: 100%;
  border-radius: 15px;
}
</style>

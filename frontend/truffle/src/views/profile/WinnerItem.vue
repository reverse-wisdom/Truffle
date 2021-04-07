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
        <div class="a active">
          <v-data-table :headers="headers" :items="status0" @click:row="detailPage" class=""></v-data-table>
        </div>
        <div class="a">
          <v-data-table :headers="headers" :items="status1" @click:row="detailPage" class=""></v-data-table>
        </div>
        <div class="a">
          <v-data-table :headers="headers" :items="status2" @click:row="detailPage" class=""></v-data-table>
        </div>
        <div class="a">
          <v-data-table :headers="headers" :items="status3" @click:row="detailPage" class=""></v-data-table>
        </div>
        <div class="a">
          <v-data-table :headers="headers" :items="status4" @click:row="detailPage" class=""></v-data-table>
        </div>
      </div>
      <div class="btn-style">
        <v-btn dark @click="$router.go(-1)">뒤로가기</v-btn>
      </div>
    </div>
  </v-container>
</template>

<script>
import { userWinEvent } from '@/api/auth';
import { fetchOrder } from '@/api/order';
import { eventDetail } from '@/api/event';

export default {
  data() {
    return {
      status0: [],
      status1: [],
      status2: [],
      status3: [],
      status4: [],
      endevent: '',
      state: '',
      headers: [
        {
          text: '카테고리',
          align: 'start',
          value: 'category',
        },
        { text: '제목', value: 'product' },
        { text: '가격', value: 'price' },
        { text: '시작시간', value: 'open_date' },
        { text: '마감시간', value: 'end_date' },
      ],
    };
  },
  computed: {
    priceComma: function() {
      return this.endevent.map(function(event) {
        return event.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      });
    },
  },
  mounted() {
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
          .getElementsByClassName('a')
          [i].classList.add('active');
      });
    }
  },
  async created() {
    //// 유저입장
    // 당첨내역조회
    const { data } = await userWinEvent(this.$store.state.email);
    // console.log('담첨내역', data);

    // 이벤트아이디로 결제 조회
    for (let i = 0; i < data.length; i++) {
      const res = await fetchOrder(data[i].event_id);
      // console.log('결제조회', res);

      if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 1) {
        const response = await eventDetail(data[i].event_id);
        this.status1.push(response.data[0]);
      } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 2) {
        const response = await eventDetail(data[i].event_id);
        this.status2.push(response.data[0]);
      } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 3) {
        const response = await eventDetail(data[i].event_id);
        this.status3.push(response.data[0]);
      } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 4) {
        const response = await eventDetail(data[i].event_id);
        this.status4.push(response.data[0]);
      } else {
        const response = await eventDetail(data[i].event_id);
        this.status0.push(response.data[0]);
      }
    }
  },

  methods: {
    tabclick() {
      // let tabPanes = document.getElementsByClassName('tab-header')[0].getElementsByTagName('div');
      // for (let i = 0; i < tabPanes.length; i++) {
      //   tabPanes[i].addEventListener('click', function() {
      //     document
      //       .getElementsByClassName('tab-header')[0]
      //       .getElementsByClassName('active')[0]
      //       .classList.remove('active');
      //     tabPanes[i].classList.add('active');
      //     document
      //       .getElementsByClassName('tab-content')[0]
      //       .getElementsByClassName('active')[0]
      //       .classList.remove('active');
      //     document
      //       .getElementsByClassName('tab-content')[0]
      //       .getElementsByTagName('div')
      //       [i].classList.add('active');
      //   });
      // }
    },
    detailPage(value) {
      const event_id = value.event_id;
      this.$router.push({ name: 'EventDetail', query: { event_id: event_id } });
    },
  },
};
</script>

<style scoped>
.v-data-table {
  width: 59vw;
}
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
.btn-style {
  text-align: right;
  margin-top: 20px;
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
  /* overflow: hidden; */
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

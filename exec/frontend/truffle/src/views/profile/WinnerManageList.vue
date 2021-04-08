<template>
  <v-container>
    <!-- <div class="title-text">당첨자 상품관리</div> -->
    <v-img :src="banner" max-height="400" max-width="1900" class="mt-12 mb-0"></v-img>
    <div class="winner-manage">
      <table class="content-table">
        <thead>
          <tr>
            <th id="no" class="no">NO</th>
            <th id="email" class="email">E-MAIL</th>
            <th id="phone" class="phone">PHONE</th>
            <th id="now" class="now">NOW</th>
            <th id="state" class="state">STATE</th>
          </tr>
        </thead>
      </table>
      <WinnerManage v-for="(winner, idx) in winnerList" :key="idx" :winner="winner" :idx="idx" :event_id="event_id"></WinnerManage>
    </div>
    <div style="text-align:right">
      <v-btn dark @click="$router.go(-1)">뒤로가기</v-btn>
    </div>
  </v-container>
</template>

<script>
import { selectedWinner } from '@/api/event';
import { editOderStatus, fetchOrder } from '@/api/order';
import WinnerManage from '@/views/profile/WinnerManage.vue';
export default {
  components: {
    WinnerManage,
  },
  data() {
    return {
      winnerList: [],
      status: '',
      list: [],
      banner: require('@/assets/img/orderbanner.jpg'),
      event_id: '',
    };
  },
  async created() {
    this.event_id = this.$route.query.event_id;
    const event_id = this.$route.query.event_id;
    const { data } = await selectedWinner(event_id);
    this.winnerList = data;
    const res = await fetchOrder(event_id);

    for (let j = 0; j < data.length; j++) {
      for (let i = 0; i < res.data.length; i++) {
        if (data[j].uuid == res.data[i].uuid) {
          const addUser = {
            ship_status: res.data[i].status,
            email: data[j].email,
            phone: data[j].phone,
          };
          this.list.push(addUser);
        }
      }
    }
  },
  methods: {
    async checkState(uuid) {
      const res = await fetchOrder(this.$route.query.event_id);
      const editdata = {
        uuid: uuid,
        event_id: res.data.event_id,
        pay_status: res.data.pay_status,
        ship_status: this.status,
      };
      const { data } = await editOderStatus(editdata);
    },
  },
};
</script>

<style scoped>
.no {
  width: 10vw !important;
  text-align: center !important;
}
.email {
  width: 23vw !important;
  text-align: center !important;
}
.phone {
  width: 26vw !important;
  text-align: center !important;
}
.now {
  width: 26vw !important;
  text-align: center !important;
}

* {
  font-family: sans-serif; /* Change your font family */
}
.title-text {
  margin-top: 10%;
  text-align: center;
  font-size: 2rem;
}
.winner-manage {
  text-align: center;
  justify-content: center;
  /* display: flex; */
  margin-top: 2rem;
}
.content-table {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  min-width: 400px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.content-table thead tr {
  background-color: #000;
  color: #ffffff;
  text-align: left;
  font-weight: bold;
}

.content-table th,
.content-table td {
  padding: 12px 15px;
  width: 1500px;
  text-align: center;
}

.content-table tbody tr {
  border-bottom: 1px solid #dddddd;
}

.content-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}

.content-table tbody tr:last-of-type {
  border-bottom: 2px solid #000;
}

.content-table tbody tr.active-row {
  font-weight: bold;
  color: #000;
}
</style>

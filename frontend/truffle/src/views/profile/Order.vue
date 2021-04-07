<template>
  <span class="order">
    <div class="process-wrapper">
      <div class="event-index" v-for="(event, idx) in endevent" ref="endevent" :key="idx">
        <div class="card">
          <figure>
            <img src="@/assets/img/women.jpg" alt="" />
          </figure>
          <section class="details">
            <div class="product-detail">
              <div class="product">{{ event.product }}</div>
              <h1 class="price">{{ priceComma[idx] }}원</h1>
            </div>
            <div class="min-details">
              <div>
                <span>#{{ event.category }}</span>
                <span>#{{ event.gender }}</span>
                <span>#{{ event.age }}</span>
              </div>

              <div class="">
                <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
              </div>
              <div class="">
                <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
              </div>
              <!-- <a class="btn">자세히보기</a> -->
              <a @click="ManageGo(event.event_id)" class="btn">당첨자관리</a>
            </div>
          </section>
        </div>
      </div>
    </div>
  </span>
</template>

<script>
import { fetchOrder } from '@/api/order';
import { userWinEvent, retailerAllEvent } from '@/api/auth';
import { selectedWinner, eventDetail } from '@/api/event';
// import WinnerItem from '@/views/profile/WinnerItem.vue';

export default {
  name: 'Order',
  data() {
    return {
      status0: [],
      status1: [],
      status2: [],
      status3: [],
      status4: [],
      endevent: '',
      state: '',
    };
  },
  computed: {
    priceComma: function() {
      return this.endevent.map(function(event) {
        return event.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      });
    },
  },
  async created() {
    if (this.$store.state.type == 1) {
      //// 유저입장
      // 당첨내역조회
      const { data } = await userWinEvent(this.$store.state.email);
      // console.log(data);

      // 이벤트아이디로 결제 조회
      for (let i = 0; i < data.length; i++) {
        const res = await fetchOrder(data[i].event_id);

        if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 1) {
          const response = await eventDetail(res.data.event_id);

          this.status1.push(response.data[0]);
        } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 2) {
          const response = await eventDetail(res.data.event_id);
          this.status2.push(response.data[0]);
        } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 3) {
          const response = await eventDetail(res.data.event_id);
          this.status3.push(response.data[0]);
        } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 4) {
          const response = await eventDetail(res.data.event_id);
          this.status4.push(response.data[0]);
        } else {
          const response = await eventDetail(res.data.event_id);
          this.status0.push(response.data[0]);
        }
      }
    } else {
      //마감된 상품
      const { data } = await retailerAllEvent(this.$store.state.uuid);
      const endevent = [];
      for (let i = 0; i < data.length; i++) {
        if (new Date(data[i].end_date) < Date.now()) {
          endevent.push(data[i]);
        }
        this.endevent = endevent;
      }
    }
  },
  methods: {
    ManageGo(event_id) {
      this.$router.push({ name: 'WinnerManage', query: { event_id: event_id } });
    },
  },
};
</script>

<style scoped>
.order {
  margin: 0;
  font-family: 'Roboto Condensed', sans-serif;
  margin-bottom: 5rem;
}

h4 {
  color: #333;
  font-weight: 700;
  margin-top: -20px;
  text-align: center;
  text-transform: uppercase;
  letter-spacing: 4px;
  line-height: 23px;
}
h2 {
  margin-top: 0;
  margin-bottom: 0;
}

/* card */
.product-detail > .product {
  margin: 3px 0;
  font-size: 1.5rem;
  font-weight: 900;
}
.product-detail > .price {
  display: flex;
  font-weight: 900;
  font-size: 1rem;
  color: #256eff;
  flex-direction: row-reverse;
  margin-top: 10px;
}
/* * {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
} */
.event {
  width: 15vw;
  margin-bottom: 50px;
  display: inline-table;
}
.event-index {
  display: flex;
  align-items: center;
  min-height: auto;
  /* justify-content: space-around; */
  font-family: 'Poppins', sans-serif;
}
h1 {
  font-size: 1.2rem;
  text-transform: capitalize;
}

.card {
  margin-right: 20px;
  position: relative;
  border-radius: 5px;
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3);
  height: 400px;
  overflow: hidden;
  width: 280px;
}
.card > figure {
  width: 90%;
  margin: 20px auto 0 auto;
}
.card > .idx-box {
  background: #000;
  color: #fff;
  text-align: center;
}
.card > figure > img {
  width: 100%;
}
.details {
  background-color: #fff;
  border-radius: 10px;
  padding: 20px;
  position: absolute;
  top: 60%;
  width: 100%;
  transition: box-shadow 0.3s ease-in-out, top 0.3s ease-in-out;
}
.card:hover .details {
  box-shadow: 0 -5px 10px rgba(0, 0, 0, 0.3);
  top: 30%;
}
.details > .min-details,
.details > .options,
.details > .options > .options-colors {
  margin: 5px 0;
}
.details > .min-details {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  font-weight: 900;
  font-size: 1rem;
}

.details > .options h1 {
  margin-bottom: 10px;
}
.details > .options-size {
  display: flex;
  justify-content: center;
  align-items: center;
}

.btn {
  background-color: #f3118e;
  border-radius: 5px;
  color: #fff;
  display: block;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  text-transform: capitalize;
  width: 100%;
  padding-bottom: 10px;
  transition: box-shadow 0.3s ease-in-out, transform 0.3s ease-in-out;
}
.btn:hover {
  box-shadow: 0 8px 10px rgba(0, 0, 0, 0.3);
  transform: translateY(-2px);
}

.content-table {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  min-width: 100%;
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

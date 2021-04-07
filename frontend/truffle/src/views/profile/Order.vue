<template>
  <span class="order">
    <div class="process-wrapper" v-if="this.$store.state.type == '1'">
      <div id="progress-bar-container">
        <ul>
          <li class="step step01 active" @click="step01"><div class="step-inner">결제전</div></li>
          <li class="step step02" @click="step02"><div class="step-inner">결제완료</div></li>
          <li class="step step03" @click="step03"><div class="step-inner">배송준비중</div></li>
          <li class="step step04" @click="step04"><div class="step-inner">배송중</div></li>
          <li class="step step05" @click="step05"><div class="step-inner">배송완료</div></li>
        </ul>

        <div id="line">
          <div id="line-progress"></div>
        </div>
      </div>

      <div id="progress-content-section">
        <div class="section-content discovery active">
          <h2>결제전</h2>
          <p>{{ status0 }}}</p>
        </div>

        <div class="section-content strategy">
          <h2>결제완료</h2>
          <p>{{ status1 }}}</p>
        </div>

        <div class="section-content creative">
          <h2>배송준비중</h2>
          <p>{{ status2 }}}</p>
        </div>

        <div class="section-content production">
          <h2>배송중</h2>
          <p>{{ status3 }}}</p>
        </div>

        <div class="section-content analysis">
          <h2>배송완료</h2>
          <p>{{ status4 }}}</p>
        </div>
      </div>
    </div>
    <div class="process-wrapper" v-else>
      <div class="event-index" v-for="(event, idx) in endevent" ref="endevent" :key="idx">
        <div class="card">
          <figure>
            <img class="detail-image" :src="'data:image/jpeg;base64,' + detailImg" />
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
import { selectedWinner } from '@/api/event';
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
    };
  },
  computed: {
    priceComma: function() {
      return this.endevent.map(function(event) {
        return event.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      });
    },
  },
  // async created() {
  //   if (this.$store.state.type == 1) {
  //     //// 유저입장
  //     // 당첨내역조회
  //     const { data } = await userWinEvent(this.$store.state.email);
  //     // console.log(data);

  //     // 이벤트아이디로 결제 조회
  //     for (let i = 0; i < data.length; i++) {
  //       const res = await fetchOrder(data[i].event_id);

  //       if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 1) {
  //         const response = await eventDetail(res.data.event_id);

  //         this.status1.push(response.data[0]);
  //       } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 2) {
  //         const response = await eventDetail(res.data.event_id);
  //         this.status2.push(response.data[0]);
  //       } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 3) {
  //         const response = await eventDetail(res.data.event_id);
  //         this.status3.push(response.data[0]);
  //       } else if (res.data.uuid == this.$store.state.uuid && res.data.ship_status == 4) {
  //         const response = await eventDetail(res.data.event_id);
  //         this.status4.push(response.data[0]);
  //       } else {
  //         const response = await eventDetail(res.data.event_id);
  //         this.status0.push(response.data[0]);
  //       }
  //     }
  //   } else {
  //     //마감된 상품
  //     const { data } = await retailerAllEvent(this.$store.state.uuid);
  //     const endevent = [];
  //     for (let i = 0; i < data.length; i++) {
  //       if (new Date(data[i].end_date) < Date.now()) {
  //         endevent.push(data[i]);
  //       }
  //       this.endevent = endevent;
  //     }
  //   }
  // },
  methods: {
    step01() {
      $('.step').click(function() {
        $(this)
          .addClass('active')
          .prevAll()
          .addClass('active');
        $(this)
          .nextAll()
          .removeClass('active');
      });

      $('.step01').click(function() {
        $('#line-progress').css('width', '3%');
        $('.discovery')
          .addClass('active')
          .siblings()
          .removeClass('active');
      });
    },
    step02() {
      $('.step').click(function() {
        $(this)
          .addClass('active')
          .prevAll()
          .addClass('active');
        $(this)
          .nextAll()
          .removeClass('active');
      });
      $('.step02').click(function() {
        $('#line-progress').css('width', '25%');
        $('.strategy')
          .addClass('active')
          .siblings()
          .removeClass('active');
      });
    },
    step03() {
      $(this)
        .addClass('active')
        .prevAll()
        .addClass('active');
      $(this)
        .nextAll()
        .removeClass('active');
      $('#line-progress').css('width', '50%');
      $('.creative')
        .addClass('active')
        .siblings()
        .removeClass('active');
    },
    step04() {
      $(this)
        .addClass('active')
        .prevAll()
        .addClass('active');
      $(this)
        .nextAll()
        .removeClass('active');
      $('#line-progress').css('width', '75%');
      $('.production')
        .addClass('active')
        .siblings()
        .removeClass('active');
    },
    step05() {
      $(this)
        .addClass('active')
        .prevAll()
        .addClass('active');
      $(this)
        .nextAll()
        .removeClass('active');
      $('#line-progress').css('width', '100%');
      $('.analysis')
        .addClass('active')
        .siblings()
        .removeClass('active');
    },
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

/* --- Start progress bar --- */

.process-wrapper {
  margin: auto;
  max-width: 1080px;
  width: 60vw;
}

#progress-bar-container {
  position: relative;
  width: 80%;
  margin: auto;
  height: 100px;
  margin-top: 65px;
}

#progress-bar-container ul {
  padding: 0;
  margin: 0;
  padding-top: 15px;
  z-index: 9999;
  position: absolute;
  width: 100%;
  margin-top: -40px;
}

#progress-bar-container li:before {
  content: ' ';
  display: block;
  margin: auto;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  border: solid 2px #aaa;
  transition: all ease 0.3s;
}

#progress-bar-container li.active:before,
#progress-bar-container li:hover:before {
  border: solid 2px #fff;

  background: #381dfc;
}

#progress-bar-container li {
  list-style: none;
  float: left;
  width: 20%;
  text-align: center;
  color: #aaa;
  text-transform: uppercase;
  font-size: 11px;
  cursor: pointer;
  font-weight: 700;
  transition: all ease 0.2s;
  vertical-align: bottom;
  height: 60px;
  position: relative;
}

#progress-bar-container li .step-inner {
  position: absolute;
  width: 100%;
  bottom: 0;
  font-size: 14px;
}

#progress-bar-container li.active,
#progress-bar-container li:hover {
  color: #444;
}

#progress-bar-container li:after {
  content: ' ';
  display: block;
  width: 20px;
  height: 20px;
  background: #fff;
  margin: auto;
  border: solid 4px #10004d;
  border-radius: 50%;
  margin-top: 40px;
  box-shadow: 0 2px 13px -1px rgba(0, 0, 0, 0.3);
  transition: all ease 0.2s;
}

#progress-bar-container li:hover:after {
  background: #000;
}

#progress-bar-container li.active:after {
  background: #f3118e;
}

#progress-bar-container #line {
  width: 80%;
  margin: auto;
  background: #eee;
  height: 6px;
  position: absolute;
  left: 10%;
  top: 50px;
  z-index: 1;
  border-radius: 50px;
  transition: all ease 0.9s;
}

#progress-bar-container #line-progress {
  content: ' ';
  width: 3%;
  height: 100%;
  background: #f3118e;
  /* background: linear-gradient(to right, #207893 0%, #2ea3b7 100%); */
  position: absolute;
  z-index: 2;
  border-radius: 50px;
  transition: all ease 0.9s;
}

#progress-content-section {
  width: 90%;
  margin: auto;
  background: #f3f3f3;
  border-radius: 4px;
}

#progress-content-section .section-content {
  padding: 30px 40px;
  text-align: center;
}

#progress-content-section .section-content h2 {
  font-size: 17px;
  text-transform: uppercase;
  color: #333;
  letter-spacing: 1px;
}

#progress-content-section .section-content p {
  font-size: 16px;
  line-height: 1.8em;
  color: #777;
}

#progress-content-section .section-content {
  display: none;
  animation: FadeInUp 700ms ease 1;
  animation-fill-mode: forwards;
  transform: translateY(15px);
  opacity: 0;
}

#progress-content-section .section-content.active {
  display: block;
}

@keyframes FadeInUp {
  0% {
    transform: translateY(15px);
    opacity: 0;
  }

  100% {
    transform: translateY(0px);
    opacity: 1;
  }
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
.price {
  margin-top: 10px;
}
</style>

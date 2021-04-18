<template>
  <div class="deadline">
    <div class="event-index" v-for="(event, idx) in events" ref="events" :key="idx">
      <div class="card">
        <div class="idx-box">{{ idx + 1 }}위</div>
        <figure>
          <img class="detail-image" :src="imgURL + event.event_id" />
        </figure>

        <section class="details">
          <div class="product-detail">
            <div class="product">{{ event.product }}</div>
            <div class="price">{{ priceComma[idx] }}원</div>
          </div>
          <div class="min-details">
            <div>
              <span>#{{ event.category }}</span>
              <span v-show="event.gender == 1" outlined>#남성</span>
              <span v-show="event.gender == 2" outlined>#여성</span>
              <span>#{{ event.age }}대</span>
            </div>
            <div>
              <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ event.join_num }}명 / 총추첨인원{{ event.win_num }}명</v-chip>
            </div>
            <div>
              <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ event.end_date }}</div>
            </div>
            <a class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
          </div>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
import { eventAll } from '@/api/event';
export default {
  data() {
    return {
      events: [],
      detailImg: [],
      index: 0,
      imgURL: 'https://j4d110.p.ssafy.io/truffle/event/selectEventImgFileEventID?event_id=',
    };
  },
  async created(idx) {
    const { data } = await eventAll();
    data.sort(function(a, b) {
      if (new Date(a.end_date) > new Date(b.end_date)) {
        return 1;
      }
      if (new Date(a.end_date) < new Date(b.end_date)) {
        return -1;
      }
      return 0;
    });
    for (let i = 0; i < data.length; i++) {
      if (new Date(data[i].end_date) < Date.now()) {
        continue;
      } else {
        this.events.push(data[i]);
      }
    }
    this.events = this.events.slice(0, 4);
  },
  computed: {
    priceComma: function() {
      return this.events.map(function(event) {
        return event.price.toLocaleString('ko-KR');
      });
    },
  },
  methods: {
    eventDetailGo(event_id) {
      // console.log('인덱스에서 이벤트아이디', event_id);
      this.$router.push({ name: 'EventDetail', query: { event_id: event_id } });
    },
  },
};
</script>

<style scoped>
.deadline {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}
.event {
  width: 15vw;
  margin-bottom: 50px;
  display: inline-table;
}
.event-index {
  display: flex;
  align-items: center;
  min-height: auto;
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
.details > .options ul li {
  border-radius: 50%;
  cursor: pointer;
  height: 20px;
  line-height: 30px;
  margin-left: 5px;
  text-align: center;
  width: 30px;
}
.options-size > ul > li {
  background-color: rgba(0, 0, 0, 0.3);
  color: #000;
  font-size: 0.7rem;
  font-weight: 900;
  text-transform: uppercase;
  transition: background-color 0.3s ease-in-out;
}
.options-size > ul > li:hover {
  background-color: #f3118e;
}
.options-colors > ul > li {
  border: none;
}
.options-colors > ul > li:nth-child(1) {
  background-color: #ff1;
}
.options-colors > ul > li:nth-child(2) {
  background-color: #000;
}
.options-colors > ul > li:nth-child(3) {
  background-color: #fb0000;
}
.options-colors > ul > li:nth-child(4) {
  background-color: #ff69b4;
}
.options-colors > ul > li:nth-child(5) {
  background-color: #ff1;
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
.product-detail > .product {
  margin: 3px 0;
  font-size: 1.5rem;
  font-weight: 900;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.product-detail > .price {
  display: flex;
  font-weight: 900;
  font-size: 1rem;
  color: #256eff;
  flex-direction: row-reverse;
}
</style>

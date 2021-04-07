<template>
  <div class="event">
    <div v-if="this.$store.state.type == '1'">
      <div class="event-index" ref="event">
        <div class="card">
          <figure>
            <img class="detail-image" :src="'data:image/jpeg;base64,' + detailImg" />
          </figure>
          <section class="details">
            <div class="product-detail">
              <div class="product">{{ event.product }}</div>
              <h1 class="price">{{ priceComma }}원</h1>
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

              <a class="btn" @click="eventDetailGo">자세히보기</a>
            </div>
          </section>
        </div>
      </div>
    </div>
    <div v-else>
      <div class="event-index" ref="event">
        <div class="card">
          <figure></figure>
          <section class="details">
            <div class="product-detail">
              <div class="product">{{ event.product }}</div>
              <h1 class="price">{{ priceComma }}원</h1>
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

              <a class="btn" @click="eventDetailGo">자세히보기</a>
            </div>
          </section>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { returnImage64 } from '@/api/event';
export default {
  name: 'Event',
  data() {
    return {
      detailImg: [],
    };
  },
  props: {
    event: {
      type: Object,
    },
  },
  computed: {
    priceComma() {
      return this.event.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    },
  },
  methods: {
    eventDetailGo() {
      this.$router.push({ name: 'EventDetail', query: { event_id: this.event.event_id } });
    },
  },
};
</script>

<style scoped>
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
.price {
  margin-top: 10px;
}
</style>

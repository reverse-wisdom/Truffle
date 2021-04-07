<template>
  <div class="event">
    <div v-if="this.$store.state.type == '1'">
      <div class="event-index">
        <div class="card">
          <figure>
            <img class="detail-image" :src="'data:image/jpeg;base64,' + detailImg" />
          </figure>
          <section class="details">
            <div class="product-detail">
              <div class="product">{{ win.product }}</div>
              <h1 class="price">{{ priceComma }}원</h1>
            </div>
            <div class="min-details">
              <div>
                <span>#{{ event.category }}</span>
                <span v-show="event.gender == 1" outlined>#남성</span>
                <span v-show="event.gender == 2" outlined>#여성</span>
                <span>#{{ event.age }}대</span>
              </div>

              <div class="">
                <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ win.join_num }}명 / 총추첨인원{{ win.win_num }}명</v-chip>
              </div>
              <div class="">
                <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ win.end_date }}</div>
              </div>

              <a class="btn" @click="eventDetailGo">자세히보기</a>
            </div>
          </section>
        </div>
      </div>
    </div>
    <div v-else>
      <div class="win-index">
        <div class="card">
          <figure>
            <img class="detail-image" :src="'data:image/jpeg;base64,' + detailImg" />
          </figure>
          <section class="details">
            <div class="product-detail">
              <div class="product">{{ win.product }}</div>
              <h1 class="price">{{ priceComma }}원</h1>
            </div>
            <div class="min-details">
              <div>
                <span>#{{ win.category }}</span>
                <span>#{{ win.gender }}</span>
                <span>#{{ win.age }}</span>
              </div>

              <div class="">
                <v-chip style="background-color:#07b8ac;" text-color="white">응모자{{ win.join_num }}명 / 총추첨인원{{ win.win_num }}명</v-chip>
              </div>
              <div class="">
                <div style="font-size: 12px; margin: 10px 0;">이벤트종료일:{{ win.end_date }}</div>
              </div>

              <a class="btn" @click="eventDetailGo">추첨자뽑기</a>
            </div>
          </section>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { userWinEvent } from '@/api/auth';
import { eventWin, returnImage64 } from '@/api/event';
export default {
  name: 'Win',
  data() {
    return {
      detailImg: '',
    };
  },
  computed: {
    priceComma() {
      return this.win.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    },
  },
  props: {
    win: {
      type: Object,
    },
  },
  async created() {
    console.log(this.win.event_id);
    const resImage = await returnImage64(this.win.event_id);
    console.log(resImage);
    this.detailImg = resImage.data;
  },
  methods: {
    eventDetailGo() {
      this.$router.push({ name: 'EventDetail', query: { event_id: this.win.event_id } });
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

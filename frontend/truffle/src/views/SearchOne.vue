<template>
  <div class="event-ct">
    <div class="event-index">
      <div class="card">
        <!-- <div class="idx-box">{{ idx + 1 }}위</div> -->
        <figure>
          <img class="detail-image" :src="imgURL + event.event_id" />
        </figure>

        <section class="details">
          <div class="product-detail">
            <div class="product">{{ event.product }}</div>
            <div class="price">{{ priceComma }}원</div>
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
            <a href="#" class="btn" style="margin-top:;" @click="eventDetailGo(event.event_id)">자세히보기</a>
          </div>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Event',
  data() {
    return {
      imgURL: 'https://j4d110.p.ssafy.io/truffle/event/selectEventImgFileEventID?event_id=',
    };
  },
  props: {
    event: {
      type: Object,
    },
  },
  methods: {
    eventDetailGo() {
      this.$router.push({ name: 'EventDetail', query: { event_id: this.event.event_id } });
    },
  },
  computed: {
    priceComma: function() {
      return this.event.price
        .toString()
        .split('')
        .reverse()
        .join('')
        .replace(/(\d{3}(?!.*\.|$))/g, '$1,')
        .split('')
        .reverse()
        .join('');
    },
  },
};
</script>

<style scoped>
.event {
  width: 15vw;
  margin-bottom: 50px;
  display: inline-table;
}
.event-ct {
  display: flex;
  flex-wrap: wrap;
  margin-bottom: 20%;
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

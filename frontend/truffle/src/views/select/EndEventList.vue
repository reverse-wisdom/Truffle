<template>
  <div class="deadline">
    <div class="event-index" v-for="(event, idx) in events" :key="idx">
      <div class="card">
        <figure>
          <img src="@/assets/img/women.jpg" alt="" />
        </figure>
        <section class="details">
          <div class="min-details">
            <h1>
              {{ event.product }}
              <span>카테고리:{{ event.category }}</span>
              <span>성별:{{ event.gender }}</span>
              <span>연령대:{{ event.age }}</span>
            </h1>
            <h1 class="price">{{ event.price }}</h1>
          </div>
          <div class="options">
            <div class="options-size">
              <h1 class="">응모자수:{{ event.join_num }}</h1>
            </div>
            <div class="options-colors">
              <h1>마감일:{{ event.end_date }}</h1>
            </div>
          </div>
          <a href="#" class="btn" @click="eventDetailGo">응모현황</a>
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
      events: '',
    };
  },
  async created() {
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
    data.reverse();
    console.log('정렬후', data);
    this.events = data.slice(0, 4);
  },
  methods: {
    eventDetailGo() {},
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
  margin-bottom: 10px;
}
.details > .min-details {
  display: flex;
  justify-content: space-between;
}
.details > .min-details > h1 > span {
  color: #7b7b7b;
  display: block;
  font-size: 0.9rem;
  font-weight: 400;
}
.details > .options h1 {
  margin-bottom: 10px;
}
.details > .options ul {
  list-style-type: none;
  display: flex;
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
</style>

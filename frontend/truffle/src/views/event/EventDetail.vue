<template>
  <div class="eventdetail">
    <div class="card-wrapper">
      <div class="card">
        <!-- card left -->
        <div class="product-imgs">
          <div class="img-display">
            <div class="img-showcase">
              <img src="@/assets/img/tombrown.jpg" alt="shoe image" />
            </div>
          </div>
        </div>
        <!-- card right -->
        <div class="product-content">
          <h2 class="product-title">{{ event.product }}</h2>

          <div class="product-price">
            <p class="price">
              가격:
              <span>{{ event.price }}</span>
            </p>
          </div>
          <div class="tag">
            <p class="product-tag">
              {{ gender }}
            </p>
            <br />
            <p class="product-tag">{{ event.age }}대</p>
          </div>
          <div class="product-detail">
            <h2>about this item:</h2>
            <ul>
              <li>
                Category:
                <span>{{ event.category }}</span>
              </li>
              <li>
                응모자수:
                <span>{{ event.join_num }}명</span>
              </li>

              <li>
                당첨자수:
                <span>{{ event.win_num }}명</span>
              </li>
              <li>
                마감일:
                <span>{{ event.end_date }}</span>
              </li>
            </ul>
          </div>

          <div v-show="$store.state.type == '1'" class="join-info">
            <button type="button" class="btn" @click="joinAdd">
              응모하기
            </button>
          </div>
        </div>
      </div>
    </div>
    <EventDetailTab></EventDetailTab>
    <div v-if="$store.state.retailuuid == event.uuid" style="text-align:right">
      <v-btn color="rgb(33,133,89)" class="mr-1" dark @click="updateEvent(event)">수정</v-btn>
      <v-btn color="rgb(68, 114, 148)" dark @click="$router.go(-1)">뒤로가기</v-btn>
    </div>
    <!-- else -->
    <div v-else style="text-align:right">
      <v-btn color="rgb(68, 114, 148)" dark @click="$router.go(-1)">뒤로가기</v-btn>
      <!-- 모달 -->
    </div>
  </div>
</template>

<script>
import EventDetailTab from '@/views/event/EventDetailTab';
import { eventDetail, eventJoin } from '@/api/event';
import { userJoinEvent } from '@/api/auth';
export default {
  name: 'EventDetail',
  components: { EventDetailTab },
  data() {
    return {
      event: '',
      tabcheck: false,
      gender: '',
    };
  },
  async created() {
    const event_id = this.$route.query.event_id;
    const { data } = await eventDetail(event_id);
    this.event = data[0];
    if (this.event.gender == 1) {
      this.gender = '남자';
    } else {
      this.gender = '여자';
    }
    console.log('상세이벤트', this.event);
  },
  methods: {
    async joinAdd() {
      const email = this.$store.state.email;
      let check = false;
      const event_id = this.$route.query.event_id;
      console.log(event_id, email);
      const { data } = await userJoinEvent(email);
      for (let i = 0; i < data.length; i++) {
        if (data[i].event_id == event_id) {
          check = true;
          break;
        } else {
          continue;
        }
      }
      if (check == false) {
        const { data } = await eventJoin(event_id);
        if (data == 'success') {
          this.event.join_num += 1;
          console.log('1증가');
        }
      } else {
        console.log('이미참여한이벤트');
      }
    },
    updateGo(value) {
      var event_id = this.event.event_id;
      this.$router.push({ name: 'EventUpdate', query: { event_id: event_id } });
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700;800&display=swap');

* {
  box-sizing: border-box;
  padding: 0;

  margin: 0;
  font-family: 'Open Sans', sans-serif;
}
/* body {
  line-height: 1.5;
} */
.card {
  margin-top: 25%;
}
.card-wrapper {
  max-width: 1100px;
  margin: 0 auto;
}
img {
  width: 100%;
  display: block;
}
.img-display {
  overflow: hidden;
}
.img-showcase {
  display: flex;
  width: 100%;
  transition: all 0.5s ease;
}
.img-showcase img {
  min-width: 100%;
}
.img-select {
  display: flex;
}
.img-item {
  margin: 0.3rem;
}
.img-item:nth-child(1),
.img-item:nth-child(2),
.img-item:nth-child(3) {
  margin-right: 0;
}
.img-item:hover {
  opacity: 0.8;
}
.product-content {
  padding: 2rem 1rem;
}
.product-title {
  font-size: 3rem;
  text-transform: capitalize;
  font-weight: 700;
  position: relative;
  color: #12263a;
  margin: 1rem 0;
}
.product-title::after {
  content: '';
  position: absolute;
  left: 0;
  bottom: 0;
  height: 4px;
  width: 80px;
  background: #12263a;
}
.product-tag {
  text-decoration: none;
  text-transform: uppercase;
  font-weight: 400;
  font-size: 0.9rem;
  display: inline-block;
  margin-bottom: 0.5rem;
  background: #256eff;
  color: #fff;
  padding: 0 0.3rem;
  transition: all 0.5s ease;
}
.product-tag:hover {
  opacity: 0.9;
}

.product-price {
  margin: 1rem 0;
  font-size: 1rem;
  font-weight: 700;
}
.product-price span {
  font-weight: 400;
}
.price span {
  color: #256eff;
}
.product-detail h2 {
  text-transform: capitalize;
  color: #12263a;
  padding-bottom: 0.6rem;
}
.product-detail p {
  font-size: 0.9rem;
  padding: 0.3rem;
  opacity: 0.8;
}
.product-detail ul {
  margin: 1rem 0;
  font-size: 0.9rem;
}
.product-detail ul li {
  margin: 0;
  list-style: none;
  background: url(../../assets/img/check.jpg) left center no-repeat;
  background-size: 18px;
  padding-left: 1.7rem;
  margin: 0.4rem 0;
  font-weight: 600;
  opacity: 0.9;
}
.product-detail ul li span {
  font-weight: 400;
}
.join-info {
  margin: 1.5rem 0;
}
.join-info input,
.join-info .btn {
  border: 1.5px solid #ddd;
  border-radius: 25px;
  text-align: center;
  padding: 0.45rem 0.8rem;
  outline: 0;
  margin-right: 0.2rem;
  margin-bottom: 1rem;
}

.join-info .btn {
  cursor: pointer;
  color: #fff;
  background: #f3118e;
}
.purchase-info .btn:hover {
  opacity: 0.9;
}

@media screen and (min-width: 992px) {
  .card {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-gap: 1.5rem;
  }
  .card-wrapper {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .product-imgs {
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  .product-content {
    padding-top: 0;
  }
}
</style>

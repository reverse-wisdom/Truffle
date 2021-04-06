<template>
  <span class="order">
    <div class="process-wrapper" v-if="(this.$store.state.type = '1')">
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
  </span>
</template>

<script>
import { fetchOrder } from '@/api/order';
import { userWinEvent } from '@/api/auth';
export default {
  name: 'Order',
  data() {
    return {
      status0: [],
      status1: [],
      status2: [],
      status3: [],
      status4: [],
    };
  },
  async created() {
    // 당첨내역조회
    const { data } = await userWinEvent(this.$store.state.email);
    console.log(data);

    // 이벤트아이디로 결제 조회
    for (let i = 0; i < data.length; i++) {
      const res = await fetchOrder(data[i].event_id);
      console.log('당첨자 결제조회', res);
      if (res.data.uuid == this.$store.state.uuid && res.data.pay_status == 1) {
        this.status1.push(res.data);
      } else if (res.data.uuid == this.$store.state.uuid && res.data.pay_status == 2) {
        this.status2.push(res.data);
      } else if (res.data.uuid == this.$store.state.uuid && res.data.pay_status == 3) {
        this.status3.push(res.data);
      } else if (res.data.uuid == this.$store.state.uuid && res.data.pay_status == 4) {
        this.status4.push(res.data);
      } else {
        this.status0.push(res.data);
      }
    }
  },
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
</style>

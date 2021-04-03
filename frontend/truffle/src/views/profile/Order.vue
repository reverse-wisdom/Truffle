<template>
  <span class="order">
    <h4>Our Process</h4>
    <br />
    <div class="process-wrapper">
      <div id="progress-bar-container">
        <ul>
          <li class="step step01 active" @click="step01"><div class="step-inner">배송 준비중</div></li>
          <li class="step step02" @click="step02"><div class="step-inner">배송시작</div></li>
          <li class="step step03" @click="step03"><div class="step-inner">배송중</div></li>
          <li class="step step04" @click="step04"><div class="step-inner">배송완료</div></li>
          <li class="step step05" @click="step05"><div class="step-inner">전달완료</div></li>
        </ul>

        <div id="line">
          <div id="line-progress"></div>
        </div>
      </div>

      <div id="progress-content-section">
        <div class="section-content discovery active">
          <h2>배송준비중</h2>
          <p>
            준비중인 물품들
          </p>
        </div>

        <div class="section-content strategy">
          <h2>배송시작</h2>
          <p>
            배송 시작한 물품
          </p>
        </div>

        <div class="section-content creative">
          <h2>배송중</h2>
          <p>
            배송중인 물품
          </p>
        </div>

        <div class="section-content production">
          <h2>배송완료</h2>
          <p>
            배송완료된 물품
          </p>
        </div>

        <div class="section-content analysis">
          <h2>전달완료</h2>
          <p>
            전달완료된 물품
          </p>
        </div>
      </div>
    </div>
  </span>
</template>

<script>
export default {
  name: 'Order',
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
}

h4 {
  color: #333;
  font-weight: 700;
  /* margin-top: 125px; */
  text-align: center;
  text-transform: uppercase;
  letter-spacing: 4px;
  line-height: 23px;
}

/* --- Start progress bar --- */

.process-wrapper {
  margin: auto;
  max-width: 1080px;
  width: 80vw;
}

#progress-bar-container {
  position: relative;
  width: 90%;
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

  background: linear-gradient(to right, #e91e63 0%, #fff 100%);
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
  background: #777;
  margin: auto;
  border: solid 7px #fff;
  border-radius: 50%;
  margin-top: 40px;
  box-shadow: 0 2px 13px -1px rgba(0, 0, 0, 0.3);
  transition: all ease 0.2s;
}

#progress-bar-container li:hover:after {
  background: #555;
}

#progress-bar-container li.active:after {
  background: #207893;
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
  background: #207893;
  background: linear-gradient(to right, #207893 0%, #2ea3b7 100%);
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

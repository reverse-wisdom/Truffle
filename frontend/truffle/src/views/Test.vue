<template>
  <!-- 현재 Home은 테스트 페이지 입니다. -->
  <div class="test">
    <img alt="Vue logo" src="../assets/img/face.jpg" width="400px" height="500px" />
    <br />
    <h2 style="font-weight: 900">이곳은 테스트페이지 입니다!</h2>
    <v-btn color="#f3118e" class="btn" style="color:white" @click="goEventdetail">Event-Detail</v-btn>
    <br />
    <v-btn color="#f3118e" class="btn" style="color:white" @click="goEventcreate">Event-Create</v-btn>
    <br />
    <v-btn color="#f3118e" class="btn" style="color:white" @click="goEventAll">Event-All</v-btn>
    <br />
    <v-btn color="#f3118e" class="btn" style="color:white" @click="goFormDataTest">썸네일테스트</v-btn>
    <br />
    <SelectAge></SelectAge>
    <h2 style="font-weight: 900">배포테스트 일자:04-01/20:05</h2>

    <v-btn depressed color="primary" @click="sweetalertTest1">sweetalert test1</v-btn>
    <br />
    <v-btn depressed class="btn" color="primary" @click="sweetalertTest1">sweetalert test1</v-btn>
    <br />
    <v-btn depressed class="btn" color="primary" @click="sweetalertTest2">sweetalert test2</v-btn>
    <br />
    <v-btn depressed class="btn" color="error" @click="sweetalertTest3">sweetalert test3</v-btn>
    <br />

    <!-- <div>
      <h2>로컬 파일 테스트</h2>
      <img id="img_test" />
    </div> -->

    <div>
      <h2>아임포트결제테스트</h2>
      <v-btn depressed color="primary" @click="iamport">결제호출</v-btn>
    </div>
  </div>
</template>

<script>
import SelectAge from '@/views/select/SelectAge.vue';
import { eventDetail } from '@/api/event';
export default {
  name: 'Test',
  components: {
    SelectAge,
  },
  created() {
    // var filePath = 'file:///volumes/data/df48f6e7-eda0-490f-8aa4-8e8f2c94bb0c.png';
    // var output = document.getElementById('img_test');
    // output.src = this.readTextFile(filePath);
  },
  methods: {
    async iamport() {
      var event_id = 25;
      const { data } = await eventDetail(event_id);
      var event = data[0];
      console.log(event.price);

      //가맹점 식별코드
      Vue.IMP().request_pay(
        {
          pg: 'inicis',
          pay_method: 'card',
          merchant_uid: event.event_id, // 이벤트 아이디 매핑
          name: event.product, // 이벤트 제품이름 매핑
          amount: event.price, // 이벤트 가격 매핑
          buyer_email: 'iamport@siot.do', // 로그인한유저의 이메일 넣기
          buyer_name: '구매자이름', // 로그인한 유저의 닉네임 넣기
          buyer_tel: '010-1234-5678', // 로그인한 유저의 전화번호 넣기
          buyer_addr: '서울특별시 강남구 삼성동', // 로그인한 유저 주소 넣기
        },
        (result_success) => {
          //성공할 때 실행 될 콜백 함수
          var msg = '결제가 완료되었습니다.';
          console.log(result_success);
          msg += '고유ID : ' + result_success.imp_uid;
          msg += '상점 거래ID : ' + result_success.merchant_uid;
          msg += '결제 금액 : ' + result_success.paid_amount;
          msg += '카드 승인번호 : ' + result_success.apply_num;
          alert(msg);
        },
        (result_failure) => {
          //실패시 실행 될 콜백 함수
          var msg = '결제에 실패하였습니다.';
          msg += '에러내용 : ' + result_failure.error_msg;
          alert(msg);
        }
      );
    },
    readTextFile(file) {
      var rawFile = new XMLHttpRequest();
      rawFile.open('GET', file, false);
      rawFile.onreadystatechange = function() {
        if (rawFile.readyState === 4) {
          if (rawFile.status === 200 || rawFile.status == 0) {
            var allText = rawFile.responseText;
            alert(allText);
          }
        }
      };
      rawFile.send(null);
    },

    sweetalertTest1() {
      this.$swal({
        icon: 'success',
        title: '테스트',
        confirmButtonText: `확인`,
      });
    },
    sweetalertTest2() {
      this.$swal({
        icon: 'warning',
        title: '에러테스트!',
        showCancelButton: true,
        confirmButtonText: `확인`,
        cancelButtonText: `취소`,
      });
    },
    async sweetalertTest3() {
      const { value: email } = await this.$swal({
        title: 'Input email address',
        input: 'email',
        inputLabel: 'Your email address',
        inputPlaceholder: 'Enter your email address',
      });

      if (email) {
        this.$swal(`Entered email: ${email}`);
      }
    },
    goEventdetail() {
      this.$router.push({ name: 'EventDetail' });
    },
    goEventcreate() {
      this.$router.push({ name: 'EventCreate' });
    },
    goEventAll() {
      this.$router.push({ name: 'EventAll' });
    },
    goFormDataTest() {
      this.$router.push({ name: 'FormDataTest' });
    },
  },
};
</script>
<style scoped>
.btn {
  margin: 0.5rem 0;
}
</style>

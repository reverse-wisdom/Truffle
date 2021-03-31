<template>
  <!-- 현재 Home은 테스트 페이지 입니다. -->
  <div class="test">
    <img alt="Vue logo" src="../assets/img/face.jpg" width="400px" height="500px" />
    <br />
    <h2 style="font-weight: 900">이곳은 테스트페이지 입니다!</h2>
    <v-btn color="#f3118e" class="btn" style="color:white" @click="goEventdetail">Event-Detail</v-btn>
    <br />
    <h2 style="font-weight: 900">배포테스트 일자:03-31/10:40</h2>
    <v-btn depressed color="primary" @click="sweetalertTest1">sweetalert test1</v-btn>
    <br />
    <v-btn depressed class="btn" color="primary" @click="sweetalertTest1">sweetalert test1</v-btn>
    <br />
    <v-btn depressed class="btn" color="primary" @click="sweetalertTest2">sweetalert test2</v-btn>
    <br />
    <v-btn depressed class="btn" color="error" @click="sweetalertTest3">sweetalert test3</v-btn>
    <br />
  </div>
</template>

<script>
export default {
  name: 'Test',
  components: {},
  methods: {
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
  },
};
</script>
<style scoped>
.btn {
  margin: 0.5rem 0;
}
</style>

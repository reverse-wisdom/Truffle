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
    <v-btn color="#f3118e" class="btn" style="color:white" @click="goEventAll">Event-Update</v-btn>
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

    <div>
      <h2>로컬 파일 테스트</h2>
      <img id="img_test" />
    </div>
  </div>
</template>

<script>
import SelectAge from '@/views/select/SelectAge.vue';

export default {
  name: 'Test',
  components: {
    SelectAge,
  },
  created() {
    var filePath = 'file:///volumes/data/df48f6e7-eda0-490f-8aa4-8e8f2c94bb0c.png';
    var output = document.getElementById('img_test');
    output.src = this.readTextFile(filePath);
  },
  methods: {
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
    goEventAll() {
      this.$router.push({ name: 'EventUpdate' });
    },
  },
};
</script>
<style scoped>
.btn {
  margin: 0.5rem 0;
}
</style>

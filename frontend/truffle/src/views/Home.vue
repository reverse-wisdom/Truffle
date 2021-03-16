<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <br />
    <input type="button" value="sweetalert test1" @click="sweetalertTest1" />
    <input type="button" value="sweetalert test2" @click="sweetalertTest2" />
    <br />
    <input type="button" value="sweetalert test3" @click="sweetalertTest3" />

    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue';

export default {
  name: 'Home',
  components: {
    HelloWorld,
  },
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
  },
};
</script>

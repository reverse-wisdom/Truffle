<template>
  <div class="container">
    <h1>리태일러</h1>
    <div class="split-screen">
      <div class="left">
        <section class="copy">
          <h1>ex1</h1>
          <p>ex1</p>
        </section>
      </div>
      <div class="right">
        <form action="">
          <section class="copy">
            <h2>ex2</h2>
            <div class="login-container">
              <p>
                asd
                <a href="">
                  <strong>Log In</strong>
                </a>
              </p>
            </div>
          </section>
          <div class="input"></div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { loginUser } from '@/api/auth';

export default {
  data() {
    return {
      Id: '',
      password: '',
    };
  },
  methods: {
    async Login() {
      const userData = {
        Id: this.Id,
        password: this.password,
      };
      // const data = await loginUser(userData);
      // console.log(data);
    },
    // 카카오로그인
    loginFormWithKakao() {
      //로그인 성공
      var $vm = this;
      Kakao.Auth.loginForm({
        success: function(authObj) {
          //로그인 성공 이후 데이터 받아오기
          Kakao.API.request({
            url: '/v2/user/me',
            success: function(res) {
              // $vm.id = res.id;
              // $vm.socialEmail = res.kakao_account.email;
              // $vm.name = res.kakao_account.profile.nickname;
              // $vm.image = res.kakao_account.profile.profile_image_url;
              // $vm.type = 'kakao';
              console.log(res);
            },
            fail: function(error) {
              alert('login success, but failed to request user information: ' + JSON.stringify(error));
            },
          });
        },
        fail: function(err) {
          this.showResult(JSON.stringify(err));
        },
      });
    },
    goSignup() {
      const container = document.querySelector('.container');
      container.classList.add('sign-up-mode');
    },
    goSignin() {
      const container = document.querySelector('.container');
      container.classList.remove('sign-up-mode');
    },
  },
};
</script>
<style scoped></style>

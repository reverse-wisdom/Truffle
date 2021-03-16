<template>
  <div class="">
    <h1>로그인페이지</h1>
    <hr />
    <div>
      <a @click="loginFormWithKakao">
        <img src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg" width="200px" />
      </a>
    </div>
    <div>
      <hr />
      <div>
        <label for="">이메일:</label>
        <input type="text" v-model="Id" />
      </div>
      <br />
      <div>
        <label for="">비밀번호:</label>
        <input type="password" v-model="password" />
      </div>
    </div>
    <br />
    <div>
      <button @click="Login">로그인</button>
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
      const data = await loginUser(userData);
      console.log(data);
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
  },
};
</script>
<style scoped></style>

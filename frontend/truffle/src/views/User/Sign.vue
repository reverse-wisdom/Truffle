<template>
  <div class="container">
    <div class="forms-container">
      <div class="signin-signup">
        <!-- 로그인 폼 -->
        <form action="#" class="sign-in-form">
          <h2 class="title">LOGIN</h2>
          <div class="input-field">
            <i class="fas fa-user"></i>
            <input type="text" placeholder="Username" v-model="email" />
          </div>
          <div class="input-field">
            <i class="fas fa-lock"></i>
            <input type="password" placeholder="Password" v-model="password" />
          </div>
          <input type="submit" value="로그인" class="btn solid" @click="Login" />
          <naverLogin @loginComplete="loginFormWithKakao"></naverLogin>
        </form>
        <form action="#" class="sign-up-form">
          <div class="about">
            <h1 class="title">Sign up</h1>
          </div>
          <div class="input-field">
            <i class="fas fa-user"></i>
            <button @click="retailer" class="branch-sign">리테일러</button>
          </div>
          <div class="input-field">
            <i class="fas fa-user"></i>
            <button @click="user" class="branch-sign">일반회원</button>
          </div>
        </form>
      </div>
    </div>

    <div class="panels-container">
      <div class="panel left-panel">
        <div class="content">
          <h3>어서오세요 트러플 회원님!</h3>
          <p style="font-size: 0.8rem;">
            서비스 이용을 위해 로그인을 진행해주세요 서비스 이용을 위해 로그인을 진행해주세요 서비스 이용을 위해 로그인을 진행해주세요
          </p>
          <p style="font-size:10px; margin-bottom: -1rem;">계정이 없으신가요?</p>
          <button class="btn transparent" id="sign-up-btn" @click="goSignup">
            →SIGN UP
          </button>
        </div>
        <img src="img/log.svg" class="image" alt="" />
      </div>
      <div class="panel right-panel">
        <div class="content">
          <h3>환영합니다!</h3>
          <p>
            서비스 이용을 위해 회원가입을 진행해주세요 서비스 이용을 위해 회원가입을 진행해주세요 서비스 이용을 위해 회원가입을 진행해주세요
          </p>
          <p style="font-size:10px; margin-bottom: -1rem;">이미 계정이 있으신가요?</p>
          <button class="btn transparent" id="sign-in-btn" @click="goSignin">
            →SIGN IN
          </button>
        </div>
        <img src="img/register.svg" class="image" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
import NaverLogin from '@/components/SocialLogin/NaverLogin.vue';
export default {
  data() {
    return {
      email: '',
      password: '',
    };
  },
  components: {
    NaverLogin,
  },
  methods: {
    naver() {
      naverLogin.getLoginStatus(function(status) {
        console.log(status);
        if (status) {
          var email = naverLogin.user.getEmail();
          if (email == undefined || email == null) {
            alert('이메일은 필수정보입니다. 정보제공을 동의해주세요.');
            naverLogin.reprompt();
          }
          alert(email); // 로그인 한 이메일 ***@naver.com 이 출력된다.
          //window.location.replace("http://127.0.0.1/test2.html");
        } else {
          console.log('callback 처리에 실패하였습니다.');
        }
      });
    },

    async Login() {
      if (this.email == null) {
        this.$swal({
          icon: 'error',
          title: '아이디를 입력해 주세요!',
        });
      } else if (this.password == null) {
        this.$swal({
          icon: 'error',
          title: '비밀번호를 입력해 주세요!',
        });
      } else {
        const userData = {
          email: this.email,
          password: this.password,
        };
        this.$store.dispatch('LOGIN', userData);
      }
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
    login() {
      console.log('네이버 성공');
    },
    retailer() {
      this.$router.push({ name: 'ResisterRetailer' });
    },
    user() {
      this.$router.push({ name: 'ResisterUser' });
    },
  },
};
</script>
<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

input {
  font-family: 'Poppins', sans-serif;
}
p {
  font-size: 0.2rem;
}

.container {
  /* margin: 0; */
  padding: 0;
  box-sizing: border-box;
  /* position: relative; */
  width: 100%;
  background-color: #fff;
  min-height: 100vh;
  /* overflow: hidden; */
}

.forms-container {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
}

.signin-signup {
  position: absolute;
  top: 50%;
  transform: translate(-50%, -50%);
  left: 75%;
  width: 50%;
  transition: 1s 0.7s ease-in-out;
  display: grid;
  grid-template-columns: 1fr;
  z-index: 5;
}

form {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0rem 5rem;
  transition: all 0.2s 0.7s;
  overflow: hidden;
  grid-column: 1 / 2;
  grid-row: 1 / 2;
}

form.sign-up-form {
  opacity: 0;
  z-index: 1;
}

form.sign-in-form {
  z-index: 2;
}

.title {
  font-size: 2.2rem;
  color: #444;
  margin-bottom: 10px;
}

.input-field {
  max-width: 380px;
  width: 100%;
  background-color: #f0f0f0;
  margin: 10px 0;
  height: 55px;
  border-radius: 55px;
  display: grid;
  grid-template-columns: 15% 85%;
  padding: 0 0.4rem;
  position: relative;
}

.input-field i {
  text-align: center;
  line-height: 55px;
  color: #acacac;
  transition: 0.5s;
  font-size: 1.1rem;
}

.input-field input {
  background: none;
  outline: none;
  border: none;
  line-height: 1;
  font-weight: 600;
  font-size: 1.1rem;
  color: #333;
}

.input-field input::placeholder {
  color: #aaa;
  font-weight: 500;
}

/* .social-icon:hover {
  color: #4481eb;
  border-color: #4481eb;
} */

.btn {
  width: 150px;
  background-color: #000;

  /* background-color: #5995fd; */
  border: none;
  outline: none;
  height: 49px;
  border-radius: 49px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 600;
  margin: 10px 0;
  cursor: pointer;
  transition: 0.5s;
}

.btn:hover {
  background-color: #fff;
  color: #000;
}
.panels-container {
  position: absolute;
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}

.container:before {
  content: '';
  position: absolute;
  height: 2000px;
  width: 2000px;
  top: -10%;
  right: 48%;
  transform: translateY(-50%);
  background-image: linear-gradient(-45deg, #000 0%, #d4cfcf 100%);
  transition: 1.8s ease-in-out;
  border-radius: 50%;
  z-index: 6;
}

.image {
  width: 100%;
  transition: transform 1.1s ease-in-out;
  transition-delay: 0.4s;
}

.panel {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  justify-content: space-around;
  text-align: center;
  z-index: 6;
}

.left-panel {
  pointer-events: all;
  padding: 3rem 17% 2rem 12%;
}

.right-panel {
  pointer-events: none;
  padding: 3rem 12% 2rem 17%;
}

.panel .content {
  color: #fff;
  transition: transform 0.9s ease-in-out;
  transition-delay: 0.6s;
}

.panel h3 {
  font-weight: 1000;
  line-height: 1;
  font-size: 1.5rem;
}

.panel p {
  font-size: 0.95rem;
  padding: 0.7rem 0;
}

.btn.transparent {
  margin: 0;
  background: none;
  /* border: 2px solid #000; */
  width: 130px;
  height: 41px;
  font-weight: 600;
  font-size: 0.8rem;
}

.btn.transparent:hover {
  margin: 0;
  background: none;
  border: 2px solid #fff;
  width: 130px;
  height: 41px;
  color: #fff;
  font-weight: 600;
  font-size: 0.8rem;
}
.btn.solid:hover {
  margin: 0;
  background: none;
  border: 2px solid #000;
  width: 130px;
  height: 41px;
  font-weight: 600;
  font-size: 0.8rem;
}

.right-panel .image,
.right-panel .content {
  transform: translateX(800px);
}

/* ANIMATION */

.container.sign-up-mode:before {
  transform: translate(100%, -50%);
  right: 52%;
}

.container.sign-up-mode .left-panel .image,
.container.sign-up-mode .left-panel .content {
  transform: translateX(-800px);
}

.container.sign-up-mode .signin-signup {
  left: 25%;
}

.container.sign-up-mode form.sign-up-form {
  opacity: 1;
  z-index: 2;
}

.container.sign-up-mode form.sign-in-form {
  opacity: 0;
  z-index: 1;
}

.container.sign-up-mode .right-panel .image,
.container.sign-up-mode .right-panel .content {
  transform: translateX(0%);
}

.container.sign-up-mode .left-panel {
  pointer-events: none;
}

.container.sign-up-mode .right-panel {
  pointer-events: all;
}

@media (max-width: 870px) {
  .container {
    min-height: 800px;
    height: 100vh;
  }
  .signin-signup {
    width: 100%;
    top: 95%;
    transform: translate(-50%, -100%);
    transition: 1s 0.8s ease-in-out;
  }

  .signin-signup,
  .container.sign-up-mode .signin-signup {
    left: 50%;
  }

  .panels-container {
    grid-template-columns: 1fr;
    grid-template-rows: 1fr 2fr 1fr;
  }

  .panel {
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
    padding: 2.5rem 8%;
    grid-column: 1 / 2;
  }

  .right-panel {
    grid-row: 3 / 4;
  }

  .left-panel {
    grid-row: 1 / 2;
  }

  .image {
    width: 200px;
    transition: transform 0.9s ease-in-out;
    transition-delay: 0.6s;
  }

  .panel .content {
    padding-right: 15%;
    transition: transform 0.9s ease-in-out;
    transition-delay: 0.8s;
  }

  .panel h3 {
    font-size: 1.2rem;
  }

  .panel p {
    font-size: 0.7rem;
    padding: 0.5rem 0;
  }

  .btn.transparent {
    width: 110px;
    height: 35px;
    color: #fff;
    font-size: 0.7rem;
  }

  .container:before {
    width: 1500px;
    height: 1500px;
    transform: translateX(-50%);
    left: 30%;
    bottom: 68%;
    right: initial;
    top: initial;
    transition: 2s ease-in-out;
  }

  .container.sign-up-mode:before {
    transform: translate(-50%, 100%);
    bottom: 32%;
    right: initial;
  }

  .container.sign-up-mode .left-panel .image,
  .container.sign-up-mode .left-panel .content {
    transform: translateY(-300px);
  }

  .container.sign-up-mode .right-panel .image,
  .container.sign-up-mode .right-panel .content {
    transform: translateY(0px);
  }

  .right-panel .image,
  .right-panel .content {
    transform: translateY(300px);
  }

  .container.sign-up-mode .signin-signup {
    top: 5%;
    transform: translate(-50%, 0);
  }
}

@media (max-width: 570px) {
  form {
    padding: 0 1.5rem;
  }

  .image {
    display: none;
  }
  .panel .content {
    padding: 0.5rem 1rem;
  }
  .container {
    padding: 1.5rem;
  }

  .container:before {
    bottom: 72%;
    left: 50%;
  }

  .container.sign-up-mode:before {
    bottom: 28%;
    left: 50%;
  }
}
/* 타이틀 */
.about {
  position: absolute;
  top: 10%;
  left: 45%;
  font-size: 3rem;
}

.about h1 {
  font-weight: bolder;
  color: #000;
  font-family: Poppins;

  text-transform: uppercase;
}
</style>

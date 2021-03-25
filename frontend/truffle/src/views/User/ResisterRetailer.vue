<template>
  <div class="body">
    <div class="split-screen">
      <div class="left">
        <section class="copy">
          <h1>Explore your ...</h1>
          <p>over 1000 courses ....</p>
        </section>
      </div>
      <div class="right">
        <form action="">
          <section class="copy">
            <h2>Sign Up</h2>
            <div class="login-container">
              <p>
                Already have an account?
                <a href="">
                  <strong>Log In</strong>
                </a>
              </p>
            </div>
          </section>
          <div class="input-container name">
            <label for="fname">Full name</label>
            <input id="fname" name="fname" type="text" />
          </div>
          <div class="input-container email">
            <label for="email">Email</label>
            <input id="email" name="email" type="email" />
          </div>
          <div class="input-container password">
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Must be at least 6 char" />
            <i class="far fa-eye-slash"></i>
          </div>
          <div class="input-container cta">
            <label class="checkbox-container"></label>
            <input type="checkbox" />
            <span class="checkmark"></span>
            Sign up ror email updates.
          </div>
          <button class="signup-btn" type="submit">Sign up</button>
          <section class="copy legal">
            <p>
              <span class="small">
                by continue, you agree...
                <br />
                <a href="#">Privacy Policy</a>
                &amp;
                <a href="#">Terms of Service</a>
                .
              </span>
            </p>
          </section>
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
<style scoped>
:root {
  font-size: 100%;
  font-size: 16px;
  line-height: 1.5;
  --primary-blue: #233975;
}
.body {
  padding: 0;
  margin: 0;
  font-family: 'Montserrat', sans-serif;
  font-weight: 500;
}
h1 {
  font-size: 2.25rem;
  font-weight: 700;
}
h2 {
  font-size: 1.5rem;
  font-weight: 700;
}
a {
  text-decoration: none;
  color: var(--primary-blue);
}
a:hover {
  text-decoration: underline;
}
.small {
  font-size: 80%;
  text-align: center;
}
.split-screen {
  display: flex;
  flex-direction: column;
}
.left {
  height: 40vh;
}
.left,
.right {
  display: flex;
  justify-content: center;
  align-items: center;
}
.left {
  background: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.5)), url('../../assets/img/model_1.png');
  background-size: cover;
}
.left .copy {
  color: white;
  text-align: center;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.left p {
  font-weight: 400;
}
.right .copy {
  color: black;
  text-align: center;
}
.right .copy p {
  margin: 1.5em 0;
  font-size: 0.875rem;
}
.rignt form {
  width: 328px;
}
form input[type='text'],
form input[type='email'],
form input[type='password'] {
  display: block;
  width: 100%;
  box-sizing: border-box;
  border-radius: 8px;
  border: 1px solid #c4c4c4;
  padding: 1em;
  margin-bottom: 1.25rem;
  font-size: 0.875rem;
}
label {
  display: block;
  margin-bottom: 0.5rem;
  font-size: 0.75rem;
}
.input-container.password {
  position: relative;
}
.input-container.password i {
  position: absolute;
  top: 42px;
  right: 16px;
}

.checkbox-container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}
.checkbox-container {
  display: block;
  position: relative;
  padding-left: 2rem;
  cursor: pointer;
  user-select: none;
  margin: 0 0 1.25rem 0;
}
.checkbox-container input:checked ~ .checkmark {
  background-color: #2c4893;
  border: 1px solid #2c4893;
}
.checkmark {
  position: absolute;
  width: 24px;
  height: 24xp;
  background: white;
  border: 1px solid #c4c4c4;
  border-radius: 2px;
  top: -4px;
  left: 0;
}
.checkmark:after {
  content: '';
  position: absolute;
  display: none;
}
.checkbox-container input:checked ~ .checkmark::after {
  display: block;
}
.checkbox-container .checkmark:after {
  border: solid white;
  border-width: 0 3px 3px 0;
  width: 5px;
  height: 10px;
  left: 8px;
  top: 4px;
  transform: rotate(45deg);
}
.signup-btn {
  display: block;
  width: 100%;
  background: #2c4893;
  color: white;
  font-weight: 700;
  border: none;
  padding: 1rem;
  border-radius: 8px;
  font-size: 0.75rem;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}
.signup-btn:hover {
  backdrop-filter: #2c4893;
  cursor: pointer;
}
@media screen and (min-width: 900px) {
  .split-screen {
    flex-direction: row;
    height: 20vh;
  }
  .left,
  .right {
    display: flex;
    height: 100vh;
    width: 50%;
  }
}
</style>

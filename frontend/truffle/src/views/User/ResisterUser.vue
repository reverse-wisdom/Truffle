<template>
  <div class="body">
    <div class="split-screen">
      <div class="left">
        <section class="copy">
          <h1>환영합니다. 고객님!</h1>
          <p>서비스이용을 위해 회원가입을 진행해주세요</p>
        </section>
      </div>
      <div class="right">
        <form action="">
          <section class="copy">
            <h2>Sign Up</h2>
            <div class="login-container">
              <p>
                이미계정이 있으신가요?
                <a href="">
                  <strong>LOGIN</strong>
                </a>
              </p>
            </div>
          </section>
          <div class="input-container name">
            <label for="fname">NICKNAME</label>
            <input id="fname" name="fname" type="text" v-model="nickname" />
          </div>
          <div class="input-container email">
            <label for="email">E-MAIL</label>
            <input id="email" name="email" type="email" v-model="email" />
          </div>
          <div class="input-container password">
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="특수문자를 포함해서 8자이상 작성해주세요" v-model="password" />
            <input id="password" name="password" type="password" placeholder="비밀번호 확인" v-model="pwdcheck" />
          </div>
          <div class="input-container gender">
            <label for="">GENDER</label>
            <div class="wrapper">
              <input type="radio" name="select" id="option-1" value="1" v-model="gender_checked" />
              <input type="radio" name="select" id="option-2" value="2" v-model="gender_checked" />
              <label for="option-1" class="option option-1">
                <div class="dot"></div>
                <span>남성</span>
              </label>
              <label for="option-2" class="option option-2">
                <div class="dot"></div>
                <span>여성</span>
              </label>
            </div>
          </div>
          <div class="input-container age">
            <label for="">AGE</label>
            <div class="wrapper1">
              <input type="radio" name="select1" id="gender-option-1" value="10" v-model="age_checked" />
              <input type="radio" name="select1" id="gender-option-2" value="20" v-model="age_checked" />
              <input type="radio" name="select1" id="gender-option-3" value="30" v-model="age_checked" />

              <label for="gender-option-1" class="gender-option gender-option-1">
                <div class="dot"></div>
                <span>10대</span>
              </label>
              <label for="gender-option-2" class="gender-option gender-option-2">
                <div class="dot"></div>
                <span>20대</span>
              </label>
              <label for="gender-option-3" class="gender-option gender-option-3">
                <div class="dot"></div>
                <span>30대</span>
              </label>
            </div>
            <div class="wrapper1">
              <input type="radio" name="select1" id="gender-option-4" value="40" v-model="age_checked" />
              <input type="radio" name="select1" id="gender-option-5" value="50" v-model="age_checked" />
              <input type="radio" name="select1" id="gender-option-6" value="60" v-model="age_checked" />
              <label for="gender-option-4" class="gender-option gender-option-4">
                <div class="dot"></div>
                <span>40대</span>
              </label>
              <label for="gender-option-5" class="gender-option gender-option-5">
                <div class="dot"></div>
                <span>50대 이상</span>
              </label>
              <label for="gender-option-6" class="gender-option gender-option-6">
                <div class="dot"></div>
                <span>60대 이상</span>
              </label>
            </div>
          </div>

          <div class="input-container password">
            <label for="">ADRESS</label>
            <div class="d-flex">
              <input id="" name="" type="text" v-model="postcode" />
              <input class="signup-btn search" type="button" @click="sample4_execDaumPostcode" value="우편번호 찾기" />
            </div>
            <input id="" name="" type="text" v-model="address" />
            <input id="" name="" type="text" v-model="detail" placeholder="상세주소를 입력해주세요" />
          </div>
          <button class="signup-btn" type="submit">SMS 본인인증</button>
          <button class="signup-btn" type="submit" @click.prevent="signup">Sign up</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { registerRetail } from '@/api/auth';

export default {
  data() {
    return {
      nickname: '',
      email: '',
      password: '',
      pwdcheck: '',
      address: '',
      detail: '',
      postcode: '',
      msg: [],
      gender_checked: '',
      age_checked: '',
    };
  },
  created() {},
  watch: {
    email(value) {
      this.email = value;
      this.validateEmail(value);
    },
    password(value) {
      this.password = value;
      this.validatePassword(value);
    },
  },
  methods: {
    validateEmail(value) {
      if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value)) {
        this.msg['email'] = true;
      } else {
        this.msg['email'] = false;
      }
    },
    validatePassword(value) {
      if (/^.*(?=^.{8,}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(value)) {
        this.msg['password'] = true;
      } else {
        this.msg['password'] = false;
      }
    },
    async signup() {
      if (!this.msg['email']) {
        this.$swal({
          icon: 'error',
          title: '이메일 형식이 잘못되었습니다.!',
        });
      } else if (this.nickname == null) {
        this.$swal({
          icon: 'error',
          title: '닉네임을 입력해주세요!',
        });
      } else if (!this.msg['password']) {
        this.$swal({
          icon: 'error',
          title: '비밀번호 입력시 8자리이상, 특수문자를 포함해주세요!',
        });
      } else if (this.address == null) {
        this.$swal({
          icon: 'error',
          title: '주소를 입력해주세요!',
        });
      } else if (this.password == null) {
        this.$swal({
          icon: 'error',
          title: '비밀번호를 입력해주세요!',
        });
      } else if (this.pwdcheck == null) {
        this.$swal({
          icon: 'error',
          title: '비밀번호확인을 입력해주세요!',
        });
      } else if (this.gender_checked == null) {
        this.$swal({
          icon: 'error',
          title: '성별을 체크해주세요!',
        });
      } else if (this.age_checked == null) {
        this.$swal({
          icon: 'error',
          title: '연령대를 체크해주세요!',
        });
      } else {
        const userData = {
          email: this.email,
          password: this.password,
          address: this.address,
          address_detail: this.detail,
          nickname: this.nickname,
          type: 1,
          gender: this.gender_checked,
          age: this.age_checked,
        };
        console.log(userData);

        // const {data} = await registerRetail(userData)

        // if (data == 'SUCCESS') {
        //   this.$swal({
        //     position: 'top-end',
        //     icon: 'success',
        //     title: '회원가입성공!!',
        //     showConfirmButton: false,
        //     timer: 1500,
        //   });
        //   this.$router.push('/');
        // } else {
        //   this.$swal({
        //     icon: 'error',
        //     title: '회원가입 실패 관리자에게 문의해주세요',
        //   });
        // }
      }
    },
    sample4_execDaumPostcode() {
      var $vm = this;
      new daum.Postcode({
        oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var roadAddr = data.roadAddress; // 도로명 주소 변수
          var extraRoadAddr = ''; // 참고 항목 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraRoadAddr += extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName;
          }
          // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraRoadAddr !== '') {
            extraRoadAddr = ' (' + extraRoadAddr + ')';
          }

          // 우편번호
          // document.getElementById('sample4_postcode').value = data.zonecode;
          $vm.postcode = data.zonecode;
          // console.log(data);
          // 도로명
          // document.getElementById('sample4_roadAddress').value = roadAddr;
          // 지번
          // document.getElementById('sample4_jibunAddress').value = data.jibunAddress;
          $vm.address = data.jibunAddress;

          // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
          // if (roadAddr !== '') {
          //   document.getElementById('sample4_extraAddress').value = extraRoadAddr;
          // } else {
          //   document.getElementById('sample4_extraAddress').value = '';
          // }

          // var guideTextBox = document.getElementById('guide');
          // // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
          // if (data.autoRoadAddress) {
          //   var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
          //   guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
          //   guideTextBox.style.display = 'block';
          // } else if (data.autoJibunAddress) {
          //   var expJibunAddr = data.autoJibunAddress;
          //   guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
          //   guideTextBox.style.display = 'block';
          // } else {
          //   guideTextBox.innerHTML = '';
          //   guideTextBox.style.display = 'none';
          // }
        },
      }).open();
    },
  },
};
</script>
<style scoped>
:root {
  font-size: 100%;
  font-size: 16px;
  line-height: 1.5;
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
a:link {
  text-decoration: none;
  color: #07b8ac;
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
  height: 100%;
  margin-top: 10rem;
}
.right {
  margin-top: 15rem;
}
.left,
.right {
  display: flex;
  justify-content: center;
  align-items: center;
}
.left {
  background: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.5)), url('../../assets/img/hero.jpg');
  background-size: cover;
  height: 100%;
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
.right form {
  width: 400px;
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
  margin: 10px 0px;
  width: 100%;
  background: #f3118e;
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
.gender-age {
  display: flex;
  align-items: center;
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

.search {
  margin: 0px 0px 20px 3px;
}
.wrapper {
  display: inline-flex;
  background: #fff;
  height: 50px;
  width: 250px;
  align-items: center;
  justify-content: space-evenly;
  border-radius: 5px;
  padding: 0 0 10px 0;
  /* box-shadow: 5px 5px 30px rgba(0, 0, 0, 0.2); */
}
.wrapper .option {
  background: #fff;
  height: 100%;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  margin: 0 15px 0 0;
  border-radius: 5px;
  cursor: pointer;
  padding: 0 10px;
  border: 2px solid lightgrey;
  transition: all 0.3s ease;
}
.wrapper .option .dot {
  height: 20px;
  width: 20px;
  background: #d9d9d9;
  border-radius: 50%;
  position: relative;
}
.wrapper .option .dot::before {
  position: absolute;
  content: '';
  top: 4px;
  left: 4px;
  width: 12px;
  height: 12px;
  background: #2bbef2;
  border-radius: 50%;
  opacity: 0;
  transform: scale(1.5);
  transition: all 0.3s ease;
}
input[type='radio'] {
  display: none;
}
/* 성별 */
#option-1:checked:checked ~ .option-1,
#option-2:checked:checked ~ .option-2 {
  border-color: #2bbef2;
  background: #2bbef2;
}
#option-1:checked:checked ~ .option-1 .dot,
#option-2:checked:checked ~ .option-2 .dot {
  background: #fff;
}
#option-1:checked:checked ~ .option-1 .dot::before,
#option-2:checked:checked ~ .option-2 .dot::before {
  opacity: 1;
  transform: scale(1);
}
.wrapper .option span {
  font-size: 15px;
  color: #808080;
}
#option-1:checked:checked ~ .option-1 span,
#option-2:checked:checked ~ .option-2 span {
  color: #fff;
}

/* 연령대 */

.wrapper1 {
  display: flex;
  background: #fff;
  height: 50px;
  width: 400px;
  align-items: center;
  justify-content: space-evenly;
  border-radius: 5px;
  padding: 0 0 10px 0;
  /* box-shadow: 5px 5px 30px rgba(0, 0, 0, 0.2); */
}
.wrapper1 .gender-option {
  background: #fff;
  height: 100%;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  margin: 0 15px 0 0;
  border-radius: 5px;
  cursor: pointer;
  padding: 0 10px;
  border: 2px solid lightgrey;
  transition: all 0.3s ease;
}
.wrapper1 .gender-option .dot {
  height: 20px;
  width: 20px;
  background: #d9d9d9;
  border-radius: 50%;
  position: relative;
}
.wrapper1 .gender-option .dot::before {
  position: absolute;
  content: '';
  top: 4px;
  left: 4px;
  width: 12px;
  height: 12px;
  background: #2bbef2;
  border-radius: 50%;
  opacity: 0;
  transform: scale(1.5);
  transition: all 0.3s ease;
}
input[type='radio'] {
  display: none;
}

#gender-option-1:checked:checked ~ .gender-option-1,
#gender-option-2:checked:checked ~ .gender-option-2,
#gender-option-3:checked:checked ~ .gender-option-3,
#gender-option-4:checked:checked ~ .gender-option-4,
#gender-option-5:checked:checked ~ .gender-option-5,
#gender-option-6:checked:checked ~ .gender-option-6 {
  border-color: #2bbef2;
  background: #2bbef2;
}
#gender-option-1:checked:checked ~ .gender-option-1 .dot,
#gender-option-2:checked:checked ~ .gender-option-2 .dot,
#gender-option-3:checked:checked ~ .gender-option-3 .dot,
#gender-option-4:checked:checked ~ .gender-option-4 .dot,
#gender-option-5:checked:checked ~ .gender-option-5 .dot,
#gender-option-6:checked:checked ~ .gender-option-6 .dot {
  background: #fff;
}
#gender-option-1:checked:checked ~ .gender-option-1 .dot::before,
#gender-option-2:checked:checked ~ .gender-option-2 .dot::before,
#gender-option-3:checked:checked ~ .gender-option-3 .dot::before,
#gender-option-4:checked:checked ~ .gender-option-4 .dot::before,
#gender-option-5:checked:checked ~ .gender-option-5 .dot::before,
#gender-option-6:checked:checked ~ .gender-option-6 .dot::before {
  opacity: 1;
  transform: scale(1);
}
.wrapper1 .option span {
  font-size: 17px;
  color: #808080;
}

#gender-option-1:checked:checked ~ .gender-option-1 span,
#gender-option-2:checked:checked ~ .gender-option-2 span,
#gender-option-3:checked:checked ~ .gender-option-3 span,
#gender-option-4:checked:checked ~ .gender-option-4 span,
#gender-option-5:checked:checked ~ .gender-option-5 span,
#gender-option-6:checked:checked ~ .gender-option-6 span {
  color: #fff;
}
</style>

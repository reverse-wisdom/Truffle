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
        <div class="form">
          <section class="copy">
            <h2>Sign Up</h2>
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
            <input type="password" placeholder="특수문자를 포함해서 8자이상 작성해주세요" v-model="password" />
            <input type="password" placeholder="비밀번호 확인" v-model="pwdcheck" />
          </div>
          <div class="input-container gender">
            <label for="">GENDER</label>
            <div class="wrapper">
              <input type="radio" name="" id="option-1" value="1" v-model="gender" />
              <input type="radio" name="" id="option-2" value="2" v-model="gender" />
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
              <input type="radio" name="select1" id="gender-option-1" value="10" v-model="age" />
              <input type="radio" name="select1" id="gender-option-2" value="20" v-model="age" />
              <input type="radio" name="select1" id="gender-option-3" value="30" v-model="age" />

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
              <input type="radio" name="select1" id="gender-option-4" value="40" v-model="age" />
              <input type="radio" name="select1" id="gender-option-5" value="50" v-model="age" />
              <input type="radio" name="select1" id="gender-option-6" value="60" v-model="age" />
              <label for="gender-option-4" class="gender-option gender-option-4">
                <div class="dot"></div>
                <span>40대</span>
              </label>
              <label for="gender-option-5" class="gender-option gender-option-5">
                <div class="dot"></div>
                <span>50대</span>
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
              <input type="text" v-model="postcode" disabled />
              <input class="signup-btn search" type="button" @click="sample4_execDaumPostcode" value="우편번호 찾기" />
            </div>
            <input name="" type="text" v-model="address" disabled />
            <input name="" type="text" v-model="address_detail" placeholder="상세주소를 입력해주세요" />
          </div>
          <div class="input-container">
            <label for="fname">PHONE</label>
            <div class="phone-num">
              <input maxlength="3" type="text" v-model="phone_num1" />
              <div class="b">-</div>
              <input maxlength="4" type="text" v-model="phone_num2" />
              <div class="b">-</div>
              <input maxlength="4" type="text" v-model="phone_num3" />
            </div>
          </div>
          <v-col cols="auto">
            <v-dialog transition="dialog-top-transition" max-width="600">
              <template v-slot:activator="{ on, attrs }">
                <button class="signup-btn" v-bind="attrs" v-on="on" @click="verifyphone">휴대폰 본인인증</button>
              </template>

              <template v-slot:default="dialog">
                <v-card>
                  <v-toolbar color="dark" dark>휴대폰 인증하기</v-toolbar>
                  <v-card-text>
                    <div class="text-h3 pa-12">
                      <label for="" class="text-h5">인증번호 4자리를 입력해주세요</label>
                      <input type="text" id="verifyphone" v-model="verifynum1" />
                    </div>
                  </v-card-text>
                  <v-card-actions class="justify-end">
                    <v-btn text @click="verifychk">인증하기</v-btn>
                    <v-btn text @click="dialog.value = false">닫기</v-btn>
                  </v-card-actions>
                </v-card>
              </template>
            </v-dialog>
          </v-col>
          <button class="signup-btn" type="button" @click.prevent="signup">Sign up</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { register, verifyPhone } from '@/api/auth';

export default {
  data() {
    return {
      nickname: '',
      email: '',
      password: '',
      pwdcheck: '',
      address: '',
      address_detail: '',
      postcode: '',
      phone: '',
      msg: [],
      gender: '',
      age: '',
      phone_num1: '',
      phone_num2: '',
      phone_num3: '',
      verifynum1: '',
      verifynum2: '',
      phonechk: false,
      dialog: true,
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
    async verifyphone() {
      const phone_num = this.phone_num1 + this.phone_num2 + this.phone_num3;
      this.phone = phone_num;
      console.log(phone_num);
      const { data } = await verifyPhone(phone_num);
      this.verifynum2 = data;
    },
    verifychk() {
      if (this.verifynum1 == this.verifynum2) {
        this.$swal({
          icon: 'success',
          title: '인증성공',
        });
        this.phonechk = true;
        this.dialog = false;
      } else {
        this.$swal({
          icon: 'error',
          title: '인증실패',
        });
      }
    },

    validateEmail(value) {
      if (
        /^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*$/.test(
          value
        )
      ) {
        this.msg['email'] = true;
      } else {
        this.msg['email'] = false;
      }
    },
    validatePassword(value) {
      if (/^(?=.*\d)(?=.*[a-z])(?=.*[^\w\d\s:])([^\s]){8,16}$/.test(value)) {
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
      } else if (this.address_detail == null) {
        this.$swal({
          icon: 'error',
          title: '상세주소를 입력해주세요!',
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
      } else if (this.gender == null) {
        this.$swal({
          icon: 'error',
          title: '성별을 체크해주세요!',
        });
      } else if (this.age == null) {
        this.$swal({
          icon: 'error',
          title: '연령대를 체크해주세요!',
        });
      } else if (this.phonechk == false) {
        this.$swal({
          icon: 'error',
          title: '휴대폰 본인인증를 해주세요!',
        });
      } else {
        const userData = {
          email: this.email,
          password: this.password,
          phone: this.phone,
          address: this.address,
          address_detail: this.address_detail,
          type: 1,
          nickname: this.nickname,
          age: this.age,
          gender: this.gender,
        };

        console.log(userData);

        const { data } = await register(userData);

        if (data == 'SUCCESS') {
          this.$swal({
            position: 'top-end',
            icon: 'success',
            title: '회원가입성공!!',
            showConfirmButton: false,
            timer: 1500,
          });
          this.$router.push('/main');
        } else {
          this.$swal({
            icon: 'error',
            title: '회원가입 실패 관리자에게 문의해주세요',
          });
        }
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
          $vm.address = data.roadAddr;
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
.col-auto {
  padding: 0;
  height: 100%;
}
#verifyphone {
  max-width: 450px;
  border: 1px solid;
}
.phone-num {
  display: flex;
  align-items: center;
}
.b {
  margin-bottom: 20px;
}

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
  margin-top: 4rem;
}
.right {
  margin-top: 20rem;
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
  height: 100vh;
  margin-bottom: 0;
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
.right .form {
  width: 400px;
}
.form input[type='text'],
.form input[type='email'],
.form input[type='password'] {
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
  height: 24px;
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

<template>
  <div class="body">
    <div class="split-screen">
      <div class="left">
        <section class="copy">
          <h1>환영합니다. 리테일러 고객님!</h1>
          <p>서비스이용을 위해 회원가입을 진행해주세요</p>
        </section>
      </div>
      <div class="right">
        <div class="form">
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
          <div class="input-container email">
            <label for="email">E-MAIL</label>
            <input id="email" name="email" type="email" v-model="email" />
          </div>
          <div class="input-container password">
            <label for="password">Password</label>
            <input type="password" placeholder="특수문자를 포함해서 8자이상 작성해주세요" v-model="password" />
            <input type="password" placeholder="비밀번호 확인" v-model="pwdcheck" />
          </div>
          <div class="input-container name">
            <label for="fname">BUSINESS_NUMBER</label>
            <div class="business-num">
              <input maxlength="3" type="text" v-model="business_num1" />
              <div class="b">-</div>
              <input maxlength="2" type="text" v-model="business_num2" />
              <div class="b">-</div>
              <input maxlength="5" type="text" v-model="business_num3" />
            </div>
          </div>
          <!-- <div class="input-container ">
            <label for="email">생년월일</label>
            <form name="frm" class="birthday">
              <input type="text" size="6" maxlength="6" name="ju1" v-model="birthday" />
              <div class="b">-</div>
              <input type="text" size="1" maxlength="1" name="ju2" style="width:100px" v-model="gender" />
            </form>
          </div> -->
          <div class="input-container password">
            <label for="">ADRESS</label>
            <div class="d-flex">
              <input type="text" v-model="postcode" disabled />
              <input class="signup-btn search" type="button" @click="sample4_execDaumPostcode" value="우편번호 찾기" />
            </div>
            <input type="text" v-model="address" disabled />
            <input type="text" v-model="address_detail" placeholder="상세주소를 입력해주세요" />
          </div>
          <label for="fname">PHONE</label>
          <div class="phone-num">
            <input maxlength="3" type="text" v-model="phone_num1" />
            <div class="b">-</div>
            <input maxlength="4" type="text" v-model="phone_num2" />
            <div class="b">-</div>
            <input maxlength="4" type="text" v-model="phone_num3" />
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
          <button class="signup-btn" type="submit" @click.prevent="signup">Sign up</button>
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
      email: '',
      dialog: true,
      password: '',
      pwdcheck: '',
      address: '',
      address_detail: '',
      phone: '',
      business_num1: '',
      business_num2: '',
      business_num3: '',
      phone_num1: '',
      phone_num2: '',
      phone_num3: '',
      phonechk: false,
      postcode: '',
      verifynum1: '',
      verifynum2: '',
      type: 2,
      msg: [],
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
      // console.log(phone_num);
      this.phone = phone_num;
      // const { data } = await verifyPhone(phone_num);
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
      } else if (!this.msg['password']) {
        this.$swal({
          icon: 'error',
          title: '비밀번호 입력시 8자리이상, 특수문자를 포함해주세요!',
        });
      } else if (this.business_num1 == null) {
        this.$swal({
          icon: 'error',
          title: '사업자 등록번호를 입력해주세요!',
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
          title: '비밀번호를 입력해주세요!',
        });
      } else if (this.password != this.pwdcheck) {
        this.$swal({
          icon: 'error',
          title: '비밀번호확인이 일치하지않습니다!',
        });
      } else {
        var business_number = this.business_num1 + '-' + this.business_num2 + '-' + this.business_num3;
        const userData = {
          email: this.email,
          password: this.password,
          phone: this.phone,
          address: this.address,
          address_detail: this.address_detail,
          business_number: business_number,
          type: 2,
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
#verifyphone {
  max-width: 450px;
  border: 1px solid;
}
.col-auto {
  padding: 0;
  height: 100%;
}
.phone-num {
  display: flex;
  align-items: center;
}

:root {
  font-size: 100%;
  font-size: 16px;
  line-height: 1.5;
}
.business-num {
  display: flex;
  align-items: center;
}
.b {
  margin-bottom: 20px;
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
  margin-top: 13rem;
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
</style>

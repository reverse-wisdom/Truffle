<template>
  <span class="basic">
    <span class="" v-if="this.$store.state.type == '1'">
      <div class="container-user">
        <div class="box">
          <div class="profile">
            <h3>기본정보</h3>
            <h4>NICKNAME</h4>
            <input type="text" class="input disabled" v-model="value.nickname" disabled />
            <h4>EMAIL</h4>
            <input type="text" class="input" v-model="value.email" disabled />
            <h4>GENDER</h4>
            <input type="text" class="input disabled" v-model="gender" disabled />
            <h4>AGE</h4>
            <input type="text" class="input disabled" v-model="value.age" disabled />
            <h4>ADDRESS</h4>
            <input type="text" class="input" v-model="fulladdress" disabled />
            <h4>PHONE</h4>
            <input type="text" class="input disabled" v-model="value.phone" disabled />
          </div>
          <button class="btn" id="update_btn" @click="update">수정하기</button>
          <!-- <button class="btn" @click="modal">탈퇴하기</button> -->
        </div>
      </div>
    </span>
    <span class="" v-else>
      <div class="container-retail">
        <div class="box ">
          <div class="profile">
            <h3>기본정보</h3>
            <h4>EMAIL</h4>
            <input type="text" class="input" v-model="value.email" disabled />
            <h4>ADDRESS</h4>
            <input type="text" class="input" v-model="fulladdress" disabled />
            <h4>PHONE</h4>
            <input type="text" class="input disabled" v-model="value.phone" disabled />
            <h4>BUSINESS_NUMBER</h4>
            <input type="text" class="input disabled" v-model="value.business_number" disabled />
          </div>
          <button class="btn" id="update_btn" @click="update">수정하기</button>
          <!-- <button class="btn" @click="modal">탈퇴하기</button> -->
        </div>
      </div>
    </span>
  </span>
</template>

<script>
import { fetchUser, editUser, signout } from '@/api/auth';

export default {
  name: 'Basic',
  data() {
    return {
      updatechk: true,
      value: '',
      gender: '',
      fulladdress: '',
    };
  },
  async created() {
    const { data } = await fetchUser(this.$store.state.email);
    // console.log('회원정보', data);
    this.value = data;
    if (data.gender == '1') {
      this.gender = '남성';
    } else {
      this.gender = '여성';
    }
    this.fulladdress = data.address + ' ' + data.address_detail;
    if (this.value.phone.length == 11) {
      this.value.phone = data.phone.slice(0, 3) + '-' + data.phone.slice(3, 7) + '-' + data.phone.slice(7, 11);
    } else {
      this.value.phone = data.phone;
    }
  },
  methods: {
    async update() {
      if (this.updatechk) {
        $('.disabled')
          .attr('disabled', false)
          .addClass('border');
        $('#update_btn').text('수정완료');
        this.updatechk = false;
      } else {
        $('.disabled')
          .attr('disabled', true)
          .removeClass('border');
        $('#update_btn').text('수정하기');
        this.updatechk = true;
        // email값 필수, 수정가능한값: address,address_detail,age,business_number,gender,nickname,password,phone
        if (this.gender == '남성' || this.gender == '남자') {
          var editgender = 1;
        } else {
          var editgender = 2;
        }
        if (this.value.type == '1') {
          // console.log(this.value.phone.length);
          if (this.value.phone.length == 11) {
            const phone = this.value.phone;
            const editdata = {
              email: this.value.email,
              password: this.$store.state.password,
              nickname: this.value.nickname,
              age: this.value.age,
              phone: this.value.phone.slice(0, 3) + '-' + this.value.phone.slice(3, 7) + '-' + this.value.phone.slice(7, 11),
              address: this.value.address,
              address_detail: this.value.address_detail,
              business_number: this.value.business_number,
              type: this.value.type,
            };
            // console.log(editdata);
            const { data } = await editUser(editdata);
          } else if (this.value.phone.length == 13) {
            const editdata = {
              email: this.value.email,
              password: this.$store.state.password,
              nickname: this.value.nickname,
              age: this.value.age,
              phone: this.value.phone,
              address: this.value.address,
              address_detail: this.value.address_detail,
              business_number: this.value.business_number,
              type: this.value.type,
            };
            // console.log(editdata);
            const { data } = await editUser(editdata);
          } else {
            this.$swal({
              icon: 'error',
              title: '수정실패, 휴대폰을 확인하세요',
            });
          }
        } else {
          if (this.value.phone.length == 11) {
            const phone = this.value.phone;
            const editdata = {
              email: this.value.email,
              password: this.$store.state.password,
              phone: this.value.phone.slice(0, 3) + '-' + this.value.phone.slice(3, 7) + '-' + this.value.phone.slice(7, 11),
              address: this.value.address,
              address_detail: this.value.address_detail,
              business_number: this.value.business_number,
              type: this.value.type,
            };
            // console.log(editdata);
            const { data } = await editUser(editdata);
          } else if (this.value.phone.length == 13) {
            const editdata = {
              email: this.value.email,
              password: this.$store.state.password,
              phone: this.value.phone,
              address: this.value.address,
              address_detail: this.value.address_detail,
              business_number: this.value.business_number,
              type: this.value.type,
            };
            // console.log(editdata);
            const { data } = await editUser(editdata);
          } else {
            this.$swal({
              icon: 'error',
              title: '수정실패, 휴대폰을 확인하세요',
            });
          }
        }
      }
    },
    async signout() {
      const { data } = await signout(this.$store.state.email);
      // console.log(data)
    },
    modal() {
      this.$swal({
        title: '탈퇴하시겠습니까?',
        icon: 'warning',
        showCancelButton: true,
        cancelButtonText: 'cancel',
      }).then((result) => {
        if (result.isConfirmed) {
          this.signout();
        } else {
        }
      });
    },
  },
};
</script>

<style scoped>
.basic {
  margin-bottom: 3rem;
}
.container-user {
  background: #fff;
  width: 60vw;
  height: 660px;
  margin: 0 auto;
  position: relative;
  box-shadow: 2px 5px 20px rgba(119, 119, 119, 0.5);
  /* margin-bottom: 50px; */
  padding-top: 20px;
}
.container-retail {
  background: #fff;
  width: 60vw;
  height: 500px;
  margin: 0 auto;
  position: relative;
  border-radius: 20px;
  box-shadow: 2px 5px 20px rgba(119, 119, 119, 0.5);
  /* margin-bottom: 50px; */
  left: 10%;
  padding-top: 20px;
}
.box {
  width: 80%;
  margin-left: 15%;
}
h3 {
  font-family: 'Montserrat', sans-serif;
  color: #000;
  font-size: 1.5rem;
  margin-top: 20px;
  margin-bottom: 35px;
}
h4 {
  color: #777;
  font-family: 'Roboto', sans-serif;
  text-transform: uppercase;
  font-size: 1rem;
  letter-spacing: 1px;
  margin-left: 2px;
  margin-top: 10px;
}
.input {
  border: 0;
  margin: 5px 0;
  border-bottom: 1px solid #000;
  width: 90%;
  font-family: 'montserrat', sans-serif;
  font-size: 0.8rem;
  padding: 7px 0;
  color: #070707;
  outline: none;
}
.border {
  border: 1px solid;
}
.btn {
  font-family: 'roboto', sans-serif;
  text-transform: uppercase;
  font-size: 15px;
  border: 0;
  color: #fff;
  background: #000;
  padding: 7px 15px;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2);
  cursor: pointer;
  margin-top: 15px;
  margin-left: 10px;
  float: right;
}
</style>

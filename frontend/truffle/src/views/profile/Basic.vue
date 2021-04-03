<template>
  <span>
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
            <input type="text" class="input disabled" v-model="value.gender" disabled />
            <h4>AGE</h4>
            <input type="text" class="input disabled" v-model="value.age" disabled />
            <h4>ADDRESS</h4>
            <input type="text" class="input" v-model="fulladdress" disabled />
            <h4>PHONE</h4>
            <input type="text" class="input disabled" v-model="value.phone" disabled />
          </div>
          <button class="btn" id="update_btn" @click="update">수정하기</button>
          <button class="btn">탈퇴하기</button>
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
          <button class="btn">탈퇴하기</button>
        </div>
      </div>
    </span>
  </span>
</template>

<script>
import { fetchUser, editUser } from '@/api/auth';

export default {
  name: 'Basic',
  data() {
    return {
      updatechk: true,
      value: '',
      fulladdress: '',
    };
  },
  async created() {
    const { data } = await fetchUser(this.$store.state.email);
    // console.log('회원정보', data);
    this.value = data;
    this.fulladdress = data.address + ' ' + data.address_detail;
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
        const editdata = {
          email: this.value.email,
          age: this.value.age,
          gender: this.value.gender,
          nickname: this.value.nickname,
          phone: this.value.phone,
          address: this.value.address,
          address_detail: this.value.address_detail,
          business_number: this.value.business_number,
          type: this.value.type,
        };
        console.log(editdata);
        const { data } = await editUser(editdata);
        console.log(data);
      }
    },
  },
};
</script>

<style scoped>
.container-user {
  background: #fff;
  width: 60vw;
  height: 600px;
  margin: 0 auto;
  position: relative;
  box-shadow: 2px 5px 20px rgba(119, 119, 119, 0.5);
  margin-bottom: 50px;
  padding-top: 20px;
}
.container-retail {
  background: #fff;
  width: 60vw;
  height: 500px;
  margin: 0 auto;
  position: relative;
  box-shadow: 2px 5px 20px rgba(119, 119, 119, 0.5);
  margin-bottom: 50px;
  padding-top: 20px;
}
.box {
  width: 80%;
  margin-left: 15%;
}
h3 {
  font-family: 'Montserrat', sans-serif;
  color: #7ed386;
  font-size: 1.5rem;
  margin-top: 40px;
  margin-bottom: 35px;
}
h4 {
  color: #777;
  font-family: 'Roboto', sans-serif;
  text-transform: uppercase;
  font-size: 0.9rem;
  letter-spacing: 1px;
  margin-left: 2px;
  margin-top: 10px;
}
.input {
  border: 0;
  border-bottom: 1px solid #3fb6a8;
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
  font-family: 'roboto' sans-serif;
  text-transform: uppercase;
  font-size: 15px;
  border: 0;
  color: #fff;
  background: #7ed386;
  padding: 7px 15px;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2);
  cursor: pointer;
  margin-top: 15px;
  margin-left: 10px;
  float: right;
}
</style>

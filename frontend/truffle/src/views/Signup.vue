<template>
  <div class="">
    <h1>회원가입페이지</h1>
    <hr />
    <div>
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
      <button @click="Signup">회원가입</button>
    </div>
  </div>
</template>

<script>
import {} from '@/api/auth';

export default {
  data() {
    return {
      Id: '',
      password: '',
    };
  },
  methods: {
    async Signup() {
      const userData = {
        Id: this.Id,
        password: this.password,
      };
      const data = await SignupUser(userData);
      console.log(data);
    },
  },
};
</script>
<style scoped></style>

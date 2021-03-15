<template>
  <div class="">
    <h1>로그인페이지</h1>
    <hr>
    <div>
      <label for="">이메일: </label>
      <input type="text" v-model="Id">
    </div>
    <br>
    <div>
      <label for="">비밀번호: </label>
      <input type="password" v-model="password">
    </div>
    <br>
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
      Id: "",
      password: ""
    }
  },
  methods: {
    async Login() {
      const userData = {
        Id : this.Id,
        password : this.password
      }
      const data = await loginUser(userData)
      console.log(data)

    }
  }
  
}
</script>
<style scoped>

</style>
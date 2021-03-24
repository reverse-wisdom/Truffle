<template>
  <div class="hero">
    <div class="left-col">
      <!-- <img src="@/assets/img/side.png" class="menu-icon-1" /> -->
      <div class="logo">
        <img src="@/assets/img/logo.jpg" alt="" />
      </div>
      <div class="bar"></div>
    </div>
    <div class="right-col">
      <div class="navbar">
        <img src="" alt="" />
        <ul>
          <li>CATEGORY</li>
          <li>공지사항</li>
          <li>SIGNUP</li>
          <li>LOGIN</li>
          <li>이벤트등록</li>
          <li>마이페이지</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: 'Open Sans', sans-serif;
}
.hero {
  display: flex;
  width: 100%;
  height: 100%;
}
.left-col {
  flex-basis: 30%;
  background: #3f74fe;
  height: 100%;
  position: relative;
}

.menu-icon-1 {
  margin: 40px;
}
.logo {
  /* margin-left: 120px; */
  /* margin-top: 120px; */
}
.bar {
  position: absolute;
  height: 20px;
  width: 280px;
  background: #fff;
  top: 250px;
  right: 0;
}
.right-col {
  flex-basis: 70%;
  background: #f3f33b;
  height: 100%;
  position: relative;
}
.navbar {
  position: absolute;
  right: 45px;
  top: 85px;
  display: flex;
}
.navbar li {
  list-style: none;
  margin: 0 40px;
  display: inline-block;
  font-size: 12px;
  font-weight: bold;
  cursor: pointer;
}
</style>

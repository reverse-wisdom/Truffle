<template>
  <div class="bg">
    <div class="container">
      <h1>truffle</h1>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.bg {
  height: 100%;
  width: 100%;
  background-color: #6b6b6b;
}
.container {
  margin: 0;
  padding: 0;
  font-family: 'Montserrat', sans-serif;
  /* background-color: #333; */
}
h1 {
  font-size: 200px;
  text-transform: uppercase;
  font-weight: 900;
  letter-spacing: 20px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  margin: 0;
  background-image: url('../assets/img/mainbg.png');
  background-size: cover;
  background-color: rgba(255, 255, 255, 0.8);
  color: rgba(255, 255, 255, 0.5);
  /* -webkit-text-fill-color: transparent; */
  background-clip: text;
}
</style>

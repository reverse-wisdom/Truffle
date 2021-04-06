<template>
  <footer class="footer-body">
    <div class="container">
      <div class="copyright">&copy;, made with by Team TruffleMaker for a better web.</div>
      <footer>
        <div class="footer-content">
          <h3>TRUFFLE MAKER</h3>
          <p>윤예준 BE</p>
          <p>이원회 FE</p>
          <p>이혜지 FE</p>
        </div>
        <div class="footer-bottom">
          <p>copyright &copy;2021 TRUFFLE</p>
        </div>
      </footer>
    </div>
  </footer>
</template>

<script>
export default {};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
footer {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  background: #111;
  height: auto;
  width: 100vw;
  font-family: 'Open Sans';
  padding-top: 10px;
  color: #fff;
}
.footer-content {
  padding: 0 auto;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  text-align: center;
}
.footer-content h3 {
  padding-top: 0;
  font-size: 1.8rem;
  font-weight: 400;
  text-transform: capitalize;
  line-height: 2rem;
}
.footer-content p {
  max-width: 500px;
  margin: 10px auto;
  line-height: 0.5rem;
  font-size: 14px;
}
.footer-bottom {
  background: #000;
  width: 100vw;
  padding: 5px 0;
  text-align: center;
}
.footer-bottom p {
  font-size: 14px;
  word-spacing: 2px;
  text-transform: capitalize;
}
</style>

<template>
  <v-app id="app">
    <!-- navbar 위치 -->
    <div id="nav">
      <router-link to="/">Home</router-link>
      |
      <router-link to="/login">Login</router-link>
      |
      <router-link to="/signup">Signup</router-link>
      |
      <router-link to="/landing">FullPage</router-link>
    </div>

    <div>
      <router-view />
    </div>

    <div id="footer">
      <hr />
      <footer class="footer">
        <div class="container">
          <div class="copyright">&copy; {{ year }}, made with by Team TruffleMaker for a better web.</div>
          <nav>
            <ul>
              <li>
                <a href="">
                  개인정보 처리방침
                </a>
              </li>
              <li>
                <a href="">
                  사이트 이용안내
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </footer>
    </div>
  </v-app>
</template>
<script>
export default {
  data() {
    return {
      year: new Date().getFullYear(),
    };
  },
};
</script>
<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
  position: fixed;
  /* text-align: center; */
  z-index: 1;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

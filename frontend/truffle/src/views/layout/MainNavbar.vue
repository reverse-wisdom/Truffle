<template>
  <div id="nav">
    <header>
      <a class="logo" href="/"><img src="@/assets/img/logo1.png" alt="logo" /></a>
      <nav>
        <ul class="nav__links" v-if="this.$store.state.token">
          <li><a class="font" href="/main">Main</a></li>
          <li><a class="font" href="/">Home</a></li>
          <li><a class="font" href="/categoryall">Category</a></li>
          <li><a class="font" href="/test">Test</a></li>
          <li><a class="font" href="/guide">Guide</a></li>

          <li v-show="$store.state.type == '2'"><a class="font" href="/eventCreate">Event</a></li>
          <li>
            <a class="font" href="/profileUser">Profile</a>
          </li>
          <li><a class="font" @click="logout">Logout</a></li>
        </ul>
        <ul class="nav__links" v-else>
          <li><a class="font" href="/">Home</a></li>
          <li><a class="font" href="/guide">Guide</a></li>
          <li><a class="font" href="/signin-signup">Login</a></li>
        </ul>
      </nav>
      <p class="menu cta" @click="menu">Menu</p>
    </header>
    <div id="mobile__menu" class="overlay">
      <a class="close" @click="close">&times;</a>
      <div class="overlay__content">
        <div v-if="this.$store.state.token">
          <a class="font" href="/">Home</a>
          <a class="font" href="/guide">Guide</a>
          <a class="font" href="/ProfileUser">profileuser</a>
          <a class="font" @click="logout">Logout</a>
        </div>
        <div class="nav__links" v-else>
          <a class="font" href="/">Home</a>
          <a class="font" href="/guide">Guide</a>
          <a class="font" href="/signin-signup">Login</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {},
  methods: {
    menu() {
      const doc = document;
      const menuOpen = doc.querySelector('.menu');
      const overlay = doc.querySelector('.overlay');

      overlay.classList.add('overlay--active');
    },
    close() {
      const doc = document;
      const menuClose = doc.querySelector('.close');
      const overlay = doc.querySelector('.overlay');
      overlay.classList.remove('overlay--active');
    },
    logout() {
      this.$store.commit('clearEmail');
      this.$store.commit('clearToken');
      this.$store.commit('clearType');
      this.$store.commit('clearPassword');
      this.$store.commit('clearNickname');

      if (this.$store.state.type == '1') {
        this.$store.commit('clearUuid');
      } else {
        this.$store.commit('clearRetailuuid');
      }
      localStorage.clear();
      sessionStorage.clear();

      this.$router.push({ name: 'Sign-In-Up' });
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
img {
  width: 30%;
}

header {
  display: flex;
  width: 100%;
  justify-content: flex-end;
  align-items: center;
  padding: 10px 5%;
  background-color: rgba(255, 255, 255, 1);
  z-index: 10;
  position: fixed;
}

.logo {
  margin-right: auto;
  display: flex;
}

.nav__links {
  list-style: none;
  display: flex;
}

.nav__links a,
.cta,
.overlay__content a {
  /* font-family: 'Montserrat', sans-serif; */
  font-weight: 500;
  color: #edf0f1;
  text-decoration: none;
}

.nav__links li {
  padding: 9px 15px;
  transition: all 0.3s ease 0s;
  color: #24252a;
  font-size: 0.8rem;
}

.nav__links li:hover {
  padding: 9px 15px;
  color: #fff;
  background-color: #381dfc;
  font-size: 1rem;
}

.nav__links li a {
  transition: all 0.3s ease 0s;
  padding: 9px 15px;
  color: #24252a;
  /* font-size: 0.8rem; */
}

.nav__links li a:hover {
  color: #fff;
  padding: 9px 15px;
  background-color: #381dfc;
  /* font-size: 1rem; */
}

.cta {
  margin-left: 20px;
  padding: 9px 25px;
  border: none;
  /* border-radius: 50px */
  cursor: pointer;
  transition: all 0.3s ease 0s;
  color: rgba(0, 0, 0, 1);
  font-size: 1rem;
}

.cta:hover {
  color: #fff;
  background-color: #381dfc;
  font-size: 1.5rem;
}

/* Mobile Nav */

.menu {
  display: none;
}

.overlay {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  background-color: #24252a;
  overflow-x: hidden;
  transition: all 0.5s ease 0s;
}

.overlay--active {
  width: 100%;
}

.overlay__content {
  display: flex;
  height: 100%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.overlay a {
  padding: 15px;
  font-size: 36px;
  display: block;
  transition: all 0.3s ease 0s;
}

.overlay a:hover,
.overlay a:focus {
  color: #0088a9;
}
.overlay .close {
  position: absolute;
  top: 50px;
  right: 45px;
  font-size: 60px;
  color: #edf0f1;
  cursor: pointer;
}

@media screen and (max-height: 450px) {
  .overlay a {
    font-size: 20px;
  }
  .overlay .close {
    font-size: 40px;
    top: 15px;
    right: 35px;
  }
}

@media only screen and (max-width: 800px) {
  .nav__links,
  .cta {
    display: none;
  }
  .menu {
    display: initial;
  }
}
</style>

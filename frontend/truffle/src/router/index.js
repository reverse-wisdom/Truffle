import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Main from '../views/Main.vue';

import MainNavbar from '../views/Layout/MainNavbar.vue';
import MainFooter from '../views/Layout/MainFooter.vue';

import Sign from '../views/User/Sign.vue';
import ResisterUser from '../views/User/ResisterUser.vue';
import ResisterRetailer from '../views/User/ResisterRetailer.vue';
import Landing from '../views/Landing.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    components: { default: Home, header: MainNavbar, footer: MainFooter },
  },
  {
    path: '/main',
    name: 'Main',
    component: Main,
  },
  {
    path: '/landing',
    name: 'Landing',
    component: Landing,
  },
  {
    path: '/signin-signup',
    name: 'Sign-In-Up',
    component: Sign,
  },
  {
    path: '/resisteruser',
    name: 'ResisterUser',
    component: ResisterUser,
  },
  {
    path: '/resisterretailer',
    name: 'ResisterRetailer',
    component: ResisterRetailer,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;

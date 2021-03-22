import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';

import MainNavbar from '../views/layout/MainNavbar.vue';
import MainFooter from '../views/layout/MainFooter.vue';

import Sign from '../views/Sign.vue';
import ResisterUser from '../views/ResisterUser.vue';
import ResisterRetailer from '../views/ResisterRetailer.vue';
import Landing from '../views/Landing.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    components: { default: Home, footer: MainFooter },
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

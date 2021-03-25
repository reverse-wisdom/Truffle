import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';

import Guide from '../views/Guide.vue';
import Test from '../views/Test.vue';
import Main from '../views/Main.vue';

import MainNavbar from '../views/layout/MainNavbar.vue';
import MainFooter from '../views/layout/MainFooter.vue';

import Full1 from '../views/Full1.vue';

import Sign from '../views/User/Sign.vue';
import ResisterUser from '../views/User/ResisterUser.vue';
import ResisterRetailer from '../views/User/ResisterRetailer.vue';
import Landing from '../views/Landing.vue';
import Board from '../views/Board.vue';
import BoardWrite from '../views/board/BoardWrite.vue';
import BoardDetail from '../views/board/BoardDetail.vue';
import BoardUpdate from '../views/board/BoardUpdate.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    components: { default: Home },
  },

  {
    path: '/test',
    name: 'Test',
    components: { default: Test, header: MainNavbar, footer: MainFooter },
  },
  {
    path: '/main',
    name: 'Main',
    components: { default: Main, header: MainNavbar, footer: MainFooter },
  },
  {
    path: '/full1',
    name: 'Full1',
    components: { default: Full1 },
  },
  {
    path: '/landing',
    name: 'Landing',
    component: Landing,
  },
  {
    path: '/guide',
    name: 'Guide',
    component: Guide,
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
  {
    path: '/board',
    name: 'Board',
    components: { default: Board, footer: MainFooter, header: MainNavbar },
  },
  {
    path: '/boardWrite',
    name: 'BoardWrite',
    components: { default: BoardWrite, footer: MainFooter, header: MainNavbar },
  },
  {
    path: '/boardDetail',
    name: 'BoardDetail',
    components: { default: BoardDetail, footer: MainFooter, header: MainNavbar },
  },

  {
    path: '/boardUpdate',
    name: 'BoardUpdate',
    component: BoardUpdate,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;

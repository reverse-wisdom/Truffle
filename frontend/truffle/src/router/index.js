import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';

import store from '@/store/index';

import Guide from '../views/Guide.vue';
import Test from '../views/Test.vue';
import Main from '../views/Main.vue';

import MainNavbar from '../views/layout/MainNavbar.vue';
import MainFooter from '../views/layout/MainFooter.vue';

import Sign from '../views/User/Sign.vue';
import ResisterUser from '../views/User/ResisterUser.vue';
import ResisterRetailer from '../views/User/ResisterRetailer.vue';

import ProfileUser from '../views/ProfileUser.vue';
import WinnerManageList from '../views/profile/WinnerManageList.vue';
import WinnerItem from '../views/profile/WinnerItem.vue';

import EventAll from '../views/event/EventAll.vue';
import EventDetail from '../views/event/EventDetail.vue';
import EventCreate from '../views/event/EventCreate.vue';
import EventUpdate from '../views/event/EventUpdate.vue';

import QnA from '../views/QnA.vue';
import QnAupdate from '../views/QnA/QnAupdate.vue';
import QnAwrite from '../views/QnA/QnAwrite.vue';
import QnAdetail from '../views/QnA/QnAdetail.vue';

import Search from '../views/Search.vue';
import CategoryAll from '../views/CategoryAll.vue';

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
    path: '/search',
    name: 'Search',
    components: { default: Search, header: MainNavbar },
  },
  {
    path: '/categoryall',
    name: 'CategoryAll',
    components: { default: CategoryAll, header: MainNavbar },
  },
  {
    path: '/guide',
    name: 'Guide',
    component: Guide,
  },

  // 회원관리
  {
    path: '/signin-signup',
    name: 'Sign-In-Up',
    components: { default: Sign },
  },
  {
    path: '/resisteruser',
    name: 'ResisterUser',
    components: { default: ResisterUser, header: MainNavbar },
  },
  {
    path: '/resisterretailer',
    name: 'ResisterRetailer',
    components: { default: ResisterRetailer, header: MainNavbar },
  },

  // 이벤트
  {
    path: '/eventAll',
    name: 'EventAll',
    components: { default: EventAll, header: MainNavbar },
  },
  {
    path: '/eventDetail',
    name: 'EventDetail',
    components: { default: EventDetail, header: MainNavbar },
    meta: { auth: true },
  },

  {
    path: '/eventCreate',
    name: 'EventCreate',
    components: { default: EventCreate, header: MainNavbar },
  },
  {
    path: '/eventUpdate',
    name: 'EventUpdate',
    components: { default: EventUpdate, header: MainNavbar },
  },
  {
    path: '/winnermanagelist',
    name: 'WinnerManageList',
    components: { default: WinnerManageList, header: MainNavbar },
  },
  {
    path: '/winnerItem',
    name: 'WinnerItem',
    components: { default: WinnerItem, header: MainNavbar },
  },

  // QnA
  // {
  //   path: '/QnA',
  //   name: 'QnA',
  //   components: { default: QnA },
  // },
  // {
  //   path: '/QnAdetail',
  //   name: 'QnAdeatil',
  //   components: { default: QnAdetail },
  // },
  // {
  //   path: '/QnAwrite',
  //   name: 'QnAwrite',
  //   components: { default: QnAwrite },
  // },
  // {
  //   path: '/QnAupdate',
  //   name: 'QnAupdate',
  //   components: { default: QnAupdate },
  // },

  // 프로필
  {
    path: '/profileUser',
    name: 'ProfileUser',
    components: { default: ProfileUser, header: MainNavbar },
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  if (to.meta.auth && !store.getters.isLogin) {
    Vue.swal({
      icon: 'error',
      title: '로그인후 사용가능한 서비스입니다.',
      showConfirmButton: false,
      timer: 1500,
    });
    next('/signin-signup');
    return;
  }
  next();
});
export default router;

import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    SERVER_URL: 'http://j4d110.p.ssafy.io/',
    LOCAL_URL: 'http://localhost:8081',
  },
  getters: {},
  mutations: {},
  actions: {},
});

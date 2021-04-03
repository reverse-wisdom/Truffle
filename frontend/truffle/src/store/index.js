import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';
import { loginUser, fetchUser } from '@/api/auth';
import router from '../router/index';
Vue.use(Vuex);

export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    token: '',
    email: '',
    nickname: '',
    retailuuid: '',
    uuid: '',
  },
  getters: {
    isLogin(state) {
      return state.token !== '';
    },
  },
  mutations: {
    setToken(state, token) {
      state.token = token;
    },
    clearToken(state) {
      state.token = '';
    },
    setEmail(state, email) {
      state.email = email;
    },
    clearEmail(state) {
      state.email = '';
    },
    setRetailuuid(state, retailuuid) {
      state.retailuuid = retailuuid;
    },
    clearLawuuid(state) {
      state.retailuuid = '';
    },
    setUuid(state, uuid) {
      state.uuid = uuid;
    },
    clearUuid(state) {
      state.uuid = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      const data = await loginUser(userData);
      console.log(data);
      if (data.data.message == 'SUCCESS') {
        commit('setToken', data.data['access-token']);
        commit('setEmail', userData.email);
        const response = await fetchUser(userData.email);
        if (response.data.type == 1) {
          commit('setUuid', response.data.uuid);
        } else {
          commit('setRetailuuid', response.data.uuid);
        }
        router.push('/main');
      } else {
        Vue.swal({
          icon: 'error',
          title: '로그인 실패! 이메일 및 비밀번호를 확인해 주세요!',
        });
      }
    },
  },
});

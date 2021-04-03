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
    type: '',
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
    clearRetailuuid(state) {
      state.retailuuid = '';
    },
    setUuid(state, uuid) {
      state.uuid = uuid;
    },
    clearUuid(state) {
      state.uuid = '';
    },
    setType(state, type) {
      state.type = type;
    },
    clearType(state) {
      state.type = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      const data = await loginUser(userData);
      // console.log(data);
      if (data.data.message == 'SUCCESS') {
        commit('setToken', data.data['access-token']);
        commit('setEmail', userData.email);
        const response = await fetchUser(userData.email);
        console.log(response);
        if (response.data.type == 1) {
          commit('setUuid', data.data.uuid);
          commit('setType', response.data.type);
        } else {
          commit('setRetailuuid', data.data.uuid);
          commit('setType', response.data.type);
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

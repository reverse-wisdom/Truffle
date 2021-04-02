import Vue from 'vue';
import Vuex from 'vuex';
import { loginUser } from '@/api/auth';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    SERVER_URL: 'http://j4d110.p.ssafy.io/',
    LOCAL_URL: 'http://localhost:8080',
    token: '',
    email: '',
    password: '',
    nickname: '',
    retailuuid: '',
    uuid: '',
  },
  getters: {
    isLogin(state) {
      return state.email !== '';
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
    setPassword(state, password) {
      state.password = password;
    },
    clearPassword(state) {
      state.password = '';
    },
    setNickname(state, nickname) {
      state.nickname = nickname;
    },
    clearNickname(state) {
      state.nickname = '';
    },
    setRetailuuid(state, Retailuuid) {
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
      var data;
      try {
        data = await loginUser(userData);
        // if (data.data.code == 'LOGIN_SUCCESS') {
        // commit('setToken', data.data['message']);
        // commit('setEmail', data.data.member.email);
        // commit('setPassword', userData.password);
        // commit('setNickname', data.data.member.name);
        // commit('setUuid', data.data.member.uuid);
        // commit('setAdress', data.data.member.phone);
        // commit('setRetailuuid', data.data.member.lawuuid);
        //   router.push('/home');
        // }
      } catch (err) {
        Vue.swal({
          icon: 'error',
          title: '로그인 실패! 이메일 및 비밀번호를 확인해 주세요!',
        });
      }
    },
  },
});

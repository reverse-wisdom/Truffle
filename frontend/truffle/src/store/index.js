import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';
import { loginUser } from '@/api/auth';
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
    //토큰
    setToken(state, token) {
      state.token = token;
    },
    clearToken(state) {
      state.token = '';
    },
    //이메일
    setEmail(state, email) {
      state.email = email;
    },
    clearEmail(state) {
      state.email = '';
    },
    //닉네임
    setNickname(state, nickname) {
      state.nickname = nickname;
    },
    clearNickname(state) {
      state.nickname = '';
    },
    //리테일러
    setRetailuuid(state, retailuuid) {
      state.retailuuid = retailuuid;
    },
    clearRetailuuid(state) {
      state.retailuuid = '';
    },
    //일반유저
    setUuid(state, uuid) {
      state.uuid = uuid;
    },
    clearUuid(state) {
      state.uuid = '';
    },
  },

  actions: {
    async LOGIN({ commit }, userData) {
      try {
        const data = await loginUser(userData);
        if (data.data.message == 'SUCCESS') {
          commit('setToken', data.data['access-token']);
          commit('setEmail', userData.email);
          commit('setUuid', userData.email);
          commit('setRetailuuid', userData.email);
          router.push('/main');
        }
      } catch (err) {
        Vue.swal({
          icon: 'error',
          title: '로그인 실패! 이메일 및 비밀번호를 확인해 주세요!',
        });
      }
    },
  },
});

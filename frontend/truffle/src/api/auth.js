import { instance, posts } from './index';

function loginUser(userData) {
  return instance.post('/account/login', userData);
}

function register(userData) {
  return instance.post('account/signUp', userData);
}

function userJoinEvent(email) {
  return posts.get(`/account/selectEventParticipationByEmail?email=${email}`);
}

export { loginUser, register, userJoinEvent };

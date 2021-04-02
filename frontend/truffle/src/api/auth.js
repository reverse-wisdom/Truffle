import { instance, posts } from './index';

function loginUser(userData) {
  return instance.post('/account/login', userData);
}

function registerRetail(userData) {
  return instance.post('');
}

function registerUser(userData) {
  return instance.post('');
}
function userJoinEvent(email) {
  return posts.get(`/account/selectEventParticipationByEmail?email=${email}`);
}

export { loginUser, registerRetail, registerUser, userJoinEvent };

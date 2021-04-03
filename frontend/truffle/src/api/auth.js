import { instance, posts } from './index';

function loginUser(userData) {
  return instance.post('/account/login', userData);
}

function fetchUser(email) {
  return posts.get(`account/accountInfo?email=${email}`);
}

function register(userData) {
  return instance.post('account/signUp', userData);
}

function editUser(userData) {
  return posts.put(`account/update`, userData);
}

function userJoinEvent(email) {
  return posts.get(`account/selectEventParticipationByEmail?email=${email}`);
}

function userWinEvent(email) {
  return posts.get(`account/selectEventWinnerByEmail?email=${email}`);
}

export { loginUser, fetchUser, register, userJoinEvent, userWinEvent, editUser };

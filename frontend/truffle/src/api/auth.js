import { instance, posts } from './index';

function loginUser(userData) {
  return instance.post('/api/member/login', userData);
}

function registerRetail(userData) {
  return instance.post('');
}

function registerUser(userData) {
  return instance.post('');
}

export { loginUser, registerRetail, registerUser };

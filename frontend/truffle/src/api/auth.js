import { instance, posts } from './index';

function loginUser(userData) {
  return instance.post('/api/member/login', userData);
}


export { loginUser }
import axios from 'axios';
import { setInterceptors } from './common/interceptors';

function createInstance() {
  return axios.create({
    baseURL: 'https://j4d110.p.ssafy.io/truffle',
  });
}

function createInstanceWithAuth(url) {
  const instance = axios.create({
    baseURL: 'https://j4d110.p.ssafy.io/truffle',
  });
  return setInterceptors(instance);
}

export const instance = createInstance();
export const posts = createInstanceWithAuth();

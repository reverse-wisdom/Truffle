import { instance, posts } from './index';

// 로그인
function loginUser(userData) {
  return instance.post('/account/login', userData);
}
// 사용자정보조회
function fetchUser(email) {
  return posts.get(`/account/accountInfo?email=${email}`);
}
//회원가입
function register(userData) {
  return instance.post('/account/signUp', userData);
}
//정보수정
function editUser(userData) {
  return posts.put(`/account/update`, userData);
}
// 응모중인 상품
function userJoinEvent(email) {
  return posts.get(`/account/selectEventParticipationByEmail?email=${email}`);
}
// 이벤트 당첨 목록
function userWinEvent(email) {
  return posts.get(`/account/selectEventWinnerByEmail?email=${email}`);
}
// 등록한 상품
function retailerAllEvent(uuid) {
  return posts.get(`/account/selectCreateEventListByID?uuid=${uuid}`);
}
// 폰인증
function verifyPhone(phone) {
  return posts.get(`/account/verifyPhoneNumber?phone=${phone}`);
}

export { loginUser, fetchUser, register, userJoinEvent, userWinEvent, editUser, retailerAllEvent, verifyPhone };

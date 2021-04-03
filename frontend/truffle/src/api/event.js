import { instance, posts } from './index';

//이벤트전체조회
function eventAll() {
  return posts.get('/event/all');
}
//이벤트 상세조회
function eventDetail(event_id) {
  return posts.get(`/event/detail?event_id=${event_id}`);
}
//이벤트 페이지 작성
function eventInsert(event_data) {
  return posts.post('/event/insert', event_data);
}
//이벤트 수정
function eventUpdate(event_data) {
  return posts.put('/event/update', event_data);
}

//나이별 상세 조회
function eventSelectAge(age) {
  return posts.get(`/event/selectByAge?age=${age}`);
}
//카테고리별 조회
function eventSelectCategory(category) {
  return posts.get(`/event/selectByCategory?category=${category}`);
}
//성별 상세 조회
function eventSelectGender(gender) {
  return posts.get(`/event/selectByGender?gender=${gender}`);
}
//상품명별 조회
function eventSelectProduct(product) {
  return posts.get(`/event/selectByProduct?product=${product}`);
}
//이벤트 참여자수 증가
function eventJoin(event_id) {
  return posts.put('/event/joinEvent', event_id, { headers: { 'Content-Type': 'application/json' } });
}

//특정이벤트 참여자 조회
function checkPartipants(event_id) {
  return posts.get(`/event/selectParticipationListByEventId?event_id=${event_id}`);
}
//특정이벤트 당첨자 조회
function eventWin(event_id) {
  return posts.get(`/event/selectWinListByEventId?event_id=${event_id}`);
}

export { checkPartipants, eventAll, eventDetail, eventInsert, eventUpdate, eventSelectAge, eventSelectCategory, eventSelectGender, eventSelectProduct, eventJoin, eventWin };

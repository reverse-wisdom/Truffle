import { instance, posts } from './index';

//결제확인
function verifyIamport(imp_uid) {
  return posts.get(`order/verifyIamport?imp_uid=${imp_uid}`);
}

//결제한사람 정보입력
function completePayment(data) {
  return posts.post(`order/completePayment`, data);
}

// 특정이벤트 결제조회
function fetchOrder(event_id) {
  return posts.get(`order/selectOrderByEventId?event_id=${event_id}`);
}

// 결제취소
function cancleOrder(imp_uid) {
  return posts.get(`order/cancelIamport?imp_uid=${imp_uid}`);
}
// 결제 테이블삭제
function deleteOrdertable(imp_uid) {
  return posts.delete(`order/deleteOrderByEventId?event_id=${imp_uid}`);
}
// 주문 상태변경
function editOderStatus(editorder) {
  return posts.put(`order/updateOrderStatus`, editorder);
}

export { verifyIamport, completePayment, fetchOrder, cancleOrder, deleteOrdertable, editOderStatus };

import { instance, posts } from './index';

function fetchBoardList() {
  return posts.get();
}
function createBoard(postData) {
  return posts.post();
}
function detailBoard(boardId) {
  return posts.get();
}
function editBoard() {
  return posts.put();
}
function deleteBoard() {
  return posts.delete(``);
}
export { fetchBoardList, createBoard, detailBoard, editBoard, deleteBoard };

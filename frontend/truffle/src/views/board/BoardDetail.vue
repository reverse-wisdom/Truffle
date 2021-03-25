<template>
  <div>
    <v-container>
      <table class="styled-table" style="width: 100%">
        <tr>
          <th scope="col">제목</th>
          <td>{{ value.title }}</td>
        </tr>
        <tr style="border-top: 1px solid;">
          <th scope="col">작성자</th>
          <td>{{ value.name }}</td>
        </tr>
        <tr style="border-top: 1px solid;">
          <th scope="col">작성시간</th>
          <!-- <td>{{ this.$moment(value.uploadDate).format('llll') }}</td> -->
          <td>{{ value.uploadDate }}</td>
        </tr>
        <tr style="border-top: 1px solid;">
          <th scope="col">조회수</th>
          <td>{{ value.hit }}</td>
        </tr>
        <tr style="border-top: 1px solid;">
          <th scope="col">내용</th>
          <td v-html="value.content"></td>
        </tr>
      </table>

      <div style="text-align:right">
        <v-btn color="#2bbef2" class="mr-1" dark @click="updatePage(value)">수정</v-btn>
        <v-btn color="#ea37a3" class="mr-1" dark @click="deletePage()">삭제</v-btn>
        <v-btn color="#000" dark @click="moveBoard()">뒤로가기</v-btn>
      </div>
    </v-container>
  </div>
</template>

<script>
import { detailBoard, deleteBoard } from '@/api/board';

export default {
  data() {
    return {
      value: { title: '제목1', category: '예1', name: '김싸피', hit: '3', uploadDate: '2021-03-23', content: '공사중입니다.', boardId: '1' },
    };
  },
  async created() {
    const postData = this.$route.query.boardId;
    // const { data } = await detailBoard(postData);
    // console.log(data);
    // this.value = data;
  },
  methods: {
    moveBoard() {
      this.$router.push('/board');
    },
    async deletePage() {
      const boardId = this.value.boardId;
      // const { data } = await deleteBoard(boardId);
      this.$swal({
        icon: 'success',
        title: '삭제성공!!',
        showConfirmButton: false,
        timer: 1500,
      });
      this.$router.push('/board');
    },
    updatePage(value) {
      var boardId = value.boardId;
      this.$router.push({ name: 'BoardUpdate', query: { boardId: boardId } });
    },
  },
};
</script>

<style scoped>
.div-hr {
  width: 80%;
}

.board {
  font-family: 'S-CoreDream-6Bold';
}

.styled-table {
  border-collapse: collapse;
  margin: 10% 0;
  font-size: 0.9em;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table th {
  background-color: #000;
  color: #ffffff;
  width: 10rem;
  text-align: center;
}
.styled-table th,
.styled-table td {
  padding: 12px 15px;
}
</style>

<template>
  <div>
    <v-container>
      <v-card>
        <v-card-title class="board-title">
          자유게시판
          <v-spacer></v-spacer>
          <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details></v-text-field>
        </v-card-title>
        <v-data-table :headers="headers" :items="values" :search="search" @click:row="detailPage" class="elevation-1"></v-data-table>
      </v-card>
      <div class="btn-right">
        <v-btn class="md-dense md-raised mt-3" style="background-color: rgb(21, 52, 80); color: white;" @click="writePage">글쓰기</v-btn>
      </div>
    </v-container>
  </div>
</template>

<script>
import { fetchBoardList } from '@/api/board';

export default {
  data() {
    return {
      values: [
        { title: '제목1', category: '예1', name: '김싸피', hit: '3', uploadDate: '2021-03-23', boardId: '1' },
        { title: '제목2', category: '예1', name: '김싸피', hit: '3', uploadDate: '2021-03-23', boardId: '2' },
      ],
      search: '',
      headers: [
        {
          text: '카테고리',
          align: 'start',
          value: 'category',
        },
        { text: '제목', value: 'title' },
        { text: '작성자', value: 'name' },
        { text: '업로드시간', value: 'uploadDate' },
      ],
    };
  },
  async mounted() {
    // const { data } = await fetchBoardList();
    // for (let i = 0; i < data.length; i++) {
    //   this.values.push({
    //     boardId: data[i].boardId,
    //     category: data[i].category,
    //     name: data[i].name,
    //     title: data[i].title,
    //     uploadDate: this.$moment(data[i].uploadDate).format('llll'),
    //   });
    // }
  },
  methods: {
    writePage() {
      this.$router.push('/boardWrite');
    },
    detailPage(value) {
      console.log(value);
      var query = value.boardId;
      this.$router.push({ name: 'BoardDetail', query: { boardId: query } });
    },
  },
};
</script>

<style scoped>
.board-title {
  margin-bottom: 1rem;
}
.btn-right {
  text-align: right;
}
</style>

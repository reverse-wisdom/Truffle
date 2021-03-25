<template>
  <div>
    <v-container>
      <div style="padding:80px">
        <h2 class="title text-center kor" style="font-weight:bold;">게시판 글쓰기</h2>
        <hr class="div-hr" />
        <form v-on:submit.prevent="writeContent">
          <v-text-field label="제목" v-model="title"></v-text-field>
          <v-select :items="items" label="글 종류" v-model="category"></v-select>
          <div id="summernote"></div>
        </form>

        <div class="btn-right">
          <v-btn color="#000" dark type="submit" @click="writeContent">
            등록
          </v-btn>
          <v-btn color="#000" class="ml-1" dark type="button" @click="moveList">
            뒤로가기
          </v-btn>
        </div>
      </div>
    </v-container>
  </div>
</template>

<script>
import { createBoard } from '@/api/board';

export default {
  data() {
    return {
      items: ['예1', '예2', '예3', '예4'],
      title: '',
      category: '',
    };
  },
  mounted() {
    $('#summernote').summernote({
      height: 300,
      minHeight: null,
      maxHeight: null,
      focus: true,
      tabsize: 2,
      toolbar: [
        ['style', ['style']],
        ['font', ['bold', 'underline', 'clear']],
        ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['table', ['table']],
        ['insert', ['link', 'picture', 'video']],
        ['view', ['fullscreen', 'codeview', 'help']],
      ],
    });
  },
  methods: {
    async writeContent() {
      const data = {
        title: this.title,
        content: $('#summernote').summernote('code'),
        category: this.category,
      };
      console.log(data);
      try {
        // const response = await createBoard(data);
        // console.log(response);

        this.$swal({
          icon: 'success',
          title: '글 작성 완료!!',
          showConfirmButton: false,
          timer: 1500,
        });
        this.moveList();
      } catch (err) {
        console.log(err);
      }
    },
    moveList() {
      this.$router.push('/board');
    },
  },
};
</script>

<style scoped>
.kor {
  font-family: 'Nanum Gothic', sans-serif;
  margin-bottom: 1rem;
}
.btn-right {
  text-align: right;
  margin-top: 2rem;
}
</style>

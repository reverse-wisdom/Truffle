<template>
  <div>
    <v-container>
      <div style="padding:80px">
        <h2 class="title text-center kor" style="font-weight:bold;">게시판 수정하기</h2>
        <hr class="div-hr" />
        <form v-on:submit.prevent="writeContent">
          <v-text-field label="제목" v-model="value.title"></v-text-field>
          <!-- 썸네일 -->
          <div class="formdata">
            <v-file-input
              id="thumbnail"
              name="thumbnail"
              v-model="image"
              show-size
              label="썸네일 이미지 (입력창을 클릭해주세요)"
              @change="Preview_image($event)"
              style="display:inline-block; cursor : pointer;"
            ></v-file-input>
            <v-img :src="url" id="preview"></v-img>
          </div>
          <v-select :items="items" label="글 종류" v-model="value.category"></v-select>
          <div id="summernote"></div>
        </form>

        <div class="btn-right">
          <v-btn color="rgb(68, 114, 148)" dark type="submit" @click="modifyBoard">
            수정
          </v-btn>
          <v-btn color="rgb(68, 114, 148)" class="ml-1" dark type="button" @click="moveBoard">
            뒤로가기
          </v-btn>
        </div>
      </div>
    </v-container>
  </div>
</template>

<script>
import { detailBoard, editBoard } from '@/api/board';

export default {
  data() {
    return {
      value: { title: '제목1', category: '예1', name: '김싸피', hit: '3', uploadDate: '2021-03-23', content: '공사중입니다.', boardId: '1' },
      items: ['예1', '예2', '예3', '예4'],
    };
  },
  created() {
    const postData = this.$route.query.boardId;
    console.log(postData);
    // const { data } = await detailBoard(postData);
    // this.value = data;
    var $vm = this;
    $(function() {
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
      // $('#summernote').summernote('pasteHTML', data.content);
      $('#summernote').summernote('pasteHTML', $vm.value.content);
    });
  },
  methods: {
    moveBoard() {
      this.$router.push({ name: 'Board' });
    },
    async modifyBoard() {
      const editData = {
        boardId: this.value.boardId,
        category: this.value.category,
        content: $('#summernote').summernote('code'),
        title: this.value.title,
        // name: this.value.name,
        // uuid: this.value.uuid,
      };
      console.log(editData);

      // const { data } = await editBoard(editData);
      // console.log(data)

      this.$swal({
        icon: 'success',
        title: '글 수정 완료',
      });
      var query = this.value.boardId;
      this.$router.push({ name: 'BoardDetail', query: { boardId: query } });
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

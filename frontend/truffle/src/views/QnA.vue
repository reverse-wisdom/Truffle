<template>
  <div>
    <v-container class="qna">
      <v-card>
        <v-card-title class="board-title">
          질문과 답변
          <v-spacer></v-spacer>
          <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details></v-text-field>
        </v-card-title>
        <v-data-table :headers="headers" :items="values" :search="search" @click:row="detailPage" class="elevation-1"></v-data-table>
      </v-card>
      <div class="btn-right">
        <v-btn class="md-dense md-raised mt-3" style="background-color: #381dfc; color: white; font-weight: 1200;" @click="writePage">글쓰기</v-btn>
      </div>
    </v-container>
  </div>
</template>

<script>
export default {
  writePage() {
    // this.$router.push('/qnaWrite')
  },
};
</script>

<style scoped>
.qna {
  width: 80%;
}
</style>

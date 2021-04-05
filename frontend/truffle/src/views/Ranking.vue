<template>
  <div style="height: 0.0rem">
    <div class="text-center" style=" display:inline-flex;">
      <v-carousel style="display:inline-block;" hide-delimiters cycle interval="3000" class="rank_outter" vertical height="100px" :prev-icon="false" :next-icon="false">
        <v-carousel-item class="rank" v-for="item in items" :key="item.hit">
          <v-card class="text-center" color="rgba(255, 255, 255, 0.1)" style="padding: 10px 0" width="200px">
            <a @click="moveSearch(item.word)" class="rank">
              <span class="rank-word">{{ item.hit }}위.{{ item.word }}</span>
            </a>
            &nbsp;
          </v-card>
        </v-carousel-item>
      </v-carousel>

      <div v-if="loadCheck">
        <!-- <v-carousel hide-delimiters cycle interval="3000" class="rank_outter" vertical height="200px" :prev-icon="false" :next-icon="false"> -->
      </div>
      <div v-else class="md-layout-item md-size-10 mx-auto">
        <br />
        <br />
        <br />
        <!-- <circle8></circle8> -->
      </div>
    </div>
  </div>
</template>

<script>
import { searchRank } from '@/api/event';
// import { Circle8 } from 'vue-loading-spinner'; // npm 스피너 컴포넌트
// import { Modal } from '@/components';
export default {
  // components: { Circle8, Modal },
  data() {
    return {
      items: [],
      loadCheck: false,
    };
  },
  async created() {
    this.loadCheck = false;
    const { data } = await searchRank();
    console.log(data);
    // 랭킹 7등까지만
    for (let i = 0; i < 3; i++) {
      this.items.push({
        hit: i + 1,
        word: data[i].word,
      });
    }
    this.loadCheck = true;
    console.log(this.items, 'items');
  },
  methods: {
    moveSearch(query) {
      this.$router.push({ name: 'search', query: { searchWord: query } });
    },
  },
};
</script>

<style scoped>
@font-face {
  font-family: 'KOTRA_BOLD-Bold';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10-21@1.1/KOTRA_BOLD-Bold.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
.rank {
  text-decoration: none;
  transition: all 0.2s ease-in-out;
  text-decoration: none;
  color: #000 !important;
  font-size: 1.3rem;
  font-family: 'paybooc-Bold';
  padding-top: 10px;
  display: 'inline-block';
  font-family: 'Nanum Gothic', sans-serif;
}
.rank-title {
  font-size: 1.7rem;
  color: #000;
  font-weight: bold;
  font-family: 'Nanum Gothic', sans-serif;
  margin-bottom: 20px;
}
.rank_outter {
  padding-bottom: 100px;
}
a {
  font-size: 0.2rem;
}
.rank-word {
  font-weight: 1000;
  font-family: 'KOTRA_BOLD-Bold';
}
</style>

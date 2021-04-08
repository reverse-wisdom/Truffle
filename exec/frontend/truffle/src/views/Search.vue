<template>
  <div class="container">
    <v-row>
      <v-img :src="url" max-height="300" max-width="1800"></v-img>
    </v-row>
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="10">
        <hr />
      </v-col>
    </v-row>
    <br />
    <h2>카테고리</h2>

    <div class="vtabs">
      <input type="radio" name="vtab" id="tab1" checked="checked" />
      <label for="tab1">검색결과</label>
      <input type="radio" name="vtab" id="tab2" />
      <label for="tab2">의류</label>
      <input type="radio" name="vtab" id="tab3" />
      <label for="tab3">뷰티</label>
      <input type="radio" name="vtab" id="tab4" />
      <label for="tab4">잡화</label>
      <input type="radio" name="vtab" id="tab5" />
      <label for="tab5">신발</label>
      <input type="radio" name="vtab" id="tab6" />
      <label for="tab6">디지털</label>
      <input type="radio" name="vtab" id="tab7" />
      <label for="tab7">취미/문화</label>
      <input type="radio" name="vtab" id="tab8" />
      <label for="tab8">기타</label>

      <div class="vtab-content">
        <div id="content1">
          <h1 class="profile">'{{ this.$route.query.product }}'으로 검색한 결과</h1>
          <div class="wrap">
            <SearchOne v-for="(event, idx) in productEvent" :key="idx" :refs="productEvent" :event="event"></SearchOne>
          </div>
        </div>
        <div id="content2">
          <Wear></Wear>
        </div>
        <div id="content3">
          <Beauty></Beauty>
        </div>
        <div id="content4">
          <Goods></Goods>
        </div>
        <div id="content5">
          <Shoes></Shoes>
        </div>
        <div id="content6">
          <Digital></Digital>
        </div>
        <div id="content7">
          <Hobby></Hobby>
        </div>
        <div id="content8">
          <Etc></Etc>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { eventSelectProduct } from '@/api/event';
import SearchOne from '@/views/SearchOne';
import Wear from '@/views/select/category/Wear';
import Beauty from '@/views/select/category/Beauty';
import Goods from '@/views/select/category/Goods';
import Shoes from '@/views/select/category/Shoes';
import Digital from '@/views/select/category/Digital';
import Hobby from '@/views/select/category/Hobby';
import Etc from '@/views/select/category/Etc';
export default {
  components: {
    SearchOne,
    Wear,
    Beauty,
    Goods,
    Shoes,
    Digital,
    Hobby,
    Etc,
  },
  data() {
    return {
      productEvent: [],
      url: require('@/assets/img/event.png'),
    };
  },
  async created() {
    const product = this.$route.query.product;
    const { data } = await eventSelectProduct(product);
    this.productEvent = data;
    // console.log(this.productEvent);
  },
  methods: {},
};
</script>

<style scoped>
.profile {
  text-align: center;
}
.container {
  margin-top: 8rem;
  font-family: 'Open Sans', sans-serif;
  color: #404040;
}
.wrap {
  display: flex;
  flex-wrap: wrap;
}
p {
  line-height: 1.5;
}
.vtabs {
  width: 100%;
  /* padding: 20px; */
  margin: 10px 0 0 0;
  position: relative;
}
.vtabs input {
  display: none;
}
.vtabs label {
  display: block;
  width: 20%;
  padding: 15px;
  color: #a2a2a2;
  font-weight: 700;
  font-size: 15px;
  border-radius: 5px solid #dcdcdc;
  transition: 0.3s ease;
}
.vtabs label:hover {
  cursor: pointer;
  color: #404040;
}
.vtabs input:checked + label {
  color: #404040;
  border-left: 5px solid #f3118e;
}
.vtabs #tab1:checked ~ .vtab-content #content1,
.vtabs #tab2:checked ~ .vtab-content #content2,
.vtabs #tab3:checked ~ .vtab-content #content3,
.vtabs #tab4:checked ~ .vtab-content #content4,
.vtabs #tab5:checked ~ .vtab-content #content5,
.vtabs #tab6:checked ~ .vtab-content #content6,
.vtabs #tab7:checked ~ .vtab-content #content7,
.vtabs #tab8:checked ~ .vtab-content #content8 {
  display: block;
}
.vtabs .vtab-content {
  position: absolute;
  top: 0%;
  max-width: 100%;
  left: 20%;
}
.vtabs .vtab-content #content1,
.vtabs .vtab-content #content2,
.vtabs .vtab-content #content3,
.vtabs .vtab-content #content4,
.vtabs .vtab-content #content5,
.vtabs .vtab-content #content6,
.vtabs .vtab-content #content7,
.vtabs .vtab-content #content8 {
  display: none;
}
.vtabs img {
  max-width: 550px;
  width: 100%;
  border-radius: 15px;
}
/* #content2 {
  display: flex;
} */
</style>

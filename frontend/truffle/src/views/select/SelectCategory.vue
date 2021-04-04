<template>
  <div class="category">
    <div class="tabs">
      <input id="ct1" type="radio" value="의류" v-model="category" @change="selectCategory" checked />
      <!--디폴트 메뉴-->
      <label for="ct1">의류</label>

      <input id="ct2" v-model="category" type="radio" @change="selectCategory" value="뷰티" />
      <label for="ct2">뷰티</label>

      <input id="ct3" v-model="category" type="radio" @change="selectCategory" value="잡화" />
      <label for="ct3">잡화</label>

      <input id="ct4" v-model="category" type="radio" value="신발" @change="selectCategory" />
      <label for="ct4">신발</label>

      <input id="ct5" v-model="category" type="radio" value="식품" @change="selectCategory" />
      <label for="ct5">식품</label>

      <input id="ct6" v-model="category" type="radio" value="디지털" @change="selectCategory" />
      <label for="ct6">디지털</label>

      <input id="ct6" v-model="category" type="radio" value="취미/문화" @change="selectCategory" />
      <label for="ct6">취미/문화</label>

      <input id="ct7" v-model="category" type="radio" value="기타" @change="selectCategory" />
      <label for="ct7">기타</label>

      <section id="content1">
        <div v-for="(object, index) in CategoryArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>

      <section id="content2">
        <div v-for="(object, index) in CategoryArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>

      <section id="content3">
        <div v-for="(object, index) in CategoryArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>

      <section id="content4">
        <div v-for="(object, index) in CategoryArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>
      <section id="content5">
        <div v-for="(object, index) in CategoryArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>
      <section id="content6">
        <div v-for="(object, index) in CategoryArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>
      <section id="content7">
        <div v-for="(object, index) in CategoryArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import { eventSelectCategory } from '@/api/event';
export default {
  data() {
    return {
      category: '',
      CategoryArray: [],
    };
  },
  methods: {
    async selectCategory() {
      const category = this.category;
      console.log('카테고리확인', category, '대');
      const { data } = await eventSelectCategory(category);
      console.log('응답데이터', data);
      this.CategoryArray = data;
      this.CategoryArray.sort(function(a, b) {
        if (a.join_num > b.join_num) {
          return 1;
        }
        if (a.join_num < b.join_num) {
          return -1;
        }
        return 0;
      });
      this.CategoryArray.reverse();
      console.log(this.CategoryArray);
      console.log('추출배열', this.CategoryArray);
    },
  },
};
</script>

<style scoped>
.category {
  /* color: #555; */
  /* background: #eeeeee; */
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

h1 {
  padding: 50px 0;
  font-weight: 400;
  text-align: center;
}

p {
  margin: 0 0 20px;
  line-height: 1.5;
}

.tabs {
  min-width: 320px;
  max-width: 1200px;
  padding: 50px;
  margin: 0 auto;
  background: #ffffff;
}

section {
  display: none;
  padding: 20px 0 0;
  border-top: 1px solid #ddd;
}

/*라디오버튼 숨김*/
input {
  display: none;
}

label {
  display: inline-block;
  margin: 0 0 -1px;
  padding: 15px 25px;
  font-weight: 600;
  text-align: center;
  color: #bbb;
  border: 1px solid transparent;
}

label:hover {
  color: #2e9cdf;
  cursor: pointer;
}

/*input 클릭시, label 스타일*/
input:checked + label {
  color: #555;
  border: 1px solid #ddd;
  border-top: 2px solid #2e9cdf;
  border-bottom: 1px solid #ffffff;
}

#ct1:checked ~ #content1,
#ct2:checked ~ #content2,
#ct3:checked ~ #content3,
#ct4:checked ~ #content4,
#ct5:checked ~ #content5,
#ct6:checked ~ #content6,
#ct7:checked ~ #content7 {
  display: block;
}
</style>

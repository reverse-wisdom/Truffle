<template>
  <div class="age">
    <div class="tabs">
      <input id="tab1" type="radio" name="tabs" value="10" v-model="age" @change="selectAge" checked />
      <!--디폴트 메뉴-->
      <label for="tab1">10대</label>

      <input id="tab2" v-model="age" type="radio" @change="selectAge" value="20" name="tabs" />
      <label for="tab2">20대</label>

      <input id="tab3" v-model="age" type="radio" @change="selectAge" value="30" name="tabs" />
      <label for="tab3">30대</label>

      <input id="tab4" v-model="age" type="radio" value="40" @change="selectAge" name="tabs" />
      <label for="tab4">40대</label>

      <input id="tab5" v-model="age" type="radio" value="50" @change="selectAge" name="tabs" />
      <label for="tab5">50대</label>

      <input id="tab6" v-model="age" type="radio" value="60" @change="selectAge" name="tabs" />
      <label for="tab6">60대이상</label>

      <section id="content1">
        <div v-for="(ages, index) in AgeArray" :key="index">
          {{ ages.join_num }}
        </div>
      </section>

      <section id="content2">
        <div v-for="(ages, index) in AgeArray" :key="index">
          {{ ages.join_num }}
        </div>
      </section>

      <section id="content3">
        <div v-for="(ages, index) in AgeArray" :key="index">
          {{ ages.join_num }}
        </div>
      </section>

      <section id="content4">
        <div v-for="(ages, index) in AgeArray" :key="index">
          {{ ages.join_num }}
        </div>
      </section>
      <section id="content5">
        <div v-for="(ages, index) in AgeArray" :key="index">
          {{ ages.join_num }}
        </div>
      </section>
      <section id="content6">
        <div v-for="(ages, index) in AgeArray" :key="index">
          {{ ages.join_num }}
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import { eventSelectAge } from '@/api/event';
export default {
  data() {
    return {
      age: '',
      AgeArray: [],
    };
  },
  methods: {
    async selectAge() {
      const age = this.age;
      console.log('나이확인', age, '대');
      const { data } = await eventSelectAge(age);
      console.log('응답데이터', data);
      this.AgeArray = data;
      this.AgeArray.sort(function(a, b) {
        if (a.join_num > b.join_num) {
          return 1;
        }
        if (a.join_num < b.join_num) {
          return -1;
        }
        return 0;
      });
      this.AgeArray.reverse();
      console.log(this.AgeArray);
      console.log('추출배열', this.AgeArray);
    },
  },
};
</script>

<style scoped>
.age {
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
  max-width: 800px;
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

#tab1:checked ~ #content1,
#tab2:checked ~ #content2,
#tab3:checked ~ #content3,
#tab4:checked ~ #content4,
#tab5:checked ~ #content5,
#tab6:checked ~ #content6 {
  display: block;
}
</style>

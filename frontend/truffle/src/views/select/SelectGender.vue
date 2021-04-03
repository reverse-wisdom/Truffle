<template>
  <div class="gender">
    <div class="tabs">
      <input id="gd1" type="radio" value="1" v-model="gender" @change="selectGender" checked />
      <!--디폴트 메뉴-->
      <label for="gd1">남성에게 인기많은</label>

      <input id="gd2" v-model="gender" type="radio" @change="selectGender" value="2" />
      <label for="gd2">여성에게 인기많은</label>

      <section id="content1">
        <div v-for="(object, index) in GenderArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>

      <section id="content2">
        <div v-for="(object, index) in GenderArray" :key="index">
          {{ object.join_num }}
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import { eventSelectGender } from '@/api/event';
export default {
  data() {
    return {
      gender: '',
      GenderArray: [],
    };
  },
  methods: {
    async selectGender() {
      const gender = this.gender;
      console.log('성별확인', gender);
      const { data } = await eventSelectGender(gender);
      console.log('응답데이터', data);
      this.GenderArray = data;
      this.GenderArray.sort(function(a, b) {
        if (a.join_num > b.join_num) {
          return 1;
        }
        if (a.join_num < b.join_num) {
          return -1;
        }
        return 0;
      });
      this.GenderArray.reverse();
      console.log(this.GenderArray);
      console.log('추출배열', this.GenderArray);
    },
  },
};
</script>

<style scoped>
.gender {
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

#gd1:checked ~ #content1,
#gd2:checked ~ #content2 {
  display: block;
}
</style>

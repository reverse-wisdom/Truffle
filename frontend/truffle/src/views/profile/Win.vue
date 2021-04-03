<template>
  <p>당첨된 이벤트: {{ value }}</p>
</template>

<script>
import { userWinEvent } from '@/api/auth';
export default {
  name: 'Win',
  data() {
    return {
      value: '',
    };
  },
  async created() {
    const { data } = await userWinEvent(this.$store.state.email);
    console.log('당첨된 이벤트', data);
    this.value = data;
  },
};
</script>

<style scoped></style>

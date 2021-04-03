<template>
  <p>응모내역 : {{ value }}</p>
</template>

<script>
import { userJoinEvent } from '@/api/auth';
export default {
  name: 'Event',
  data() {
    return {
      value: '',
    };
  },
  methods: {},
  async created() {
    const { data } = await userJoinEvent(this.$store.state.email);
    console.log('응모내역', data);
    this.value = data;
  },
};
</script>

<style scoped></style>

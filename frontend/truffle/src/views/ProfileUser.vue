<template>
   <div class="container">
     <h1>프로필</h1>
    <v-tabs
      background-color="white"
      fixed-tabs
      >
      <v-tab @click="gotoBasic">기본정보</v-tab>
      <v-tab @click="gotoRagister">래플응모내역</v-tab>
      <v-tab @click="gotoEvent">찜한이벤트</v-tab>
      <v-tab @click="gotoReview">구매후기</v-tab>
      <v-tab @click="gotoOrder">주문내역조회</v-tab>
    </v-tabs>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'ProfileUser',
  methods: {
    gotoBasic() {
      if (this.$route.path !== "/profileuser") {
        this.$router.push({name:"Basic"})
      }
    },
    gotoEvent() {
      if (this.$route.path !== "/profileuser/event") {
        this.$router.push({name:"Event"})
      }
    },
    gotoReview() {
      if (this.$route.path !== "/profileuser/review") {
        this.$router.push({name:"Review"})
      }
    },
    gotoOrder() {
      if (this.$route.path !== "/profileuser/order") {
        this.$router.push({name:"Order"})
      }
    },
    gotoRagister() {
      if (this.$route.path !== "/profileuser/register") {
        this.$router.push({name:"Register"})
      }
    },
  },
}
</script>

<style>

</style>
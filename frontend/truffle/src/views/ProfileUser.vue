<template>
   <div class="container">
    <v-tabs
      background-color="white"
      fixed-tabs
      >
      <v-tab @click="gotoBasic">기본정보</v-tab>
      <!-- <v-tab @click="gotoRaffle">래플응모내역</v-tab> -->
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
    // gotoRaffle() {
    //   if (this.$route.path !== "/profileuser/raffle") {
    //     this.$router.push({name:"Reffle"})
    //   }
    // },
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
  },
}
</script>

<style>

</style>
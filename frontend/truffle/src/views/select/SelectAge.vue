<template>
  <div>
    <v-tabs>
      <v-tab href="#search">
        10대
      </v-tab>
      <v-tab-item key="search"></v-tab-item>
      <v-tab href="#rare">
        20대
      </v-tab>
      <v-tab-item key="rare">
        22222
      </v-tab-item>
      <v-tab href="#review">
        30대
      </v-tab>
      <v-tab-item key="review">
        33333
      </v-tab-item>
    </v-tabs>
  </div>
</template>

<script>
import Component1 from '@/views/select/Component1.vue';
export default {
  components: {
    Component1,
  },
};
</script>

<style></style>

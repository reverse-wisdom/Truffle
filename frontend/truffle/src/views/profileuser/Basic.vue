<template>
  <div>
    기본정보
  </div>
</template>

<script>
export default {
  name: 'Basic',
};
</script>

<style scoped>
.container {
  width: 1200px;
  height: 1000px;
  border: 2px dashed black;
  margin: 50px auto;
}

.card {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 700px;
  border: 2px dashed black;
  margin: 0 auto;
}

.card-nav {
  display: flex;
  justify-content: center;
  background-color: linen;
}

.card-header {
  padding: 18px;
}

.card-img {
  display: block;
  width: 100%;
  height: 330px;
}

.card-img-description {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: white;
  height: 70px;
  justify-content: center;
}

.card-body {
  padding: 18px;
}

.card-body-title {
  display: flex;
  align-items: center; /*글자먼저 정렬하고*/
  justify-content: space-between; /*이렇게 정렬하면 깔끔*/
}

.card-body-description {
  background-color: linen;
  margin-top: 10px;
  padding: 10px;
}

.card-footer {
  display: flex;
  justify-content: flex-end;
  background-color: green;
  color: white;
  padding: 10px;
}
</style>

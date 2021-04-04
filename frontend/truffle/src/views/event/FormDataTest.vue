<template>
  <div class="formdata">
    <v-file-input v-model="image" show-size label="File input" @change="Preview_image($event)" style="display:inline-block; cursor : pointer;"></v-file-input>
    <!-- <v-btn color="primary" style="display:inline-block;">Upload</v-btn> -->
    <v-img :src="url" id="preview"></v-img>
  </div>
</template>
<script>
import axios from 'axios';
export default {
  data() {
    return {
      url: null,
      image: null,
    };
  },

  methods: {
    Preview_image() {
      this.url = URL.createObjectURL(this.image);
    },
    // async upload() {
    //   var fd = new FormData();
    //   fd.append('files', this.files);
    //   await axios
    //     .post('http://localhost:1337/upload', fd, {
    //       headers: {
    //         'Content-Type': 'multipart/form-data',
    //       },
    //     })
    //     .then((response) => {
    //       console.log('SUCCESS!!');
    //       console.log(response.data);
    //     })
    //     .catch(function() {
    //       console.log('FAILURE!!');
    //     });
    // },
  },
};
</script>
<style scoped>
.formdata {
  margin-top: 20%;
}
#preview {
  max-height: 100px;
  max-width: 100px;
  display: inline-block;
  margin-left: 5%;
}
.v-file-input {
  width: 300px;
}
</style>

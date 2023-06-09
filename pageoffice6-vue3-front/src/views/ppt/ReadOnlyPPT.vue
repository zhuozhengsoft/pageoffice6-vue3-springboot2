<template>
  <div id="podiv" v-html="poHtmlCode" />
  
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "ReadOnlyPPT",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/ppt/ReadOnlyPPT/ppt")
      .then((response) => {
        this.poHtmlCode = response.data;
      })
      .catch(function (err) {
        console.log(err);
      });
  }
}
</script>
<style scoped>
#podiv {
    position: absolute;
    width: 100%;
    height: 100%;
}
</style>



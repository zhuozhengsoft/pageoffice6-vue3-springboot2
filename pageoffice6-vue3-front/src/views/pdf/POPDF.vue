<template>
  <div id="podiv" v-html="poHtmlCode" />
  
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "POPDF",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/pdf/POPDF/pdf")
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



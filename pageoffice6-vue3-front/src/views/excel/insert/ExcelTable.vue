<template>
  <div id="podiv" v-html="poHtmlCode" />
  
</template>
<script>
import axios from 'axios';

export default {
  name: "Excel",
  data() {
    return {
      message: "ExcelTable",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/excel/ExcelTable/excel")
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



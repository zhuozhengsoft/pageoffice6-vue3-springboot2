<template>
<font style="color:red">POBrowser.openWindow的第二个参数left，top即可控制POBrowser窗口的位置，使用width，height参数即可控制POBrowser窗口的高宽。单位是像素：px</font>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "POBrowserPosition",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/POBrowserPosition/word")
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



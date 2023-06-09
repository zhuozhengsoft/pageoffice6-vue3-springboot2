<template>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "HideOfficeToolbar",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/HideOfficeToolbar/word")
      .then((response) => {
        this.poHtmlCode = response.data;
      })
      .catch(function (err) {
        console.log(err);
      });
  },
  methods:{
    // PageOffice事件回调函数
    OnPageOfficeCtrlInit() {
      pageofficectrl.OfficeToolbars = false; //隐藏Office工具栏
    }
  },
  mounted: function () {
    // 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
    window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
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



<template>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "CustomToolButton",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/pdf/CustomToolButtonPDF/pdf")
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
      pageofficectrl.AddCustomToolButton("测试按钮", "myTest()", 0);
    },
    myTest() {
      alert("测试按钮被点击了");
    }
  },
  mounted: function () {
    window.myTest = this.myTest;

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



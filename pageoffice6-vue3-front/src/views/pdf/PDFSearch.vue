<template>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "PDFSearch",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/pdf/PDFSearch/pdf")
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
      pageofficectrl.addCustomToolButton("搜索", "SearchText()", 0);
      pageofficectrl.addCustomToolButton("搜索下一个", "SearchTextNext()", 0);
      pageofficectrl.addCustomToolButton("搜索上一个", "SearchTextPrev()", 0);
    },
    SearchText() {
      pageofficectrl.SearchText();
    },

    SearchTextNext() {
      pageofficectrl.SearchTextNext();
    },

    SearchTextPrev() {
      pageofficectrl.SearchTextPrev();
    }
  },
  mounted: function () {
    window.SearchText = this.SearchText;
    window.SearchTextNext = this.SearchTextNext;
    window.SearchTextPrev = this.SearchTextPrev;
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



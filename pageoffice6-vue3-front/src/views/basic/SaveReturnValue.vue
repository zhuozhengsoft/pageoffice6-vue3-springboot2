<template>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "SaveReturnValue",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/SaveReturnValue/word")
      .then((response) => {
        this.poHtmlCode = response.data;
      })
      .catch(function (err) {
        console.log(err);
      });
  },
  methods:{
    // 控件中的一些常用方法都在这里调用，比如保存，打印等等
    Save() {
      pageofficectrl.WebSave();
    },
    // PageOffice事件回调函数
    OnPageOfficeCtrlInit() {
      pageofficectrl.AddCustomToolButton("保存", "Save()", 1);
    },
    AfterDocumentSaved(){
      let result=pageofficectrl.CustomSaveResult;
      alert("保存结果为："+result);
    }
  },
  mounted: function () {
    window.Save = this.Save;
    // 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
    window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
    window.AfterDocumentSaved = this.AfterDocumentSaved;
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



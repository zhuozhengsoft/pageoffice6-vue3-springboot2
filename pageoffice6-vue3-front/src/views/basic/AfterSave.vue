<template>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "AfterSave",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/AfterSave/word")
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
    AfterDocumentSaved(){ 
      // TO-DO  保存文件后要调用的代码
      // 例如，在此可以获取到保存的结果：pageofficectrl.CustomSaveResult
      alert('文档保存后事件已执行。');
    },
    OnPageOfficeCtrlInit() {
      // PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
      // 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
      pageofficectrl.AddCustomToolButton("保存", "Save()", 1); 
    }
  },
  mounted: function () {
    window.Save = this.Save;
    window.AfterDocumentSaved = this.AfterDocumentSaved;
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



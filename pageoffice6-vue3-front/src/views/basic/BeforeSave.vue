<template>
演示: 文档保存前触发的事件BeforeDocumentSaved()。点击保存按钮后，请仔细观察下面文本框中提示消息的变化。<br>
  <input id="input"  :value="message"/>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/BeforeSave/word")
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
    BeforeDocumentSaved() {
      // TO-DO  保存前需要执行的逻辑
       this.message="文件要开始保存了...."
    },
    OnPageOfficeCtrlInit() {
      // PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
      // 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
      pageofficectrl.AddCustomToolButton("保存", "Save()", 1); 
    }
  },
  mounted: function () {
    window.Save = this.Save;
    window.BeforeDocumentSaved = this.BeforeDocumentSaved;
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



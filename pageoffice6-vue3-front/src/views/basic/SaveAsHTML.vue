<template>
    <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "SaveAsHTML",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/SaveAsHTML/word")
      .then((response) => {
        this.poHtmlCode = response.data;
      })
      .catch(function (err) {
        console.log(err);
      });
  },
  methods:{
    // 控件中的一些常用方法都在这里调用，比如保存，打印等等
    saveAsHTML() {
      pageofficectrl.WebSaveAsHTML(); //另存当前文件为Html格式 
     alert("HTML格式的文件已经保存到后端doc/basic/SaveAsHTML目录下");
      
    },
    // PageOffice事件回调函数
    OnPageOfficeCtrlInit() {
      // PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
      // 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
      pageofficectrl.AddCustomToolButton("另存为HTML", "saveAsHTML()", 1);
    },
  },
  mounted: function () {
    // 将methods中的方法通过mounted挂载到window对象上
    window.saveAsHTML = this.saveAsHTML;

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



<template>
    <div id="podiv" v-html="poHtmlCode" />
  </template>
  <script>
  import axios from 'axios';
  
  export default {
    name: "Word",
    data() {
      return {
        message: "SimpleWord",
        poHtmlCode: "",
      };
    },
    created: function () {
      axios
        .post("/api/word/RevisionOnly/Word")
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
          // 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
          
          pageofficectrl.AddCustomToolButton("保存", "Save()",1); 
          pageofficectrl.AddCustomToolButton("隐藏痕迹", "hideRevision()", 18);
          pageofficectrl.AddCustomToolButton("显示痕迹", "showRevision()", 9);
      },
      
      // 控件中的一些常用方法都在这里调用，比如保存，打印等等
        Save() {
          pageofficectrl.WebSave();
        },

        showRevision() {
        pageofficectrl.ShowRevisions = true;
        },
    
        hideRevision() {
          pageofficectrl.ShowRevisions = false;
        }
    },
    mounted: function () {
        // 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
        window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
        
        // 将methods中的方法通过mounted挂载到window对象上
        window.Save = this.Save;
        window.showRevision = this.showRevision;
        window.hideRevision = this.hideRevision;
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
  
  
  
<template>
 <div id="podiv" v-html="poHtmlCode" />
</template>

<script>
  import axios from 'axios';
  export default{
    name: 'Word',
    data() {
      return {
        message: "ReadOnly2",
        poHtmlCode: "",
      };
    },
    created: function () {
      axios
        .post("/api/word/ReadOnly2/Word")
        .then((response) => {
          this.poHtmlCode = response.data;
        })
        .catch(function (err) {
          console.log(err);
        });
    },
    methods:{
      //控件中的一些常用方法都在这里调用，比如保存，打印等等
      AfterDocumentOpened() {
        // pageofficectrl.SetEnableFileCommand(4, false); //禁止另存
        // pageofficectrl.SetEnableFileCommand(5, false); //禁止打印
        // pageofficectrl.SetEnableFileCommand(6, false); //禁止页面设置
        // pageofficectrl.SetEnableFileCommand(8, false); //禁止打印预览
      }
    },
    mounted: function(){
      // 将vue中的方法赋值给window
	  window.AfterDocumentOpened = this.AfterDocumentOpened;
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
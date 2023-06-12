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
       // PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
      OnPageOfficeCtrlInit() {
        pageofficectrl.CustomToolbar=false;//隐藏自定义工具栏    
        pageofficectrl.OfficeToolbars=false;//隐藏Office工具栏
        //修改PageOffice控件标题栏文本内容      
        pageofficectrl.Caption="演示：文件在线安全浏览";
       }
     
    },
    mounted: function(){
      // 将vue中的方法赋值给window
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
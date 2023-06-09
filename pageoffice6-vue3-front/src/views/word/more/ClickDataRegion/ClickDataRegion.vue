<template>
<div class="Word">
  <div style="width:auto; height:700px;" v-html="poHtmlCode" >
  </div>
</div>
</template>

<script>
  import axios from 'axios';
  export default{
    name: 'Word',
    data(){
      return {
        message: ' ',
        poHtmlCode: '',

      }
    },
    created: function(){
      //由于vue中的axios拦截器给请求加token都得是ajax请求，所以这里必须是axios方式去请求后台打开文件的controller
      axios.post("/api/word/ClickDataRegion/Word").then((response) => {
        this.poHtmlCode = response.data;

      }).catch(function (err) {
        console.log(err)
      })
    },
    methods:{
      // PageOffice事件回调函数
			OnPageOfficeCtrlInit() {
				// PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
				// 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
				pageofficectrl.AddCustomToolButton("保存", "Save()", 1); 
      },
      //控件中的一些常用方法都在这里调用，比如保存，打印等等
      Save() {
        pageofficectrl.WebSave();
      },
      OnWordDataRegionClick(Name, Value, Left, Bottom) {
        if (Name == "PO_deptName") {
          var strRet = pageofficectrl.ShowHtmlModalDialog("ClickDataRegionDlg", Value, "left=" + Left + "px;top=" + Bottom + "px;width=400px;height=300px;");
          if (strRet != "") {
            // return (strRet);
            alert(strRet);
            //插入图片
            
          }
          else {
            if ((Value == undefined) || (Value == ""))
              return " ";
            else
              return Value;
          }
        }
      }
    },
    mounted: function(){
      // 将vue中的方法赋值给window
      window.Save = this.Save;
      window.OnWordDataRegionClick = this.OnWordDataRegionClick;
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
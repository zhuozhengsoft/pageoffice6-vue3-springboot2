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
      .post("/api/basic/SimpleWord/word")
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
    SaveAs() {
      pageofficectrl.ShowDialog(2);
    },
    IsFullScreen() {
      pageofficectrl.FullScreen = !pageofficectrl.FullScreen;
    },
    PrintFile() {
      pageofficectrl.ShowDialog(4);
    },
    Close() {
      window.external.close();
    },
    // PageOffice事件回调函数
    OnPageOfficeCtrlInit() {
      // PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
      // 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
      pageofficectrl.AddCustomToolButton("保存", "Save()", 1); 
      pageofficectrl.AddCustomToolButton("另存为", "SaveAs()", 11);
      pageofficectrl.AddCustomToolButton("打印", "PrintFile()", 6);
      pageofficectrl.AddCustomToolButton("全屏", "IsFullScreen()", 4);
      pageofficectrl.AddCustomToolButton("关闭", "Close()", 21);
    }
  },
  mounted: function () {
    // 将methods中的方法通过mounted挂载到window对象上
    window.Save = this.Save;
    window.SaveAs = this.SaveAs;
    window.PrintFile = this.PrintFile;
    window.IsFullScreen = this.IsFullScreen;
    window.Close = this.Close;

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




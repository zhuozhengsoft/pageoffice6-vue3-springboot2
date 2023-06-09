<template>
  <input type="text" id="userName"  value="zhangsan"/><br>
   <span style="color:red">保存页面获取form域结果及代码请查看当前示例的服务器端保存方法及控制台输出信息。</span>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "SendParameters2",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/SendParameters2/word")
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
    }
  },
  mounted: function () {
    window.Save = this.Save;
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



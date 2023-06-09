<template>
  PageOffice给保存方法传递参数的方式有两种：<br />

  1.通过设置保存地址的url中的?传递参数。例如：<br />

  poCtrl.setSaveFilePage("/save?p1=1");<br />

  2.通过input隐藏域给保存方法传递参数。例如：<br />
  <span v-text="hideinput"></span><br>
  <span style="color:red">保存页面获取参数的结果及代码请查看当前示例的服务器端保存方法及控制台输出信息。</span>

  <div id="podiv" v-html="poHtmlCode" />

  <input type="hidden" id="p2" value="2" />
</template>
<script>
import axios from "axios";

export default {
  name: "Word",
  data() {
    return {
      message: "SendParameters",
      poHtmlCode: "",
      hideinput: '<input type="hidden"  id="p2"  value="2"/>',
    };
  },
  created: function () {
    axios
      .post("/api/basic/SendParameters/word")
      .then((response) => {
        this.poHtmlCode = response.data;
      })
      .catch(function (err) {
        console.log(err);
      });
  },
  methods: {
    // 控件中的一些常用方法都在这里调用，比如保存，打印等等
    Save() {
      pageofficectrl.WebSave();
    },
    // PageOffice事件回调函数
    OnPageOfficeCtrlInit() {
      pageofficectrl.AddCustomToolButton("保存", "Save()", 1);
    },
  },
  mounted: function () {
    window.Save = this.Save;
    // 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
    window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
  },
};
</script>
<style scoped>
#podiv {
    position: absolute;
    width: 100%;
    height: 100%;
}
</style>



<template>
   <p style="color: brown;">以新建空白Word为例：新建的文件保存在后端项目static/doc/word/CreateBlankFile目录下</p>
  文档名称：<input id="fileName" type="text" @focus="getFocus()" @blur="lostFocus()" class="boder" style="width: 180px;" v-model="message"/>
  <input type="button" value="保存并关闭" @click="Save()"/>
  <div id="podiv" v-html="poHtmlCode" />
  
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "新建的文件",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/word/CreateBlankFile/Word")
      .then((response) => {
        this.poHtmlCode = response.data;
      })
      .catch(function (err) {
        console.log(err);
      });
  },
  methods:{
    getFocus() {
      let str = document.getElementById("fileName").value;
      if (str == "请输入文档名称") {
          document.getElementById("fileName").value = "";
      }
    },
    lostFocus() {
        let str = document.getElementById("fileName").value;
        if (str.length <= 0||str.split(" ").join("").length == 0) {
            document.getElementById("fileName").value = "请输入文档名称";
        }
    },
    // 控件中的一些常用方法都在这里调用，比如保存，打印等等
    Save() {
      pageofficectrl.WebSave();
      window.external.close();
    }
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



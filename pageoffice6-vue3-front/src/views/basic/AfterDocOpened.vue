<template>
  <div id="podiv" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "AfterDocOpened",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/AfterDocOpened/word")
      .then((response) => {
        this.poHtmlCode = response.data;
      })
      .catch(function (err) {
        console.log(err);
      });
  },
  methods:{
    // PageOffice事件回调函数
    AfterDocumentOpened() {
      // TO-DO  文档打开后需要执行的逻辑
      // pageofficectrl.ShowRevisions = false; // 隐藏痕迹。true为显示痕迹。    
      // pageofficectrl.word.DocumentMap = true; // 显示文档结构图
      // pageofficectrl.word.ZoomPercent = 75; // 设置文档缩放比例为百分之75
      // pageofficectrl.FullScreen = true; // 设置文档窗口全屏显示

      // 添加其他更多的实际使用代码

      alert('文档打开了。');
    }
  },
  mounted: function () {
    // 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
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



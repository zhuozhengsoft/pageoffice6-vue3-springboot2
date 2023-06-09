<template>
  <input type="button" value="设置父窗口Count的值加1" @click="increaseCount(1);"/>
  <input type="button" value="设置父窗口Count的值加5并关闭当前窗口" @click="increaseCountAndClose(5);"/>
  <div style="height:800px;width:auto;" v-html="poHtmlCode" />
</template>
<script>
import axios from 'axios';

export default {
  name: "Word",
  data() {
    return {
      message: "CallParentFunction",
      poHtmlCode: "",
    };
  },
  created: function () {
    axios
      .post("/api/basic/CallParentFunction/word")
      .then((response) => {
        this.poHtmlCode = response.data;
      })
      .catch(function (err) {
        console.log(err);
      });
  },
  methods:{
    increaseCount(value) {
      // 通过CallParentFunc回调父页面的updateCount函数
      let sResult = window.external.CallParentFunc("updateCount(" + value + ");");
      if (sResult == 'poerror:parentlost') {
        alert('父页面关闭或跳转刷新了，导致父页面函数没有调用成功！');
      }
    },
    increaseCountAndClose(value){
      // 通过CallParentFunc回调父页面的updateCount函数
      let sResult = window.external.CallParentFunc("updateCount(" + value + ");");
      window.external.close();//关闭POBrowser窗口
      if (sResult == 'poerror:parentlost') {
        alert('父页面关闭或跳转刷新了，导致父页面函数没有调用成功！');
      }
    }
  }
}
</script>




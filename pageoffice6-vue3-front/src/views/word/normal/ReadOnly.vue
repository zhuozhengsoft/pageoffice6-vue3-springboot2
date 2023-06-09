<template>
 <div id="podiv" v-html="poHtmlCode" />
</template>

<script>
  import axios from 'axios';
  export default{
    name: 'Word',
    data() {
      return {
        message: "ReadOnly",
        poHtmlCode: "",
      };
    },
    created: function () {
      axios
        .post("/api/word/ReadOnly/Word")
        .then((response) => {
          this.poHtmlCode = response.data;
        })
        .catch(function (err) {
          console.log(err);
        });
    },
    methods:{
      //控件中的一些常用方法都在这里调用，比如保存，打印等等
    },
    mounted: function(){
      // 将vue中的方法赋值给window
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
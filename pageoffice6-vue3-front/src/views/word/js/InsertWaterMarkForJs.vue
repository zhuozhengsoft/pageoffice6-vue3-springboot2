<template>
	  <div id="podiv" v-html="poHtmlCode" />
</template>

<script>
	import axios from 'axios';
	  export default{
	    name: 'Word',
	    data(){
	      return {
	        poHtmlCode: '',
	
	      }
	    },
	    created: function(){
	      //由于vue中的axios拦截器给请求加token都得是ajax请求，所以这里必须是axios方式去请求后台打开文件的controller
	      axios.post("/api/word/InsertWaterMarkForJs/Word").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
		  AfterDocumentOpened() {
			 pageofficectrl.word.SetWaterMark("水印文字");
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

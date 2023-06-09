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
	      axios.post("/api/word/DocumentMap/Word").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
			OnPageOfficeCtrlInit() {
				// PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
				// 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
				pageofficectrl.AddCustomToolButton("隐藏导航窗口", "HiddenDocumentMap()", 1); 
			},
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
		  HiddenDocumentMap() {
               pageofficectrl.word.DocumentMap = false ;//隐藏文档结构图； true：显示文档结构图。
		  }
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
			window.HiddenDocumentMap = this.HiddenDocumentMap;
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

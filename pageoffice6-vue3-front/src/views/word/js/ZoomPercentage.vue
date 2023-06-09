<template>
	<div class="Word">
		    <div style=" font-size:small; color:Red;">
		        <label>关键代码：看js函数：</label>
		        <label>设置视图缩放时，请先输入相应的缩放比例！</label><br/>
		        <label>缩放比例：</label><input id="ZoomPercentage" type="text" v-model="zoom"/>
		    </div>
		    <input id="Button1" type="button" @click="SetZoomPercent();" value="设置视图缩放"/>
	  <div style="height: 800px; width: auto" v-html="poHtmlCode" />
	</div>
</template>

<script>
	import axios from 'axios';
	  export default{
	    name: 'Word',
	    data(){
	      return {
	        poHtmlCode: '',
			zoom:'100'
	
	      }
	    },
	    created: function(){
	      //由于vue中的axios拦截器给请求加token都得是ajax请求，所以这里必须是axios方式去请求后台打开文件的controller
	      axios.post("/api/word/ZoomPercentage/Word").then((response) => {
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
				pageofficectrl.AddCustomToolButton("设置视图缩放", "SetZoomPercent()", 5); 
			},
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
		  SetZoomPercent() {			   
             pageofficectrl.word.ZoomPercent = this.zoom;
		  },
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
			window.SetZoomPercent = this.SetZoomPercent;
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

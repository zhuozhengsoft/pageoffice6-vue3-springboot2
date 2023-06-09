<template>
	<div class="Word">
		<div style=" font-size:small; color:Red;">
		    <label>关键代码：看js函数：</label>
		    <label>function locateBookMark()</label>
		    <br/>
		    <label>将光标定位到书签前，请先在文本框中输入要定位到的书签名称（可点击Office工具栏上的“插入”→“书签”，来查看当前Word文档中所有的书签名称）！</label><br/>
		    <label>书签名称：</label><input id="txtBkName" type="text"  v-model="bkname"  />
		</div>
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
			bkname:'PO_userName',
	
	      }
	    },
	    created: function(){
	      //由于vue中的axios拦截器给请求加token都得是ajax请求，所以这里必须是axios方式去请求后台打开文件的controller
	      axios.post("/api/word/WordLocateBKMK/Word").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
			OnPageOfficeCtrlInit() {
				// PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
				// 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
				pageofficectrl.AddCustomToolButton("定位光标到指定书签", "locateBookMark()", 5); 
			},
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
			  locateBookMark() {             
				 pageofficectrl.word.SelectBookmark(this.bkname);//定位光标到"PO_UserName"书签
			  }
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
			window.locateBookMark = this.locateBookMark;
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

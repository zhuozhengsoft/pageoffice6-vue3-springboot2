<template>
	<div class="Word">
		不弹出用户名、密码输入框盖章
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
	
	      }
	    },
	    created: function(){
	      //由于vue中的axios拦截器给请求加token都得是ajax请求，所以这里必须是axios方式去请求后台打开文件的controller
	      axios.post("/api/word/InsertSeal/AddSeal/Word2").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
		  //保存
		  Save() {
			  pageofficectrl.WebSave();
		  },
	  
		  //加盖印章
		  InsertSeal() {
			  try {
				  pageofficectrl.zoomseal.AddSeal("李志");
			  } catch (e) {
			  }
		  },
		  // PageOffice事件回调函数
		  OnPageOfficeCtrlInit() {
			// PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
			// 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
			pageofficectrl.AddCustomToolButton("保存", "Save()", 1); 
			pageofficectrl.AddCustomToolButton("加盖印章", "InsertSeal()", 2);
    	}
	    },
	    mounted: function(){
			// 将vue中的方法赋值给window
			window.Save = this.Save;
			window.InsertSeal = this.InsertSeal;
			// 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
			window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
  
	    }
	}
</script>


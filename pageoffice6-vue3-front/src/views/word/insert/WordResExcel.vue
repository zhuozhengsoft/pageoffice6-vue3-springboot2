<template>
	<div class="Word">
		<div style="font-size: 12px; line-height: 20px; border-bottom: dotted 1px #ccc; border-top: dotted 1px #ccc; padding: 5px;">
		    关键代码：
		    <span style="background-color: Yellow;"> <br/>DataRegion
						dataRegion = worddoc.openDataRegion("PO_开头的书签名称"); <br/>
						dataRegion.setValue("[excel]doc/1.xlsx[/excel]");</span>
		    <br/>
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
	
	      }
	    },
	    created: function(){
	      //由于vue中的axios拦截器给请求加token都得是ajax请求，所以这里必须是axios方式去请求后台打开文件的controller
	      axios.post("/api/word/WordResExcel/Word").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
	      OnPageOfficeCtrlInit() {
            pageofficectrl.CustomToolbar=false;//隐藏自定义工具栏    
            //修改PageOffice控件标题栏文本内容      
            pageofficectrl.Caption="演示：后台编程插入excel文件到数据区域(企业版)";
       }
	      
	    },
	    mounted: function(){
	       // 将vue中的方法赋值给window
           // 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
          window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
	      
	    }
	}
</script>


<template>
	<div class="Excel">
		<div>
			<div style="color:Red;">设置当工作表只读时，允许用户手动调整行列:sheet1.setAllowAdjustRC(true);</div>
		</div>
	  <div style="height: 800px; width: auto" v-html="poHtmlCode" />
	</div>
</template>

<script>
import axios from 'axios';
	  export default{
	    name: 'Excel',
	    data(){
	      return {
	        poHtmlCode: '',
	
	      }
	    },
	    created: function(){
	      //由于vue中的axios拦截器给请求加token都得是ajax请求，所以这里必须是axios方式去请求后台打开文件的controller
	      axios.post("/api/excel/ExcelAdjustRC/excel").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
	      
	    },
	    mounted: function(){
	      
	    }
	}
</script>


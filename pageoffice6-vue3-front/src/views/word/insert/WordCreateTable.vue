<template>
	<div class="Word">
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
	      axios.post("/api/word/WordCreateTable/Word").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
	      OnPageOfficeCtrlInit() {
             pageofficectrl.CustomToolbar=false;//隐藏自定义工具栏    
       }
	      
	    },
	    mounted: function(){
	    // 将vue中的方法赋值给window
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

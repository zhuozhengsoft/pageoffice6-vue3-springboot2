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
	      axios.post("/api/word/WordCompare/Word").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
			SaveDocument() {
				pageofficectrl.WebSave();
			},
			ShowFile1View() {
				pageofficectrl.word.ShowCompareView(1);
			},

			ShowFile2View() {
				pageofficectrl.word.ShowCompareView(2);
			},

			ShowCompareView() {
				pageofficectrl.word.ShowCompareView(0);
			},

			SetFullScreen() {
				pageofficectrl.FullScreen = !pageofficectrl.FullScreen;
			},
		OnPageOfficeCtrlInit() {
        // PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮    
		pageofficectrl.AddCustomToolButton("显示A文档", "ShowFile1View()", 0);
        pageofficectrl.AddCustomToolButton("显示B文档", "ShowFile2View()", 0);
        pageofficectrl.AddCustomToolButton("显示比较结果", "ShowCompareView()", 0);

    },
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
	      window.SaveDocument = this.SaveDocument;
		  window.ShowFile1View = this.ShowFile1View;
		  window.ShowFile2View = this.ShowFile2View;
		  window.ShowCompareView = this.ShowCompareView;
		  window.SetFullScreen = this.SetFullScreen;
		  window.OnPageOfficeCtrlInit=this.OnPageOfficeCtrlInit;
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

<template>
	<div class="Word">
		<div >
			<div class="flow4">
				<input type="button" @click="exit()" value="关闭窗口" />
				<strong>当前用户：</strong>
				<span style="color: Red;">{{user}}</span>
			</div>
			<div style="height: 800px; width: auto" v-html="poHtmlCode"/>
		</div>
		
	</div>
</template>

<script>
	import axios from 'axios';
	  export default{
	    name: 'Word',
	    data(){
	      return {
			poHtmlCode:'',
			user:'',
	      }
	    },
		created: function(){
			const url = new URL(window.location.href);
			const searchParams = new URLSearchParams(url.search);
			this.user  = searchParams.get('user');

			axios.post("/api/word/SameTimeEdit/Word?user="+this.user).then((response) => {
				this.poHtmlCode = response.data;
			  }).catch(function (err) {
				console.log(err)
			  })
		},
	    methods:{
			exit(){
				window.external.close();
			},
			Save() {
				pageofficectrl.WebSave();
			},
			
			//全屏/还原
			IsFullScreen() {
				pageofficectrl.FullScreen = !pageofficectrl.FullScreen;
			},
			OnPageOfficeCtrlInit() {
				// PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
				pageofficectrl.AddCustomToolButton("保存", "Save", 1);
        		pageofficectrl.AddCustomToolButton("全屏/还原", "IsFullScreen", 4);
			},
			AfterDocumentOpened(){
				// PageOffice的文档打开后事件回调函数
			},
			BeforeDocumentSaved() {
				// PageOffice的文档保存前事件回调函数
			},
			AfterDocumentSaved() {
				// PageOffice的文档保存后事件回调函数
			}
		  
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
		  window.Save = this.Save;
		  window.IsFullScreen = this.IsFullScreen;

		  // 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
		  window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
		  window.AfterDocumentOpened = this.AfterDocumentOpened;
		  window.BeforeDocumentSaved = this.BeforeDocumentSaved;
		  window.AfterDocumentSaved = this.AfterDocumentSaved;
	    }
	}
</script>


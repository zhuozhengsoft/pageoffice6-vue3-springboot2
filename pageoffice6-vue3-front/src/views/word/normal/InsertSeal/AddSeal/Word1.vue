<template>
	<div class="Word">
		<span style="color: red;">操作说明：</span>点“加盖印章”按钮即可，插入印章时的用户名为：李志，密码默认为：111111。
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
	      axios.post("/api/word/InsertSeal/AddSeal/Word1").then((response) => {
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
				pageofficectrl.AddCustomToolButton("保存", "Save()", 1); 
				pageofficectrl.AddCustomToolButton("加盖印章", "InsertSeal()", 2);
				pageofficectrl.AddCustomToolButton("删除印章", "DeleteSeal()", 21);
				pageofficectrl.AddCustomToolButton("验证印章", "VerifySeal()", 5);
				pageofficectrl.AddCustomToolButton("修改密码", "ChangePsw()", 0);
			},
	      	//控件中的一些常用方法都在这里调用，比如保存，打印等等
			//保存
			Save() {
				pageofficectrl.WebSave();
				alert("文件保存成功。");
			},
		
			//加盖印章
			InsertSeal() {
				try {
					pageofficectrl.zoomseal.AddSeal();
				} catch (e) {
				}
			},
		
			//删除印章
			DeleteSeal() {
				var iCount = pageofficectrl.zoomseal.Count;//获取当前文档中加盖的印章数量
				if (iCount > 0) {
					pageofficectrl.zoomseal.Item(iCount - 1).DeleteSeal();//删除最后一个印章，Item 参数下标从 0 开始
					alert("成功删除了最新加盖的印章。");
				} else {
					alert("请先在文档中加盖印章后，再执行删除操作。");
				}
			},
		
			//验证印章
			VerifySeal() {
				pageofficectrl.zoomseal.VerifySeal();
			},
		
			//修改密码
			ChangePsw() {
				pageofficectrl.zoomseal.ShowSettingsBox();
			}
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
			window.Save = this.Save;
			window.InsertSeal = this.InsertSeal;
			window.DeleteSeal = this.DeleteSeal;
			window.VerifySeal = this.VerifySeal;
			window.ChangePsw = this.ChangePsw;
			// 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
			window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
  
	    }
	}
</script>


<template>
	<div class="Word">
		    <span style="color: red;">操作说明：</span>点“签字”按钮即可，插入签字时的用户名为：李志，密码默认为：111111。
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
	      axios.post("/api/word/InsertSeal/AddSeal/Word7").then((response) => {
	        this.poHtmlCode = response.data;
	
	      }).catch(function (err) {
	        console.log(err)
	      })
	    },
	    methods:{
			OnPageOfficeCtrlInit() {
				// PageOffice的初始化事件回调函数，您可以在这里添加自定义按钮
				// 您可以在这里添加自定义按钮，执行您自定义的js。比如添加保存、打印、另存、关闭等按钮
				pageofficectrl.AddCustomToolButton("保存", "Save()", 1); 
				pageofficectrl.AddCustomToolButton("盖章到印章位置", "AddSealByPos()", 2);
			},
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
			Save() {
					pageofficectrl.WebSave();
			},
	
			AddSealByPos() {
					try {
							//先定位到印章位置,再在印章位置上盖章
							pageofficectrl.zoomseal.LocateSealPosition("Seal1");
							/**
							 *第一个参数，必填项，标识印章名称（当存在重名的印章时，默认选取第一个印章）；
							 *第二个参数，可选项，标识是否保护文档，为null时保护文档，为空字符串时不保护文档；
							 *第三个参数，可选项，标识盖章指定位置名称，须为英文或数字，不区分大小写
							 */
							var bRet = pageofficectrl.zoomseal.AddSealByName("李志签名", null, "Seal1"); //位置名称不区分大小写
							if (bRet) {
									alert("盖章成功！");
							} else {
									alert("盖章失败！");
							}
					} catch (e) {
					};
			}
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
			window.Save = this.Save;
			window.AddSealByPos = this.AddSealByPos;
			// 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
			window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
	    }
	}
</script>


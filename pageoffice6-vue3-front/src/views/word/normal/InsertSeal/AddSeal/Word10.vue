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
	      axios.post("/api/word/InsertSeal/AddSeal/Word10").then((response) => {
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
					pageofficectrl.AddCustomToolButton("删除指定印章", "DeleteSeal()", 21);
					pageofficectrl.AddCustomToolButton("清除所有印章", "DeleteAllSeal()", 21);
					
				},
				//控件中的一些常用方法都在这里调用，比如保存，打印等等
				Save() {
					pageofficectrl.WebSave();
				},
				
				InsertSeal() {
					var strSealName = "测试公章";//指定印章名称
					try {
						//第一个参数，必填项，标识印章名称（当存在重名的印章时，默认选取第一个印章），且该印章签章人的签章类型方式必须为用户名+密码；第二个参数，可选项，标识是否保护文档，为null时保护文档，为空字符串时不保护文档；第三个参数，可选项，标识盖章指定位置名称，须为英文或数字，不区分大小写
						pageofficectrl.zoomseal.AddSealByName(strSealName, null);
					} catch (e) {
					}
				},
			
				DeleteSeal() {
					var strSealName = "测试公章";//指定印章名称
					var iCount = pageofficectrl.zoomseal.Count;//获取加盖的印章数量
					var strTempSealName = "";
					if (iCount > 0) {
						for (var i = 0; i < iCount; i++) {
							strTempSealName = pageofficectrl.zoomseal.Item(i).SealName;//获取加盖的印章名称
							if (strTempSealName == strSealName) {
								pageofficectrl.zoomseal.Item(i).DeleteSeal();//删除印章
								alert("成功删除了“" + strSealName + "”");
								break;
							}
						}
					} else {
						alert("请先在文档中加盖印章后，再执行当前操作。");
					}
				},
			
				DeleteAllSeal() {
					var iCount = pageofficectrl.zoomseal.Count;//获取加盖的印章数量
					if (iCount > 0) {
						for (var i = iCount - 1; i >= 0; i--) {
							var strTempSealName = pageofficectrl.zoomseal.Item(i).SealName;//获取加盖的印章名称
							pageofficectrl.zoomseal.Item(i).DeleteSeal();//删除印章
						}
					} else {
						alert("请先在文档中加盖印章后，再执行当前操作。");
					}
				},
			
				ChangePsw() {
					pageofficectrl.zoomseal.ShowSettingsBox();
				}
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
			window.Save = this.Save;
			window.InsertSeal = this.InsertSeal;
			window.DeleteSeal = this.DeleteSeal;
			window.DeleteAllSeal = this.DeleteAllSeal;
			window.ChangePsw = this.ChangePsw;
			// 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
			window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
  
	    }
	}
</script>


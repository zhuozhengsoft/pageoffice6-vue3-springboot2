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
	      axios.post("/api/word/InsertSeal/AddSign/Word4").then((response) => {
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
				pageofficectrl.AddCustomToolButton("签字", "AddHandSign()", 3);
			},
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
			Save() {
					pageofficectrl.WebSave();
			},

			AddHandSign() {
					try {
							//定位到印章位置
							pageofficectrl.zoomseal.LocateSealPosition("Seal1");
							/**第一个参数，可选项，签字的用户名，为空字符串时，将弹出用户名密+密码框，如果为指定的签章用户名，则直接弹出签字框；
							 * 第二个参数，可选项，标识是否保护文档，为null时保护文档，为空字符串时不保护文档;
							 * 第三个参数，可选项，标识盖章指定位置名称，须为英文或数字，不区分大小写。
							 */
							pageofficectrl.zoomseal.AddHandSign("李志", null, "Seal1");
					} catch (e) {
					}
					;
			}
	    },
	    mounted: function(){
	      // 将vue中的方法赋值给window
			window.Save = this.Save;
			window.AddHandSign = this.AddHandSign;
			// 以下的为PageOffice事件的回调函数，名称不能改，否则PageOffice控件调用不到
			window.OnPageOfficeCtrlInit = this.OnPageOfficeCtrlInit;
  
	    }
	}
</script>


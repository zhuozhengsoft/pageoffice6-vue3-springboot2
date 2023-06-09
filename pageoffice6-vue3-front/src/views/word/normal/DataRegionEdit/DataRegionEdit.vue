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
	      axios.post("/api/word/DataRegionEdit/Word").then((response) => {
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
				pageofficectrl.AddCustomToolButton("定义数据区域", "ShowDefineDataRegions()", 3);
			},
	      //控件中的一些常用方法都在这里调用，比如保存，打印等等
		  Save() {
			  pageofficectrl.WebSave();
		  },
		  ShowDefineDataRegions() {
			  pageofficectrl.ShowHtmlModelessDialog("DataRegionDlg", "parameter=xx", "left=300px;top=390px;width=520px;height=410px;");
		  },
		  
		  //获取后台添加的书签名称字符串
		  getBkNames() {
			  var bkNames = pageofficectrl.DataRegionList.DefineNames;
			  return bkNames;
		  },
		  //获取后台添加的书签文本字符串
		  getBkConts() {
			  var bkConts = pageofficectrl.DataRegionList.DefineCaptions;
			  return bkConts;
		  },
		  //定位书签
		  locateBK(bkName) {
			  var drlist = pageofficectrl.DataRegionList;
			  drlist.GetDataRegionByName(bkName).Locate();
			  pageofficectrl.Activate();
			  window.focus();
		  },
		  //添加书签
		  addBookMark(param) {
			  var tmpArr = param.split("=");
			  var bkName = tmpArr[0];
			  var content = tmpArr[1];
			  var drlist = pageofficectrl.DataRegionList;
			  drlist.Refresh();
			  try {
				  pageofficectrl.Document.Application.Selection.Collapse(0);
				  drlist.Add(bkName, content);
				  return "true";
			  } catch (e) {
				  return "false";
			  }
		  },
		  //删除书签
		  delBookMark(bkName) {
			  var drlist = pageofficectrl.DataRegionList;
			  try {
				  drlist.Delete(bkName);
				  return "true";
			  } catch (e) {
				  return "false";
			  }
		  },
		  //遍历当前Word中已存在的书签名称
		  checkBkNames() {
			  var drlist = pageofficectrl.DataRegionList;
			  drlist.Refresh();
			  var bkName = "";
			  var bkNames = "";
			  for (var i = 0; i < drlist.Count; i++) {
				  bkName = drlist.Item(i).Name;
				  bkNames += bkName.substr(3) + ",";
			  }
			  return bkNames.substr(0, bkNames.length - 1);
		  },
		  //遍历当前Word中已存在的书签文本
		  checkBkConts() {
			  var drlist = pageofficectrl.DataRegionList;
			  drlist.Refresh();
			  var bkCont = "";
			  var bkConts = "";
			  for (var i = 0; i < drlist.Count; i++) {
				  bkCont = drlist.Item(i).Value;
				  bkConts += bkCont + ",";
			  }
			  return bkConts.substr(0, bkConts.length - 1);
		  }
	    },
		
	    mounted: function(){

	      // 将vue中的方法赋值给window
			window.Save = this.Save;
			window.ShowDefineDataRegions = this.ShowDefineDataRegions;
			
			window.getBkNames = this.getBkNames;
			window.getBkConts = this.getBkConts;
			window.locateBK = this.locateBK;
			window.addBookMark = this.addBookMark;
			window.delBookMark = this.delBookMark;
			window.checkBkNames = this.checkBkNames;
			window.checkBkConts = this.checkBkConts;
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

<template>
<div class="Word">
	<div>
		请输入部门名称：<input type="text" value="" id="deptName"/>
		<br/><br/>
		<input type="submit" value="确定" @click="getValue();"/>
		<input type="submit" value="取消" @click="closeWindow();"/>
	</div>
  </div>
</template>

<script>
  import axios from 'axios';
  export default{
    name: 'Word',
    data(){
      return {
        message: '111 ',
        poHtmlCode: '',

      }
    },
	
    methods:{
	  //控件中的一些常用方法都在这里调用，比如保存，打印等等
	  getValue() {
		//   var deptName = document.getElementById("deptName").value;
		//   if (deptName != null && deptName != "") {
		// 	  window.external.DialogResult = deptName;
		//   }
		  window.external.DialogResult = "图片路径";
	
		  window.external.close();
		  return;
	  },

		closeWindow() {
			window.external.close();
		}
		},
		mounted: function(){
			document.getElementById("deptName").value = window.external.DialogArgs;
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
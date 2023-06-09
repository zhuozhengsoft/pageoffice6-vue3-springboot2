<template>
	<div class="Word">

		<form id="form1">
			<div style=" text-align:center;">
				<div>请选择登录用户：</div>
				<br/>
				<select name="user" v-model="user">
					<option value="zhangsan">甲客户：zhangsan</option>
					<option value="lisi">乙客户：lisi</option>
				</select><br/><br/>
				<input type="button" @click="openWord()" value="打开文件"/><br/><br/>
				<div style=" color:Red;">不同的用户登录后，在文档中可以编辑的区域不同</div>
			</div>
		</form>

		
	</div>
</template>

<script>

	  export default{
	    name: 'Word',
	    data(){
	      return {
			user:'zhangsan',
	      }
	    },
	    methods:{

		  openWord(){
			POBrowser.openWindow("/word/normal/SameTimeEdit/Word?user="+this.user , 'width=1200px;height=800px;');
		  },
		  
	    },
	    mounted: function(){
	     
	    }
	}
</script>


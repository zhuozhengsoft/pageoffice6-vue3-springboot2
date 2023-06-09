<template>
  <div>Count=<input id="Text1" type="text" value="0"/>
  </div>
  <input type="button" @click="openWord" value="POBrowser方式打开Word文档"/>
</template>
<script>
export default {
  name: "Word",
  data() {
    return {
      message: "index",
      poHtmlCode: "",
      count:0
    };
  },
  methods:{
    openWord(){
      POBrowser.openWindow('CallParentFunction' , 'width=1200px;height=800px;')
    },
    updateCount(value) {
      this.count =  parseInt(document.getElementById("Text1").value);
      this.count += value;
      document.getElementById("Text1").value = this.count;
    }
  },
  mounted: function () {
    // 将methods中的方法通过mounted挂载到window对象上
    window.updateCount = this.updateCount;
  },
}
</script>




<script setup>
import Index from '../components/Index.vue'
</script>

<template>
  <header>
    <div class="logo" ><img src="../assets/logo.png"/> <a>PageOffice V6</a></div>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">首页</RouterLink>
        <a href="https://www.zhuozhengsoft.com" target="_blank">文档 <svg xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" x="0px" y="0px" viewBox="0 0 100 100" width="15" height="15" class="icon outbound"><path fill="currentColor" d="M18.8,85.1h56l0,0c2.2,0,4-1.8,4-4v-32h-8v28h-48v-48h28v-8h-32l0,0c-2.2,0-4,1.8-4,4v56C14.8,83.3,16.6,85.1,18.8,85.1z"></path> <polygon fill="currentColor" points="45.7,48.7 51.3,54.3 77.2,28.5 77.2,37.2 85.2,37.2 85.2,14.9 62.8,14.9 62.8,22.9 71.5,22.9"></polygon></svg></a>
        <a href="https://www.zhuozhengsoft.com" target="_blank">Java手册 <svg xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" x="0px" y="0px" viewBox="0 0 100 100" width="15" height="15" class="icon outbound"><path fill="currentColor" d="M18.8,85.1h56l0,0c2.2,0,4-1.8,4-4v-32h-8v28h-48v-48h28v-8h-32l0,0c-2.2,0-4,1.8-4,4v56C14.8,83.3,16.6,85.1,18.8,85.1z"></path> <polygon fill="currentColor" points="45.7,48.7 51.3,54.3 77.2,28.5 77.2,37.2 85.2,37.2 85.2,14.9 62.8,14.9 62.8,22.9 71.5,22.9"></polygon></svg></a>
        <a href="https://www.zhuozhengsoft.com" target="_blank">JS手册 <svg xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" x="0px" y="0px" viewBox="0 0 100 100" width="15" height="15" class="icon outbound"><path fill="currentColor" d="M18.8,85.1h56l0,0c2.2,0,4-1.8,4-4v-32h-8v28h-48v-48h28v-8h-32l0,0c-2.2,0-4,1.8-4,4v56C14.8,83.3,16.6,85.1,18.8,85.1z"></path> <polygon fill="currentColor" points="45.7,48.7 51.3,54.3 77.2,28.5 77.2,37.2 85.2,37.2 85.2,14.9 62.8,14.9 62.8,22.9 71.5,22.9"></polygon></svg></a>
      </nav>
    </div>
  </header>

<Index></Index>

  <div class="footer">   
    (本页是PageOffice示例，仅供程序员编程参考，不得作为独立网站发布)<br />
	  <span>PageOffice | Copyright © 2013-2023</span>
  </div>
</template>

<style scoped>
header {
  max-height: 60px;
  box-shadow: 0px 0px 5px #ccc;
  position: fixed;
  top: 0;
  width:100%;
  z-index: 1000;
  background-color: #fff;
}

.logo {
  display: block;
  
}

.logo img{
  width:32px;
  vertical-align: bottom;
  margin: 0 20px;
}
.logo a{
  font-size: 20px;
  font-family: 微软雅黑;
  color:#157BAE;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  color:#333;
  font-size: 14px;
}

nav a:first-of-type {
  border: 0;
}

nav svg{
  color:#666;
  padding-top:3px;
}

.footer{
  display: block;
  height: 160px;
  text-align: center;
  color: gray;
  padding-top: 80px;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    justify-content: space-between;
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
    margin-right: 30px;
  }

  nav {
    text-align: left;
    font-size: 1rem;

    padding: 1rem 0;
  }
}
</style>

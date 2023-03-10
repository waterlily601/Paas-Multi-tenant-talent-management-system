<template>
  <el-container>
    <el-header class="home_header" >

      <div class="home_title" >PMTTMS人才管理系统</div>
      <div class="home_userinfoContainer">
        <div>
          <el-link href="http://localhost:8080/signup" target="_blank" >注册</el-link>
          <a>   |  </a>
          <el-link href="http://localhost:8080/login" target="_blank" >登录</el-link>
        </div>
      </div>
    </el-header>
    <el-container>
      <div style="width: 100%; text-align: center;">
        <img src="1.png">
      </div>
    </el-container>
  </el-container>
</template>


<script>
export default {
  data() {
    return {
      url: 'logo.png',
      srcList: [
        'logo.png'
      ]
    }
  }
}
</script>

<style>
.el-header {
  background-color: white;
  color: #3A4C7D;
  line-height: 60px;
}

</style>
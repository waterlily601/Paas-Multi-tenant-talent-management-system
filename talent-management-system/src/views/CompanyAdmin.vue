<template>
  <el-container class="home_container">
    <el-header class="home_header">
      <div class="home_title">PMTTMS人才管理系统-公司管理员</div>
      <div class="home_userinfoContainer">
        <el-dropdown>
                  <span class="el-dropdown-link home_userinfo">
                    {{admin.username}}<i class="el-icon-arrow-down el-icon--right home_userinfo"></i>
                  </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container>

      <el-aside class="home_aside" width="220px">

        <el-menu router>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-s-platform"></i>部门模块</template>
            <el-menu-item index="/departmentAdd" :class="$route.path=='/departmentAdd'?'is-active':''">
              <i class="el-icon-s-check"></i>添加部门
            </el-menu-item>
            <el-menu-item index="/departmentManagement" :class="$route.path=='/departmentManagement'?'is-active':''">
              <i class="el-icon-document-copy"></i>部门信息
            </el-menu-item>
          </el-submenu>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-s-platform"></i>HR模块</template>
            <el-menu-item index="/entryManagement" :class="$route.path=='/companyAdminManagement'?'is-active':''">
              <i class="el-icon-s-check"></i>添加HR
            </el-menu-item>
            <el-menu-item index="/entryRecord" :class="$route.path=='/companyAdminRecord'?'is-active':''">
              <i class="el-icon-document-copy"></i>HR信息
            </el-menu-item>
          </el-submenu>
        </el-menu>

      </el-aside>

      <el-container>
        <el-main>
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item v-text="this.$router.currentRoute.name"></el-breadcrumb-item>
          </el-breadcrumb>
          <router-view></router-view>
        </el-main>
        <el-footer class="home_footer">2023 © PMTTMS</el-footer>
      </el-container>

    </el-container>

  </el-container>
</template>
<script>
export default{
  methods: {
    logout(){
      let _this = this;
      this.$confirm('注销登录吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function () {
        localStorage.removeItem('CompanyAdmin')
        _this.$router.replace({path: '/login'})
      })
    }
  },
  data(){
    return {
      admin:''
    }
  },
  created() {
    let admin = JSON.parse(window.localStorage.getItem('CompanyAdmin'))
    this.admin = admin
  }
}
</script>
<style>
.home_container {
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
}

.home_header {
  background-color: #2B2B2B;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.home_title {
  color: #C2C2C2;
  font-size: 22px;
  display: inline;
}

.home_userinfo {
  color: #fff;
  cursor: pointer;
}

.home_userinfoContainer {
  display: inline;
  margin-right: 20px;
}

.home_aside {
  background-color: #FFFFFF;
}

.home_footer {
  background-color: #FFFFFF;
  color: #000000;
  font-size: 18px;
  line-height: 60px;
  text-align: center;
}
</style>

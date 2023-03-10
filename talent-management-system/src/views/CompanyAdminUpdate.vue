<template>
  <el-card style="width: 500px;margin:auto;">
    <el-form label-width="120px" size="small" :model="form" :rules="rules" ref="pass">

      <!--      <el-form-item label="原密码" prop="password">-->
      <!--        <el-input v-model="form.password" readonly autocomplete="off" ></el-input>-->
      <!--      </el-form-item>-->
      <el-form-item label="新密码" prop="newPassword">
        <el-input v-model="form.newPassword" autocomplete="off" show-password></el-input>
      </el-form-item>
      <el-form-item label="确认新密码" prop="confirmPassword">
        <el-input v-model="form.confirmPassword" autocomplete="off" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="save">确 定</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
export default {
  data() {
    return {
      form: {
        password:''
      },  // username, password, newPassword, confirmNewPassword 这4个属性
      ruleForm:{
        password:'',
        companyID:'',
        state:'同意',
      },
      //companyAdmin: localStorage.getItem("companyAdmin") ? JSON.parse(localStorage.getItem("companyAdmin")) : {},
      rules: {
        // password: [
        //   { required: true, message: '请输入原密码', trigger: 'blur' },
        // ],
        newPassword: [
          { required: true, message: '请输入新密码', trigger: 'blur' },
        ],
        confirmPassword: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
      }
    }
  },
  created() {
    //this.form.username = this.companyAdmin.username
    let admin = JSON.parse(window.localStorage.getItem('companyAdmin'))
    this.admin = admin
    this.form.password=this.admin.password
  },
  methods: {
    save() {
      const _this = this
      this.$refs.pass.validate((valid) => {
        if (valid) {  //合法
          if (_this.form.newPassword !== _this.form.confirmPassword) {
            _this.$message.error("2次输入的新密码不相同")
            return false
          }else{
            _this.ruleForm.password=_this.form.newPassword
            _this.ruleForm.companyID=_this.admin.companyID
            axios.post('http://localhost:8181/companyadmin/updatepassword',_this.ruleForm).then(function (resp) {
              if(resp.data.code == 0){
                _this.$alert('修改成功！', '', {
                  confirmButtonText: '确定',
                  callback: action => {
                    _this.$router.push('/departmentManagement')
                  }
                });
              }
            })
          }
          // this.request.post("/user/password", this.form).then(res => {
          //   if (res.code === '200') {
          //     this.$message.success("修改成功")
          //     this.$store.commit("logout")
          //   } else {
          //     this.$message.error(res.msg)
          //   }
          // })
        }
      })
    },
  }
}
</script>

<style>
.avatar-uploader {
  text-align: center;
  padding-bottom: 10px;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 138px;
  height: 138px;
  line-height: 138px;
  text-align: center;
}
.avatar {
  width: 138px;
  height: 138px;
  display: block;
}
</style>


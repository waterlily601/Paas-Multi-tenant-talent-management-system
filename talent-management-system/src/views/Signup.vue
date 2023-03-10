<template>
  <div style="margin-top: 60px;margin-left:330px;width: 300px;height: 500px;border: 0px solid red;" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="公司名" prop="companyname">
        <el-input v-model="ruleForm.companyname"></el-input>
      </el-form-item>
      <el-form-item label="账号" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item label="法人名称" prop="legalperson">
        <el-input v-model="ruleForm.legalperson"></el-input>
      </el-form-item>
      <el-form-item label="公司地址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="telephone">
        <el-input v-model="ruleForm.telephone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="ruleForm.email"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即注册</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
export default {
  data() {
    return {
      category:null,
      ruleForm: {
        companyname: '',
        username: '',
        password: '',
        legalperson: '',
        address: '',
        telephone: '',
        email: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        companyname: [
          { required: true, message: '请输入公司名称', trigger: 'blur' },
        ],
        legalperson: [
          { required: true, message: '请输入公司法人', trigger: 'blur' },
          { required: true, pattern: /^[\u2E80-\u9FFF]+$/, message: '请输入公司法人', trigger: 'blur' }
        ],
        address: [
          { required: true, message: '请输入公司地址', trigger: 'blur' },
          { required: true, pattern: /^[\u2E80-\u9FFF]+$/, message: '请输入公司地址', trigger: 'blur' }
        ],
        telephone: [
          { required: true, message: '请输入公司电话', trigger: 'blur' },
          { required: true, pattern: /^\d{11}$/, message: '请输入公司电话', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8181/companyadmin/save',_this.ruleForm).then(function (resp) {
            if(resp.data.code==-1){
              _this.$alert('账号已存在', '提示', {
                confirmButtonText: '确定'
              })
            }
            if(resp.data.code==-2){
              _this.$alert('未知错误，注册失败', '提示', {
                confirmButtonText: '确定'
              })
            }
            if(resp.data.code==0){
              axios.post('http://localhost:8181/companyinfo/save',_this.ruleForm).then(function (resp) {
                if(resp.data.code==0){
                  _this.$alert('注册申请成功', '', {
                    confirmButtonText: '确定',
                    callback: action => {
                      _this.$router.push('/login')
                    }
                  });
                }
              })
            }
          })
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
}
</script>

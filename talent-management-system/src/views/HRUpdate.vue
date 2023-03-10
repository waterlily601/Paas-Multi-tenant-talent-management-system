<template>
  <div style="margin-top: 100px;margin-left:500px;width: 300px;height: 500px;border: 0px solid red;" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item label="姓名" prop="hrname">
        <el-input v-model="ruleForm.hrname"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即修改</el-button>
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
        hrname: '',
        username: '',
        password: ''
      },
      rules: {
        hrname: [
          { required: true, message: '请输入HR姓名', trigger: 'blur' }
        ],
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.put('http://localhost:8181/hradmin/update',_this.ruleForm).then(function (resp) {
            if(resp.data.code == 0){
              _this.$alert('修改成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/hrManagement')
                }
              });
            }
          })
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/hradmin/findById/'+_this.$route.query.id).then(function (resp) {
      _this.ruleForm = resp.data.data
    })
  }
}
</script>
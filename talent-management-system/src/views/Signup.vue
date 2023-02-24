<template>
  <div style="margin-top: 60px;margin-left:330px;width: 300px;height: 500px;border: 0px solid red;" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="公司名" prop="companyName">
        <el-input v-model="ruleForm.companyName"></el-input>
      </el-form-item>
      <el-form-item label="账号" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
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
        companyName: '',
        username: '',
        password: ''
      },
      rules: {
        // animalSpecies: [
        //   { required: true, message: '请输入公司名', trigger: 'blur' },
        //   { required: true, pattern: /^[\u2E80-\u9FFF]+$/, message: '请输入动物种类', trigger: 'blur' }
        // ],
        // animalOrigin: [
        //   { required: true, message: '请输入动物来源', trigger: 'blur' },
        //   { required: true, pattern: /^[\u2E80-\u9FFF]+$/, message: '请输入动物来源', trigger: 'blur' }
        // ],
        // numberOfAnimals: [
        //   { required: true, message: '请输入动物数量', trigger: 'blur' },
        //   { required: true, pattern: /^\d{1,5}$/, message: '请输入动物数量', trigger: 'blur' }
        // ],
        // contactDetails: [
        //   { required: true, message: '请输入联系方式', trigger: 'blur' },
        //   { required: true, pattern: /^\d{11}$/, message: '请输入联系方式', trigger: 'blur' }
        // ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8181/companyAdmin/save',_this.ruleForm).then(function (resp) {
            if(resp.data.code == 0){
              _this.$alert('注册申请成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/login')
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
  // created() {
  //   const _this = this
  //   axios.get('http://localhost:8181/dormitory/availableList').then(function (resp) {
  //     _this.dormitoryList = resp.data.data
  //   })
  // }
}
</script>

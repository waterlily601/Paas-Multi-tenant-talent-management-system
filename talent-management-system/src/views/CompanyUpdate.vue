<template>
  <div style="margin-top: 60px;margin-left:330px;width: 300px;height: 500px;border: 0px solid red;" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="公司名称" prop="companyname">
        <el-input v-model="ruleForm.companyname"></el-input>
      </el-form-item>
      <el-form-item label="公司法人" prop="legalperson">
        <el-input v-model="ruleForm.legalperson"></el-input>
      </el-form-item>
      <el-form-item label="公司地址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
      </el-form-item>
      <el-form-item label="公司电话" prop="telephone">
        <el-input v-model="ruleForm.telephone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="ruleForm.email"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
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
        legalperson: '',
        address:'',
        telephone: '',
        email: ''
      },
      rules: {
        companyname: [
          { required: true, message: '请输入公司名称', trigger: 'blur' },
          { required: true, pattern: /^[\u2E80-\u9FFF]+$/, message: '请输入公司名称', trigger: 'blur' }
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
          axios.put('http://localhost:8181/companyinfo/update',_this.ruleForm).then(function (resp) {
            if(resp.data.code == 0){
              _this.$alert('公司信息修改成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/companyinfo')
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
    console.log(_this.$route.query.companyID)
    axios.get('http://localhost:8181/companyinfo/findById/'+_this.$route.query.companyID).then(function (resp) {
      _this.ruleForm = resp.data.data
    })
  }
}
</script>

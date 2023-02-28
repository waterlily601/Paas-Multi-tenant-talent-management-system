<template>
  <div style="margin-top: 60px;margin-left:330px;width: 300px;height: 500px;border: 0px solid red;" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="部门编号" prop="departmentid">
        <el-input v-model="ruleForm.departmentid"readonly></el-input>
      </el-form-item>
      <el-form-item label="部门名称" prop="departmentname">
        <el-input v-model="ruleForm.departmentname"></el-input>
      </el-form-item>
      <el-form-item label="部门电话" prop="telephone">
        <el-input v-model="ruleForm.telephone"></el-input>
      </el-form-item>
      <el-form-item label="公司名称" prop="company">
        <el-input v-model="ruleForm.company"></el-input>
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
        departmentid:'',
        departmentname: '',
        telephone: '',
        company: '',
      },
      rules: {
        // departmentid: [
        //   { required: true, message: '请输入部门编号', trigger: 'blur' }
        // ],
        departmentname: [
          { required: true, message: '请输入部门名称', trigger: 'blur' }
        ],
        telephone: [
          { required: true, message: '请输入部门电话', trigger: 'blur' }
        ],
        company: [
          { required: true, message: '请输入公司名称', trigger: 'blur' }
        ],
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(_this.ruleForm)
          axios.post('http://localhost:8181/departmentInformation/update',_this.ruleForm).then(function (resp) {
            if(resp.data.code == 0){
              _this.$alert(_this.ruleForm.departmentid+'，修改成功！', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/departmentManagement')
                }
              });
            }
          })
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/departmentInformation/findById/'+_this.$route.query.departmentid).then(function (resp) {
      _this.ruleForm = resp.data.data
    })
  }
}
</script>

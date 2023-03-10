<template>
  <div style="margin-top: 60px;margin-left:330px;width: 300px;height: 500px;border: 0px solid red;" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="部门编号" prop="departmentID">
        <el-input v-model="ruleForm.departmentID" readonly></el-input>
      </el-form-item>
      <el-form-item label="部门名称" prop="departmentname">
        <el-input v-model="ruleForm.departmentname"></el-input>
      </el-form-item>
      <el-form-item label="部门电话" prop="telephone">
        <el-input v-model="ruleForm.telephone"></el-input>
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
        departmentID:'',
        departmentname: '',
        telephone: ''
      },
      rules: {

        departmentname: [
          { required: true, message: '请输入部门名称', trigger: 'blur' }
        ],
        telephone: [
          { required: true, message: '请输入部门电话', trigger: 'blur' },
          { required: true, pattern:/^((0\d{2,3}-\d{7,8})|(1[34578]\d{9}))$/,message: '请输入11位手机号或固定电话', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(_this.ruleForm)
          axios.post('http://localhost:8181/department/update',_this.ruleForm).then(function (resp) {
            if(resp.data.code == 0){
              _this.$alert(_this.ruleForm.departmentID+'，修改成功！', '', {
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
    axios.get('http://localhost:8181/department/findById/'+_this.$route.query.departmentID).then(function (resp) {
      _this.ruleForm = resp.data.data
    })
  }
}
</script>
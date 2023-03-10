<template>
  <div style="margin-top: 30px; margin-left:330px;width: 500px;height: 120px;border: 0px solid red;" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
      <el-form-item label="员工编号" prop="employeeID">
        <el-select v-model="ruleForm.employeeID" placeholder="请选择员工编号">
          <el-option v-for="item in employeeList" :label="item.employeeID" :value="item.employeeID"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="绩效月份" prop="month">
        <el-date-picker v-model="ruleForm.month"  type="month" value-format="yyyy-MM" placeholder="请选择绩效月份"> </el-date-picker>
      </el-form-item>
      <el-form-item label="绩效分数" prop="employeescore">
        <el-input v-model="ruleForm.employeescore" placeholder="请输入本月绩效分数"></el-input>
      </el-form-item>
      <el-form-item label="评价" prop="apparise">
        <el-input v-model="ruleForm.apparise" placeholder="请输入员工评价"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
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
        performanceID:'',
        employeeID:'',
        month:'',
        employeescore: '',
        apparise: '',
        companyID:''
      },
      employeeList:'',
      rules: {
        employeeID: [
          { required: true, message: '请选择员工编号', trigger: 'blur' }
        ],
        month: [
          { required: true, message: '请选择绩效月份', trigger: 'blur' }
        ],
        employeescore: [
          { required: true, pattern:/(^(\d|[1-9]\d)(\.\d{1,2})?$)|(^100$)/, message: '请输入0-100数字,最多可保留两位小数', trigger: 'blur' },
        ],
        apparise: [
          { required: true, message: '请输入员工评价', trigger: 'blur' }
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
          _this.ruleForm.companyID=this.admin.companyID
          axios.post('http://localhost:8181/performance/save',_this.ruleForm).then(function (resp) {
            if(resp.data.code == 0){
              _this.$alert('绩效记录添加成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/achievementManager')
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
    let admin = JSON.parse(window.localStorage.getItem('HR'))
    this.admin = admin
    axios.get('http://localhost:8181/employee/employeelist'+'/'+this.admin.companyID).then(function (resp) {
      _this.employeeList = resp.data.data
    })
  }
}
</script>
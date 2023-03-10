<template>
  <div style="margin-top: 30px; margin-left:330px;width: 500px;height: 120px;border: 0px solid red;" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="140px" class="demo-ruleForm">
      <el-form-item label="员工姓名" prop="employeename">
        <el-input v-model="ruleForm.employeename" placeholder="请输入员工姓名"></el-input>
      </el-form-item>
      <el-form-item label="员工性别" prop="employeesex">
        <el-radio-group v-model="ruleForm.employeesex" placeholder="请选择员工性别">
          <el-radio :label="男">男</el-radio>
          <el-radio :label="女">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="员工所属部门" prop="departmentID">
        <el-select v-model="ruleForm.departmentID" placeholder="请选择员工所属部门">
          <el-option v-for="item in departmentList" :label="item.departmentname" :value="item.departmentID"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="员工职级" prop="employeelevel">
        <el-select v-model="ruleForm.employeelevel" placeholder="请选择员工职级">
          <el-option label="普通员工" value="普通员工"></el-option>
          <el-option label="部门主管" value="部门主管"></el-option>
          <el-option label="部门经理" value="部门经理"></el-option>
          <el-option label="部门总监" value="部门总监"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="员工薪资" prop="employeesalary">
        <el-select v-model="ruleForm.employeesalary" placeholder="请选择员工薪资">
          <el-option label="一级薪资" value="一级薪资"></el-option>
          <el-option label="二级薪资" value="二级薪资"></el-option>
          <el-option label="三级薪资" value="三级薪资"></el-option>
          <el-option label="四级薪资" value="四级薪资"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="员工地址" prop="address">
        <el-input v-model="ruleForm.address" placeholder="请输入员工地址"></el-input>
      </el-form-item>
      <el-form-item label="员工联系方式" prop="telephone">
        <el-input v-model="ruleForm.telephone" placeholder="请输入员工联系方式" ></el-input>
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
        employeename:'',
        employeesex: '',
        departmentID: '',
        employeelevel: '',
        employeesalary: '',
        address: '',
        telephone:'',
        companyID:''
      },
      departmentList:'',
      rules: {
        employeename: [
          { required: true, message: '请输入员工姓名', trigger: 'blur' }
        ],
        employeesex: [
          { required: true, message: '请选择员工性别', trigger: 'blur' },
        ],
        departmentID: [
          { required: true, message: '请选择员工部门编号', trigger: 'blur' }
        ],
        employeelevel: [
          { required: true, message: '请选择员工职级', trigger: 'blur' }
        ],
        employeesalary: [
          { required: true, message: '请选择员工薪资', trigger: 'blur' }
        ],
        address: [
          { required: true, message: '请输入员工居住地址', trigger: 'blur' }
        ],
        telephone: [
          { required: true, message: '请输入员工电话', trigger: 'blur' },
          {
            validator: function(rule, value, callback) {
              if (/^(13[0-9]|14[0-9]|15[0-9]|16[6]|18[0-9]|19[6,9]|17[0-9])\d{8}$/i.test(value) == false) {
                callback(new Error("请正确输入手机号"));
              } else {
                //校验通过
                callback();
              }
            },
            trigger: "blur"
          }
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
          axios.post('http://localhost:8181/employee/save',_this.ruleForm).then(function (resp) {
            if(resp.data.code == 0){
              _this.$alert('员工信息添加成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/employeeManager')
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
    axios.get('http://localhost:8181/department/departmentlist'+'/'+this.admin.companyID).then(function (resp) {
      _this.departmentList = resp.data.data
    })
  }
}
</script>
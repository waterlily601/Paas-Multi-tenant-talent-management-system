<template>
  <div style="margin-top: 40px;margin-left:80px;margin-right:80px;border: 0px solid red;" >
    <el-form style="margin-left: -40px" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
      <el-form-item label="字段：" prop="key">
        <el-select v-model="ruleForm.key" style="width: 160px;float: left" placeholder="请选择字段">
          <el-option label="员工编号" value="employeeID"></el-option>
          <el-option label="考勤月份" value="month"></el-option>
        </el-select>
      </el-form-item>
      <div style="border: 0px solid red;width: 400px;height: 60px;position: relative;top: -64px;left: 270px">
        <el-form-item label="值：">
          <el-input v-model="ruleForm.value" placeholder="请输入关键字" style="width: 160px;"></el-input>
          <el-button type="primary" icon="el-icon-search" style="position: relative;left: 10px;" @click="submitForm('ruleForm')">搜索</el-button>
        </el-form-item>
      </div>
    </el-form>

    <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%;position: relative;top:-30px">
      <el-table-column
          fixed
          prop="employeeID"
          label="员工编号"
          width="120">
      </el-table-column>
      <el-table-column
          fixed
          prop="month"
          label="考勤月份"
          width="120">
      </el-table-column>
      <el-table-column
          prop="fullday"
          label="全勤天数"
          width="120">
      </el-table-column>
      <el-table-column
          prop="abscentday"
          label="缺勤天数"
          width="120">
      </el-table-column>
      <el-table-column
          prop="dayoff"
          label="请假天数"
          width="120">
      </el-table-column>
    </el-table>

    <el-pagination style="margin-top: 20px;float: right"
                   background
                   layout="prev, pager, next"
                   :page-size="pageSize"
                   :total="total"
                   :current-page.sync="currentPage"
                   @current-change="page">
    </el-pagination>
  </div>

</template>

<script>
export default {
  data() {
    return {
      tableData:null,
      currentPage: 1,
      pageSize: 3,
      total: '',
      key: '',
      value: '',
      ruleForm: {
        key: '',
        value: '',
        page: '',
        size: 3,
        id:''
      },
      rules: {
        key: [
          { required: true, message: '请选择字段', trigger: 'change' }
        ]
      }
    }
  },
  methods:{
    submitForm(formName) {
      const _this = this
      //让翻页复原
      _this.currentPage = 1
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this
          _this.ruleForm.page = _this.currentPage
          _this.ruleForm.id=this.admin.companyID
          axios.get('http://localhost:8181/checkonwork/search',{params:_this.ruleForm}).then(function (resp) {
            _this.tableData = resp.data.data.data
            _this.total = resp.data.data.total
          })
        }
      });
    },
    page(currentPage){
      const _this = this
      if(_this.ruleForm.value == ''){
        axios.get('http://localhost:8181/checkonwork/list/'+currentPage+'/'+_this.pageSize+'/'+this.admin.companyID).then(function (resp) {
          _this.tableData = resp.data.data.data
          _this.total = resp.data.data.total
        })
      } else {
        _this.ruleForm.page = _this.currentPage
        _this.ruleForm.id=this.admin.companyID
        axios.get('http://localhost:8181/checkonwork/search',{params:_this.ruleForm}).then(function (resp) {
          _this.tableData = resp.data.data.data
          _this.total = resp.data.data.total
        })
      }
    }
  },
  created() {
    const _this = this
    let admin = JSON.parse(window.localStorage.getItem('HR'))
    this.admin = admin
    axios.get('http://localhost:8181/checkonwork/list/1/'+_this.pageSize+'/'+this.admin.companyID).then(function (resp) {
      _this.tableData = resp.data.data.data
      _this.total = resp.data.data.total
    })
  }
}
</script>
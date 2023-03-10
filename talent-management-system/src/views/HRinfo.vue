<template>
  <div style="margin-top: 40px;margin-left:40px;margin-right:40px; border: 0px solid red;" >
    <h1>人事管理解决方案</h1>
    <el-collapse v-model="activeNames" @change="handleChange">
      <el-collapse-item title="全程数字化人事服务" name="1">
        <div>员工可以通过员工自助门户，场景化的查询信息、发起申请与办理业务。人事各类证明文件，通过一个流程在线申请、审批、用印。高效、安全！</div>
      </el-collapse-item>
      <el-collapse-item title="全面协同的员工入职流程" name="2">
        <div>通过一个流程，对员工的入职申请、信息采集、合同签订、资产领用、员工培训等分散业务串联，协同各个部门，让数据和信息高效协同。</div>
      </el-collapse-item>
      <el-collapse-item title="全方位的人员评估" name="3">
        <div>人事管理与业务场景全面打通，通过人事卡片将和员工所有信息聚合，结合人才成长模型、人员风险模型等系统模型，实现人员的全方位评估。</div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeNames: ['1']
    };
  },
  methods: {
    handleChange(val) {
      console.log(val);
    }
  }
}
</script>
<template>
    <div style="height: 100%">
      <el-input @change="getPayLogList" style="width: 200px" placeholder="请输入订单号" prefix-icon="el-icon-search" v-model="orderId"></el-input>
      <el-date-picker v-model="startPayTime" format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="请选择支付起始时间"></el-date-picker>
      <el-date-picker v-model="endPayTime" format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="请选择支付结束时间"></el-date-picker>
      <el-button type="success" @click="getPayLogList" round>点击搜索</el-button>
      <el-table :data="payLogList" height="250">
        <el-table-column prop="orderId" label="订单号" width="180" align="center"></el-table-column>
        <el-table-column prop="create_time" label="支付时间" width="180" align="center"></el-table-column>
        <el-table-column label="支付方式" width="80" align="center">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.payType === 1">在线支付</el-tag>
            <el-tag type="success" v-if="scope.row.payType === 2">货到付款</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="订单实付金额" width="120" align="center">
          <template slot-scope="scope">
            <span>{{scope.row.totalFee/100}}</span>
          </template>
        </el-table-column>
        <el-table-column prop="transactionId" label="微信交易号" width="120" align="center"></el-table-column>
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleShow(scope.row)">查看</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页组件 -->
      <el-pagination
        :background="true"
        layout="prev, pager, next, jumper"
        :current-page="pageNum"
        :page-count = "pages"
        @current-change="handlePageNum"
      >
      </el-pagination>
  </div>
</template>

<script>
export default {
  name: "Statistics",
  data(){
    return {
      payLogList:[],
      pageInfo:null,
      pages:0,
      pageNum:1,
      pageSize:3,
      orderId:'',
      startPayTime:null,
      endPayTime:null
    }
  },
  methods:{
    handlePageNum(val){
      this.pageNum = val
      this.getPayLogList()
    },
    getPayLogList(){
      let payLogFo = {
        pageNum:this.pageNum,
        pageSize:this.pageSize,
        orderId:this.orderId,
        startPayTime:this.startPayTime,
        endPayTime:this.endPayTime
      }
      this.$axios.post("/api/order/payLog/list",payLogFo).then(res=>{
        console.log(res.data)
        this.pageInfo = res.data
        this.payLogList = res.data.list
        this.pages = res.data.pages
      })
    }
  },
  created() {
    this.getPayLogList()
  }
}
</script>

<style scoped>

</style>

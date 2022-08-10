<template>
  <div style="height: 100%">
    <el-table :data="orderList" style="width: 100%;height: 100%" height="250">
      <el-table-column prop="order_id" label="订单号" width="150"></el-table-column>
      <el-table-column prop="create_time" label="下单时间" width="120"></el-table-column>
      <el-table-column label="支付方式" width="80">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.payment_type === 1">在线支付</el-tag>
          <el-tag type="success" v-if="scope.row.payment_type === 2">货到付款</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="post_fee" label="运费" width="60"></el-table-column>
      <el-table-column label="地址" width="300">
        <template slot-scope="scope">
          <span>{{scope.row.receiver_city + scope.row.receiver_district + scope.row.receiver_address}}</span>
        </template>
      </el-table-column>
      <el-table-column prop="receiver_zip" label="邮编" width="80"></el-table-column>
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleShow(scope.row)">查看</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "order",
  data(){
    return {
      orderList:[],
    }
  },
  created() {
    this.getOrderList()
  },
  methods:{
    //获取订单列表
    getOrderList(){
      this.$axios.get("/api/order/list").then(res=>{
        this.orderList = res.data.data
      })
    },
    handleDelete(){

    },
    handleShow(val){
      console.log(val.order_id)
      this.$axios.get("/api/order/item").then(res=>{
        console.log(res.data.data)
      })
    }
  }
}
</script>

<style scoped>

</style>

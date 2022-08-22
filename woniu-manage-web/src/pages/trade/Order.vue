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
      <el-table-column label="订单实付金额" width="120" align="center">
        <template slot-scope="scope">
          <span>{{scope.row.actual_pay/100}}</span>
        </template>
      </el-table-column>
      <el-table-column prop="post_fee" label="运费" width="60" align="center"></el-table-column>
      <el-table-column label="收货地址" width="350" align="center">
        <template slot-scope="scope">
          <span>{{scope.row.receiver_city + scope.row.receiver_district + scope.row.receiver_address}}</span>
        </template>
      </el-table-column>
      <el-table-column prop="receiver_zip" label="邮编" width="80" align="center"></el-table-column>
      <el-table-column label="操作" width="200" fixed="right" align="center">
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
      :page-count = "pageInfo.pages"
      @current-change="handlePageNum"
    >
    </el-pagination>

    <!--订单项详情-->
    <el-dialog title="订单详情" :visible.sync="dialogTableVisible">
      <el-table :data="orderDetails">
        <el-table-column property="title" label="商品名" width="350" align="center"></el-table-column>
        <el-table-column label="实付金额" width="120" align="center">
          <template slot-scope="scope">
            <span>{{scope.row.price/100}}</span>
          </template>
        </el-table-column>
        <el-table-column property="num" label="数量"></el-table-column>
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="showGoodDetail(scope.row)">查看商品详情</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "order",
  data(){
    return {
      orderList:[],
      orderDetails:[],
      skuId:"",
      dialogTableVisible:false,
      pageInfo:null,
      pageNum:1,
      pageSize:3,
    }
  },
  created() {
    this.getOrderList()
  },
  methods:{
    handlePageNum(val){
      this.pageNum = val
      this.getOrderList()
    },
    //获取订单列表
    getOrderList(){
      this.$axios.get("/api/order/order/list?pageNum="+this.pageNum).then(res=>{
        this.pageInfo = res.data.data
        this.orderList = res.data.data.list
      })
    },
    handleDelete(val){
      this.$axios.post("/api/order/order/delete/"+val.order_id).then(res=>{
        if (res.data.code === 200){
          alert("删除成功")
          window.location.reload();
        }else {
          alert("删除失败,请稍后重试")
        }
      }).catch(error => {
        alert("服务器繁忙,请稍后重试")
      })
    },
    handleShow(val){
      this.$axios.get("/api/order/order/item/list?orderId="+val.order_id).then(res=>{
        console.log(res.data.data)
        this.orderDetails = res.data.data
        this.dialogTableVisible = true
      })
    },
  //  根据sku_id查商品详细信息
    showGoodDetail(val){
      console.log(val.sku_id)
    }
  }
}
</script>

<style scoped>

</style>

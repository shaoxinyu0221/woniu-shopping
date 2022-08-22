<template>
  <div>
    <el-table
      :data="tableData" border
      style="width: 60%">
      <el-table-column
        fixed
        prop="date"
        label="id"
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        label="类别父种类"
        width="120">
      </el-table-column>
      <el-table-column
        prop="province"
        label="子种类"
        width="120">
      </el-table-column>
      <el-table-column
        prop="province"
        label="孙种类"
        width="120">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="150">
        <template slot-scope="scope">
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
  export default {
    name: "category",
    data() {
      return {
        categoryList:[],
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        tableData: [],
      }
    },
    methods: {
      getcategoryRoot(){
        this.$axios.get('api/category/root').then(res=>{
          console.log(res.data)
          this.tableData=res.data
        })
      }
    },
    created() {
      this.getcategoryRoot()
    }
  };
</script>

<style scoped>

</style>

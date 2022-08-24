<template>
  <div>
    <el-tree
      :data="data"
      show-checkbox
      node-key="id"
      :default-expanded-keys="[2, 3]"
      :default-checked-keys="[5]"
      :props="defaultProps">
    </el-tree>
  </div>
</template>

<script>
export default {
  name: "List",
  data() {
    return {
      permsList:null,
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      userList:null,
      userId:0
    }
  },
  created() {

  },
  methods:{
    getPermsListByUserId(val){
      this.$axios.get("/api/perms/perms/list/"+val.userId).then(res=>{

      })
    },
    getUserList(){
      this.$axios.get("/api/perms/user/list").then(res=>{
        this.userList = res.data.data
      })
    }
  }

}
</script>

<style scoped>

</style>

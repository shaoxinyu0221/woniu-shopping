<template>
  <div>
    <el-tree
      :data="categoryList"
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
    name: "category",
    data() {
      return {
        categoryList:[],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      }
    },
    methods: {

    },
    created() {

    }
  };
</script>

<style scoped>

</style>

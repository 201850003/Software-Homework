<template>
  <ul class="todo-main">
    <Item v-for="taskObj in tasks"
          :key="taskObj.id"
          :task="taskObj"
          :update="update"
          :mydelete="mydelete"></Item>
  </ul>
</template>

<script>
  import Item from "./Item";
    export default {
        name: "List",
        components: {
            Item
        },
        props: ['tasks', 'update', 'mydelete']
    }
</script>

<style scoped>
  .todo-main {
    margin-left: 0px;
    border: 1px solid #ddd;
    border-radius: 2px;
    padding: 0px;
  }
  .todo-empty {
    height: 40px;
    line-height: 4px;
    border: 1px solid #ddd;
    border-radius: 2px;
    padding-left: 5px;
    margin-top: 10px;
  }
</style>

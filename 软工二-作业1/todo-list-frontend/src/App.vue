<template>
  <div class="todo-container">
    <h1>Lab 1 todolist</h1>
    <div class="todo-wrap">
      <Header :add="add"></Header>
      <List :tasks="tasks" :update="update" :mydelete="mydelete"></List>
    </div>
  </div>
</template>
<script>
  import Header from './components/Header';
  import List from "./components/List";
  import axios from 'axios';
  export default {
    name: "App",
    components: {
      Header,
      List
    },
    data() {
      return {
        tasks: []
      }
    },
    mounted() {
      axios.get('/api/all').then(response => (
              this.tasks = response.data
      ));
      console.log(this.tasks);
    },
    methods: {
      async add(title) {
        await axios.post('/api/add?title=' + title);
        axios.get('/api/all').then(response => (
                this.tasks = response.data
        ));
        alert('添加成功！');
      },
      async update(id, isCompleted) {
        await axios.put('/api/task/' + id +'?isCompleted=' +isCompleted);
        axios.get('/api/all').then(response => (
                this.tasks = response.data
        ));
        alert('更新成功！');
      },
      async mydelete(id) {
        await axios.delete('/api/task/' + id);
        axios.get('/api/all').then(response => (
                this.tasks = response.data
        ));
        alert('删除成功！');
      }
    }

  }
</script>
<style lang="scss">
  /*#app {*/
  /*  font-family: Avenir, Helvetica, Arial, sans-serif;*/
  /*  -webkit-font-smoothing: antialiased;*/
  /*  -moz-osx-font-smoothing: grayscale;*/
  /*  text-align: center;*/
  /*  color: #2c3e50;*/
  /*}*/
  body {
    background-color: #FFFFFF;
  }
  .todo-container {
    width: 600px;
    margin: 0 auto;
  }
  .todo-container .todo-wrap {
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }
</style>

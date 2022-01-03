<template>
  <div>
    <h1>Server Message</h1>
    <span >{{ msg }}</span>
    <button @click="getServerGreeting">Get Message from Server</button>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return { 
      msg: '',
    }
  },
  methods: {
    async getServerGreeting() {
      const res = await fetch('http://localhost:9090/api/greeting');
      console.log(res);
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

<template>
  <div>
  <div>Количество лайков<strong>{{like}}</strong></div>
      <div>Количество дизлайков<strong>{{dislike}}</strong></div>
  </div>
</template>
<script>

export default {

  components: {
      data(){
          return{likes:0,
          dislikes:5}
      }

  }
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

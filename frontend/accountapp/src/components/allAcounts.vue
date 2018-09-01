<template>
    <div class="tableContainer">
       <b-table hover :items="accounts"></b-table>
    </div>
</template>

<script>
  import axios from 'axios'

    export default {
        name: "allAcounts",
      data() {
        return {
          accounts: []
        }
      },
          mounted: function(){
            axios.get('http://www.localhost:8182/account/getall')
            .then(response => {
              this.accounts = response.data;
              console.log(response.data)
            })
            .catch(e => {
              this.errors.push(e)
            })
        }
    }
</script>

<style scoped>
.tableContainer{
  margin: 5px;
  padding: 2px;
}
</style>

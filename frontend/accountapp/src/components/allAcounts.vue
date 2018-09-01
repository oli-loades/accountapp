<template>
    <div>
      <table>
        <thead>
        <th>ID</th> <th>First Name</th> <th> Last Name</th> <th> Account Number </th>
        </thead>
        <tr v-for="account in accounts" v-on:key="id">
          <td>{{account.id}}</td> <td>{{account.firstname}}</td> <td> {{account.surname}}</td> <td> {{account.accountNumber}}</td>
        </tr>
      </table>
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

</style>

<template>
  <div id ='form'>
    <p>First name</p>
    <input type=text v-model=account.firstname><br>
    <p>Surname</p>
    <input type=text v-model=account.surname><br>
    <p>Account number</p>
    <input type=text v-model=account.accountNumber><br>
    <button @click='add()'>Add Account</button><br>
    <p>{{msg}}</p>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: "addAccount",
    data() {
      return {
        msg: "",
        account: {
          firstname: "",
          surname: "",
          accountNumber: ""
        }
      }
    },
    methods: {
      add: function() {
        axios.post('http://www.localhost:8182/account/add', this.account)
          .then(response => {
            this.msg = response.data;
            console.log(response.data)
          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    }
  }
</script>

<style scoped>

</style>

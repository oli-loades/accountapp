<template>
  <div class='form'>
    <b-alert show>{{msg.message}}</b-alert>
    <b-form @submit="add()" @reset="reset()">
      <b-form-group label="First Name:"
                    label-for="firstNameFeild">
        <b-form-input id="firstNameFeild"
                      v-model="account.firstname"
                      type="text"
                      placeholder="Enter your first name"></b-form-input>
      </b-form-group>

      <b-form-group label="Surname:"
                    label-for="surnameFeild">
        <b-form-input id="surnameFeild"
                      v-model="account.surname"
                      type="text"
                      placeholder="Enter your surname"></b-form-input>
      </b-form-group>

      <b-form-group label="Account Number:"
                    label-for="accountNumberField">
        <b-form-input id="accountNumberField"
                      v-model="account.accountNumber"
                      type="text"
                      placeholder="Enter your account number"></b-form-input>
      </b-form-group>

      <b-button  type="submit" variant="primary">Add Account</b-button>
      <b-button  type="reset" variant="danger">Reset</b-button>

    </b-form>
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
      add: function () {
        axios.post('http://www.localhost:8182/account/add', this.account)
          .then(response => {
            this.msg = response.data;
            console.log(response.data)
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      reset: function () {
        this.account.firstname = '';
        this.account.surname = '';
        this.account.accountNumber = '';
      }
    }
  }
</script>

<style scoped>
  .form {
    margin: 15px;
    padding: 20px;
    text-align: center;
  }

</style>

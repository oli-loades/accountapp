<template>
  <div>
    <v-app id="inspire">

      <v-alert
        :value="!alert"
        color="success"
        transition="scale-transition">
        Account successfully added.
      </v-alert>

      <v-container>

        <v-form ref="form" v-model="valid" lazy-validation>
          <v-layout align-center justify-center column/>
          <v-text-field
            v-model="account.firstname"
            :rules="rule"
            label="First name"
            required></v-text-field>
          <v-text-field
            v-model="account.surname"
            :rules="rule"
            label="Surname"
            required></v-text-field>
          <v-text-field
            v-model="account.accountNumber"
            :rules="rule"
            label="Account number"
            required></v-text-field>

          <div>
            <v-btn outline :disabled="!valid" @click="add">submit
            </v-btn>
            <v-btn outline @click="reset">clear</v-btn>
          </div>

        </v-form>

      </v-container>

    </v-app>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: "addAccount",
    data() {
      return {
        msg: "",
        alert: true,
        valid: true,
        rule: [v => !!v || 'Required'],
        account: {
          firstname: "",
          surname: "",
          accountNumber: ""
        }
      }
    },
    methods: {
      add: function () {
        if (this.$refs.form.validate()) {
          this.alert = false
          axios.post('http://www.localhost:8182/account/add', this.account)
            .then(response => {
              this.msg = response.data;
              console.log(response.data)
            })
            .catch(e => {
              this.errors.push(e)
            })
        }
      },
      reset: function () {
        this.alert = true
        this.$refs.form.reset()
      }
    }
  }
</script>

<style scoped>


</style>

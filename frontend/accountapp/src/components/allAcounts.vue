<template>
  <div class="tableContainer">
    <v-app id="accountTable">

      <v-alert
        :value="!alert"
        @click = 'alert = true'
        color="success"
        transition="scale-transition">
        {{msg.message}}
      </v-alert>

      <v-dialog v-model="deleteDialog" persistent max-width="290">
        <v-card>
          <v-card-title class="headline">Delete account?</v-card-title>
          <v-card-text>Please confirm action.</v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green darken-1" flat @click.native="deleteDialog = false">Cancel</v-btn>
            <v-btn color="green darken-1" flat @click.native="deleteAccount()">Confirm</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
      <v-container>
        <v-data-table :headers="headers" :items="accounts" hide-actions class="elevation-1">
          <template slot="items" slot-scope="props">
            <td class="text-xs-center">{{ props.item.id }}</td>
            <td class="text-xs-center">{{ props.item.firstname }}</td>
            <td class="text-xs-center">{{ props.item.surname }}</td>
            <td class="text-xs-center">{{ props.item.accountNumber }}</td>
            <v-icon color='blue' meduim @click=''>edit</v-icon>
            <v-spacer></v-spacer>
            <v-icon color='red' meduim @click='deletePressed(props.item)'>delete</v-icon>
          </template>
          <template slot="no-data">
            <v-alert :value="true" color="error" icon="warning">
              No data to display.
            </v-alert>
          </template>
        </v-data-table>
      </v-container>
    </v-app>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: "allAcounts",
    data() {
      return {
        deleteDialog: false,
        toBeDeleted: 0,
        msg: '',
        alert: true,
        headers: [
          {
            text: 'ID',
            align: 'center',
            sortable: true,
            value: 'id'
          },
          {text: 'First name', value: 'firstname', sortable: true, align: 'center'},
          {text: 'Surname', value: 'surname', sortable: true, align: 'center'},
          {text: 'Account number', value: 'accountNumber', sortable: false, align: 'center'},
        ],
        accounts: []
      }
    },
    mounted: function () {
      axios.get('http://www.localhost:8182/account/getall')
        .then(response => {
          this.accounts = response.data;
          console.log(response.data)
        })
        .catch(e => {
          this.errors.push(e)
        })
    },
    methods: {
      deleteAccount() {
        console.log(this.toBeDeleted);
        axios.delete('http://www.localhost:8182/account/delete/' + this.toBeDeleted.id)
          .then(response => {
            this.msg = response.data;
            this.alert=false;
            this.deleteDialog=false;
            this.accounts.splice(this.accounts.indexOf(this.toBeDeleted), 1);
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      deletePressed(account){
        this.toBeDeleted = account;
        this.deleteDialog=true;
      }
    }
  }
</script>

<style scoped>

</style>

<template>
  <div class="tableContainer">
    <v-app id="accountTable">

      <v-alert
        :value="!alert"
        @click='alert = true'
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
            <v-btn color="black" flat @click.native="deleteDialog = false">Cancel</v-btn>
            <v-btn color="black" flat @click.native="deleteAccount()">Confirm</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>

      <v-dialog v-model="editDialog" max-width="500px">
        <v-card>
          <v-card-text>
            <v-container grid-list-md>
              <v-layout wrap>
                <v-flex xs12 sm6 md4>
                  <v-text-field v-model="editedAccount.firstname" label="First name"></v-text-field>
                </v-flex>
                <v-flex xs12 sm6 md4>
                  <v-text-field v-model="editedAccount.surname" label="Surname"></v-text-field>
                </v-flex>
                <v-flex xs12 sm6 md4>
                  <v-text-field v-model="editedAccount.accountNumber" label="Account number"></v-text-field>
                </v-flex>
              </v-layout>
            </v-container>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="black" flat @click="editDialog = false">Cancel</v-btn>
              <v-btn color="black" flat @click="editAccount()">Confirm</v-btn>
            </v-card-actions>
          </v-card-text>
        </v-card>
      </v-dialog>

      <v-container>
        <v-data-table :headers="headers" :items="accounts" hide-actions class="elevation-1">
          <template slot="items" slot-scope="props">
            <td class="text-xs-center">{{ props.item.id }}</td>
            <td class="text-xs-center">{{ props.item.firstname }}</td>
            <td class="text-xs-center">{{ props.item.surname }}</td>
            <td class="text-xs-center">{{ props.item.accountNumber }}</td>
            <v-icon color='blue' meduim @click='editPressed(props.item)'>edit</v-icon>
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
        editDialog: false,
        msg: '',
        alert: true,
        prevAcc: '',
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
        accounts: [],
        editedAccount: {
          firstname: '',
          surname: '',
          accountNumber: ''
        }
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
        axios.delete('http://www.localhost:8182/account/delete/' + this.toBeDeleted.id)
          .then(response => {
            this.msg = response.data;
            this.alert = false;
            this.deleteDialog = false;
            this.accounts.splice(this.accounts.indexOf(this.toBeDeleted), 1);
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      deletePressed(account) {
        this.toBeDeleted = account;
        this.deleteDialog = true;
      },
      editAccount() {
        axios.put('http://www.localhost:8182/account/update/' + this.prevAcc.id, this.editedAccount)
          .then(response => {
            this.msg = response.data;
            this.alert = false;
            this.editDialog = false;
            this.update();
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      editPressed(account) {
        this.prevAcc = account;
        this.editedAccount.firstname = account.firstname;
        this.editedAccount.surname = account.surname;
        this.editedAccount.accountNumber = account.accountNumber;
        this.editDialog = true;
      },
      update() {
        const index = this.accounts.indexOf(this.prevAcc);
        this.accounts[index].firstname = this.editedAccount.firstname;
        this.accounts[index].surname = this.editedAccount.surname;
        this.accounts[index].accountNumber = this.editedAccount.accountNumber;
      }
    }
  }
</script>

<style scoped>

</style>

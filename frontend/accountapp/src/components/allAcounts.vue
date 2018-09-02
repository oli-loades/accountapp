<template>
  <div class="tableContainer">
    <v-app id="accountTable">
      <v-container>
        <v-data-table :headers="headers" :items="accounts" hide-actions class="elevation-1">
          <template slot="items" slot-scope="props">
            <td class="text-xs-center">{{ props.item.id }}</td>
            <td class="text-xs-center">{{ props.item.firstname }}</td>
            <td class="text-xs-center">{{ props.item.surname }}</td>
            <td class="text-xs-center">{{ props.item.accountNumber }}</td>
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
        headers: [
          {
            text: 'ID',
            align: 'center',
            sortable: false,
            value: 'id'
          },
          {text: 'First name', value: 'firstname', sortable: false,align: 'center'},
          {text: 'Surname', value: 'surname', sortable: false,align: 'center'},
          {text: 'Account number', value: 'accountNumber', sortable: false,align: 'center'},
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
    }
  }
</script>

<style scoped>

</style>

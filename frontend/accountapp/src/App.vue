<template>
  <div id="app">
    <v-app id="navi">
      <v-toolbar dark>
        <v-toolbar-title>Accountapp</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn flat v-for="routes in links"
                 v-bind:key="routes.id"
                 :to="`${routes.page}`">{{routes.text}}
          </v-btn>
        </v-toolbar-items>
      </v-toolbar>
      <router-view/>
    </v-app>
  </div>
</template>

<script>

  export default {
    name: 'app',
    data() {
      return {
        links: [
          {
            id: 0,
            text: 'Home',
            page: '/'
          },
          {
            id: 1,
            text: 'Add Account',
            page: '/add'
          },
          {
            id: 2,
            text: 'View All',
            page: '/all'
          }
        ]
      }
    }
  }
</script>

<style>

</style>

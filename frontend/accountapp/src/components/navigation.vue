<template>
    <div>
      <b-navbar variant="primary" type="dark" class='navbar'>
        <b-navbar-nav>
        <b-nav-item v-for="routes in links"
                     v-bind:key="routes.id"
                     :to="`${routes.page}`">{{routes.text}}</b-nav-item>
          </b-navbar-nav>
      </b-navbar>
    </div>
</template>

<script>
    export default {
        name: "navigation",
      data() {
        return {
          links: [
            {
              id: 0,
              text: 'Home',
              page:'/'
            },
            {
              id: 1,
              text: 'Add Account',
              page:'/add'
            },
            {
              id: 2,
              text: 'View All',
              page:'/all'
            }
          ]
        }
      }
    }
</script>

<style scoped>

</style>

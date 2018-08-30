import Vue from 'vue'
import Router from 'vue-router'
import home from '.././components/home'
import addAccount from '.././components/addAccount'
import allAccounts from '.././components/allAcounts'

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: home
    },
    {
      path: '/add',
      name: 'addAccount',
      component: addAccount
    },
    {
      path: '/all',
      name: 'allAccounts',
      component: allAccounts
    }
  ]
})

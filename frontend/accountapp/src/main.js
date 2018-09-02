import '@babel/polyfill'
import Vue from 'vue'
import './plugins/vuetify'
import App from './App'
import router from './router'
import Vuetify from 'vuetify'

Vue.use(Vuetify);

new Vue({
  el: '#app',router,
  components: App,
  template: '<App/>',
  render: h => h(App)
});

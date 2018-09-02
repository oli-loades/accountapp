import '@babel/polyfill'
import Vue from 'vue'
import './plugins/vuetify'
import App from './App'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Vuetify from 'vuetify'

Vue.use(BootstrapVue);
Vue.use(Vuetify);

new Vue({
  el: '#app',router,
  components: App,
  template: '<App/>',
  render: h => h(App)
});

import Vue from 'vue'
import App from './App.vue'
import router from "@/router"

import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import Toast from 'primevue/toast';
import ToastService from 'primevue/toastservice';
import Card from 'primevue/card';
import Divider from 'primevue/divider';

import 'primevue/resources/primevue.min.css';
import 'primeicons/primeicons.css';
import 'primevue/resources/themes/tailwind-light/theme.css';


Vue.use(ToastService);

Vue.component('Card', Card);
Vue.component('InputText', InputText);
Vue.component('Button', Button)
Vue.component('Toast', Toast);
Vue.component('Divider', Divider);



Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

import Vue from 'vue'
import App from './App.vue'
import router from "@/router"
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import Toast from 'primevue/toast';
import ToastService from 'primevue/toastservice';
import 'primevue/resources/primevue.min.css';
import 'primeicons/primeicons.css';
import 'primevue/resources/themes/arya-blue/theme.css';

Vue.use(ToastService);

Vue.component('p-input', InputText);
Vue.component('p-button', Button);
Vue.component('p-toast', Toast);



Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

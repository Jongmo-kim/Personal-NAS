import Vue from 'vue';
import VueRouter from 'vue-router';
import HelloWorld from '@/components/HelloWorld';
import AboutComponent from '@/components/AboutComponent';

Vue.use(VueRouter);

const route = [
    {path: "/", component: HelloWorld},
    {path: "/about", component: AboutComponent},
];

// Vue 라우터 인스턴스 생성
const router = new VueRouter({
    mode: 'history',
    routes: route
});

export default router;
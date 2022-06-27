import Vue from 'vue';
import VueRouter from 'vue-router';
import FileBrowser from '@/components/FileBrowser';
import MainBoard from '@/components/MainBoard';
import UserLogin from '@/components/UserLogin';
import UserSignup from '@/components/UserSignup';

Vue.use(VueRouter);

const route = [
    {path: "/", component: null},
    {path: "/signup", component: UserSignup},
    {path: "/login", component: UserLogin},
    {path: "/board", component: MainBoard},
    {path: "/file-browser", component: FileBrowser},
];

// Vue 라우터 인스턴스 생성
const router = new VueRouter({
    mode: 'history',
    routes: route
});

export default router;
import {createRouter, createWebHashHistory} from 'vue-router'


import Login from "@/components/MyLogin.vue";
import Register from "@/components/MyRegister.vue";
import Home from '@/components/MyHome.vue';

// Home组件
import HomePage from '@/components/Home/HomePage.vue';
import GodManage from '@/components/Home/GodManage.vue';
import UserManage from '@/components/Home/UserManage.vue';
import ToBeGod from '@/components/Home/ToBeGod.vue';

//Position
import PositionList from '@/components/PositionManage/PositionList';
import BranchManage from '@/components/PositionManage/BranchManage';

//Merit组件
import AddMerit from '@/components/MeritManage/AddMerit.vue';
import MeritStore from '@/components/MeritManage/MeritStore.vue'

//Root组件
import AddAdmin from '@/components/Root/AddAdmin.vue';
import StoreManage from '@/components/Root/StoreManage.vue';


const router = createRouter({

    history: createWebHashHistory(),

    routes: [
        {path: '/', redirect: '/Home/HomePage'},

        {path: '/Login', component: Login},
        {path: '/Register', component: Register},
        {
            path: '/Home', component: Home, redirect: '/Home/HomePage',
            children: [
                {path: '/Home/HomePage', component: HomePage},
                {path: '/Home/GodManage', component: GodManage},
                {path: '/Home/UserManage', component: UserManage},
                {path: '/Home/ToBeGod', component: ToBeGod},
                {
                    path: '/Home/MeritManage', redirect: '/Home/MeritManage/AddMerit',
                    children: [
                        {path: '/Home/MeritManage/AddMerit', component: AddMerit},
                        {path: '/Home/MeritManage/MeritStore', component: MeritStore},
                    ]
                },
                {
                    path: '/Home/Position', redirect: '/Home/Position/PositionList',
                    children: [
                        {path: '/Home/Position/PositionList', component: PositionList},
                        {path: '/Home/Position/BranchManage', component: BranchManage},
                    ]
                },
                {
                    path: '/Home/Root', redirect: '/Home/Root/AddAdmin',
                    children: [
                        {path: '/Home/Root/AddAdmin', component: AddAdmin},
                        {path: '/Home/Root/StoreManage', component: StoreManage},
                    ]
                },
            ]
        },
    ]
})

export default router

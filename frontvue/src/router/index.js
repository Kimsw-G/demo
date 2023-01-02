import { createRouter, createWebHashHistory } from 'vue-router'

//component
const HEADER = () => import(/* webpackChunkName: "identi"   */ '@/components/HeaderComp.vue')

//view
const HOME_VIEW = () => import(/* webpackChunkName: "identi"   */ '@/views/HomeView.vue')
const TODOCAL_VIEW = () => import(/* webpackChunkName: "identi"   */ '@/views/TodocalView.vue')
const BUDGETCAL_VIEW = () => import(/* webpackChunkName: "identi"   */ '@/views/BudgetCalView.vue')
const LOGIN_VIEW = () => import(/* webpackChunkName: "identi"   */ '@/views/LoginView.vue')
const SIGNUP_VIEW = () => import(/* webpackChunkName: "identi"   */ '@/views/SignupView.vue')
const SEETODO_VIEW = () => import(/* webpackChunkName: "identi"   */ '@/views/SeeTodoView.vue')
const SPECDAY_VIEW = () => import(/* webpackChunkName: "identi"   */ '@/views/SpecDayView.vue')


const routes = [
    {
        path: '/',
        name: 'home',
        components: {
            header: HEADER,
            default: HOME_VIEW
        }
    },
    {
        path: '/todocal',
        name: 'todocal',
        components: {
            header: HEADER,
            default: TODOCAL_VIEW
        }
    },
    {
        path: '/login',
        name: 'login',
        components: {
            header: HEADER,
            default: LOGIN_VIEW
        }
    },
    {
        path: '/signup',
        name: 'signup',
        components: {
            header: HEADER,
            default: SIGNUP_VIEW
        }
    },
    {
        path: '/todo/seetodo',
        name: 'seetodo',
        components: {
            header: HEADER,
            default: SEETODO_VIEW
        }
    },
    {
        path: '/budgetcal',
        name: 'budgetcal',
        components: {
            header: HEADER,
            default: BUDGETCAL_VIEW
        }
    },
    {
        path: '/todo/specday',
        name: 'specday',
        components: {
            header: HEADER,
            default: SPECDAY_VIEW
        }
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
import { createRouter, createWebHashHistory } from 'vue-router'

const HEADER = () => import(/* webpackChunkName: "identi"   */ '../components/HeaderView.vue') 

const HOME_VIEW = () => import(/* webpackChunkName: "identi"   */ '../views/HomeView.vue')
const LOGIN = () => import(/* webpackChunkName: "identi"   */ '../views/LoginView.vue')
const SIGNUP = () => import(/* webpackChunkName: "identi"  */ '../views/SignupView.vue')
const TODOCAL = () => import(/* webpackChunkName: "todo"*/ '../views/todo/TodocalView.vue')
const TODO_SPEC_DAY = () => import(/* webpackChunkName: "todo" */ '../views/todo/TodoSpecDayView.vue')
// const ADD_EVENT = () => import(/* webpackChunkName: "todo"  */ '../components/AddEventView.vue')
// const ADD_TODO = () => import(/* webpackChunkName: "todo"  */ '../components/AddTodoView.vue')
const SEE_TODO = () => import(/* webpackChunkName: "todo"  */ '../views/todo/SeeTodoView.vue')
const BUDGETCAL = () => import(/* webpackChunkName: "budget"  */ '../views//budget/BudgetCalView.vue')
const BUDGET_SPEC_DAY = () => import(/* webpackChunkName: "budget"  */ '../views/budget/BudgetSpecDayView.vue')
const routes = [
  {
    path: '/',
    name: 'home',
    components: {
      header : HEADER,
      default : HOME_VIEW
    }
  },
  {
    path: '/login',
    name: 'login',
    component: LOGIN
  },
  {
    path: '/signup',
    name: 'signup',
    components: {
      header : HEADER,
      default : SIGNUP
    }
  },
  {
    path: '/todocal',
    name: 'todocal',
    components: {
      header : HEADER,
      default : TODOCAL
    }
  },
  {
    path: '/todocal/specday',
    name: 'todocal_specday',
    components: {
      header : HEADER,
      default : TODO_SPEC_DAY
    }
  },
  // {
  //   path: '/todocal/addevent',
  //   name: 'todocal_addevent',
  //   component: ADD_EVENT
  // },
  // {
  //   path: '/todocal/addtodo',
  //   name: 'todocal_addtodo',
  //   component: ADD_TODO
  // },
  {
    path: '/todocal/seetodo',
    name: 'todocal_seetodo',
    components:{
      header : HEADER,
      default : SEE_TODO
    }
  },
  {
    path: '/budgetcal',
    name: 'budgetcal',
    components: {
      header : HEADER,
      default : BUDGETCAL
    }
  },
  {
    path: '/budgetcal/specday',
    name: 'budgetcal_specday',
    components: {
      header : BUDGET_SPEC_DAY,
      default : SIGNUP
    }
  }

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router

import { createApp } from 'vue'
import App from './App.vue'
import route from './router'
import store from './store'
import axios from 'axios'
import InfiniteLoading from "v3-infinite-loading";
import "v3-infinite-loading/lib/style.css";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


axios.defaults.baseURL="http://127.0.0.1:8090"

const app=createApp(App).use(store).use(route).use(ElementPlus)
app.component("infinite-loading", InfiniteLoading);
app.config.globalProperties.axios=axios
app.mount('#app')
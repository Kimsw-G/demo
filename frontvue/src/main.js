import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import InfiniteLoading from "v3-infinite-loading";
import "v3-infinite-loading/lib/style.css";

axios.defaults.baseURL="http://localhost:8090"

const app=createApp(App).use(store).use(router)
app.component("infinite-loading", InfiniteLoading);
app.config.globalProperties.axios=axios
app.mount('#app')
<template>
<div id="allbody">
    <div>
        <h4>진행중 작업</h4>
        <form for="" >
        <ul id="search-bar">
            <li><input class="search-input" type="text" name="">
                <button class="search-button">검색</button>
            </li>
            <li class="index">
                <div class="updown-box">
                    <div class="triangle-up"></div>
                    <div class="triangle-down"></div>
                </div>
                제목
            </li>
            <li class="index">
                <div class="updown-box">
                    <div class="triangle-up"></div>
                    <div class="triangle-down"></div>
                </div>
                시작일
            </li>
            <li class="index">
                <div class="updown-box">
                    <div class="triangle-up"></div>
                    <div class="triangle-down"></div>
                </div>
                종료일
            </li>
        </ul>
        </form>
        <table id="open-todo">
            <tr v-for="todo in openTodo" :key="todo" class="todo-tr">
                <td>{{todo.title}}</td>
                <td>{{todo.startDay}}</td>
                <td>{{todo.endDay}}</td>
                <td class="progress-td"><progress class="todo-progress" :value="todo.percent" min="0" max="100"/> {{todo.percent}}%</td>
            </tr>
        </table>
        <h4>종료 작업</h4>
        <ul id="search-bar">
            <li><input class="search-input" type="text" name="">
                <button class="search-button">검색</button>
            </li>
            <li class="index">
                <div class="updown-box">
                    <div class="triangle-up"></div>
                    <div class="triangle-down"></div>
                </div>
                제목
            </li>
            <li class="index">
                <div class="updown-box">
                    <div class="triangle-up"></div>
                    <div class="triangle-down"></div>
                </div>
                시작일
            </li>
            <li class="index">
                <div class="updown-box">
                    <div class="triangle-up"></div>
                    <div class="triangle-down"></div>
                </div>
                종료일
            </li>
        </ul>
        <table id="close-todo">
            <tr v-for="todo in closeTodo" :key="todo" class="todo-tr">
                <td>{{todo.title}}</td>
                <td>{{todo.startDay}}</td>
                <td>{{todo.endDay}}</td>
                <td class="progress-td"><progress class="todo-progress" :value="todo.percent" min="0" max="100"/> {{todo.percent}}%</td>
            </tr>
        </table>
    </div>
    <div id="side-bar">

    </div>
</div>
</template>
<script>
export default {
    components: {},
    data() {
        return {
            openTodo:[
                {
                    title:'운동하기',
                    percent:50,
                    startDay:'2022-12-01',
                    endDay:'2022-12-14'
                }
            ],
            closeTodo:[
                {
                    title:'운동안하기',
                    percent:90,
                    startDay:'2022-11-01',
                    endDay:'2022-11-30'
                },
                {
                    title:'밥묵기',
                    percent:70,
                    startDay:'2022-11-01',
                    endDay:'2022-11-30'
                }
            ]
        }
    },
    created() {},
    mounted() {},
    unmounted() {},
    methods: {}
}
</script>
<style scoped>
/* searchbar css */
li{
    display: table-cell;
    margin: 0 40px;
}
.index:hover{
    background-color: aqua;
}
#search-bar{
    width: 90vw;
    display: grid;
    grid-template-columns: 1fr 0.7fr 0.7fr 0.7fr;
}
.index{
    text-align: center;
}
.updown-box{
    width: 10px;
    height: 0px;
    display: grid;
    grid-template-rows: 1fr 1fr;
    gap: 2px;
    float: right;
}
.triangle-up,.triangle-down{
    display: inline-block;
    width: 0px;
    height: 0px;
    border-left: 5px solid transparent;
    border-right: 5px solid transparent;
}
.triangle-up{
    border-bottom: 10px solid #666666;
}
.triangle-down{
    border-top: 10px solid #666666;
}
#search-input{
    line-height: 100%;
    border: none;
    padding: 0px 5px;
}
#search-button{
    height: 100%;
    border: none;
    padding: 2px 4px;
    background-color: white;
}
#search-button:hover{
    background-color: rgb(230, 230, 230);
}
/* todo css */
table{
    width: 100%;
}
progress{
    width: 90%;
    appearance: none;
}
progress::-webkit-progress-bar{
    border-radius: 10px;
    box-shadow: inset 3px 3px 10px #ebebeb;
}
progress::-webkit-progress-value{
    border-radius: 10px;
    background: #93F9B9;
    background: -webkit-linear-gradient(to rigth, #93F9B9, #41b98f);
    background: linear-gradient(to right, #93F9B9, #41b98f)
}

#open-todo progress{

}
#open-todo progress::-webkit-progress-bar{

}
#open-todo progress::-webkit-progress-value{

}
#close-todo progress{
    
}
#close-todo progress::-webkit-progress-bar{

}
#close-todo progress::-webkit-progress-value{

}
.todo-tr{
    display: grid;
    grid-template-columns: 1fr 0.3fr 0.3fr;
    border-bottom: 1px solid black;
}
#open-todo tr:hover{
    background-color: #ffffc3;

}

#close-todo td:nth-child(1){
    text-decoration: line-through;
}
#close-todo tr{
    background-color: rgba(218, 218, 218, 0.726);
}
#close-todo tr:hover{
    background-color: rgb(218, 218, 218);
}
</style>

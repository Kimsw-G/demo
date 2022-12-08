<template>
<div class="black-bg" @click="closeModal">
    <div class="white-bg">
        <label class="ttitle-label" for="ttitle">제목</label>
        <input type="text" id="ttitle" name="ttitle"> <br>
        <label class="date-label" for="startday">시작일</label><label class="date-label" for="endday">종료일</label>
        <input type="date" id="startday" class="date" name="startday"><input type="date" id="endday" class="date" name="endday"> <br>
        <div class="dow-box">
            <button @click="checkDow(idx)" 
                    @mouesenter.passive="overMouse(idx)"
                    v-for="(dow,idx) in dows" 
                    :key="dow"
                    :id="`button${idx}`"
                    :class="'button'">
                {{dow}}
            </button>
        </div>
        <textarea rows="" cols="" id="etext" name="etext"/>
    </div>
</div>
</template>
<script>
export default {
    props:{
        isAddTodo: Boolean
    },
    components: {},
    data() {
        return {
            dows:[
                '일','월','화','수','목','금','토'
            ],
            isDows:[
                false,false,false,false,false,false,false,
            ]
        }
    },
    created() {},
    mounted() {},
    unmounted() {},
    methods: {
        closeModal(event){
            if(event.target.classList.contains("black-bg")) this.$emit("closeTodo")
        },
        checkDow(idx){
            this.isDows[idx] = !this.isDows[idx]
            let button = document.querySelector("#button"+idx)
            if(this.isDows[idx]){//색 넣기
                button.style.backgroundColor= "#7de0b4";
            }else{
                button.style.backgroundColor= "beige";
            }
        },
        overMouse(idx){
            console.log('hi');
            let button = document.querySelector("#button"+idx)
            button.style.backgroundColor="#7de0b4"
        }
    }
}
</script>
<style scoped>
input{
    padding: 5px 7px;
}
#ttitle{
    width: 90%;
    height: 2em;
    margin: 3px;
}
.ttitle-label{
    display: inline-block;
    width: 90%;
    margin-top: 10px;
}
.date-label{
    display: inline-block;
    width: 45%;
}
#startday, #endday{
    width: 45%;
    height: 2em;
}
.dow-box{
    margin: 3px auto ;
    width: 90%;
    display: grid;
    grid-template-columns: repeat(7,1fr);
    gap: 1px;
    justify-items: center;
}
.button{
    width: 30px;
    height: 30px;
    border-radius: 15px;
    border: 0px;
    background-color: beige;
}
#etext{
    width: 90%;
    height: 4em;
}
</style>
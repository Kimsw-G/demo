<template>
<div class="black-bg" @click="closeModal">
    <div class="white-bg">
        <label class="ftitle-label" for="ftitle">제목</label>
        <input type="text" id="ftitle" name="ftitle" v-model="ftitle"> <br>
        <label class="date-label" for="startday" >시작일</label><label class="date-label" for="endday">종료일</label>
        <input type="date" id="startday" class="date" name="startday" v-model="start_day"><input type="date" id="endday" class="date" name="endday" v-model="end_day"> <br>
        <div class="dow-box">
            <button @click="checkDow(idx)" 
                    @mouseover="overMouse(idx)"
                    @mouseleave="leaveMouse(idx)"
                    v-for="(dow,idx) in dows" 
                    :key="dow"
                    :id="`button${idx}`"
                    :class="'button'">
                {{dow}}
            </button>
        </div>
        <textarea rows="" cols="" id="ftext" name="etext" v-model="ftext"/>
        <button id="submit" @click="submitData">제출테스트</button>
        <pre id="errMsg">{{ errMsg }}</pre>
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
            ],
            errMsg: '',
            start_day: '',
            end_day: '',
            ftitle: '',
            ftext: '',
            suser: ''
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
        },
        leaveMouse(idx){
            let button = document.querySelector("#button"+idx)
            if(!this.isDows[idx])button.style.backgroundColor="white"
        },
        submitData(){
            let freq=0
            for (let i = 0; i < this.isDows.length; i++) {
                if(this.isDows[i]) freq+=Math.pow(2,this.isDows.length-i-1)
            }
            freq+=""
            let data = {
                start_day: this.start_day,
                end_day: this.end_day,
                ftitle: this.ftitle,
                ftext: this.ftext,
                suser: 1,
                freq: freq
            }
            this.axios.post("/feed/addTodo",data
            ).then(()=>{
                this.$emit("closeTodo")
            }).catch(()=>{
                this.errMsg = '에러가 발생하였습니다.\n 잠시후 재시도 부탁드립니다.'
            })
        }
    }
}
</script>
<style scoped>
input{
    padding: 5px 7px;
}
#ftitle{
    width: 90%;
    height: 2em;
    margin: 3px;
}
.ftitle-label{
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
#ftext{
    padding: 0.5em;
    width: 90%;
    height: 4em;
}
#errMsg {
    color: red;
}
</style>
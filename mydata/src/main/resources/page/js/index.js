function f1() {
    var data = new Date();
    document.getElementById("data").innerText=data.getFullYear()+"年"+data.getMonth()+"月"+
        data.getDay()+"日"+data.getHours()+"时"+data.getMinutes()+"分"+data.getSeconds()+"秒";

}
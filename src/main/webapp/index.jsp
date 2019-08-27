<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>用WebSocket实时获知系统参数</title>
</head>
<body>
<div align="center" style="color:darkblue;font-size:1.2em;margin-top:10px">当前系统参数</div>
<div align="center" style="color:blue;font-size:0.9em;margin-top:20px">当前时间： <span id="time" style="color: black">1</span></div>

<div style="position: relative;width:400px;margin:20px auto;border:1px solid lightgray;padding:20px;text-align:center;">
    <div align="center" style="color:darkblue;font-size:1.2em;margin-top:10px">CPU参数</div>
    <div style="color:blue;font-size:0.9em;margin-top:20px">CPU总使用率： <span id="combined" style="color: black">1</span> %</div>

</div>
<div style="position: relative;width:400px;margin:20px auto;border:1px solid lightgray;padding:20px;text-align:center;">
    <div align="center" style="color:darkblue;font-size:1.2em;margin-top:10px">内存参数</div>
    <div style="color:blue;font-size:0.9em;margin-top:20px">当前内存使用率： <span id="MemUsed_p" style="color: black">1</span> %</div>
    <div style="color:blue;font-size:0.9em;margin-top:20px">当前内存空闲率： <span id="MemFree_p" style="color: black">1</span> %</div>
</div>


</body>

<script type="text/javascript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/ws/monitorServer");

        //连接成功建立的回调方法
        websocket.onopen = function () {
            websocket.send("客户端链接成功");
        };

        //接收到消息的回调方法
        websocket.onmessage = function (event) {
            setMessageInnerHTML(event.data);
        };

        //连接发生错误的回调方法
        websocket.onerror = function () {
            alert("WebSocket连接发生错误");
        };

        //连接关闭的回调方法
        websocket.onclose = function () {
            alert("WebSocket连接关闭");
        };

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            closeWebSocket();
        };

    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        var server = eval("("+innerHTML+")");
        document.getElementById('combined').innerHTML = server.combined;
        document.getElementById('MemUsed_p').innerHTML = server.MemUsed_p;
        document.getElementById('MemFree_p').innerHTML = server.MemFree_p;
        document.getElementById('time').innerHTML = server.time;
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

</script>
</html>
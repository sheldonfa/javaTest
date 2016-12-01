<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>client1</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <script>
        $(function(){
            $("#test1").on("click",function(){
                var idList = new Array();
                idList.push("1");
                idList.push("2");
                idList.push("3");
                $.post("/mvc/client1/test1",{idList:idList})
            });
            $("#test2").on("click",function(){
                var id          =1;
                var username    ="fangxin";
                $.post("/mvc/client1/test2",{id:id,username:username,birthday:new Date()})
            });
            $("#test3").on("click",function(){
                var user = {
                    id:1,
                    username:"fangxin",
                    birthday:new Date(),
                    luckyNums:[1,2,3],
                    friends:[
                        {name:"zhangsan"},
                        {name:"lisi"}
                    ]
                };
                $.ajax({
                    type: "POST",
                    url:"/mvc/client1/test3",
                    data: JSON.stringify(user),
                    contentType:"application/json"
                })
            });
            $("#test4").on("click",function(){
                var user = {
                    id:1,
                    username:"fangxin",
                    birthday:new Date(),
                    luckyNums:[1,2,3],
                    friends:[
                        {name:"zhangsan"},
                        {name:"lisi"}
                    ]
                };
                var id  = 5;
                $.ajax({
                    type: "POST",
                    url:"/mvc/client1/test4/"+id,
                    data: JSON.stringify(user),
                    contentType:"application/json"
                })
            });
            $("#test5").on("click",function(){
                var users = [];
                for(var i=0;i<10;i++){
                    var user = {
                        id:1,
                        username:"fangxin",
                        birthday:new Date(),
                        luckyNums:[1,2,3],
                        friends:[
                            {name:"zhangsan"},
                            {name:"lisi"}
                        ]
                    };
                    users.push(user);
                }
                $.ajax({
                    type: "POST",
                    url:"/mvc/client1/test5/",
                    data: JSON.stringify(users),
                    contentType:"application/json"
                })
            });
            $("#test6").on("click",function(){
                var users = [];
                for(var i=0;i<10;i++){
                    var user = {
                        id:1,
                        username:"fangxin"
                    };
                    users.push(user);
                }
                $.ajax({
                    type: "POST",
                    url:"/mvc/client1/test6",
                    data: JSON.stringify(users),
                    contentType:"application/json"
                })
            });
            $("#test7").on("click",function(){
                var user = {
                    id:1,
                    username:"fangxin"
                };
                $.ajax({
                    type: "POST",
                    url:"/mvc/client1/test7",
                    data: JSON.stringify(user),
                    contentType:"application/json"
                })
            });
        })
    </script>
</head>
<body>
    <button id="test1">test1:简单类型list</button>
    <button id="test2">test2:简单对象</button>
    <button id="test3">test3:复杂对象</button>
    <button id="test4">test4:复杂对象+简单参数</button>
    <button id="test5">test5:复杂List</button>
    <button id="test6">test6:List&lt;Map&gt;</button>
    <button id="test7">test7:Map</button>
</body>
</html>

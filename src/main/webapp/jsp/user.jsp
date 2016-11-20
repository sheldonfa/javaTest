<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/9
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账交易系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <script>
        $(function(){
            $("#deal").on("click",function(){
                var friends = {};
                for(var i=0;i<5;i++){
                    friends[i] = "zhangsan"+i;
                }
                var params= {
                    username: "zhangsan",
                    friends: friends,
                    luckyNums: {1:"5",2:"4",3:"3"}
                };
                var url = "/springUser/getUser";
                $.ajax({
                    "async":true,
                    "type":"POST",
                    "url":url,
                    "data":params,
//                    "contentType":"application/json",
                    "success":function(data){
                        alert("交易成功")
                    },
                    "error" : function(data){
                    }
                });
            })
        })
    </script>
</head>
<body>
    <button id="deal">提交信息</button>
</body>
</html>

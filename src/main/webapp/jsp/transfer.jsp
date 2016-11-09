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
                var params= {cash:$("#cash").val(),fromId:10,toId:16};
                var url = "/transaction/transfer";
                $.ajax({
                    "async":true,
                    "type":"POST",
                    "url":url,
                    "data":params,
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
    张三先生转账<br>
    <input id="cash" type="text">元<br>
    给李四先生
    <br><br>
    <button id="deal">交易</button>
</body>
</html>

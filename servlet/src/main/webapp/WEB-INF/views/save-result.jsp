
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
servlet mvc로 성공!
<ul>
    <%--property 접근법으로 attribute에서 member object를 꺼내와 자동 캐스팅 후 getter로 가져 올 수 있음--%>
    <li>id:${member.id}</li>
    <li>username: ${member.username}</li>
    <li>age: ${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>

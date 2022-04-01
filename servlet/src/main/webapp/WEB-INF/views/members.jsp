<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %><%
  MemberRepository store = MemberRepository.getInstance();
  List<Member> members = store.findAll();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jsp 모든 멤버</title>
</head>
<body>
<table>
  <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
  </thead>
  <tbody>
  <c:forEach var="item" items="${members}">
    <tr>
      <td>${item.id}</td>
      <td>${item.username}</td>
      <td>${item.age}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="/index.html">메인</a>
</body>
</html>

<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %><%
  MemberRepository store = MemberRepository.getInstance();
  List<Member> members = store.findAllMembers();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <%
    for (Member member: members){
      out.write("<tr>");
      out.write("<td>" + member.getId() + "</td>");
      out.write("<td>" + member.getUsername() + "</td>");
      out.write("<td>" + member.getAge() + "</td>");
      out.write("</tr>");
    }
  %>
  </tbody>
</table>

</body>
</html>

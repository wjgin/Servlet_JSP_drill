<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  // jsp 로직 구간
    // request, response 는 사용 가능
    MemberRepository store = MemberRepository.getInstance();

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    store.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
jsp로 성공!
<ul>
    <li>id: <%=member.getId()%></li>
    <li>username: <%=member.getUsername()%></li>
    <li>age: <%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
‘[
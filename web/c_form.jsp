<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%--<c:redirect url="/student.do"/>--%>

<a href="<c:url value="/student.do"/>">TEST</a>


<c:url value="/teacher.do" var="link"/>
<a href="${link}">链接地址</A>

<!-- forToken标签 -->
<c:forTokens items="1-2-3" delims="-" var="item">
    <c:out value="${item}"/>
</c:forTokens>

<c:forEach var="i" begin="1" end="5">
    Item <c:out value="${i}"/><br/>
</c:forEach>


<%
    List<String> list = new ArrayList<String>();
    list.add("优秀");
    list.add("一般");
    list.add("差");
    request.setAttribute("list", list);
%>

<c:forEach var="item" items="${list}">
    <c:out value="${item}"></c:out>
</c:forEach>


<%--<c:import url="http://www.baidu.com" charEncoding="UTF-8"/>--%>
</body>
</html>
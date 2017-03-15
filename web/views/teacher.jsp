<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post">
    <table border="1">
        <tr align="center">
            <td width="100">姓名:</td>
            <td width="150"><form:input path="name"/></td>
        </tr>
        <tr align="center">
            <td>用户名:</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>所有错误信息:</td>
            <td><form:errors path="*"/></td>
        </tr>
        <tr>
            <td>Name的错误信息:</td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <style type="text/css">
        .yx {
            background-color: red;
        }
    </style>
</head>
<body>

<h2>Student Information</h2>

<form:form method="post">
    <form:errors path="name" cssClass="yx"/>
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">Age</form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>

        <tr>
            <td><form:label path="sex">sex</form:label></td>
            <td>
                <form:select path="sex">
                    <form:option value="nan">男</form:option>
                    <form:option value="nv">女</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="health">健康否</form:label></td>
            <td>
                <label><form:radiobutton path="health" value="0"/>Yes</label>
                <label><form:radiobutton path="health" value="1"/> No</label>
            </td>
        </tr>
        <tr>
            <td><form:label path="hobby">爱好</form:label></td>
            <td>
                <label><form:checkbox path="hobby[0]" value="java"/>java</label>
                <label><form:checkbox path="hobby[1]" value="php"/>php</label>
                <label><form:checkbox path="hobby[2]" value="css"/>css</label>
            </td>
        </tr>
        <tr>
            <td><form:label path="desc">个人简介</form:label></td>
            <td>
                <form:textarea path="desc"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
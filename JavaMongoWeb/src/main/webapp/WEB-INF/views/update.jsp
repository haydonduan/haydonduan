<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}" scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
    <form action="${context}/doupdate" method="post">
    <input type="hidden" name="_id" value="${p._id}">
	    <table>
	       <tr><td>name:</td><td><input type="text" name="name" value="${p.name}"></td></tr>
	       <tr><td>psw:</td><td><input type="password" name="password" value="${p.password}"></td></tr>
	       <tr><td><input type="submit" value="submit"></td></tr>
	    </table>
	    <span style="color:red">${tips}</span>
    </form>
    </center>
</body>
</html>
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
<a href="${context}/logout">logout</a><br><a href="${context}/update">更新</a><br>
    hello:${person.name}
    <br>
    用户有：
       <table border="1px">
        <tr><td>姓名</td><td>密码</td></tr>
            <c:forEach items="${personList}" var="person">
                <tr><td>${person.name}</td><td>${person.password}</td></tr>
            </c:forEach>
       </table><br>
       <c:if test="${pageBean.hasUpPage}">
                         <a href="${context}/detail/${pageBean.currentPage-1}">上一页</a>
         </c:if>
         <c:if test="${pageBean.hasNextPage}">
                        <a href="${context}/detail/${pageBean.currentPage+1}">下一页</a>
         </c:if>
 </center>
</body>
</html>
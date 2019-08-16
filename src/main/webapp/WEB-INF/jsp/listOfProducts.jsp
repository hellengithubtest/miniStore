<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" --%>
<html>
<body>
<font color=navy>
<h2>Welcome to mini Market!</h2>
<h3>List of items:</h3>
<c:forEach items="${list}" var="item">
              <tr>
                       <td><a href="/product/${item.productId}">${item.productName}</a></td><br>
                </tr>
            </c:forEach>
</body>
</html>

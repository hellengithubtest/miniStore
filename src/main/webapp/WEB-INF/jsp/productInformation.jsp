<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" --%>
<html>
  <head>
    <title>Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
   </head>
<body>
<h2>Description of product</h2>
            Product Id: <td>${product.productId}</td><br>
            Product Name: <td>${product.productName}</td><br>
            Product Cost: <td>${product.productCost}</td><br>

<div class = "col-md-9 col-md-push-3">
 <h2>Content</h2>
 <div class = "row">
  <div class = "col-sm-4">
 <div class = "panel">
 <h4>Header</h4>
 <img src = "index1.jpg" class = "img-responsive">
<p>fdhfdhfdhfd hdfhfdhfdhf hfdhfd fdhfdhfdhdf fdhfdhfdhhfd hfdhd</p>
 </div>
</div>
<script src="//code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

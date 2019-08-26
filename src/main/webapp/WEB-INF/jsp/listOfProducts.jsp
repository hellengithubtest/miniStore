<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<div class="row">
    <div class="col-4 col-md-3" >
        <!-- Search form -->
         <form class="form-inline md-form mr-auto mb-4">
            <input name="filter" class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn aqua-gradient btn-rounded btn-sm my-0" type="submit">Search</button>
         </form>
    </div>
</div>

<div class="main">
    <div class="col-md-3">

        <table>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td><a href="/product/${item.id}" class="btn btn-primary btn-lg btn-block" > ${item.name} </a></td>
                    <td><a href="/update/${item.id}" class="btn btn-outline-primary"> Edit </a></td>
                    <td><a href="/delete/${item.id}" class="btn btn-outline-primary"> Delete </a></td>
                </tr>
            </c:forEach>
                <tr>
                    <td><a href="./product/new" class="btn btn-outline-primary"> new product </a></td>
                </tr>
        </table>

            <c:choose>
                <%-- Show Prev as link if not on first page --%>
                <c:when test="${pages.getNumber}">
                  <span>Prev</span>
                </c:when>
                <c:otherwise>
                    <c:url value="/products/prev" var="url" />
                    <a href='<c:out value="${url}" />'>Prev</a>
                </c:otherwise>
            </c:choose>

            <c:forEach begin="0" end="${totalPages - 1}" step="1"  varStatus="tagStatus">
                <c:choose>
                    <%-- In PagedListHolder page count starts from 0 --%>
                    <c:when test="${(page) == tagStatus.index}">
                        <span>${tagStatus.index}</span>
                    </c:when>
                    <c:otherwise>
                        <c:url value="/products/${tagStatus.index}?filter=${filter}" var="url" />
                        <a href='<c:out value="${url}" />'>${tagStatus.index}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <%-- Show Next as link if not on last page --%>
                <c:when test="${pages.getTotalPages}">
                  <span>Next</span>
                </c:when>
                <c:otherwise>
                    <c:url value="/products/next" var="url" />
                    <a href='<c:out value="${url}" />'>Next</a>
                </c:otherwise>
            </c:choose>
    </div>
</div>
<footer class="page-footer font-small">
    <jsp:include page="footer.jsp"/>
</footer>
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
<form method="post">
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
                    <c:when test="${(pageable.getPageNumber()) == tagStatus.index}">
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
            </form>
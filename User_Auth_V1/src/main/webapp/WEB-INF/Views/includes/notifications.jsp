<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Display Message -->
<c:if test="${requestScope.error != null}">
    <div class="bg-danger text-center text-white rounded-3 p-3">
        ${requestScope.error}
    </div>
</c:if>
<!-- End Display Message -->


<!-- Display Message -->
<c:if test="${requestScope.success != null}">
    <div class="bg-success text-center text-white rounded-3 p-3">
        ${requestScope.success}
    </div>
</c:if>
<!-- End Display Message -->

<!-- Loop through List Of Errors -->
<c:if test="${requestScope.form_errors != null}">

    <div class="bg-danger text-white rounded-3 p-3">
        <c:forEach items="${requestScope.form_errors}" var="form_error">

            <c:if test="${form_error.value != null}">
                <li>${form_error.value}</li>
            </c:if>
        </c:forEach>
    </div>

</c:if>
<!-- End Of Loop through List Of Errors -->

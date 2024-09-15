<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="includes/header.jsp"/>

        <!-- Row -->
        <div class="row">
            <!-- Column: Text Content and Action Buttons -->
            <div id="column" class="col py-3 px-4">
                <h1 class="main-font text-white">Success</h1>
                <p class="lead text-light-grey">
                    ${requestScope.msg}
                </p>
                <!-- Action Buttons -->
                <a href="/sign-in" class="btn btn-lg bg-sea-green text-white main-font col-12"> Sign In</a>
                <!-- End Of Action Buttons -->
            </div>
            <!-- End Of Column: Text Content and Action Buttons -->

            <!-- Column: Image -->
            <div id="column" class="col">
                <img src="images/undraw_order_confirmed_re_g0if.svg" height="350" width="350" alt="user phone">
            </div>
            <!-- End Of Column: Image -->
        </div>
        <!-- End Of Row -->

 <jsp:include page="includes/footer.jsp"/>

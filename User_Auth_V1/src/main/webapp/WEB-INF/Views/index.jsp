<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>


   <jsp:include page="includes/header.jsp"/>

        <!-- Row -->
        <div class="row">
            <!-- Column: Text Content and Action Buttons -->
            <div id="column" class="col py-3 px-4">
                <h1 class="main-font text-white">Welcome</h1>
                <p class="lead text-light-grey">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Ratione voluptate, ex, aliquam eaque soluta nemo assumenda libero, 
                    sunt vero modi blanditiis? Alias maiores et fugiat eveniet inventore in.
                </p>

                <!-- Action buttons -->
                <div class="d-flex jus">
                    <a href="/sign-in" class="btn btn-lg bg-dark-purple text-white main-font me-3"> Sign In</a>
                    <a href="/sign-up" class="btn btn-lg bg-sea-green text-white main-font"> Sign Up</a>
                </div>
                <!-- End Of Action buttons -->

            </div>
            <!-- End Of Column: Text Content and Action Buttons -->

            <!-- Column: Image -->
            <div id="column" class="col">
                <img src="images/undraw_my_app_re_gxtj.svg" height="350" width="350" alt="user phone">
            </div>
            <!-- End Of Column: Image -->
        </div>
        <!-- End Of Row -->

<jsp:include page="includes/footer.jsp"/>
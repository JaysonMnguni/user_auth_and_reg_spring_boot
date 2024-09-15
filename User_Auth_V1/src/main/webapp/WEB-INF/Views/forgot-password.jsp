 <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>


   <jsp:include page="includes/header.jsp"/>
    <jsp:include page="includes/notifications.jsp"/>
        <!-- Row -->
        <div class="row">
            <!-- Column: Login form and Action Buttons -->
            <div id="column" class="col py-3 px-4">
                <h1 class="main-font text-white">Forgot Password</h1>
                <p class="lead text-light-grey">
                    Enter email below to reset your password.
                </p>

                <!-- Forgot Password Form -->
                <form action="/forgot-password" method="POST" data-bs-theme="dark">

                    <div class="form-floating mb-3" >
                        <input type="email" name="email" class="form-control form-control-lg bg-dark-purple border-0" id="floatingInput" placeholder="name@example.com">
                        <label class="form-text-purle" for="floatingInput">Email address</label>
                    </div>

                    <!-- Action buttons -->
                    <div class="my-3">
                        <!--<a href="sign-in.html" class="btn btn-lg bg-dark-purple text-white main-font me-3"> Sign In</a>-->
                        <button class="btn btn-lg bg-sea-green text-white main-font mb-2"> Submit</button>

                        <p class="text-light-grey">
                          <small>Back to <a href="/sign-in" class="text-link-green">Sign In</a></small>
                        </p>


                    </div>
                    <!-- End Of Action buttons -->
                </form>

            </div>
            <!-- End Of Column: Forgot Password form and Action Buttons -->

            <!-- Column: Image -->
            <div id="column" class="col">
                <img src="images/undraw_sign_up_n6im.svg" height="350" width="350" alt="user phone">
            </div>
            <!-- End Of Column: Image -->
        </div>
        <!-- End Of Row -->

<jsp:include page="includes/footer.jsp"/>
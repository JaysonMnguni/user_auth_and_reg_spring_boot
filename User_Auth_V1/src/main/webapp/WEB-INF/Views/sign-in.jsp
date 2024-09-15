<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>


   <jsp:include page="includes/header.jsp"/>
    <jsp:include page="includes/notifications.jsp"/>
        <!-- Row -->
        <div class="row">
            <!-- Column: Login form and Action Buttons -->
            <div id="column" class="col py-3 px-4">
                <h1 class="main-font text-white">Sign In</h1>
                <p class="lead text-light-grey">
                    Sign In below to access your account.
                </p>

                <!-- Login Form -->
                <form action="/sign-in" method="POST" data-bs-theme="dark">

                    <div class="form-floating mb-3" >
                        <input type="email" value="${form_data.email}" name="email" class="form-control form-control-lg bg-dark-purple border-0" id="email" placeholder="name@example.com">
                        <label class="form-text-purle" for="floatingInput">Email address</label>
                        <c:if test="${form_errors.containsKey('email')}">
                            <script type="text/javascript">
                                document.getElementById("email").classList.remove("border-0");
                                document.getElementById("email").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>
                    </div>
                    <div class="form-floating">
                        <input type="password"  name="password" class="form-control form-control-lg bg-dark-purple border-0" id="password" placeholder="Password">
                        <label class="form-text-purle" for="floatingPassword">Password</label>
                        <c:if test="${form_errors.containsKey('password')}">
                            <script type="text/javascript">
                                document.getElementById("password").classList.remove("border-0");
                                document.getElementById("password").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>
                    </div>

                    <!-- Action buttons -->
                    <div class="my-3">
                        <!--<a href="/sign-in" class="btn btn-lg bg-dark-purple text-white main-font me-3"> Sign In</a>-->
                        <button class="btn btn-lg bg-sea-green text-white main-font mb-2"> Sign In</button>

                        <p class="text-light-grey">
                          <small>Dont have an account? click  <a href="/sign-up" class="text-link-green">Sign Up</a> or <a href="/forgot-password" class="text-link-green">Forgot Password</a></small>
                        </p>
                        <small><a href="/" class="text-link-green">Back to home</a></small>
                    </div>
                    <!-- End Of Action buttons -->
                </form>

            </div>
            <!-- End Of Column: Login form and Action Buttons -->

            <!-- Column: Image -->
            <div id="column" class="col">
                <img src="images/undraw_authentication_re_svpt.svg" height="350" width="350" alt="user phone">
            </div>
            <!-- End Of Column: Image -->
        </div>
        <!-- End Of Row -->

<jsp:include page="includes/footer.jsp"/>

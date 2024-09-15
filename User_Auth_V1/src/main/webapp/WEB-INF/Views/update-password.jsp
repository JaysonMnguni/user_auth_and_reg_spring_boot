 <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>


   <jsp:include page="includes/header.jsp"/>
    <jsp:include page="includes/notifications.jsp"/>
        <!-- Row -->
        <div class="row">
            <!-- Column: Change Password Form and Action Buttons -->
            <div id="column" class="col py-3 px-4">
                <h1 class="main-font text-white">Update Password</h1>
                <p class="lead text-light-grey">
                    Fill in the form below to change your password.
                </p>

                <!-- Change Password Form  -->
                <form action="/app/update-password" method="POST"data-bs-theme="dark">

                    <!-- Form Floating -->
                    <div class="form-floating mb-3">
                        <input type="password" value="${requestScope.current_pass}" name="current" class="form-control form-control-lg bg-dark-purple border-0" id="current" placeholder="Password">
                        <label class="form-text-purle" for="floatingPassword">Currrent Password</label>
                        <c:if test="${form_errors.containsKey('current')}">
                            <script type="text/javascript">
                                document.getElementById("current").classList.remove("border-0");
                                document.getElementById("current").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>
                    </div>
                    <!-- End Of Form Floating -->

                    <!-- Form Floating -->
                    <div class="form-floating mb-3">
                        <input type="password" name="new_password" class="form-control form-control-lg bg-dark-purple border-0" id="new_password" placeholder="Password">
                        <label class="form-text-purle" for="floatingPassword">New Password</label>
                        <c:if test="${form_errors.containsKey('new_password')}">
                            <script type="text/javascript">
                                document.getElementById("new_password").classList.remove("border-0");
                                document.getElementById("new_password").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>
                    </div>
                    <!-- End Of Form Floating -->

                    <!-- Form Floating -->
                    <div class="form-floating mb-3">
                        <input type="password" name="confirm_password" class="form-control form-control-lg bg-dark-purple border-0" id="confirm_password" placeholder="Password">
                        <label class="form-text-purle" for="floatingPassword">Confirm Password</label>
                        <c:if test="${form_errors.containsKey('confirm_password')}">
                            <script type="text/javascript">
                                document.getElementById("confirm_password").classList.remove("border-0");
                                document.getElementById("confirm_password").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>
                    </div>
                    <!-- End Of Form Floating -->

                    <!-- Action buttons -->
                    <div class="my-3">
                        <!--<a href="sign-in.html" class="btn btn-lg bg-dark-purple text-white main-font me-3"> Sign In</a>-->
                        <button class="btn btn-lg bg-sea-green text-white main-font mb-2"> Submit</button>
                        <br>
                        <small><a href="/app/dashboard" class="text-link-green">Back</a></small>
                    </div>
                    <!-- End Of Action buttons -->
                </form>
                <!-- End Of Change Password Form  -->

            </div>
            <!-- End Of Column: End Of Change Password Form and Action Buttons -->

            <!-- Column: Image -->
            <div id="column" class="col">
                <img src="images/undraw_mobile_login_re_9ntv.svg" height="350" width="350" alt="user phone">
            </div>
            <!-- End Of Column: Image -->
        </div>
        <!-- End Of Row -->
 <jsp:include page="includes/footer.jsp"/>

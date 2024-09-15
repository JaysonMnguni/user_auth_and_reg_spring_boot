<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="includes/header.jsp"/>

        <jsp:include page="includes/notifications.jsp"/>
        <!-- Row -->
        <div class="row">
            <!-- Column: Login form and Action Buttons -->
            <div id="column" class="col py-3 px-4">
                <h1 class="main-font text-white">Sign Up</h1>
                <p class="lead text-light-grey">
                    Fill in the form below to create an account.
                </p>

                <!-- Login Form -->
                <form action="/sign-up" method="POST" data-bs-theme="dark">

                    <!-- Row: First name and Last name -->
                    <div class="row">
                        <!-- Column: first Name -->
                        <div id="column" class="col">
                            <div class="form-floating mb-3" >
                                <input type="text" value="${form_data.firstName}" name="first_name" class="form-control form-control-lg bg-dark-purple border-0" id="first_name" placeholder="name@example.com">
                                <label class="form-text-purle" for="floatingInput">First Name</label>
                            </div>
                        </div>
                        <c:if test="${form_errors.containsKey('firstName')}">
                            <script type="text/javascript">
                                document.getElementById("first_name").classList.remove("border-0");
                                document.getElementById("first_name").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>

                        <!-- End Of Column: first Name -->

                        <!-- Column: first Name -->
                        <div id="column" class="col">
                            <div class="form-floating mb-3" >
                                <input type="text" value="${form_data.lastName}" name="last_name" class="form-control form-control-lg bg-dark-purple border-0" id="last_name" placeholder="name@example.com">
                                <label class="form-text-purle" for="floatingInput">Last Name</label>
                            </div>
                        </div>

                        <c:if test="${form_errors.containsKey('lastName')}">
                            <script type="text/javascript">
                                document.getElementById("last_name").classList.remove("border-0");
                                document.getElementById("last_name").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>

                        <!-- End Of Column: first Name -->
                    </div>
                    <!-- End Of Row: First name and Last name -->

                    <div class="form-floating mb-3" >
                        <input type="email" value="${form_data.email}" name="email" class="form-control form-control-lg bg-dark-purple border-0" id="email" placeholder="name@example.com">
                        <label class="form-text-purle" for="floatingInput">Email address</label>
                    </div>
                        <c:if test="${form_errors.containsKey('email')}">
                            <script type="text/javascript">
                                document.getElementById("email").classList.remove("border-0");
                                document.getElementById("email").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>

                    <!-- Row: Password and Confirm -->
                    <div class="row">
                        <!-- Column: Password -->
                        <div id="column" class="col">
                            <div class="form-floating">
                                <input type="password" value="${form_data.password}" name="password" class="form-control form-control-lg bg-dark-purple border-0" id="password" placeholder="Password">
                                <label class="form-text-purle" for="floatingPassword">Password</label>
                            </div>  
                        </div>
                        <c:if test="${form_errors.containsKey('password')}">
                            <script type="text/javascript">
                                document.getElementById("password").classList.remove("border-0");
                                document.getElementById("password").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>
                        <!-- End Of Column: Password -->

                        <!-- Column: Confirm -->
                        <div id="column" class="col">
                            <div class="form-floating">
                                <input type="password" value="${form_data.confirm}" name="confirm" class="form-control form-control-lg bg-dark-purple border-0" id="confirm" placeholder="Password">
                                <label class="form-text-purle" for="floatingPassword">Confirm</label>
                            </div>  
                        </div>
                        <c:if test="${form_errors.containsKey('confirm')}">
                            <script type="text/javascript">
                                document.getElementById("confirm").classList.remove("border-0");
                                document.getElementById("confirm").classList.add("is-invalid", "border", "border-danger");
                            </script>
                        </c:if>
                        <!-- End Of Column: Confirm -->
                    </div>
                    <!-- End Of Row: Password and Confirm -->

                    <!-- Action buttons -->
                    <div class="my-3">
                        <!--<a href="sign-in.html" class="btn btn-lg bg-dark-purple text-white main-font me-3"> Sign In</a>-->
                        <button class="btn btn-lg bg-sea-green text-white main-font mb-2"> Sign Up</button>

                        <p class="text-light-grey">
                          <small>Already have an account? click  <a href="/sign-in" class="text-link-green">Sign In</a></small>
                        </p>
                        <small><a href="/" class="text-link-green">Back to home</a></small>
                    </div>
                    <!-- End Of Action buttons -->
                </form>

            </div>
            <!-- End Of Column: Login form and Action Buttons -->

            <!-- Column: Image -->
            <div id="column" class="col">
                <img src="images/undraw_my_password_re_ydq7.svg" height="350" width="350" alt="user phone">
            </div>
            <!-- End Of Column: Image -->
        </div>
        <!-- End Of Row -->

<jsp:include page="includes/footer.jsp"/>

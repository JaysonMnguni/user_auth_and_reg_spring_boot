<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="css/colors.css">
    <link rel="stylesheet" href="css/style.css">
    <title>${PageTitle}</title>

</head>
<body class="bg-dark-purple d-flex align-items-center">

    <!-- Main Container -->
    <div class="container rounded-3 p-5 col-9">
        <!-- Page Header -->
        <h1 class="main-font text-white">Dashboard</h1>
        <!-- End Of Page Header -->

        <!-- Card: Dashboard -->
        <div class="card bg-light-purle shadow-sm border-0 text-white border-0">
            <!-- Card Body -->
            <div class="card-body rounded-3 px-3">
                <!-- Row -->
                <div class="row d-flex align-items-center">
                    <!-- Column: Image -->
                    <div class="col">
                        <img src="images/undraw_secure_login_pdn4.svg" height="350" width="350" alt="user phone">
                    </div>
                    <!-- End Of Column: Image -->

                    <!-- Column: Text Content -->
                    <div class="col">
                        <div class="card bg-transparent border-0">
                            <!-- Card Body -->
                            <div class="card-body">
                                <h1 class="card-title main-font text-white">Welcome</h1>
                                <!-- Details Table -->
                                <table class="text-white">
                                    <tr><th>First Name</th><td class="text-end">${user.first_name}</td></tr>
                                    <tr><th>Last Name</th><td class="text-end">${user.last_name}</td></tr>
                                    <tr><th>Email</th><td class="text-end">${user.email}</td></tr>
                                </table>
                                <!-- End Of Details Table -->

                                <!-- Action buttons -->
                                <div class="d-flex my-3">
                                    <form action="/sign-out" method="POST">
                                        <button class="btn btn-lg bg-just-red text-white main-font me-3"> Sign Out</button>
                                    </form>
                                    <a href="/app/update-password" class="btn btn-lg bg-ocean-blue text-white main-font"> Update Password</a>
                                </div>
                                <!-- End Of Action buttons -->
                            </div>
                            <!-- End Of Card Body -->
                        </div>
                    </div>
                    <!-- End Of Column: Text Content -->
                </div>
                <!-- End Of Row -->
            </div>
            <!-- End Of Card Body -->
        </div>
        <!-- End Of Card: Dashboard -->

    </div>
    <!-- End Of Main Container -->


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
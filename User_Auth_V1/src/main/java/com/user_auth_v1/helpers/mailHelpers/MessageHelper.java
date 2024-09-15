package com.user_auth_v1.helpers.mailHelpers;

public class MessageHelper {


    public static String verifyAccountEmailBody(String token, String code){
        String url = "http://127.0.0.1:7001/verify-account?token=" +token+"&code="+code;


        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Verify Account</title>\n" +
                "    <style>\n" +
                "\n" +
                "        *{\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "        .secondary-font{\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "        }\n" +
                "\n" +
                "        /* Colors */\n" +
                "\n" +
                "        .bg-dark-purple{\n" +
                "            background-color: #252330;\n" +
                "        }\n" +
                "\n" +
                "        .bg-light-purle{\n" +
                "            background-color: #464559;\n" +
                "        }\n" +
                "\n" +
                "        .bg-sea-green{\n" +
                "            background-color: #48C9B0;\n" +
                "        }\n" +
                "\n" +
                "        .bg-ocean-blue{\n" +
                "            background-color: #00C7E2;\n" +
                "        }\n" +
                "\n" +
                "        .text-light-grey{\n" +
                "            color: #E6E6E6;\n" +
                "        }\n" +
                "\n" +
                "        .text-link-green{\n" +
                "            color: #A5E9DC;\n" +
                "        }\n" +
                "\n" +
                "        .form-text-purle{\n" +
                "            color: #6C6B77;\n" +
                "        }\n" +
                "\n" +
                "        .main-font{\n" +
                "            font-family: 'Cooper Black';\n" +
                "        }\n" +
                "\n" +
                "        .base-white{\n" +
                "            color: #fff;\n" +
                "        }\n" +
                "\n" +
                "        /* End Of Colors */\n" +
                "\n" +
                "\n" +
                "        /* Email Template Styling */\n" +
                "\n" +
                "        /* Body styling */\n" +
                "        body{\n" +
                "            height:  100vh;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        /* Main Container Styling */\n" +
                "        #main-container{\n" +
                "            padding: 15px 25px;\n" +
                "            height: auto;\n" +
                "            border-radius: 15px;\n" +
                "        }\n" +
                "\n" +
                "        #main-container .row{\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        \n" +
                "        }\n" +
                "\n" +
                "        #verify-btn{\n" +
                "            text-align: center;\n" +
                "            padding: 15px 5px;\n" +
                "            border-radius: 5px;  \n" +
                "            width: 100%;     \n" +
                "        }\n" +
                "        #verify-btn a{\n" +
                "            text-decoration: none;\n" +
                "            \n" +
                "        }\n" +
                "\n" +
                "        /* End Of Email Template Styling */\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"bg-dark-purple\">\n" +
                "\n" +
                "    <!-- Main Container -->\n" +
                "    <div id=\"main-container\" class=\"bg-light-purle\">\n" +
                "        <!-- Column: Text Content and Action Buttons -->\n" +
                "        <div id=\"column\" class=\"\">\n" +
                "            <h1 class=\"main-font base-white\">Verify Account</h1>\n" +
                "            <p class=\"secondary-font text-light-grey\" style=\"margin: 5px 0px; text-align: center;\">\n" +
                "                Click below to verify your account.\n" +
                "            </p>\n" +
                "            <br>\n" +
                "            <!-- Action Buttons -->\n" +
                "            <div id=\"verify-btn\" class=\"bg-sea-green\">\n" +
                "                <a  href=\""+url+"\" class=\"main-font base-white\"> Verify</a>\n" +
                "            </div>\n" +
                "            <!-- End Of Action Buttons -->\n" +
                "        </div>\n" +
                "        <!-- End Of Column: Text Content and Action Buttons -->\n" +
                "    </div>\n" +
                "    <!-- End Of Main Container -->\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }// END VERIFY EMAIL ACCOUNT EMAIL BODY METHOD.


    public static String forgotPasswordMailMessage(String token, String code, String password){
        String url = "http://127.0.0.1:7001/change-password?token=" +token+"&code="+code;

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Verify Account</title>\n" +
                "    <style>\n" +
                "\n" +
                "        *{\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "        .secondary-font{\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "        }\n" +
                "\n" +
                "        /* Colors */\n" +
                "\n" +
                "        .bg-dark-purple{\n" +
                "            background-color: #252330;\n" +
                "        }\n" +
                "\n" +
                "        .bg-light-purle{\n" +
                "            background-color: #464559;\n" +
                "        }\n" +
                "\n" +
                "        .bg-sea-green{\n" +
                "            background-color: #48C9B0;\n" +
                "        }\n" +
                "\n" +
                "        .bg-ocean-blue{\n" +
                "            background-color: #00C7E2;\n" +
                "        }\n" +
                "\n" +
                "        .text-light-grey{\n" +
                "            color: #E6E6E6;\n" +
                "        }\n" +
                "\n" +
                "        .text-link-green{\n" +
                "            color: #A5E9DC;\n" +
                "        }\n" +
                "\n" +
                "        .form-text-purle{\n" +
                "            color: #6C6B77;\n" +
                "        }\n" +
                "\n" +
                "        .main-font{\n" +
                "            font-family: 'Cooper Black';\n" +
                "        }\n" +
                "\n" +
                "        .base-white{\n" +
                "            color: #fff;\n" +
                "        }\n" +
                "\n" +
                "        /* End Of Colors */\n" +
                "\n" +
                "\n" +
                "        /* Email Template Styling */\n" +
                "\n" +
                "        /* Body styling */\n" +
                "        body{\n" +
                "            height:  100vh;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        /* Main Container Styling */\n" +
                "        #main-container{\n" +
                "            padding: 15px 25px;\n" +
                "            height: auto;\n" +
                "            border-radius: 15px;\n" +
                "        }\n" +
                "\n" +
                "        #main-container .row{\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        \n" +
                "        }\n" +
                "\n" +
                "        #verify-btn{\n" +
                "            text-align: center;\n" +
                "            padding: 15px 5px;\n" +
                "            border-radius: 5px;  \n" +
                "            width: 100%;     \n" +
                "        }\n" +
                "        #verify-btn a{\n" +
                "            text-decoration: none;\n" +
                "            \n" +
                "        }\n" +
                "\n" +
                "        /* End Of Email Template Styling */\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"bg-dark-purple\">\n" +
                "\n" +
                "    <!-- Main Container -->\n" +
                "    <div id=\"main-container\" class=\"bg-light-purle\">\n" +
                "        <!-- Column: Text Content and Action Buttons -->\n" +
                "        <div id=\"column\" class=\"\">\n" +
                "            <h1 class=\"main-font base-white\">Change Password</h1>\n" +
                "             <h3 class=\"base-white\">Your Temporary Password is: "+ password +"</h3>"+
                "            <p class=\"secondary-font text-light-grey\" style=\"margin: 5px 0px; text-align: center;\">\n" +
                "                Click below to change your password.\n" +
                "            </p>\n" +
                "            <br>\n" +
                "            <!-- Action Buttons -->\n" +
                "            <div id=\"verify-btn\" class=\"bg-sea-green\">\n" +
                "                <a  href=\""+ url +"\" class=\"main-font base-white\"> Change Password</a>\n" +
                "            </div>\n" +
                "            <!-- End Of Action Buttons -->\n" +
                "        </div>\n" +
                "        <!-- End Of Column: Text Content and Action Buttons -->\n" +
                "    </div>\n" +
                "    <!-- End Of Main Container -->\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }// END OF FORGOT PASSWORD EMAIL MESSAGE METHOD.

    public static String forgotPasswordRedirectMsg(){
        return "An email will be sent to the email address that you have provided if the email exists" +
                " please check your email and proceed with changing your password. ";
    }// END OF FORGOT PASSWORD REDIRECT MESSAGE METHOD.


}// END OD MESSAGE HELPER CLASS.

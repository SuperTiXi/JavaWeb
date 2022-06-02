<%--
  Created by IntelliJ IDEA.
  User: zhangtianxiang
  Date: 2022/6/2
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel = "stylesheet" type = text/css href = css/login.css>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

</head>

<body>

<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form id = "registerInfo" action="RegisterServlet" method="post">
            <h1>Create Account</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g" ></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in" ></i></a>
            </div>
            <span>or use your email for registration</span>
            <input type="text" placeholder="Name" id="name_Register" name = "name_Register"/>
            <input type="password" placeholder="Password" id="password_Register" name = "password_Register"/>
            <script>
                const msg =<%=request.getParameter("msg")%>;
                const name = <%=request.getParameter("name")%>
                if(msg!==null){
                    alert(msg)
                }
                else if(name!==null){
                    document.getElementById("name_Register").value = name;
                }
            </script>
            <button  id = "btn_Register">Sign Up</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form id = "loginInfo" action="LoginServlet" method="post">
            <h1>Sign in</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your account</span>
            <input type="text" placeholder="Name" id = "name_Login" name="name_Login" />
            <input type="password" placeholder="Password" id="password_Login" name = "password_Login"/>
            <script>
                const msg =<%=request.getParameter("msg")%>;
                const name = <%=request.getParameter("name")%>
                if(msg!==null){
                    alert(msg)
                }
                else if(name!==null){
                    document.getElementById("name_Login").value = name;
                }
            </script>
            <button id = "btn_Login">Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="js/login.js"></script>
</html>

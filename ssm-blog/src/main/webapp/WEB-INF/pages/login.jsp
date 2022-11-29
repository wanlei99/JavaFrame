<%--
  Created by IntelliJ IDEA.
  User: wanlei
  Date: 2022/11/18
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Wopop</title>
    <link href="../css/style_log.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" type="text/css" href="../css/userpanel.css">
    <link rel="stylesheet" type="text/css" href="../css/jquery.ui.all.css">

</head>

<body class="login" mycollectionplug="bind">
<div class="login_m">
    <form action="/user/login" method="post">
        <div class="login_logo"><img src="./Wopop_files/logo.png" width="196" height="46"></div>
        <div class="login_boder">
            <div class="login_padding" id="login_model">
                <h2>USERNAME</h2>
                <label>
                    <input type="text" id="username" class="txt_input txt_input2" value="Your name">
                </label>
                <h2>PASSWORD</h2>
                <label>
                    <input type="password" name="textfield2" id="userpwd" class="txt_input" value="******">
                </label>
                <p class="forgot"><a id="iforget" href="javascript:void(0);">Forgot your password?</a></p>
                <div class="rem_sub">
                    <div class="rem_sub_l">
                        <input type="checkbox" name="checkbox" id="save_me">
                        <%--                    <label for="checkbox">Remember me</label>--%>
                    </div>
                    <label>
                        <input type="submit" class="sub_button" name="button" id="button" value="SIGN-IN"
                               style="opacity: 0.7;">
                    </label>
                </div>
            </div>
        </div><!--login_boder end-->
    </form>
</div><!--login_m end-->
</body>
</html>

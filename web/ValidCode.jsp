<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("a").click(function () {
                //浏览器有缓存功能,不能提交相同请求
                $("img").attr("src","imgCode?date="+new Date());
                return false;
            })
        })
    </script>
</head>
<body>
${error }
<form action="/login" method="post">
    姓名：<input type="text" name="uname"/><br>
    密码：<input type="password" name="pwd"/><br>
    验证码：<input type="text" name="code"><img src="imgCode" alt=""> <a href="">看不清</a><br>
    <input type="submit" value="提交"/><input type="reset" value="重置"/>
</form>
</body>
</html>

<%--suppress ALL --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Регистрация</title>

    <link href="resources/css/regostration.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="resources/bootstrap/bootstrap-grid-3.3.1.min.css" />
</head>
<body>
<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon"></div>

    <form name="login-form" class="login-form" action="" method="post">

        <div class="header">
            <h1>Регистрация посетителей</h1>
            <span>Введите ваши данные для регистрации на сайте.</span>
        </div>

        <div class="content">
            <label>
                <input name="username" type="text" class="input username" value="Логин" onfocus="this.value=''" />
            </label>
            <label>
                <input name="password" type="password" class="input password" value="Пароль" onfocus="this.value=''"/>
            </label>
            <label>
                <input name="firstname" type="text" class="input firstname" value="Имя" onfocus="this.value=''"/>
            </label>
            <label>
                <input name="lastname" type="text" class="input lastname" value="Фамилия" onfocus="this.value=''"/>
            </label>
            <label>
                <input name="address" type="text" class="input address" value="Адрес" onfocus="this.value=''" />
            </label>
        </div>

        <div class="footer">
            <input type="submit" name="submit" value="Сохранить" class="button" />
            <input type="submit" name="submit" value="Регистрация" class="register" />
        </div>

    </form>
</div>
<div class="gradient"></div>
</body>
</html>

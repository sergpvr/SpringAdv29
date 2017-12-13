<html>
<head>
    <title>Login to Booking Service</title>
    <link rel="stylesheet" type="text/css"
          href="/spring-course-1.0-SNAPSHOT/resources/css/style.css" />
</head>

<body>
<div id="header">
    <H2>Login to Booking Service</H2>
</div>

<div id="content">

    <fieldset>
        <legend> User credentials </legend>
        <form name="f" action="login" method="post">
            <table>
                <tr><td>Username : </td><td><input type="text" name="username" /></td></tr>
                <tr><td>Password : </td><td><input type="password" name="password" /></td></tr>
                <#if error><tr><td colspan="2"> <span  style="color:red">username or password is incorrect</span> </td></tr> </#if>
                <tr><td colspan="2"><input type="submit" value="   Login   " /></td></tr>
            </table>
        </form>
    </fieldset>

</div>
</body>
</html>
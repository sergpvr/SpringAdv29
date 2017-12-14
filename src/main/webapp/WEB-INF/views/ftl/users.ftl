<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css"
          href="/spring-course-1.0-SNAPSHOT/resources/css/style.css" />
</head>

<body>
    <div id="header">
        <H2>Users</H2>
    </div>

    <div id="content">

        <fieldset>
            <legend>Add User</legend>
            <form name="user" action="addUser" method="post">
                <table>
                    <tr><td>Name : </td><td><input type="text" name="name" /></td></tr>
                    <tr><td>Email : </td><td><input type="text" name="email" /></td></tr>
                    <tr><td>Password : </td><td><input type="password" name="password" /></td></tr>
                    <tr><td>Birthday : </td><td><input type="date" name="birthday" /></td></tr>
                    <tr><td>Roles : </td><td><input type="text" name="roles"  value="REGISTERED_USER" placeholder="REGISTERED_USER,BOOKING_MANAGER,ADMIN"/></td></tr>
                    <tr><td colspan="2" align="right"><input type="submit" value="   Save   " /></td></tr>
                </table>
            </form>
        </fieldset>

        <br/>

        <table class="datatable" border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Birthday</th>
                <th>Roles</th>
                <th>Action</th>
            </tr>
            <#list model["userList"] as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${(user.birthday)!}</td>
                <td>${(user.roles)!}</td>
                <td><a href="deleteUser?userId=${user.id}">delete</a></td>
            </tr>
            </#list>
        </table>

    </div>
</body>
</html>
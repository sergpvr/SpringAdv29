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
                Name : <input type="text" name="name" />	<br/>
                Email : <input type="text" name="email" />	<br/>
                Birthday : <input type="date" name="birthday" />	<br/>
                <input type="submit" value="   Save   " />
            </form>
        </fieldset>

        <br/>

        <table class="datatable" border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Birthday</th>
                <th>Action</th>
            </tr>
            <#list model["userList"] as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${(user.birthday)!}</td>
                <td><a href="deleteUser?userId=${user.id}">delete</a></td>
            </tr>
            </#list>
        </table>

    </div>
</body>
</html>
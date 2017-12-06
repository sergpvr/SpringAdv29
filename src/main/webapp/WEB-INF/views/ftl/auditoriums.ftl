<html>
<head>
    <title>Auditoriums</title>
    <link rel="stylesheet" type="text/css"
          href="/spring-course-1.0-SNAPSHOT/resources/css/style.css" />
</head>

<body>
<div id="header">
    <H2>Auditoriums</H2>
</div>

<div id="content">

    <table class="datatable" border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>SeatsNumber</th>
            <th>VipSeats</th>
        </tr>
        <#list model["auditoriumList"] as auditorium>
            <tr>
                <td>${auditorium.id}</td>
                <td>${auditorium.name}</td>
                <td>${auditorium.seatsNumber}</td>
                <td>${auditorium.vipSeats}</td>
            </tr>
        </#list>
    </table>

</div>
</body>
</html>
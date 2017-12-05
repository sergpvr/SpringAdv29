<html>
<head>
    <title>Auditoriums</title>
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
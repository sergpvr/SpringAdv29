<html>
<head>
    <title>Booking Service</title>
    <link rel="stylesheet" type="text/css"
          href="/spring-course-1.0-SNAPSHOT/resources/css/style.css" />
</head>

<body>
<div id="header">
    <H2>Booking Service</H2>
</div>

<div id="content">

    <fieldset>
        <legend>Book Tickets</legend>
        <form name="booking" action="bookTickets" method="post">
            User : <select name="userId">
                    <#list  model["userList"] as user>
                    <option value="${user.id}">${user.name}  ${(user.email)!}</option>
                    </#list>
                </select>	  <br/>
            Event : <select name="eventId">
                    <#list  model["eventList"] as event>
                    <option value="${event.id}">${event.name} in the ${(event.auditorium.name)!} (${(event.auditorium.seatsNumber)!} seats including ${(event.auditorium.vipSeats)!} vip) at ${(event.dateTime)!}</option>
                    </#list>
                </select>	  <br/>
            Seats : <input type="text" name="seats" /> Example: 1,2,35 <br/>

             <input type="submit" value="   Book   " />
        </form>

    </fieldset>


    <br/>
    <div><b>Booked Tickets</b></div>
    <br/>
    <table class="datatable" border="1">
        <tr>
            <th>EventName</th>
            <th>Place</th>
            <th>DateTime</th>
            <th>Seats</th>
            <th>UserName</th>
            <th>Price</th>
        </tr>
        <#list model["ticketList"] as ticket>
        <tr>
            <td>${(ticket.event.name)!}</td>
            <td>${(ticket.event.auditorium.name)!}</td>
            <td>${(ticket.dateTime)!}</td>
            <td>${(ticket.seats)!}</td>
            <td>${(ticket.user.name)!} ${(ticket.user.email)!}</td>
            <td>${(ticket.price)!}</td>
        </tr>
    </#list>
    </table>

</div>
</body>
</html>
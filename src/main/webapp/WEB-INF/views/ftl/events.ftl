
<#macro listSelect selectName values>
<select name="${selectName}">
<#list values as elm>
<option value="${elm}">${elm}</option>
</#list>
</select>
</#macro>

<html>
<head>
    <title>Events</title>
</head>

<body>
<div id="header">
    <H2>Events</H2>
</div>

<div id="content">

    <fieldset>
        <legend>Add Event</legend>
        <form name="event" action="addEvent" method="post">
            Name* : <input type="text" name="name" />	<br/>
            Rate* :  <@listSelect "rate" model["rateValues"]/>	<br/>
            BasePrice : <input type="number" step="0.01" name="basePrice" />	<br/>
            DateTime : <input type="datetime-local" name="dateTime" step="600"/>	 <br/>
            Auditorium : <@listSelect "auditorium" model["auditoriumList"]/>	  <br/>
            <input type="submit" value="   Save   " />
        </form>
    </fieldset>

    <br/>

    <table class="datatable" border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Rate</th>
            <th>BasePrice</th>
            <th>DateTime</th>
            <th>Auditorium</th>
            <th>Action</th>
        </tr>
        <#list model["eventList"] as event>
        <tr>
            <td>${event.id}</td>
            <td>${event.name}</td>
            <td>${event.rate}</td>
            <td>${(event.basePrice)!}</td>
            <td>${(event.dateTime)!}</td>
            <td>${(event.auditorium.name)!}</td>
            <td><a href="deleteEvent?eventId=${event.id}">delete</a></td>
        </tr>
        </#list>
    </table>

</div>
</body>
</html>
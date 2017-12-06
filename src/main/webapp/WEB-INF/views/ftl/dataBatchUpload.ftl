<html>
<head>
    <title>Data Batch Upload</title>
    <link rel="stylesheet" type="text/css"
          href="/spring-course-1.0-SNAPSHOT/resources/css/style.css" />
</head>

<body>
<div id="header">
    <H2>Data Batch Upload Service</H2>
</div>

<div id="content">

    <fieldset>
        <legend>Upload data</legend>
        <form name="batchData" action="uploadDataFile" enctype="multipart/form-data" method="post">
            FileName :  <input type="file" name="file" id="file" />	<br/>
            <input type="submit" value="   Save   " />
        </form>
    </fieldset>

</div>
</body>
</html>
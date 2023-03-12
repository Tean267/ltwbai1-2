
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Murach's Java Servlets and JSP</title>
<link rel="stylesheet" href="Styles/main.css" type="text/css"/>
</head>
<body>
	<h1>Join our email list</h1>
	<p>To join our email list, enter your name and
	email address below.</p>
	<form action="emailList" method="post">
		<input type ="hidden" name="action" value="add">
		
		<label>Email:</label>
		<input type ="email" name="email"  ><br>
		<p> <i>${mess1}</i> </p>
			
		<label>First Name:</label>
		<input type ="text" name="firstName" value="${user.firstName}" ><br>
		<p> <i>${mess2}</i> </p>
		
		<label>Last Name:</label>
		<input type ="text" name="lastName" value="${user.lastName}"><br>
		<p> <i>${mess3}</i> </p>
		
		<label>I'm interested in these types of music:</label>
		<select name="musicTypes[]" multiple>
			<option value="Rock">Rock</option>
			<option value="Country">Country</option>
			<option value="Bluegrass">Bluegrass</option>
			<option value="Folk">Folk</option>
		</select><br>
		
		<label>&nbsp;</label>
		<input type="submit" value="Join Now" id="submit">
	</form>
</body>
</html>
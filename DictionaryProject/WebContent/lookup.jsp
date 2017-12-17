<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dictionary Application</title>
</head>
<body>

	<form action="lookup" method="post">
	
		<h1>Search dictionary</h1>
	
		<table cellpadding="5" cellspacing="5">
		
			<tr>
				<td><label>Enter word to search</label></td>
				<td><input type="text" name="word" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Search" /></td>
			</tr>
		
		</table>
		
		<span class="error">${messages.description}</span>
	
	</form>

</body>
</html>
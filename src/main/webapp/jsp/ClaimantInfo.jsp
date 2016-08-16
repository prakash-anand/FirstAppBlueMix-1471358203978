<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claimant Portal</title>
</head>
<body>
Claimant Portal<br>
<form action="/JsonServlet">			
			 Please enter your details<br>
			Name: <input type="text" name="color"size="20px"><br>
			Address: <textarea rows="4" cols="50" name="name"></textarea><br>
			Post Code: <input type="text" name="address"size="20px"><br>
			Interests: <textarea rows="4" cols="50" name="interests"></textarea><br>
			Remarks: <textarea rows="4" cols="50" name="remarks"></textarea><br>
			<input type="submit" value="submit">						
		</form>

</body>
</html>
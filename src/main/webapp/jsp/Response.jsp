<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claimant Response</title>
</head>
<body>
This is the response from Watson

<b>Weather: </b>
<%=(String)request.getAttribute("weatherPostcode")%><br><br>

<b>Personality Insight:</b><br>
<%=(String)request.getAttribute("personality")%>

</body>
</html>
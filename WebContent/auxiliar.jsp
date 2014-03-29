<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String e = request.getParameter("e");
%>
<body>
	<%
	if(e.compareTo("ActualizaCarro") == 0){
	%>
		<s:action name="MostrarCarrito" executeResult="true"/>
	<% 
	} else if(e.compareTo("MostrarLibros") == 0){
	%>
		<s:action name="MostrarLibros" executeResult="true"/>
	<% 
	} else if(e.compareTo("MostrarDiscos") == 0){	
	%>
		<s:action name="MostrarDiscos" executeResult="true"/>
	<% 
	} 
	%>

</body>
</html>
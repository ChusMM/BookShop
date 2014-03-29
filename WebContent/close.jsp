<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.identification.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cerrar Sesion</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="Contenido/style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="wrapper2">
			<div id="header">
					<div id="logo">
						<h1> LibyShop</h1>
					</div>
			</div>
			<div id="page">
				<div id="content">
						<div class="post">
						<h2 class="title">Cerrar sesión</h2>    
				
						<%
						String nombre = request.getParameter("login");
						String pass = request.getParameter("pass");
						session = request.getSession(false);
						Cliente cli = (Cliente)request.getSession().getAttribute("cliente");
						if(cli != null) {
								
							session.invalidate();
						%>
							Sesion cerrada.<br>
							<a href=index.jsp>Ir a Login</a>
						<%
						}
						else {
							out.print("Sesion caducada");
						%>
							<br>
							<a href=index.jsp>Ir a Login</a>
						<%}%>
						</div>
				</div>
			<div style="clear: both;">&nbsp;</div>
			</div>
		</div>
		<div id="footer">
			<p id="legal"> &copy; 2011 - 2012. Carlos Fernandez-Vegue, Fernando Garcia, Jose Maria Gutierrez, Jesus Manuel Muñoz</p>
		</div>
	</div>		
</body>
</html>
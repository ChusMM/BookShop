<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="domain.identification.Cliente" %>
<%@ page import="domain.identification.Carrito" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cerrar cuenta</title>
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
					<div id="menu">
						<ul>
							<%
								session = request.getSession(false);
								Carrito c = (Carrito)session.getAttribute("carrito");
							if(c != null) {%>
							<li><s:a href = "identify.jsp">Ir a inicio</s:a></li>
							<li><s:url id="url" action="MostrarLibros"></s:url>
							<s:a href="%{url}">Libros</s:a></li>		
							<li><s:url id="url" action="MostrarDiscos"></s:url>
							<s:a href="%{url}">Discos</s:a></li>	
							<li><s:url id="url" action="MostrarCarrito"></s:url>
							<s:a href="%{url}">Ver Carrito (<%= c.getNumero_Productos() %>)</s:a></li>		
							<li><a href="#">Acerca de</a></li>
							<%} %>					
						</ul>
					</div>
			</div>
			<div id="page">
				<div id="content">				
					<div class="post">
						<h2 class="title">Cerrar cuenta</h2>
                        	<div class="entry">
								<%
								session = request.getSession(false);
								Cliente cli = (Cliente)session.getAttribute("cliente");
								if(cli != null) { 
								%>
									Confima tu baja por favor.
									<s:form action="Darse_De_Baja">
									<s:submit value="Confirmar"/>
									</s:form>
								<%
								} else {
									out.print("Sesion caducada");
								%>
								<br>
								<a href=index.jsp>Ir a Login</a>
								<%}%>
							</div>
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
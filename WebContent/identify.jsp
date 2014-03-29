<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ page import="domain.identification.Carrito" %>
 <%@ page import="domain.identification.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido!</title>
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
						<%
						
						Cliente cli = (Cliente)request.getSession().getAttribute("cliente");
						if(cli != null) {%>
							Welcome <%= cli.getLogin() %><br>
							<a href="menu.jsp">Menú</a><br>
							<a href="close.jsp">Cerrar sesión</a><br>
							<a href="closeAccountForm.jsp">Darse de baja</a><br>
							<a href="modifyForm.jsp">Modificar cuenta</a><br><br>
							<%
								if(cli.isAdmin()){
							%>
								<a href="addProducto.jsp">Añadir producto a la base de datos</a>
							<%
								}
						}
						else { 
							out.print("Sesion caducada");
						%>
							<br>
							<a href=index.jsp>Ir a Login</a>
						<%}%>
					</div>
				</div>
				<div id="sidebar">
					<ul>
						<li>
							<h3>Enlaces de interes</h3>
			                    <ul>
		    	                    <li><a href="www.youtube.es">Youtube</a></li>
		                            <li><a href="www.facebook.es">Facebook</a></li>
		                            <li><a href="www.tuenti.com">Tuenti</a></li>
		                       </ul>
						</li>
		            </ul>			
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
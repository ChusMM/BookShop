<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ page import="domain.identification.Carrito" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sobre nosotros...</title>
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
							%>
		
							<li><s:url id="url" action="MostrarLibros"></s:url>
							<s:a href="%{url}">Libros</s:a></li>		
							<li><a href="#">Discos</a></li>
							<li><a href="#">Ver Carrito (<%= c.getNumero_Productos() %>)</a>
							<li><a href="aCercaDe.jsp">A cerca de</a><li>		
		
						</ul>
					</div>
			</div>
			<div id="page">
				<div id="content">
					<div class="post">
						<h3>Gracias por interesarte sobre nuestra organización!</h3>
<pre>										
	Desarrolladores:
	
		- Carlos Fernandez-Vegue
		- Fernando García
		- José María Gutiérrez
		- Jesús Manuel Muñoz
</pre>



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
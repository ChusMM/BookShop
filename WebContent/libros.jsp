<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "domain.identification.Articulo" %>
<%@ page import="domain.identification.Carrito" %>
<%@ page import="domain.identification.Cliente" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>libyShop:libros</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="Contenido/style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="Contenido/jquery/jquery-1.7.min.js"></script>
<script type="text/javascript" src="Contenido/jquery/jquery.poptrox-0.1.js"></script>
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
							<h2 class="title">Catálogo de libros</h2>
	                        	<div class="entry">
	                        	<%
								String nombre = request.getParameter("login");
								String pass = request.getParameter("pass");
								session = request.getSession(false);
								Cliente cli = (Cliente)request.getSession().getAttribute("cliente");
								if(cli != null) {%>
	                        		<div id="poptrox">

										<!-- start -->
									
										<ul id="gallery">                          
										
											<s:iterator id="lista_articulo" value="libros" status="it">
											   <tr>	
											   <s:form action="AddCarrito" namespace="/" theme="simple">																			   	 
											   	 <td><a href="<s:property value="foto"/>"><img src="<s:property value="foto"/>" WIDTH=140 HEIGHT=210 title="<s:property value="nombre"/>" ALIGN="LEFT" alt="Imagen no encontrada" /></a></td>
											     <td>Titulo del libro: <s:property value="nombre"/><br></td>
											     <td>Autor: <s:property value="autor"/><br></td>
											     <td>Fecha de publicacion: <s:property value="fecha"/><br></td>
											     <td>Numero de ejemplares: <s:property value="ejemplares"/><br></td>
											     <td>Precio: <s:property value="precio"/> Euros <br></td>
											     <td>Genero: <s:property value="categoria"/><br></td>											     
											     <td>Descripcion: <s:property value="descripcion"/><br><br></td>
											     <td>Cantidad: <s:textfield label="Cantidad" name="cant" size="4" value="1" /><br></td>
												 <td><s:hidden name="id"/></td>
											     <td><s:submit value=" Añadir carrito " align="left"/><br><br><br><br></td> 
											   </s:form>
											     
											   </tr>
											</s:iterator>
										
																																									
										</ul>
									
										<br class="clear" />
									
										<script type="text/javascript">
									
											$('#gallery').poptrox();
									
											</script>
									
										<!-- end -->									
									</div>
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

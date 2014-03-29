<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pago</title>
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
							<li><a href="identify.jsp">Inicio</a></li>		
							<li><s:url id="url" action="MostrarLibros"></s:url>
							<s:a href="%{url}">Libros</s:a></li>		
							<li><s:url id="url" action="MostrarDiscos"></s:url>
							<s:a href="%{url}">Discos</s:a></li>	
							<li><a href="#">A cerca de</a></li>					
						</ul>
					</div>
			</div>
			<div id="page">
					<div id="content">				
						<div class="post">						
							<h2 class="title">Sistema de pago</h2>
	                        	<div class="entry"> 
								<table border="0">
									<tr>
										<th>Pago con Tarjeta</th>
										<th>Pago con PayPal</th>
									</tr>
									<tr>
										<td>
											<s:form action="PagarConTarjeta" namespace="/" >	
												<s:textfield name="numeroDeTarjeta" label="Número de tarjeta" maxlength="16"/>
												<s:textfield name="mesCaducidad" label="Mes de caducidad" maxlength="2"/>
												<s:textfield name="anioCaducidad" label="Año de caducidad" maxlength="4"/>
												<s:textfield name="titular" label="Titular"/>	
												<s:textfield name="alumno" label="Alumno"/>
												<s:textfield name="precioTotal" label="Importe" readonly="true"/>
												<s:submit value=" Pagar "/>
											</s:form>
										</td>
										<td>
											<s:form action="PagarConPayPal" namespace="/" >	
												<s:textfield name="correoUsuario" label="Dirección de correo electrónico"/>
												<s:textfield name="pwd" label="Contraseña"/>					
												<s:textfield name="alumno" label="Alumno"/>
												<s:textfield name="precioTotal" label="Importe" readonly="true"/>
												<s:submit value="Pagar"/>
											</s:form>
										</td>
									</tr>											
									</table>
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
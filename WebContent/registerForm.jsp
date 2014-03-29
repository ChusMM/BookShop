<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de registro</title>
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
							<li><s:a href = "index.jsp">Ir a Login</s:a></li>
							<li><a href="#">Acerca de</a></li>					
						</ul>
					</div>
			</div>
			<div id="page">
				<div id="content">				
					<div class="post">
						<h2 class="title">Registro</h2>
                        	<div class="entry"> 
								<s:form action="Registro" namespace="/">
									<s:textfield label="Login" name="login" maxlength="20"/>
									<s:password label="Password" name="password" maxlength="30"/>
									<s:password label="Confirmar" name="password2" maxlength="30"/>
									<s:textfield label="Nombre" name="nombre" maxlength="30"/>
									<s:textfield label="Primer Apellido" name="ap1" maxlength="30"/>
									<s:textfield label="Segundo Apellido" name="ap2" maxlength="30"/>
									<s:textfield label="Direccion" name="direccion" maxlength="50"/>
									<s:textfield label="Telefono" name="telefono" maxlength="9"/>
									<s:textfield label="Correo" name="correo" maxlength="50"/>
									<s:textfield label="Codigo Postal" name="cp" maxlength="5"/>
									<s:textfield label="Pais" name="pais" maxlength="30"/>
									<s:textfield label="Fecha de Nacimiento" name="fecha" maxlength="10"/>
									<s:submit value="Aceptar"/>
								</s:form>
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
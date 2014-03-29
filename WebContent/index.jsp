<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
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
						<h2 class="title">Login</h2>

                                  <div class="entry"> 
                                    <s:form action="Login" namespace="/">
										<s:textfield label="Login" name="login" maxlength="10"/>
										<s:password label="Password"  name="password" maxlength="8"/>
										<s:submit value="Entrar"/>
									</s:form>
									<a href="registerForm.jsp">Create una cuenta nueva!</a>
                                  </div>
                                  
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


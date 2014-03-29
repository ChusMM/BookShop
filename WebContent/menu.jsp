<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.identification.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="Contenido/style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="Contenido/jquery/jquery-1.7.min.js"></script>
<script type="text/javascript" src="Contenido/jquery/jquery.slidertron-0.1.js"></script>

<script type="text/javascript" src="Contenido/jquery/jquery.poptrox-0.1.js"></script>

<style type="text/css">
	@import "Contenido/gallery.css";
</style>

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
							<h2 class="title">Tienda</h2>
	                        	<div class="entry"> 

									<%
										session = request.getSession(false);
										String nom = (String)session.getAttribute("log");
										if(nom == null) {
											out.print("Sesión caducada");
										} 
										else {
											out.print("Tienda");
										}
									%>
									
									<div id="gallery-bg">

										<div id="gallery-bgtop">
					
											<div id="gallery-bgbtm">
					
												<div id="foobar">
					
													<div class="navigation"> <a href="#" class="first">[ &lt;&lt; ]</a> &nbsp; <a href="#" class="previous">[ &lt; ]</a> &nbsp; <a href="#" class="next">[ &gt; ]</a> &nbsp; <a href="#" class="last">[ &gt;&gt; ]</a> </div>
					
													<div class="viewer">
					
														<div class="reel">
					
															<div class="slide"> <a href="index.jsp"> <img src="Contenido/images/img13.jpg" alt=""> </a> <span>Pichon.</span> </div>					
															<div class="slide"> <img src="Contenido/images/img14.jpg" alt=""> <span>Parrot.</span> </div>					
															<div class="slide"> <img src="Contenido/images/img15.jpg" alt=""> <span>Parrot.</span> </div>					
															<div class="slide"> <img src="Contenido/images/img16.jpg" alt=""> <span>Hummingbird.</span> </div>
					
														</div>
					
													</div>
					
												</div>
					
												<script type="text/javascript">
					
					
					
												$('#foobar').slidertron({
						
													viewerSelector:			'.viewer',
						
													reelSelector:			'.viewer .reel',
						
													slidesSelector:			'.viewer .reel .slide',
						
													navPreviousSelector:	'.previous',
						
													navNextSelector:		'.next',
						
													navFirstSelector:		'.first',
						
													navLastSelector:		'.last'
						
												});
					
											
					
												</script>
					
												<!-- end -->
					
											</div>
					
										</div>
					
									</div>								
									<!-- end -->
									
							</div>
					</div>
					<div class="post">
							<h2 class="title">Tienda</h2>
	                        	<div class="entry"> 
	                        		<div id="poptrox">

										<!-- start -->
									
										<ul id="gallery">
									
											<li><a href="Contenido/images/img01_big.jpg"><img src="Contenido/images/img001.jpg" title="Esto es la polla" alt="" /></a></li>
											<li><a href="Contenido/images/img02_big.jpg"><img src="Contenido/images/img002.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
											<li><a href="Contenido/images/img03_big.jpg"><img src="Contenido/images/img003.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
											<li><a href="Contenido/images/img04_big.jpg"><img src="Contenido/images/img004.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
											<li><a href="Contenido/images/img02_big.jpg"><img src="Contenido/images/img002.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
											<li><a href="Contenido/images/img01_big.jpg"><img src="Contenido/images/img001.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
											<li><a href="Contenido/images/img04_big.jpg"><img src="Contenido/images/img004.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
											<li><a href="Contenido/images/img03_big.jpg"><img src="Contenido/images/img003.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
									
										</ul>
									
										<br class="clear" />
									
										<script type="text/javascript">
									
											$('#gallery').poptrox();
									
											</script>
									
										<!-- end -->
									
									</div>
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
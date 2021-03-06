<%@ include file="header.jsp" %>

<% if (ub == null || !(ub.getTipo().equals("gestore"))) { %>
		<h3 class="red" style="font-family:avenir" align="center">Accedi come gestore</h3>
	<% } else { %>

<!-- Jumbotron -->
<div class="jumbotron" id = "jumbotron_login">
	<div class="container text-center my_satisfy">
		<h1>Area personale</h1>
	</div>
</div>
<!-- ./Jumbotron -->
	
<!-- Personal status -->
<div class="container my_avenir">
	<div class="row">
		<div class="col-md-12">

			<%
				Boolean message = (Boolean) request.getAttribute("message");
				if (message != null) {
			%>
					<div class="alert alert-success">
						<strong>Successo!</strong> I dati dell'attivit� sono stati modificati.
					</div>
			 <% } %>
			<h1 class ="dark_brown" style="font-family: satisfy">Bentornato <strong><span class ="light_brown"><%=ub.getNome() %></span></strong></h1>
			<a href="modificaDatiAttivita.jsp">Modifica dati attivit�</a>
			<br>
			<a href="getmenus">Gestione men�</a>
			<br>
			<a href="GetCamerieri">Gestione cameriere</a>
			<br>
			<a href="VisualizzaPrenotazioni">Visualizza prenotazioni</a>
			<br>
			<a href="visualizzaBilancio.jsp">Visualizza bilancio</a>
	
		</div>
	</div>
</div>
<% } %>
<br>
<br>
<!-- ./Personal status -->

<%@ include file="footer.jsp" %>
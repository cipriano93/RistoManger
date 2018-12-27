<%@ include file="heading.jsp" %>

<!-- Breadcrumb -->
<nav aria-label="breadcrumb">
 	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="">Home</a></li>
		<li class="breadcrumb-item active" aria-current="page">Gestione portata</li>
	</ol>
</nav>
<!-- ./Breadcrumb -->

<div class="container">
	<h3 class="dark_brown">Gestione portata</h3>
	<hr/>
</div>

<!-- Tabella portata -->
<div class="container">
	<div align="center">
		Mený "mare"<a href="modificaNomeMený.jsp">rinomina</a>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>Portata</th>
				<th>Modifica/Rimuovi</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Portata 1</td>
				<td>
					<a href="#" class="btn btn-default">Modifica</a>
					<a href="#" class="btn btn-danger">Rimuovi</a>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- ./Tabella portata -->

<%@ include file="footer.jsp" %>
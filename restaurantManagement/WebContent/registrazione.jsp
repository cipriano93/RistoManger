<%@ include file="header.jsp" %>

<% if (ub != null) { %>
	<div align="center">
		<h3 class = "red" style="font-family:avenir">Effettua il logout per registrarti</h3>
		<a href="Logout" class="btn btn-default btn-lg">Logout</a>
	</div>
<% } else { %>
	
	 <!-- Validation -->
	 <script>
  	  function verify(errore){
  	  		document.getElementById("ver").innerHTML = errore;
  	  }	
      function validateForm(){
        var name = document.form1.name;
        var surname = document.form1.surname;
        var username = document.form1.usr;
        var password = document.form1.pwd; 
        var passwordConfirm = document.form1.pwd_confirm; 
        
        if(validationName(name) && validationSurname(surname) && validationUsername(username) && validationPassword(password) && validationConfirmPassword(passwordConfirm, password)){
          	return true;
        } else {
         	return false;
        }
      }
      function validationName(name){
  	  	var nameformat = /^[A-Z a-z]{3,}$/;
    		if(name.value.match(nameformat)){
      		return true;
      	}else {
      		verify("Inserire correttamente il nome");
         	name.focus();
         	return false;
      	}
	   }
   	  function validationSurname(surname){
	  	var surnameformat = /^[A-Za-z]{3,}$/;
 	 	if(surname.value.match(surnameformat)){
    			return true;
   	 	}else {
    			verify("Inserire correttamente il cognome");
      	 	surname.focus();
       		return false;
    		}
	   }
   	  function validationUsername(username) {
   	  	var username_format=/^[0-9a-zA-Z]{3,}$/;
   		if (username.value.match(username_format))
   			return true;
   		else {
   			verify("Inserire correttamente la username");
   			username.focus();
   			return false;
   		}
   	  }
      function validationPassword(password){
    	  	var passwordformat = /^[A-Za-z0-9]{5,}$/;
        if(password.value.match(passwordformat)){
      	  	return true;
        }else {
	    		verify("Inserire correttamente la password");
         	password.focus();
         	return false;
        }
      }
      function validationConfirmPassword(confirmPassword, password){
        if(confirmPassword.value == password.value){
      	  	return true;
        }else {
        		verify("Le due password devono coincidere");
         	confirmPassword.focus();
         	return false;
        }
      }
     
    </script>
	<!-- ./Validation -->
	
	<!-- Breadcrumb -->
<nav aria-label="breadcrumb">
 	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="">Home</a></li>
		<li class="breadcrumb-item active" aria-current="page">Registrazione</li>
	</ol>
</nav>
<!-- ./Breadcrumb -->

	<div class="container my_avenir">
	  <h3 style="font-family: satisfy">Crea un account personale</h3>
	  <hr/>
		<%
			Boolean message = (Boolean) request.getAttribute("message");
			if (message != null) { 
		%>
				<div class="alert alert-danger">
	  				<strong>Errore!</strong> Username gi� utilizzata. Inserire un'altra username.
				</div>
		<% } %>
	
	<!-- Signup form -->
	   	<form  name ="form1" action="Registrazione" method="POST" onsubmit ="return validateForm()">
	 	 	<div class="row">
	 	 		<div class="col-sm-6">
			 	 	<div class="form-group">
			      		<label class ="dark_brown" for="name">Nome:</label>
			      		<input type="text" class="form-control light_brown" name="name">
			    	</div>
			    </div>
			    <div class="col-sm-6">
			    	<div class="form-group">
			      		<label class ="dark_brown" for="surname">Cognome:</label>
			      		<input type="text" class="form-control light_brown" name="surname">
			    	</div>
			    </div>
		    </div>
	    	<div class="form-group">
	      		<label class ="dark_brown" for="email">Username:</label>
	      		<input type="text" class="form-control light_brown" name="usr">
	    	</div>
	    	<div class="row">
	    		<div class="col-sm-6">
			    	<div class="form-group">
				    	<label class ="dark_brown" for="pwd">Password:</label>
				     	<input type="password" class="form-control light_brown" name="pwd">
			    	</div>
			    </div>
			    <div class="col-sm-6">
			    	<div class="form-group">
				    	<label class ="dark_brown" for="pwd_confirm">Conferma password:</label>
				     	<input type="password" class="form-control light_brown" name="pwd_confirm">
			    	</div>
			    </div>
		    </div>
			<button type="submit" class="btn btn-primary">Crea account</button>
		</form>		
		<p id="ver" class ="red" ></p>
	<!-- ./Singup form -->
	</div>
	
	<% } %>
	
	<br>
	<br>
	
<%@ include file="footer.jsp" %>
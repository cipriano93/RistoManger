<%@ include file="header.jsp" %>	
	 <!-- Validation -->
	 <script>
  	  function verify(errore) {
  	  		document.getElementById("ver").innerHTML = errore;
  	  }
  	  
      function validateForm() {
        var name = document.form.name;
        var surname = document.form.surname;
        var email = document.form.email;
        var password = document.form.pwd; 
        var passwordConfirm = document.form.pwd_confirm; 
        
        if(validationName(name) && validationSurname(surname) && validationEmail(email) && validationPassword(password) && validationConfirmPassword(passwordConfirm, password)){
          	return true;
        } else {
         	return false;
        }
      }
      
      function validationName(name) {
  	  	var nameformat = /^[A-Z a-z]{3,}$/;
    		if(name.value.match(nameformat)){
      		return true;
      	} else {
      		verify("Inserire correttamente il nome");
         	name.focus();
         	return false;
      	}
	  }
      
   	  function validationSurname(surname) {
	  	var surnameformat = /^[A-Za-z]{3,}$/;
 	 	if(surname.value.match(surnameformat)){
    			return true;
   	 	} else {
    			verify("Inserire correttamente il cognome");
      	 	surname.focus();
       		return false;
    	}
	  }
   	  
      function validationPassword(password) {
    	  	var passwordformat = /^[A-Za-z0-9]{5,}$/;
        if(password.value.match(passwordformat)){
      	  	return true;
        } else {
	    		verify("Inserire correttamente la password");
         	password.focus();
         	return false;
        }
      }
   	  
      function validationConfirmPassword(confirmPassword, password) {
        if(confirmPassword.value == password.value){
      	  	return true;
        } else {
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
		<li class="breadcrumb-item active" aria-current="page">Modifica cameriere</li>
	</ol>
</nav>
<!-- ./Breadcrumb -->

	<div class="container">
	  <h3>Modifica cameriere</h3>
	  <hr/>
	</div>
	
	<!-- Modifica cameriere form -->
	<div class="container">
	   		<form  name="form" action="" method="POST" onsubmit="return validateForm()">
	 	 		<div class="row">
	 	 			<div class="col-sm-6">
			 	 		<div class="form-group">
			      			<label class="dark_brown" for="name">Nome:</label>
			      			<input type="text" class="form-control light_brown" name="name">
			      			<span id="ver" class="red"></span>
			    		</div>
			    	</div>
			    	<div class="col-sm-6">
			    		<div class="form-group">
			      			<label class ="dark_brown" for="surname">Cognome:</label>
			      			<input type="text" class="form-control light_brown" name="surname">
			      			<span id="ver" class="red"></span>
			    		</div>
			    	</div>
		    	</div>
	    		<div class="form-group">
	      			<label class="dark_brown" for="email">Username:</label>
	      			<input type="email" class="form-control light_brown" name="username">
	      			<span id="ver" class ="red"></span>
	    		</div>
	    		<div class="row">
	    			<div class="col-sm-6">
			    		<div class="form-group">
				    		<label class="dark_brown" for="pwd">Password:</label>
				     		<input type="password" class="form-control light_brown" name="pwd">
				     		<span id="ver" class="red"></span>
			    		</div>
			    	</div>
			    	<div class="col-sm-6">
			    		<div class="form-group">
				    		<label class="dark_brown" for="pwd_confirm">Conferma password:</label>
				     		<input type="password" class="form-control light_brown" name="pwd_confirm">
				     		<span id="ver" class="red"></span>
			    		</div>
			    	</div>
		    	</div>
				<button type="submit" class="btn btn-primary">Modifica cameriere</button>
			</form>	
	</div>
	<br>
	<br>
	<!-- ./Modifica cameriere form -->
	
<%@ include file="footer.jsp" %>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://vdab.be/tags' prefix='v' %>
<!doctype html>
<html lang='nl'>
<v:head title="artikel toevoegen"/>
<body>
<v:menu/>
<h1>Artikel toeveogen</h1>
<form method='post' id='toevoegform'>
<label>Naam:<br><input name='naam' value='${param.naam}'autofocus required></label><br>
<label>Aankoopprijs:<br><input name='aankoopprijs' value='${param.aankoopprijs}' type="number" required min=0 step=0.01></label><br>
<label>Verkoopprijs:<br><input name='verkoopprijs' value='${param.verkoopprijs}' type="number" required min=0 step=0.01></label><br>

<button type="submit" id="toevoegknop">toevoegen</button><br><br>

<input type="radio" id="food" name="type" value="food"><label for="type">Food</label><br>
Houdbaarheid:<br>
<input name="houdbaarheid" id="houdbaarheid"  type="number" step="1"><br>
<input type="radio" id="nonfood" name="type" value="nonfood"><label for="type">Non-food</label><br>
Garantie:<br>
<input id="garantie" name="garantie" type="number" step="1">
</form>
<span id="foutje"></span>
<script>
document.getElementById('toevoegknop').onclick = function(event) {
	
	event.preventDefault();
	if(document.getElementById('houdbaarheid').value.length == 0 && document.getElementById('garantie').value.length == 0){
		
		document.getElementById("foutje").textContent = "vul houdbaarheid/garantie in";
		
		
	}else{
		console.log("hier");
		document.getElementById('toevoegform').submit();
		
	}
	
	

};

document.getElementById('food').onclick = enableDisableInputs;
document.getElementById('nonfood').onclick = enableDisableInputs; 
enableDisableInputs(); 

function enableDisableInputs() {   
	document.getElementById('houdbaarheid').disabled = ! document.getElementById('food').checked;   
	document.getElementById('garantie').disabled = ! document.getElementById('nonfood').checked;  
	} 

</script>
</body>
</html>
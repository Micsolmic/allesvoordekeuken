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

<button type="submit" id="toevoegknop">toevoegen</button>
</form>
<script>
document.getElementById('toevoegform').onsubmit = function() {
document.getElementById('toevoegknop').disabled = true;
};
</script>
</body>
</html>
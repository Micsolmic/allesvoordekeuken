<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v' %>
<!doctype html>
<html lang='nl'>
<v:head title="zoeken op nummer"/>
<body>
<v:menu/>
<h1>Artikel zoeken</h1>
<form>
<label>Artikelnummer:<span>${fouten.id}</span>
<input name='id' value='${param.id}'
required autofocus type='number' min='1'></label>
<input type='submit' value='Zoeken'>
</form>
<c:if test='${not empty param and empty fouten and empty artikel}'>
<br>Artikel niet gevonden
</c:if>
<br>
<c:if test='${not empty artikel}'>
product: ${artikel.naam}, aankoopprijs: &euro; <fmt:formatNumber value='${artikel.aankoopprijs}'/>
, verkoopprijs: &euro; <fmt:formatNumber value='${artikel.verkoopprijs}'/>

winst: <fmt:formatNumber value='${(artikel.verkoopprijs - artikel.aankoopprijs)/artikel.aankoopprijs*100}'/>%


</c:if>
</body>
</html>



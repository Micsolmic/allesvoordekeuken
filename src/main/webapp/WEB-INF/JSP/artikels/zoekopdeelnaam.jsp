<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v' %>
<!doctype html>
<html lang='nl'>
<v:head title="zoeken op sleutelwoord"/>
<body>
<v:menu/>
<h1>Zoek artikel op sleutelwoord</h1>
<form>
<label>sleutelwoord: <input type=text name="deelnaam" value=${param.deelnaam}></label>
<button type='submit'>Zoek</button>

</form>
<br>
<c:if test='${empty lijstRecords and not empty param.deelnaam}'>
Geen producten voor gekozen sleutelwoord
</c:if>
<br>
<c:if test='${not empty lijstRecords}'>

<c:forEach var='record' items='${lijstRecords}'>

<table id="artikelsOpDeelnaam">

<thead>
<tr>
<th>Naam</th><th>Aankoopprijs</th><th>Verkoopprijs</th><th>Winst</th>
</tr>
</thead>
<tr>
<td>${record.naam}</td>
<td>&euro;<fmt:formatNumber value='${record.aankoopprijs}' maxFractionDigits='2'/></td>
<td>&euro;<fmt:formatNumber value='${record.verkoopprijs}' maxFractionDigits='2'/></td>
<td>&euro;<fmt:formatNumber value='${(record.verkoopprijs - record.aankoopprijs)/record.aankoopprijs * 100}' maxFractionDigits='2'/> %</td>

</tr>

</table>





</c:forEach> 


</c:if>
</body>
</html>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Kortingen' />

</head>
<body>
	<v:menu />
	<h1>Kortingen</h1>
	
	<c:if test='${empty artikels}'>
	
	<p>Geen artikels gevonden</p>
	
	</c:if>
	
	
	<c:if test='${not empty artikels}'>
	
	<c:forEach var='art' items='${artikels}'>
	
	<c:url value='/artikels/kortingen.htm' var='url'><c:param name="artId" value="${art.id}"/></c:url>
	
	<c:set value='' var='bold'/>
	
	<c:if test='${art.id == param.artId}'>
	<c:set value='bold' var='bold'/>
	</c:if>
	
	<a href='${url}' class='${bold}'>${art.naam}</a><br><br>
	
	</c:forEach>
	</c:if>
	
	<c:if test='${not empty detailartikel}'>
	
	<h2>Uw voordeel</h2>
	<ul>
	<li>
	<c:forEach var='korting' items='${detailartikel.kortingen}'>
	
	Aantal: ${korting.vanafAantal} Percentage: -${korting.kortingsPercentage}<br><br>
	</c:forEach>
	</li>
	<li>
	
	</li>
	</ul>	
	
	</c:if>
	
	
</body>
</html>
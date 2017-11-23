<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html>
<head>
<title>Welkom beginpagina</title>
<link rel="stylesheet" href='<c:url value="/styles/rules.css"/>'/>
</head>
<body>

<ul>

<li><a href='<c:url value="/artikels/zoekenopnummer.htm"/>'>Artikel zoeken op nummer</a></li>
<li><a href='<c:url value="/artikels/toevoegen.htm"/>'>Artikel toevoegen</a></li>
<li><a href='<c:url value="/artikels/zoekenopnaam.htm"/>'>Artikels zoeken op naam</a></li>
<li><a href='<c:url value="/artikels/prijsverhoging.htm"/>'>Prijsverhoging</a></li>
<li><a href='<c:url value="/artikels/kortingen.htm"/>'>Artikelkortingen</a></li>
<li><a href='<c:url value="/artikels/perartikelgroep.htm"/>'>Artikels per artikelgroep</a></li>


</ul>


<img src='<c:url value="/images/logo2.jpg"/>'>


</body>
</html>
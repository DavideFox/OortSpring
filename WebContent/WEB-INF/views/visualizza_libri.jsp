<%@page import="it.beije.oort.lauria.biblioteca.JPADBtools"%>
<%@page import="it.beije.oort.lauria.biblioteca.entity.Libro"%>
<%@page import="it.beije.oort.lauria.biblioteca.entity.Autore"%>
<%@page import="it.beije.oort.lauria.biblioteca.entity.Editore"%>
<%@page import="it.beije.oort.lauria.biblioteca.entity.Utente"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
	</style>
<meta charset="ISO-8859-1">
<title>Oort Biblioteca</title>
</head>
<body>
<h3>${utente.nome} ${utente.cognome}</h3>
<c:if test = "${utente == null}">
	<a href="./home_biblio">HOME</a><br>
</c:if>
<c:if test = "${utente != null}">
	<a href="./conferma_login">HOME</a><br>
</c:if>	 

<table>
	<h2>Sono presenti ${libri.size()} libri in biblioteca</h2>
	
<c:if test = "${!utente.isAdmin()}">

		<tr>
			<th>Id</th>
			<th>Titolo</th>
			<th>Descrizione</th>
			<th>Id_autore</th>
			<th>Id_editore</th>
			<th>Anno</th>
		</tr>

	<c:forEach items="${libri}" var="libro">
		<tr>
			<td>${libro.getId()}</td>
			<td>${libro.getTitolo()}</td>
			<td>${libro.getDescrizione() != null ? libro.getDescrizione() : ""}</td>
			<td>${libro.getId_autore()} (${autori.get(libro.getId_autore()-1).getNome()} ${autori.get(libro.getId_autore()-1).getCognome()})</td>
			<td>${libro.getId_editore()} (${editori.get(libro.getId_editore()-1).getDenominazione()})</td>
			<td>${libro.getAnno()}</td>
		</tr>
	</c:forEach>

</c:if>

<c:if test = "${utente.isAdmin()}">	

		<tr>
			<th>Mod.</th>
			<th>Canc.</th>
			<th>Id</th>
			<th>Titolo</th>
			<th>Descrizione</th>
			<th>Id_autore</th>
			<th>Id_editore</th>
			<th>Anno</th>
		</tr>
		
	<c:forEach items="${libri}" var="libro">
		<tr>
			<td>&#9999;</td>
			<td>&#128465</td>
			<td>${libro.getId()}</td>
			<td>${libro.getTitolo()}</td>
			<td>${libro.getDescrizione() != null ? libro.getDescrizione() : ""}</td>
			<td>${libro.getId_autore()} (${autori.get(libro.getId_autore()-1).getNome()} ${autori.get(libro.getId_autore()-1).getCognome()})</td>
			<td>${libro.getId_editore()} (${editori.get(libro.getId_editore()-1).getDenominazione()})</td>
			<td>${libro.getAnno()}</td>
		</tr>
	</c:forEach>
<%-- 	<%
		for (Libro libro : libri) {
		// potrei inserire autore ed editore come ho fatto nelle JPADBtools e scriverli fra parentesi affianco a numero id
	%>

		<tr>		
			<!--  <td><a href="./ModificaBiblio?page=<%=libro.getId()%>">&#9999;</a></td> -->
			<td>&#9999;</td>
			<td><a href="./EliminaLibro?page=<%=libro.getId()%>">&#128465;</a></td>
			<td><%=libro.getId()%></td>
			<td><%=libro.getTitolo()%></td>
			<td><%=libro.getDescrizione() != null ? libro.getDescrizione() : ""%></td>
			<td><%=libro.getId_autore()%> (<%=autori.get(libro.getId_autore()-1).getNome()%> <%=autori.get(libro.getId_autore()-1).getCognome()%>)</td>
			<td><%=libro.getId_editore()%> (<%=editori.get(libro.getId_editore()-1).getDenominazione()%>)</td>
			<td><%=libro.getAnno()%></td>
		</tr>
		<%
		}
	%> --%>
</c:if>
	
		</table>	
		
</body>
</html>
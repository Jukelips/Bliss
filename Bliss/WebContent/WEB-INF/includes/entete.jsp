<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" />
<title>Projet Bliss</title>
<script type="text/javascript"
	src="<c:url value="/jquery/jQuery v3.1.1.js"/>">
	
</script>
<script type="text/javascript"
	src="<c:url value="/bootstrap/js/bootstrap.min.js"/>">
	
</script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-left">
				<li><h3>Bonjour ${sessionScope.UTILISATEUR.login}</h3></li>
				</br>
			</ul>
			</br>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${!empty sessionScope.UTILISATEUR }">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Menu <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/backoffice/liste_salle"/>">Liste
									des salles</a></li>
							<li><a href="<c:url value="/backoffice/liste_machine"/>">Liste
									des machines</a></li>
							<li><a href="<c:url value="/logout"/>">Déconnexion</a></li>
					</div>
				</c:if>
				<c:if test="${empty sessionScope.UTILISATEUR }">
					<li><a href="<c:url value="/login"/>">Login</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>
	<c:if test="${!empty errors}">
		<div class="alert alert-danger" role="alert">
			<ul>
				<c:forEach items="${errors}" var="e">
					<li>${e}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	<c:if test="${!empty infos}">
		<div class="alert alert-info" role="alert">
			<ul>
				<c:forEach items="${infos}" var="e">
					<li>${e}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
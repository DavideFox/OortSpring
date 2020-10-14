<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrati</title>
    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioAdd.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioView.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico" />
</head>
<body>
<div class="home">
    <a href="${pageContext.request.contextPath}/register"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class = "small-center-container">
        <div class="header">
            <h1><i>Registrati</i></h1>
        </div>
        <div class = "rubrica-form">
            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="single-input">
                    <label for="nome">Nome: </label>
                    <input type="text" name="nome" id="nome">
                </div>
                <div class="single-input">
                    <label for="cognome">Cognome: </label>
                    <input type="text" name="cognome" id="cognome">
                </div>
                <div class="single-input">
                    <label for="cf">Codice Fiscale: </label>
                    <input type="text" name="codiceFiscale" id="cf" required>
                </div>
                <div class="single-input">
                    <label for="email">Email: </label>
                    <input type="email" name="email" id="email" required>
                </div>
                <div class="single-input">
                    <label for="password">Password: </label>
                    <input type="password" name="password" id="password" required>
                </div>
                <div class="single-input">
                    <label for="admin">Admin? </label>
                    <input type="checkbox" name="admin" id="admin" value="true">
                </div>
                <div class="submit">
                    <input type="submit" value="Registrati">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

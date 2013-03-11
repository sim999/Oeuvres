<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Gestion des Oeuvres</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
  <style>
            body {
                padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }
        </style>
</head>

<body>


<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="brand">Gestion d'oeuvre</div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="offset2 span9">

            <div class="tabbable tabs-left">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab_login" data-toggle="tab">Se connecter</a></li>
                </ul>

                <div class="tab-content">
                    <div class="tab-pane active" id="tab_login">

                        <div class="alert alert-error hide">
                            <strong>Erreur</strong> lors de la connexion !
                        </div>

                        <form class="form-horizontal well" method="POST" action="Controller?action=login">
                            <fieldset>
                                <legend>Connectez-vous...</legend>

                                <div class="control-group " >
                                    <label class="control-label" for="user_login">Login :</label>
                                    <div class="controls">
                                        <input type="text" placeholder="Nom d'utilisateur..." name="user_login" id="user_login" />
                                    </div>
                                </div>

                                <div class="control-group " >
                                    <label class="control-label" for="user_password">Mot de passe :</label>
                                    <div class="controls">
                                        <input type="password" placeholder="*******" name="user_password" id="user_password" />
                                    </div>
                                </div>

                                <div class="form-actions">
                                    <button type="submit" class="btn btn-primary">Connexion</button>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


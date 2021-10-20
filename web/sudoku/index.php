<?php
if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true){
	header("location: content.php");
	exit;
}
else header("location: login.php");
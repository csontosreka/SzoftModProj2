<?php
// Munkamenet inicializálása
session_start();

// Megnézzük hogy a felhasználó adminként van-e bejelentkezve és ha nem, kiléptetjük és átirányítjuk a bejelentkezési oldalra
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true || $_SESSION["username"] !== "admin"){
	session_destroy();
	header("location: ../login.php");
	exit;
}

// Konfig fájl betöltése(kell az adatbázishoz)
require_once "../config.php";

// Bejelentkezési adatok megadása az Adminer számára
$_GET["username"] = DB_USERNAME;
$_GET["db"] = DB_NAME;
function adminer_object() {
	class AdminerAutoLogin extends Adminer {
		function name() {
			return 'SQL Admin';
		}
		function credentials() {
			return array(DB_SERVER, DB_USERNAME, DB_PASSWORD);
		}
		function login($login, $password) {
			return true;
		}
	}
	return new AdminerAutoLogin;
}
require_once("adminer-4.8.1-mysql.php");


// Szard le, nem is kell: "Failed to load resource: the server responded with a status of 403 (Forbidden)"
?>

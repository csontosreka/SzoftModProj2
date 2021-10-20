<?php
/* Adatbázis hitelesítési adatok */
define('DB_SERVER', 'localhost');
define('DB_USERNAME', 'mysqladmin');
define('DB_PASSWORD', 'TitkosJelszo01');
define('DB_NAME', 'sudoku');

/* Kapcsolódás MySQL adatbázishoz */
$link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

// Kapcsolat ellenőrzése
if($link === false){
	die("HIBA: Nem sikerült kapcsolódni az adatbázishoz. " . mysqli_connect_error());
}
?>
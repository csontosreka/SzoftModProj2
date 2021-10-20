<?php
// Konfig fájl betöltése(kell az adatbázishoz)
require_once "config.php";

//http://localhost/sudoku/submitscore.php?scoretoken=sziauram&score=998

if(isset($_GET['scoretoken']) && isset($_GET['score'])){
	mysqli_query($link, "INSERT INTO `scoreboard` (`userid`, `score`) SELECT id, " . $_GET["score"] . ' AS score FROM `users` WHERE scoretoken ="' . rawurldecode($_GET["scoretoken"] . '"'));
	exit();
}
else{
	echo "Hibás scoretoken/score!";
	exit;
}
	// Kapcsolat bontása
	mysqli_close($link);
?>
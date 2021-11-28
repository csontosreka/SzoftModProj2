<?php
// Konfig fájl betöltése(kell az adatbázishoz)
require_once "config.php";

//http://localhost/SudokuWeb/submitscore.php?scoretoken=sziauram&score=998

if(isset($_POST['scoretoken']) && isset($_POST['score'])){
	mysqli_query($link, "INSERT INTO `scoreboard` (`userid`, `score`) SELECT id, " . $_POST["score"] . ' AS score FROM `users` WHERE scoretoken ="' . rawurldecode($_POST["scoretoken"] . '"'));
	exit();
}
else{
	echo "Hibás scoretoken/score!";
	exit;
}
	// Kapcsolat bontása
	mysqli_close($link);
?>
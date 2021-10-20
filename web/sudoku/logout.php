<?php
// Munkamenet inicializálása
session_start();

// Az összes munkameneti változó törlése
$_SESSION = array();

// Munkamenet törlése
session_destroy();

// Átirányítás az index oldalra
header("location: index.php");
exit;
?>
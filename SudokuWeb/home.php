<!DOCTYPE html>
<html lang="hu">
<head>
	<meta charset="UTF-8">
</head>
<body>
	<div class="container-fluid p-4">
		<h2 style="text-align:center;">Elért eredmények:</h2>
		<?php
		// Konfig fájl betöltése(kell az adatbázishoz)
		require_once "config.php";
		// Adatok lekérdezéséhez szükséges utasítás
		$scorelink = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
		$scorequery = mysqli_query($scorelink, 'SELECT users.username AS "Név", scoreboard.score AS "Elért pontszám", scoreboard.created_at AS "Dátum" FROM `scoreboard` INNER JOIN users ON users.id = scoreboard.userid ORDER BY convert(scoreboard.score, decimal) DESC');
		$scorefield = mysqli_field_count($scorelink);

		// Felhasználók táblázat megjelenítése
		echo '<table class="table table-sm table-bordered"><thead class="thead-light"><tr>';
		// Mezőnevek sorának kiírása
		for($i = 0; $i < $scorefield; $i++) {
			echo '<th>'.mysqli_fetch_field_direct($scorequery, $i)->name.'</th>';
		}
		echo '</tr></thead><tbody>';
		// Tábla végigpörgetése
		while($scorerow = mysqli_fetch_array($scorequery)) {
			if($scorerow[1] != "admin"){
				// Sorok kiírása
				echo '<tr>';
				for($i = 0; $i < $scorefield; $i++) {
					echo '<td>'.$scorerow[mysqli_fetch_field_direct($scorequery, $i)->name].'</td>';
				}

				echo '</tr>';
			}
		}
		echo '</tbody></table>';

		mysqli_close($scorelink);
		?>
	</div>
</body>
</html>
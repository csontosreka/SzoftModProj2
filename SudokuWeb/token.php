<?php
// Munkamenet inicializálása
session_start();

// Megnézzük hogy a felhasználó be van-e jelentkezve és ha nem, átirányítjuk a bejelentkezési oldalra
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
	header("location: login.php");
	exit;
}

// Konfigurációs fájl, kell az adatbázishoz
require_once "config.php";

// Változők deklarálása és alapértelmezett kezdőértéke
$new_apptoken = mysqli_fetch_array(mysqli_query($link, 'SELECT scoretoken FROM users WHERE username = "' . $_SESSION["username"] . '"'))[0];
$new_apptoken_err="";

// Az űrlapadatok feldolgozása amikor elküldik
if($_SERVER["REQUEST_METHOD"] == "POST"){

	// Új apptoken üres-e
	if(empty(trim($_POST["new_apptoken"]))){
		$new_apptoken_err = "Adjon meg egy tokent!";
	} elseif(strlen(trim($_POST["new_apptoken"])) < 4 || strlen(trim($_POST["new_apptoken"])) > 255){
		$new_apptoken_err = "A tokennek legalább 4 és legfeljebb 255 karakter hosszúnak kell lennie.";
	} else{
		$new_apptoken = trim($_POST["new_apptoken"]);
	}

	// Hibák keresése az adatbázis frissítése előtt
	if(empty($new_apptoken_err)){
		// Frissítő utasítás előkészítése
		$sql = "UPDATE users SET scoretoken = ? WHERE id = ?";
		
		if($stmt = mysqli_prepare($link, $sql)){
			// Változók paraméterként való csatolása az előkészített utasításhoz
			mysqli_stmt_bind_param($stmt, "si", $param_scoretoken, $param_id);
			
			// Paraméterek beállítása
			$param_scoretoken = $new_apptoken;
			$param_id = $_SESSION["id"];
			
			// Megpróbáljuk lefuttatni az előkészített utasítást
			if(mysqli_stmt_execute($stmt)){
				// Új token megadása sikeres volt, munkamenet törlése és átirányítás a content oldalra
				header("location: content.php");
				exit();
			} else{
				echo "Hoppá! Valami hiba történt, próbáld újra később.";
			}
		}
		// Záró utasítás
		mysqli_stmt_close($stmt);
	}
	// Kapcsolat bontása
	mysqli_close($link);
}
?>

<!DOCTYPE html>
<html lang="hu">
<head>
	<meta charset="UTF-8">
	<title>AppToken</title>
	<link rel='shortcut icon' type='image/x-icon' href='img/favicon.ico' />
	<link rel="stylesheet" href="css/bootstrap.css">
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.wrapper{ width: 350px; padding: 20px; }
		.has-error .help-block { color: red; }
	</style>
</head>
<body>
	<div class="container pt-5">
		<div class="row">
			<div class="col-3">
			</div>
			<div class="col-6">
				<h2>AppToken</h2>
				<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post"> 
					<div class="form-group <?php echo (!empty($new_apptoken_err)) ? 'has-error' : ''; ?>">
						<input type="text" name="new_apptoken" class="form-control" value="<?php echo $new_apptoken; ?>">
						<span class="help-block"><?php echo $new_apptoken_err; ?></span>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Megváltoztat">
						<a class="btn btn-link" href="content.php">Mégse</a>
					</div>
				</form>
			</div> 
			<div class="col-3">
			</div>
		</div> 
	</div>
	<!-- Lábléc -->
	<footer class="page-footer py-1 fixed-bottom bg-dark text-white">
		<!-- Copyright -->
		<div class="footer-copyright text-center">
			Copyright © 
			<script>
				now = new Date;
				theYear=now.getYear();
				if (theYear < 1900) theYear=theYear+1900;
				document.write(theYear);
			</script> | Backlog csapat
		</div>
	</footer>
	<!-- Lábléc -->
</body>
</html>
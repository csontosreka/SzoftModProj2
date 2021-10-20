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
$new_password = $confirm_password = "";
$new_password_err = $confirm_password_err = "";

// Az űrlapadatok feldolgozása amikor elküldik
if($_SERVER["REQUEST_METHOD"] == "POST"){

	// Új jelszó üres-e
	if(empty(trim($_POST["new_password"]))){
		$new_password_err = "Adjon meg egy új jelszót.";
	} elseif(strlen(trim($_POST["new_password"])) < 4){
		$password_err = "A jelszónak legalább 4 karakter hosszúnak kell lennie.";
	} else{
		$new_password = trim($_POST["new_password"]);
	}
	
	// Új jelszó megerősítés üres-e
	if(empty(trim($_POST["confirm_password"]))){
		$confirm_password_err = "Erősítse meg a jelszavát.";
	} else{
		$confirm_password = trim($_POST["confirm_password"]);
		if(empty($new_password_err) && ($new_password != $confirm_password)){
			$confirm_password_err = "A megadott jelszavak nem egyeznek.";
		}
	}

	// Hibák keresése az adatbázis frissítése előtt
	if(empty($new_password_err) && empty($confirm_password_err)){
		// Frissítő utasítás előkészítése
		$sql = "UPDATE users SET password = ? WHERE id = ?";
		
		if($stmt = mysqli_prepare($link, $sql)){
			// Változók paraméterként való csatolása az előkészített utasításhoz
			mysqli_stmt_bind_param($stmt, "si", $param_password, $param_id);
			
			// Paraméterek beállítása
			$param_password = password_hash($new_password, PASSWORD_DEFAULT);
			$param_id = $_SESSION["id"];
			
			// Megpróbáljuk lefuttatni az előkészített utasítást
			if(mysqli_stmt_execute($stmt)){
				// Új jelszó megadása sikeres volt, munkamenet törlése és átirányítás a bejelentkezési oldalra
				session_destroy();
				header("location: login.php");
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
	<title>Jelszó megváltoztatása</title>
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
				<h2>Jelszó megváltoztatása</h2>
				<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post"> 
					<div class="form-group <?php echo (!empty($new_password_err)) ? 'has-error' : ''; ?>">
						<label>Új jelszó</label>
						<input type="password" name="new_password" class="form-control" value="<?php echo $new_password; ?>">
						<span class="help-block"><?php echo $new_password_err; ?></span>
					</div>
					<div class="form-group <?php echo (!empty($confirm_password_err)) ? 'has-error' : ''; ?>">
						<label>Új jelszó újra</label>
						<input type="password" name="confirm_password" class="form-control">
						<span class="help-block"><?php echo $confirm_password_err; ?></span>
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
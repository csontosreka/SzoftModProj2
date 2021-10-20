<?php
// Munkamenet inicializálása
session_start();

// Megnézzük hogy a felhasználó be van-e jelentkezve és ha igen, átirányítjuk a tartalmak oldalra
if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true){
	header("location: content.php");
	exit;
}

// Konfigurációs fájl, kell az adatbázishoz
require_once "config.php";

// Változők deklarálása és alapértelmezett kezdőértéke
$username = $password = "";
$username_err = $password_err = "";

// Az űrlapadatok feldolgozása amikor elküldik
if($_SERVER["REQUEST_METHOD"] == "POST"){

	// Felhasználónév üres-e
	if(empty(trim($_POST["username"]))){
		$username_err = "Adjon meg egy felhasználónevet.";
	} else{
		$username = trim($_POST["username"]);
	}
	
	// Jelszó üres-e
	if(empty(trim($_POST["password"]))){
		$password_err = "Adja meg a jelszavát.";
	} else{
		$password = trim($_POST["password"]);
	}
	
	// Adatok ellenőrzése
	if(empty($username_err) && empty($password_err)){
		// SQL select utasítás előkészítése
		$sql = "SELECT id, username, password FROM users WHERE username = ?";
		
		if($stmt = mysqli_prepare($link, $sql)){
			// Változók paraméterként való csatolása az előkészített utasításhoz
			mysqli_stmt_bind_param($stmt, "s", $param_username);
			
			// Paraméterek beállítása
			$param_username = $username;
			
			// Megpróbáljuk lefuttatni az előkészített utasítást
			if(mysqli_stmt_execute($stmt)){
				// Eredményeket eltároljuk
				mysqli_stmt_store_result($stmt);
				
				// Megnézzük hogy a felhasználó létezik-e és ellenőrizzük a jelszót
				if(mysqli_stmt_num_rows($stmt) == 1){                    
					// Eredményeket csatoljuk az előkészített utasításhoz
					mysqli_stmt_bind_result($stmt, $id, $username, $hashed_password);
					if(mysqli_stmt_fetch($stmt)){
						if(password_verify($password, $hashed_password)){
							// Helyes jelszó, munkamenet indítása
							session_start();
							
							// Adatok munkamenetváltozókban való letárolása
							$_SESSION["loggedin"] = true;
							$_SESSION["id"] = $id;
							$_SESSION["username"] = $username;

							// Átírányítás a tartalomra
							header("location: content.php");
						} else{
							// Helytelen jelszó hibaüzenet megjelenítése
							$password_err = "A megadott jelszó nem helyes!";
						}
					}
				} else{
					// Nemlétező felhasználónév hibaüzenet megjelenítése
					$username_err = "Nincs ilyen nevű felhasználó!";
				}
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
	<title>Bejelentkezés</title>
	<link rel='shortcut icon' type='image/x-icon' href='img/favicon.ico' />
	<link rel="stylesheet" href="css/bootstrap.css">
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.wrapper{ width: 350px; padding: 20px; }
		.has-error .help-block { color: red; }
	</style>
</head>
<body class="bg-light">
	<div class="container-fluid pt-5">
		<div class="row">
			<div class="col-3">
				<h2>Bejelentkezés</h2>
				<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
					<div class="form-group <?php echo (!empty($username_err)) ? 'has-error' : ''; ?>">
						<label>Felhasználónév</label>
						<input type="text" name="username" class="form-control" value="<?php echo $username; ?>">
						<span class="help-block"><?php echo $username_err; ?></span>
					</div>    
					<div class="form-group <?php echo (!empty($password_err)) ? 'has-error' : ''; ?>">
						<label>Jelszó</label>
						<input type="password" name="password" class="form-control">
						<span class="help-block"><?php echo $password_err; ?></span>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Bejelentkezés">
					</div>
					<p>Még nem regisztráltál? <a href="register.php">Regisztrálj most!</a></p>
				</form>
			</div> 
			<div class="col-9">
				<?php require_once "home.php"; ?>
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
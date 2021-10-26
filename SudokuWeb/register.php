<?php

function generateRandomString($length = 20) {
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $charactersLength = strlen($characters);
    $randomString = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomString;
}

// Konfig fájl betöltése(kell az adatbázishoz)
require_once "config.php";

// Változők deklarálása és alapértelmezett kezdőértéke
$username = $password = $confirm_password = "";
$username_err = $password_err = $confirm_password_err = "";

// Az űrlapadatok feldolgozása amikor elküldik
if($_SERVER["REQUEST_METHOD"] == "POST"){

    // Felhasználónév üres-e
	if(empty(trim($_POST["username"]))){
		$username_err = "Adjon meg egy felhasználónevet.";
	} else{
        // SQL select utasítás előkészítése
		$sql = "SELECT id FROM users WHERE username = ?";

		if($stmt = mysqli_prepare($link, $sql)){
            // Változők paraméterként való csatolása az előkészített utasításhoz
			mysqli_stmt_bind_param($stmt, "s", $param_username);

            // Paraméterek beállítása
			$param_username = trim($_POST["username"]);

            // Megpróbáljuk lefuttatni az előkészített utasítást
			if(mysqli_stmt_execute($stmt)){
				// Eredményeket eltároljuk
				mysqli_stmt_store_result($stmt);

				if(mysqli_stmt_num_rows($stmt) == 1){
					$username_err = "Ez a felhasználónév már foglalt.";
				} else{
					$username = trim($_POST["username"]);
				}
			} else{
				echo "Hoppá! Valami hiba történt, próbáld újra később.";
			}
		}

        // Záró utasítás
		mysqli_stmt_close($stmt);
	}

    // Jelszó üres-e
	if(empty(trim($_POST["password"]))){
		$password_err = "Adjon meg egy jelszót.";     
	} elseif(strlen(trim($_POST["password"])) < 4){
		$password_err = "A jelszónak legalább 4 karakter hosszúnak kell lennie.";
	} else{
		$password = trim($_POST["password"]);
	}

    // Jelszó megerősítés üres-e
	if(empty(trim($_POST["confirm_password"]))){
		$confirm_password_err = "Erősítse meg a jelszavát.";     
	} else{
		$confirm_password = trim($_POST["confirm_password"]);
		if(empty($password_err) && ($password != $confirm_password)){
			$confirm_password_err = "A megadott jelszavak nem egyeznek.";
		}
	}

    // Hibák keresése az adatbázisba való beszúrás előtt
	if(empty($username_err) && empty($password_err) && empty($confirm_password_err)){
        // Beszúró utasítás előkészítése
		$sql = "INSERT INTO users (username, password, scoretoken) VALUES (?, ?, ?)";

		if($stmt = mysqli_prepare($link, $sql)){
            // Változók paraméterként való csatolása az előkészített utasításhoz
			mysqli_stmt_bind_param($stmt, "sss", $param_username, $param_password, $param_scoretoken);

            // Paraméterek beállítása
			$param_username = $username;
            $param_password = password_hash($password, PASSWORD_DEFAULT); // Jelszóból hash képzés
            $param_scoretoken = generateRandomString();
            
            // Megpróbáljuk lefuttatni az előkészített utasítást
            if(mysqli_stmt_execute($stmt)){
                // Átirányítás a bejelentkezési oldalra
            	header("location: login.php");
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
	<title>Regisztráció</title>
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
			</div>
			<div class="col-6">
				<h2>Regisztráció</h2>
				<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
					<div class="form-group <?php echo (!empty($username_err)) ? 'has-error' : ''; ?>">
						<label>Felhasználónév</label>
						<input type="text" name="username" class="form-control" value="<?php echo $username; ?>">
						<span class="help-block"><?php echo $username_err; ?></span>
					</div>
					<div class="form-group <?php echo (!empty($password_err)) ? 'has-error' : ''; ?>">
						<label>Jelszó</label>
						<input type="password" name="password" class="form-control" value="<?php echo $password; ?>">
						<span class="help-block"><?php echo $password_err; ?></span>
					</div>
					<div class="form-group <?php echo (!empty($confirm_password_err)) ? 'has-error' : ''; ?>">
						<label>Jelszó újra</label>
						<input type="password" name="confirm_password" class="form-control" value="<?php echo $confirm_password; ?>">
						<span class="help-block"><?php echo $confirm_password_err; ?></span>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Regisztráció">
					</div>
					<p>Már regisztráltál? <a href="login.php">Jelentkezz be!</a></p>
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
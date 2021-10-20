<?php
// Munkamenet inicializálása
session_start();

// Megnézzük hogy a felhasználó be van-e jelentkezve és ha nem, átirányítjuk a bejelentkezési oldalra
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
	header("location: login.php");
	exit;
}
?>

<!DOCTYPE html>
<html lang="hu">
<head>
	<!-- Meta adatok -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<!-- jQuery aztán Bootstrap.js -->
	<script src="./js/jquery-3.4.1.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<!-- Ikonokért felejős js -->
	<script src="./fontawesome/js/all.js" crossorigin="anonymous"></script>

	<title>SUDOKU!</title>
	<link rel='shortcut icon' type='image/x-icon' href='./img/favicon.ico' />
</head>
<body>
	<!-- Navigációs Sáv -->
	<nav class="navbar navbar-expand bg-dark navbar-dark">
		<div class="d-flex flex-grow-1">
			<div class="navbar-brand">
				<img src="img/logo.png" alt="SUDOKU!" style="width:65px; padding-right: 15px;"><span style="vertical-align:middle;">SUDOKU!</span>
			</div>

			<!-- Nav gombok -->
			<ul class="nav nav-pills align-content-center">
				<li class="nav-item">
					<a class="nav-link active loadContent" data-toggle="pill" href="javascript:void(0);" data-href="home.php"><i class="fas fa-poll"></i> Eredménytábla</a>
				</li>
				<li class="nav-item">
					<a class="nav-link loadContent" data-toggle="pill" href="javascript:void(0);" data-href="gamerules.php"><i class="fas fa-check-circle"></i> Játékszabály</a>
				</li>
				<li class="nav-item">
					<a class="nav-link loadContent" data-toggle="pill" href="javascript:void(0);" data-href="info.php"><i class="fas fa-info-circle"></i> Információ</a>
				</li>
				<?php
				// Admin menü ha admin felhasználó
				if($_SESSION["username"] == "admin"){
					echo '<li class="nav-item"><a class="nav-link" href="adminer/adminer-loader.php" target="_blank"><i class="fas fa-database"></i> DB ADMIN</a></li>';
				}
				?>
			</ul>
			<!-- Nav gombok vége -->
		</div>
		<div>
			<!-- FelhasználóDropdown -->
			<div class="dropdown">
				<a class="btn btn-outline-primary dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
					<?php echo htmlspecialchars($_SESSION["username"]); ?> <i class="fas fa-user"></i>
				</a>
				<div class="dropdown-menu dropdown-menu-right">
					<a href="reset-password.php" class="dropdown-item"><i class="fas fa-key"></i> Jelszó megváltoztatása</a>
					<div class="dropdown-divider"></div>
					<a href="token.php" class="dropdown-item"><i class="fas fa-barcode"></i> AppToken</a>
					<div class="dropdown-divider"></div>
					<a href="logout.php" class="dropdown-item"><i class="fas fa-sign-out-alt"></i> Kijelentkezés</a>
				</div>
			</div>
		</div>
		<!-- FelhasználóDropdown vége -->
	</nav>
	<!-- Navigációs Sáv vége -->

	<!-- Gombokhoz kapcsolt javascript -->
	<script>
		$(document).ready(function (){
			$('#js-content').load("./home.php");
			$('.loadContent').on('click',function(){
				var dataURL = $(this).attr('data-href');
				$('#js-content').load(dataURL);
			});
		});
	</script>

	<div class="container-fluid p-0">
		<div id="js-content"><!-- A tartalom ide fog betöltődni --></div>
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
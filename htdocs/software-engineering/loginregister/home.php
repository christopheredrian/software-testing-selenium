<?php 
session_start();

if (isset($_SESSION['username'])) {
	$username = $_SESSION['username'];
} else{
	// Redirect to logout
	header('Location: http://localhost/software-engineering/loginregister/logout.php');    

}

?>
<!DOCTYPE HTML>
<html>
<head>
	<title>Homepage</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
					Software Engineering(Testing) - HomePage
				</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<h3 id="username">Logged in as:  <?php echo $username ?></h3>
		<a href="login.php">Log Out</a>
		
	</div>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
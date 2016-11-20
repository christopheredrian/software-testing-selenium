<?php 

$username = "";
$password = "";
$submitted = false;
$errorMessage = "";
// Dummy database
$users = array('chrisesp@gmail.com' => '123456',
	'leotag@gmail.com' => '542312',
	'cesc@yahoo.com' => 'y2h00',
	'matlabre@yahoo.com' => 'mats',
	'bitmeadh@gmail.com' => 'bm4321'
	);
if (isset($_POST['submit'])) {
	$submitted = true;
	$username = $_POST['username'];
	$password = $_POST['password'];
	/**
	*	User is not registered.
	*	Incorrect password.
	*	Username is required!
	*	Password is required!
	*/
	if (empty($username)) {
		$errorMessage = "Username is required!";
	}elseif (empty($password)) {
		$errorMessage = "Password is required!";
	} elseif (!contains("@", $username)) {
		$errorMessage = "Email is not properly formatted.";
	} elseif (!array_key_exists($username, $users)) {
		$errorMessage = "User is not registered.";
	} elseif (!(array_key_exists($username, $users) && ($password === $users[$username]))) {
		$errorMessage = "Incorrect password.";
	} else{
		// This is a new page  
		session_start();
		$_SESSION['username'] = $username;
		header('Location: http://localhost/software-engineering/loginregister/home.php');    
		exit();  
	}

} else{
	// This is a new page

	
}
	// returns true if $needle is a substring of $haystack
function contains($needle, $haystack)
{
	return strpos($haystack, $needle) !== false;
}
?>


<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
					Software Engineering(Testing) - Login
				</a>
			</div>
		</div>
	</nav>
	<div class="container">


		<div class="row">
			<div class="col-xs-5 col-md-offset-3">
				<h1 class="page-header">Login</h1>
				<!-- Error message box here -->
				<?php if ($submitted): ?>
					<span id="error-message" class="text-danger"><?php echo $errorMessage ?></span>
				<?php endif ?>
				<form method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label>
						<input name="username" value="<?php echo $username ?>" type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						<input name="password" value="<?php echo $password ?>" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
					</div>
					<button class="btn btn-primary col-xs-12" name="submit" type="submit" >Login</button>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
<?php 
session_start();
session_destroy();
header('Location: http://localhost/software-engineering/loginregister/login.php');    
die();
?>
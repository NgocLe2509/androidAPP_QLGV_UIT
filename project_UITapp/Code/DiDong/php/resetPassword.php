<?php
	include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['item1'];
	$newPassword = $_POST['item2'];
	
	$hash = password_hash($newPassword, PASSWORD_BCRYPT, array("cost" => 10));

	// query the database for user
	changePassword($UserID, $hash);
	$rep = array("error"=>"false");
	$arr = array();
	$arr[] = $rep;
	echo json_encode($arr);
?>
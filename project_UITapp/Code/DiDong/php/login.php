<?php
	include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['item1'];
	$Password = $_POST['item2'];

	// query the database for user
	$row = get_NguoiDung($UserID, $Password);
	$arr = array();
	if($row != 0){
		$error = array("error"=>"false");
	}
	else {
		$error= array("error"=>"true");
		
	}
	$arr[] = $error;
	echo json_encode($arr);
?>
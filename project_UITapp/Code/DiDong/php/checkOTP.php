<?php
	include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['UserID'];
	$Code = $_POST['Code'];

	if($Code == "FFFF"){
		$rep = array("code"=>"false");
		echo json_encode($rep);
	}
	else{
		// query the database for user
		$result = chkCode($UserID, $Code);
		if($result == 1){
			$rep = array("code"=>"true");
			echo json_encode($rep);
		}
		else {
			$rep = array("code"=>"false");
			echo json_encode($rep);
		}
	}
?>
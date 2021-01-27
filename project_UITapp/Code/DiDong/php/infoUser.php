<?php
	include("./include/config.php");
	$UserID = $_POST['item1'];
	$row = get_SinhVien($UserID);
	$arr = array();
	$arr[] = $row;
	echo json_encode($arr);
?> 
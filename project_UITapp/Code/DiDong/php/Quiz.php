<?php
	include("./include/config.php");
    $Code = $_POST['item1'];
    

	$row = get_CauHoi($Code);
	echo json_encode($row);
?> 
<?php
	include("./include/config.php");
	// Get values username, password
    $UserID = $_POST['item1'];
    $Code = $_POST['item2'];
    $MaLop = $_POST['item3'];
    $Buoi = $_POST['item4'];

	// query the database for user
    $row3 = addSVDiemDanh($MaLop, $Buoi, $UserID, $Code);
    if($row3 == 1){
        $result = array("code" => "1"); 
    }
    else {
        $result = array("code" => "0"); 
    }

    $value[] = $result;
    echo json_encode($value);

?>
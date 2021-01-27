<?php

include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['item1'];

	// query the database for user
    $list = get_XepLop($UserID);
    
    $row = array();
    
    foreach($list as $item){
        $khaosat = get_LopHP($item['MaLopHP']);
        $row[] = $khaosat;
    }

 // Hiển thị kết quả
 echo json_encode($row);
?>

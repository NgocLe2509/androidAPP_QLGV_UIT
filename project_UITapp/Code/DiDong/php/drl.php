<?php
	include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['item1'];

	// query the database for user
    $row = get_drl($UserID);
    
    $count = count($row);
    for ($i = 0; $i < $count; $i++) {
        for($j = $i +1; $j< $count; $j++){
            if(($row[$j]['HocKi'] < $row[$i]['HocKi'])){
                    $temp = $row[$i];
                    $row[$i] = $row[$j];
                    $row[$j] = $temp;
                }
        }
    }
	echo json_encode($row);
?>
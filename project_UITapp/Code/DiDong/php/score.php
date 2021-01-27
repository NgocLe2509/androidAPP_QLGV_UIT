<?php
	include("./include/config.php");
	// Get values username, password
    $UserID = $_POST['item1'];

	// query the database for user
    $list= get_KetQua($UserID);
    $count = count($list);
    for($i=0; $i < $count; $i++){
        for($j=$i+1; $j<$count; $j++){
            if($list[$j]['Ki'] < $list[$i]['Ki']){
                $temp = $list[$i];
                $list[$i] = $list[$j];
                $list[$j] = $temp;
            }
        }
    }
	echo json_encode($list);
?>
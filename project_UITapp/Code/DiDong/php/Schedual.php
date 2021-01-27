<?php
	include("./include/config.php");
	// Get values username, password
    $UserID = $_POST['item1'];

	// query the database for user
    $row = get_XepLop($UserID);
    $list = array();
    foreach($row as $item){
        $testSchedual = get_ThoiKhoaBieu($item['MaLopHP']);
        if($testSchedual != null){
            $list[] = $testSchedual;
        }
    }
    
    $count = count($list);
    for($i=0; $i < $count; $i++){
        for($j=$i+1; $j<$count; $j++){
            if($list[$j]['Day'] < $list[$i]['Day']  || ($list[$j]['Day'] == $list[$i]['Day'] && $list[$j]['TietBD'] < $list[$i]['TietBD'])){
                $temp = $list[$i];
                $list[$i] = $list[$j];
                $list[$j] = $temp;
            }
        }
    }
	echo json_encode($list);
?>
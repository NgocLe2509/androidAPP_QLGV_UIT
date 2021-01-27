<?php
	include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['item1'];

	// query the database for user
    $list = get_XepLop($UserID);
    
    $row = array();
    
    foreach($list as $item){
        $testSchedual = get_LichThi($item['MaLopHP']);
        if($testSchedual != null){
            $row[] = $testSchedual;
        }
    }

    //Sắp xếp môn nào thi trước xếp lên đầu
    $count = count($row);
    for ($i = 0; $i < $count; $i++) {
        for($j = $i +1; $j< $count; $j++){
            if(($row[$j]['Nam'] < $row[$i]['Nam']) || ($row[$j]['Nam'] == $row[$i]['Nam'] && $row[$j]['Thang'] < $row[$i]['Thang']) || 
                ($row[$j]['Nam'] == $row[$i]['Nam'] && $row[$j]['Thang'] == $row[$i]['Thang'] && $row[$j]['Ngay'] < $row[$i]['Ngay']) || 
                ($row[$j]['Nam'] == $row[$i]['Nam'] && $row[$j]['Thang'] == $row[$i]['Thang'] && $row[$j]['Ngay'] == $row[$i]['Ngay'] && $row[$j]['Ca'] == $row[$i]['Ca'])){
                    $temp = $row[$i];
                    $row[$i] = $row[$j];
                    $row[$j] = $temp;
                }
        }
    }
	echo json_encode($row);
?>
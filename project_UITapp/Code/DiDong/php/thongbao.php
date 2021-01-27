<?php

include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['item1'];

	// query the database for user
    $list = get_ThongBao();
    $row = array();

    // LoaiTB = 0: thong bao nghi
    // LoaiTB = 1: thong bao bu
    // LoaiTB = 2: thong bao lich hoc
    // LoaiTB = 3: thong bao chung 
    
    foreach($list as $item){
        if($item['LoaiTB'] == 3){
            $row[] = $item;
        }
        else {
            if(check_XepLop($UserID, $item['MaLop']) == 0){
                $row[] = $item;
            }
        }
    }

 // Hiển thị kết quả
 echo json_encode($row);
?>

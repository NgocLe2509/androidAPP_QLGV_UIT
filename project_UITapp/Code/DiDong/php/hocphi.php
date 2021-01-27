<?php

    include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['item1'];

	// query the database for user
    $list = get_hocphi($UserID);
    $row = array();
    
    foreach($list as $item){
        $hocki = "Học kỳ ".$item['HocKi']." - Năm học ".$item['NamHoc'];
        $xeplop = getXepLop($UserID, $item['HocKi'], $item['NamHoc']);
        $countSoMon = count($xeplop);
        $dkhp = "";
        if($countSoMon != 0){
            for($i =0; $i<$countSoMon; $i++){
                $dkhp .= $xeplop[$i]['MaLopHP'];
                if($i != $countSoMon - 1){
                    $dkhp .= ", ";
                }
            }
        }

        $tong = $item['NoTruoc']." + ".$item['PhaiDong']." = ".$item['Tong'];
        $row[] = array("hocky" => $hocki, "somon" => $countSoMon, "dkhp" => $dkhp, "tong" => $tong, "dadong" => $item['DaDong'],
                "conlai" => $item['ConLai'], "tai" => $item['Tai'], "thoigian" => $item['ThoiGian']);
    }

    // Hiển thị kết quả
    echo json_encode($row);
?>

<?php

    include("./include/config.php");
	// Get values username, password
	$UserID = $_POST['item1'];

	// query the database for user
    $list = get_Deadline();
    $row = array();
    
    foreach($list as $item){
        $xeplop = check_XepLop($UserID, $item['MaLopHP']);
        if($xeplop == 0){

            $nopbai = getNopBai($UserID, $item['STT']);

            if($nopbai != 0){
                $tinhtrang = "Đã Nộp Bài";
                $filebainop =$nopbai['filename'];
                $sttbainop = $nopbai['STT'];
            }
            else {
                $tinhtrang = "Chưa Nộp Bài";
                $filebainop = "null";
                $sttbainop = "null";
            }

            $today = date("Y-m-d H:i:s");
            $another_date = $item['HanChot'];
            if (strtotime($today) < strtotime($another_date)) {
                $hanchot = "Chưa hết hạn";
            } else {
                $hanchot = "Hết hạn";
            }
            
            $row[] = array("malop" => $item['MaLopHP'], "noidung" => $item['NoiDung'], "deadline" => $item['HanChot'], "tinhtrang" => $tinhtrang,
        "hanchot" => $hanchot, "filename" => $filebainop, "STTBaiNop" => $sttbainop, "STTBai" => $item['STT']);
        }
        
    }
 
    // Hiển thị kết quả
    echo json_encode($row);
?>

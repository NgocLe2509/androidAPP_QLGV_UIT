<?php

    include("./include/config.php");
	// Get values username, password
    $UserID = $_POST['item1'];
    $STTBai= $_POST['item2'];
    $FIlename= $_POST['item3'];

    $row = addNopBai($UserID, $STTBai, $FIlename);
    $bainop = getNopBai($UserID, $STTBai);
    $value = array();
    if($row == 1){
        $result = array("code" => "ok", "SttBaiNop" => $bainop['STT']);
    }
    else {
        $result = array("code" => "no", "SttBaiNop" => "null");
    }
    $value[] = $result;
 
    // Hiển thị kết quả
    echo json_encode($value);
?>

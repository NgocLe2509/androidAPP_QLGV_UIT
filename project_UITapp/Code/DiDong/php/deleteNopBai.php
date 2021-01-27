<?php
    include("./include/config.php");
    $UserID = $_POST['item1'];
    $STT = $_POST['item2'];

    $row = deleteNopBai($UserID, $STT);
    $value = array();
    if($row == 1){
        $result = array("code" => "ok");
    }
    else {
        $result = array("code" => "no");
    }
    $value[] = $result;
    echo json_encode($value);
?>
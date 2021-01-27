<?php

// error = 0 : Code sai
// error = 1 : game không còn hạn
// error = 2 : user không thuộc lớp
// error = 3: đúng

include("./include/config.php");
	// Get values username, password
    $UserID = $_POST['item1'];
    $Code = $_POST['item2'];

	// query the database for user
    $xeplop = get_XepLop($UserID);

    $codeGame = get_Game($Code);

    $check = "";

    $arr = array();

    if($codeGame!=null){

        if ($codeGame['TinhTrang'] == "0"){
            $result = array("result"=>"1");
        }
        else {
            foreach($xeplop as $item){
                if($item['MaLopHP'] == $codeGame['MaMon']){
                    $check = "true";
                    break;
                }
            }
    
            if($check == "true"){
                $result = array("result"=>"3");
            }
            else {
                $result = array("result"=>"2");
            }
        }


    }
    else {
        $result = array("result"=>"0");
		
    }

    $arr[] = $result;
    echo json_encode($arr);

?>

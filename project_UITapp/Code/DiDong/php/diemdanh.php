<?php
	include("./include/config.php");
	// Get values username, password
    $UserID = $_POST['item1'];
    $Code = $_POST['item2'];

	// query the database for user
    $row = get_DiemDanh($Code);
    $value = array();
    
    if($row != 0){
        $row1 = check_XepLop($UserID, $row['MaLopHP']);
        if($row1 == 0){
            $row2 = check_DiemDanh($UserID, $Code);
            if($row2 == 1){
                $result = array("code" => "4", "malop" => $row['MaLopHP'], "buoi" => $row['Buoi']); 
            }
            else {
                $result = array("code" => "3"); 
            }
        }
        else {
            $result = array("code" => "2"); 
        }
    }
    else {
        $result = array("code" => "1"); 
    }

    // code = 1: khong tim thay code hoac code het han
    // code = 2: sinh vien khong thuoc lop
    // code = 3: sinh vien da diem danh roi
    // code = 4: ok

    $value[] = $result;
    echo json_encode($value);

?>
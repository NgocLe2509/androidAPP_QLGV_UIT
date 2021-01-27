<?php
	include("./include/config.php");
    $userID = $_POST['item1'];
    $Diem = $_POST['item2'];
    $IDGame = $_POST['item3'];
    

    insert_SV_game($IDGame, $userID, $Diem);
	echo json_encode("true");
?> 
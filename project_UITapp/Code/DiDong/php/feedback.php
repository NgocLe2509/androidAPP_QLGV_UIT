<?php
	include("./include/config.php");
    $UserID = $_POST['item1'];
    $Content = $_POST['item2'];
    
    // sendmail
    $to = "18521155@gm.uit.edu.vn";
    $subject = "User Feedback App: ".$UserID;
    $head = "from: 18521155@gm.uit.edu.vn";
    $arr = array();
    if(mail($to, $subject, $Content, $head)){
        updateFeedBack($UserID, $Content);
        $rep= array("error"=>"false");
    }
    else{
        $rep= array("error"=>"true");
    }
    $arr[] = $rep;
	echo json_encode($arr);
?> 
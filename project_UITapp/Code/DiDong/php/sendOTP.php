<?php
   include("./include/config.php");
   $to = $_POST['item1'];
   $check_UserID = check_NguoiDung($to);
   if($check_UserID==null){
    $rep= array("sendmail"=>"fail");
	echo json_encode($rep);
   }
   else{
        $otp = get_OTP($to);
        $to = $to."@gm.uit.edu.vn";
        $subject = "Forgot password - UIT";
        $message = "Xin chào! Bạn hoặc một ai đó đã sử dụng chức năng quên mật khẩu. Nếu bạn muốn đặt lại mật khẩu thì nhập mã OTP sau đây: ";
        $message = $message.$otp;
        $head = "from: 18521155@gm.uit.edu.vn";
        $arr = array();
        if(mail($to, $subject, $message, $head)){
            $rep= array("sendmail"=>"success");
        }
        else{
            $rep= array("sendmail"=>"fail");
	        
        }
   }
   $arr[] = $rep;
   echo json_encode($arr);
?>
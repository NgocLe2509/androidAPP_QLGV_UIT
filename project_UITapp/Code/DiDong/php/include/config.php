<?php
// global connection variable
$connect = 0;
$conn;
header('Content-Type: application/json; charset=UTF-8');

// connect database
function connect_db()
{
	global $connect;
	global $conn;
	if($connect == 0){
		$conn=mysqli_connect("localhost","root","","QLGV") or die("Cannot connect");
		$conn -> set_charset("utf8");
		$connect = 1;
	}
}

// disconnect database
function disconnect_db()
{
	global $connect;
	global $conn;
	if ($connect == 1){
		mysqli_close($conn);	
		$connect = 0;
    }
}

// select table information
function get_NguoiDung($UserID, $Password)
{
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$Password = $conn -> real_escape_string($Password);

	$query = mysqli_query($conn, "select * from NguoiDung where UserID = '$UserID'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);
	disconnect_db();
	if($row == null)
	{
		return 0;
	}
	else if(password_verify($Password, $row['Password'])){
		return $row;
	}
	else {
		return 0;
	}
}

// check NguoiDung
function check_NguoiDung($UserID)
{
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);

	$query = mysqli_query($conn, "select * from NguoiDung where UserID = '$UserID'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);
	disconnect_db();

	return $row;
}

// check NguoiDung
function get_OTP($UserID)
{
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);

	$value_random = mt_rand(1000, 9999);

	$query = mysqli_query($conn, "update NguoiDung set Code = '$value_random' where UserID = '$UserID'") or die("Failed to query database");
	disconnect_db();

	return $value_random;
}

function chkCode($UserID, $Code){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$Code = $conn -> real_escape_string($Code);

	$query = mysqli_query($conn, "select * from NguoiDung where UserID = '$UserID'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);
	if($row['Code'] == $Code){
		mysqli_query($conn, "update NguoiDung set Code = 'FFFF' where UserID = '$UserID'") or die("Failed to query database");
		disconnect_db();
		return 1;
	}
	else{
		disconnect_db();
		return 0;
	}
}

// get info student
function get_SinhVien($UserID)
{
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);

	$query = mysqli_query($conn, "select * from SinhVien where MaSV = '$UserID'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);

	disconnect_db();
	return $row;
}

// change Password
function changePassword($UserID, $newPassword){
	global $conn;

	connect_db();
	$UserID = $conn -> real_escape_string($UserID);
	$newPassword = $conn -> real_escape_string($newPassword);

	mysqli_query($conn, "update NguoiDung SET Password = '$newPassword' where UserID = '$UserID'") or die("Failed to query database");
	disconnect_db();
}


// reset password
function resetPassword($UserID, $newPassword){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$newPassword = $conn -> real_escape_string($newPassword);

	mysqli_query($conn, "update NguoiDung SET Password = '$newPassword' where UserID = '$UserID'") or die("Failed to query database");
	
	disconnect_db();
}

// Feedback
function updateFeedBack($UserID, $Content){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$Content = $conn -> real_escape_string($Content);

	mysqli_query($conn, "insert into LienHeGopY(MaSV,NoiDung) values('$UserID','$Content')") or die("Failed to query database");
	
	disconnect_db();
}

// select table XepLop
function get_XepLop($UserID)
{
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);

	$query = mysqli_query($conn, "select * from XepLop where MaSV = '$UserID' and Ki = '1' and NienKhoa = '2020-2021'") or die("Failed to query database");
	$list = array();
	while($row = mysqli_fetch_assoc($query))
	{
		$list[] = $row;
	}

	disconnect_db();
	return $list;
}


// get info LichThi with MaLop
function get_LichThi($MaLop)
{
	global $conn;
	connect_db();

	$MaLop = $conn -> real_escape_string($MaLop);

	$query = mysqli_query($conn, "select * from LichThi where MaLH = '$MaLop'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);

	disconnect_db();
	return $row;
}

// get info LichThi
function get_ThoiKhoaBieu($MaLop)
{
	global $conn;
	connect_db();

	$MaLop = $conn -> real_escape_string($MaLop);

	$query = mysqli_query($conn, "select * from ThoiKhoaBieu where MaLopHP = '$MaLop'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);

	disconnect_db();
	return $row;
}

function get_KetQua($UserID)
{
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);

	$query = mysqli_query($conn, "select * from KetQua where MaSV = '$UserID'") or die("Failed to query database");
	$list = array();
	while($row = mysqli_fetch_assoc($query))
	{
		$list[] = $row;
	}

	disconnect_db();
	return $list;
}

function get_LopHP($MaLop)
{
	global $conn;
	connect_db();

	$MaLop = $conn -> real_escape_string($MaLop);

	$query = mysqli_query($conn, "select MaLopHP, KhaoSat from LopHP where MaLopHP = '$MaLop'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);

	disconnect_db();
	return $row;
}

function get_Game($Code)
{
	global $conn;
	connect_db();

	$Code = $conn -> real_escape_string($Code);

	$query = mysqli_query($conn, "select * from Game where IDGame = '$Code'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);

	disconnect_db();
	return $row;
}

function get_CauHoi($Code)
{
	global $conn;
	connect_db();

	$Code = $conn -> real_escape_string($Code);

	$query = mysqli_query($conn, "select * from CauHoi where IDGame = '$Code'") or die("Failed to query database");
	$list = array();
	while($row = mysqli_fetch_assoc($query))
	{
		$list[] = $row;
	}

	disconnect_db();
	return $list;
}

function insert_SV_game($IDGame, $MaSV, $SoCauDung){
	global $conn;
	connect_db();

	$IDGame = $conn -> real_escape_string($IDGame);
	$MaSV = $conn -> real_escape_string($MaSV);
	$SoCauDung = $conn -> real_escape_string($SoCauDung);

	mysqli_query($conn, "insert into SV_game(IDGame, MaSV, SoCauDung) values ('$IDGame', '$MaSV', '$SoCauDung')") or die("Failed to query database");

	disconnect_db();
}

function get_drl($UserID){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);

	$query = mysqli_query($conn, "select * from DRL where MaSV = '$UserID'") or die("Failed to query database");
	$list = array();
	while($row = mysqli_fetch_assoc($query))
	{
		$list[] = $row;
	}

	disconnect_db();
	return $list;
}

function get_ThongBao(){
	global $conn;
	connect_db();

	$query = mysqli_query($conn, "select * from ThongBao") or die("Failed to query database");
	$list = array();
	while($row = mysqli_fetch_assoc($query))
	{
		$list[] = $row;
	}

	disconnect_db();
	return $list;
}

function check_XepLop($UserID, $MaLop)
{
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$MaLop = $conn -> real_escape_string($MaLop);

	$query = mysqli_query($conn, "select * from XepLop where MaSV = '$UserID' and MaLopHP = '$MaLop'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);
	disconnect_db();
	if($row != null){
		return 0;
	}
	else {
		return 1;
	}
}

function get_hocphi($UserID){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);

	$query = mysqli_query($conn, "select * from HocPhi where MaSV = '$UserID'") or die("Failed to query database");
	$list = array();
	while($row = mysqli_fetch_assoc($query))
	{
		$list[] = $row;
	}

	disconnect_db();
	return $list;
}

function getXepLop($UserID, $HocKi, $Nam){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$HocKi = $conn -> real_escape_string($HocKi);
	$Nam = $conn -> real_escape_string($Nam);

	$query = mysqli_query($conn, "select * from XepLop where MaSV = '$UserID' and Ki = '$HocKi' and NienKhoa = '$Nam'") or die("Failed to query database");
	$list = array();
	while($row = mysqli_fetch_assoc($query))
	{
		$list[] = $row;
	}

	disconnect_db();
	return $list;
}

function get_Deadline(){
	global $conn;
	connect_db();

	$query = mysqli_query($conn, "select * from Deadline") or die("Failed to query database");
	$list = array();
	while($row = mysqli_fetch_assoc($query))
	{
		$list[] = $row;
	}

	disconnect_db();
	return $list;
}

function getNopBai($UserID, $STT){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$STT = $conn -> real_escape_string($STT);

	$query = mysqli_query($conn, "select * from NopBai where MaSV = '$UserID' and STTDeadline = '$STT'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);
	disconnect_db();
	if($row != null){
		return $row;
	}
	else {
		return 0;
	}
}

function deleteNopBai($UserID, $STT){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$STT = $conn -> real_escape_string($STT);
	if(mysqli_query($conn, "delete from NopBai where STT = '$STT' and MaSV ='$UserID'")){
		disconnect_db();
		return 1;
	}
	else {
		disconnect_db();
		return 0;
	}
	
}

function addNopBai($UserID, $STTBai, $Filename){
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$STTBai = $conn -> real_escape_string($STTBai);
	$Filename = $conn -> real_escape_string($Filename);

	if(mysqli_query($conn, "insert into NopBai(MaSV, STTDeadline, filename) values('$UserID','$STTBai', '$Filename')")){
		disconnect_db();
		return 1;
	}
	else {
		disconnect_db();
		return 0;
	}
}

function addDiemDanh($MaLop, $Buoi, $Code){
	global $conn;
	connect_db();

	$MaLop = $conn -> real_escape_string($MaLop);
	$Buoi = $conn -> real_escape_string($Buoi);
	$Code = $conn -> real_escape_string($Code);

	if(mysqli_query($conn, "insert into DiemDanh(MaLopHP,Buoi,code,TinhTrang) values('$MaLop','$Buoi', '$Code', 1)")){
		disconnect_db();
		return 1;
	}
	else {
		disconnect_db();
		return 0;
	}
}

function get_DiemDanh($Code){
	global $conn;
	connect_db();

	$Code = $conn -> real_escape_string($Code);

	$query = mysqli_query($conn, "select * from DiemDanh where code = '$Code' and TinhTrang = '1'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);
	disconnect_db();
	if($row != null){
		return $row;
	}
	else {
		return 0;
	}
}

function check_DiemDanh($UserID, $Code)
{
	global $conn;
	connect_db();

	$UserID = $conn -> real_escape_string($UserID);
	$Code = $conn -> real_escape_string($Code);

	$query = mysqli_query($conn, "select * from SVDiemDanh where MaSV = '$UserID' and code = '$Code'") or die("Failed to query database");
	$row = mysqli_fetch_assoc($query);
	disconnect_db();
	if($row != null){
		return 0;
	}
	else {
		return 1;
	}
}

function addSVDiemDanh($MaLop, $Buoi, $MaSV, $Code){
	global $conn;
	connect_db();

	$MaLop = $conn -> real_escape_string($MaLop);
	$Buoi = $conn -> real_escape_string($Buoi);
	$Code = $conn -> real_escape_string($Code);
	$MaSV = $conn -> real_escape_string($MaSV);

	if(mysqli_query($conn, "insert into SVDiemDanh(MaLopHP,Buoi,MaSV,code) values('$MaLop','$Buoi','$MaSV', '$Code')")){
		disconnect_db();
		return 1;
	}
	else {
		disconnect_db();
		return 0;
	}
}
?>
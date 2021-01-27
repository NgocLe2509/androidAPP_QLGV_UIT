create database QLGV;
use QLGV;
create table NguoiDung (UserID char(10) primary key, Password char(200), LoaiTK char(2), Code char(6));
create table Khoa (MaKhoa char(10) primary key, TenKhoa nvarchar(50), NGTLap datetime, TRGKhoa char(5));
create table MonHoc (MaMH char(10) primary key, TenMH nvarchar(50), TCLT int, TCTH int, MaKhoa char(10));
create table LopSH (MaLopSH char(10) primary key, TenLopSH nvarchar(100), SiSo int, CVHT char(10), MaKhoa char(10), NienKhoa int, HeDaoTao nvarchar(20));
create table LopHP (MaLopHP char(10) primary key, MaMH char(10), TenLopHP nvarchar(100), SiSo int, MaGV char(10), HocKy int, Nam int, NgayBD datetime, NgayKT datetime, KhaoSat varchar(100));
create table SinhVien (MaSV char(10) primary key, HoTen nvarchar(50), GioiTinh nvarchar(3), NgaySinh varchar(10), Email varchar(50), DiaChi nvarchar(100), SDT varchar(15), MaLopSH char(10), TinhTrang nvarchar(20), HocKi varchar(5));
create table XepLop (STT int AUTO_INCREMENT primary key, MaLopHP char(10), MaSV char(10), Ki int, NienKhoa int);
create table KetQua (STT int AUTO_INCREMENT primary key,MaSV char(10), Ki int, NamHoc char(10), MaMH char(10), MaLop char(10), TinChi int, QuaTrinh float, GiuaKi float, ThucHanh float, CuoiKi float, DTB float, KetQua int);
create table LichThi (MaLH char(10) primary key, TenLop nvarchar(50), Ca int, Ngay int, Thang int, Nam int, Phong varchar(10));
create table GiaoBai (STT int AUTO_INCREMENT primary key, MaLopHP char(10), TieuDe nvarchar(50), MoTa nvarchar(100),FileUpload nvarchar(500), NgayBD datetime, NgayKT datetime);
create table TraBai (STT int AUTO_INCREMENT primary key, STTBai int, MaSV char(10), FileUpload nvarchar(500));
create table GiangVien (MaGV char(10) primary key, HoTen nvarchar(50), HocVi_HocHam nvarchar(5), GioiTinh nvarchar(3), NgaySinh varchar(10), NgayLV datetime, Email nvarchar(100), DiaChi nvarchar(100), SDT char(10), HeSo decimal(15,2), MucLuong int, MaKhoa char(10));
create table DieuKien (MaMH char(10) primary key, MaMH_Truoc char(10));
create table ThongBao (STT int AUTO_INCREMENT primary key, LoaiTB int, MaLop char(10), Mon nvarchar(100), Thu int, Ngay char(10), Tiet varchar(12), Phong nvarchar(10), NoiDung nvarchar(5000));
create table LienHeGopY (STT int AUTO_INCREMENT primary key, MaSV char(10), NoiDung nvarchar(500));
create table HocPhi (STT int AUTO_INCREMENT primary key, MaSV char(10), HocKi int, NamHoc char(10), PhaiDong char(15), NoTruoc char(15), Tong char(15), DaDong char(15), ConLai char(15), Tai char(10), ThoiGian nvarchar(20));
create table ThoiKhoaBieu (MaLopHP char(10) primary key, TenLop nvarchar(50), TietBD int, TietSau varchar(5), Phong varchar(10), Day varchar(10), TenGV nvarchar(50));
create table KhaoSat (STT int AUTO_INCREMENT primary key, MaSV char(10), MaLop char(10),TenMauDon nvarchar(50), URL text );
create table DRL(STT int AUTO_INCREMENT primary key, MaSV char(10), HocKi int, Nam char(10), TongDiem int, XepLoai  nvarchar(10));
create table Deadline (STT int AUTO_INCREMENT primary key, MaLopHP char(10), NoiDung nvarchar(500), HanChot datetime);
create table NopBai(STT int AUTO_INCREMENT primary key, MaSV char(10), STTDeadline int, filename nvarchar(100));
create table DiemDanh (STT int AUTO_INCREMENT primary key, MaLopHP char(10), Buoi int, code int, TinhTrang int);
create table SVDiemDanh (STT int AUTO_INCREMENT primary key, MaLopHP char(10), Buoi int, MaSV char(10), code int);
create table Game (IDGame char(10), TenGame nvarchar(100), MaMon char(10), TinhTrang char(2));
create table CauHoi (STT int AUTO_INCREMENT primary key, IDGame char(10), CauHoi nvarchar(200), CauA nvarchar(200), CauB nvarchar(200), CauC nvarchar(200), CauD nvarchar(200), CauDung nvarchar(10));
create table SV_game(STT int AUTO_INCREMENT primary key, IDGame char(10), MaSV char(10), SoCauDung char(5));




insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT208.L11','Nộp bài lab 5.2','2020-09-20 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT208.L11','Nộp báo cáo Lab 6.2','2020-09-20 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT118.L11','Nộp thực hành Lab5','2020-09-22 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT118.L11','Nộp bài Lab 4.2','2020-09-22 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT118.L11','Nộp bài Lab 4 lớp .1','2020-09-22 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT118.L11','Nộp bài thực hành vuổi 5 (JS) - Buổi chẵn','2020-09-25 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT101.L11','Nộp slide báo cáo','2020-09-25 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT101.L11','Nộp bài thực hành buổi 4 - Buổi chẵn','2020-09-25 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT101.L11','Nộp bài thực hành Lab 5.1','2020-09-25 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT101.L11','Nộp Bài tập kiểm tra lab 6','2021-01-09 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('CS231.L11.KHTN','Nộp Bài tập kiểm tra lab 6','2021-01-09 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT118.L11','Nộp báo cáo lab 6.2','2021-01-10 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('IE104.L11','Nộp bài TH buổi 6','2021-01-11 00:00:00');
insert into Deadline(MaLopHP,NoiDung,HanChot) values('NT118.L11','Roadmap - Nộp theo nhóm - deadline 23h00 15/01/2000','2021-01-15 23:00:00');

insert into NopBai(MaSV, STTDeadline, filename) values('18521155', 1, 'DayLaFileBaiNopThuNhat_ahihi.doc');
insert into NopBai(MaSV, STTDeadline, filename) values('18521155', 3, 'DayLaFileBaiNopThuHai_ahihi.doc');
insert into NopBai(MaSV, STTDeadline, filename) values('18521155', 14, 'DayLaFileBaiNopRoadmapThuBa_ahihi.doc');
insert into NopBai(MaSV, STTDeadline, filename) values('18521155', 13, 'DayLaFileBaiNopRoadmapThuBa_ahihi.doc');
insert into NopBai(MaSV, STTDeadline, filename) values('18521155', 12, 'DayLaFileBaiNopRoadmapThuBa_ahihi.doc');
insert into NopBai(MaSV, STTDeadline, filename) values('18521155', 10, 'DayLaFileBaiNopRoadmapThuBa_ahihi.doc');


insert into HocPhi (MaSV, HocKi, NamHoc, PhaiDong, NoTruoc, Tong, DaDong, ConLai, Tai, ThoiGian) values 
('18521155', 1, 2018, '5,260,000', '0','5,260,000', '5,260,000', '0', 'ACB', '2018-08-14'),
('18521155', 2, 2018, '4,600,000', '0','4,600,000', '4,600,000', '0', 'ACB', '2019-03-27'),
('18521155', 1, 2019, '5,300,000', '0','5,300,000', '4,600,000', '371,000', 'ACB', '2019-03-27'),
('18521155', 2, 2019, '4,929,000', '0','5,300,000', '5,300,000', '0', 'ACB', '2020-02-21'),
('18521155', 1, 2020, '5,850,000', '-371,000','5,479,000', '5,479,000', '0', 'ACB', '2020-08-10'),
('18521155', 2, 2020, '5,850,000', '0','5,850,000', '0', '-5,850,000', '', ''),
('18521198', 2, 2018, '4,600,000', '0','5,260,000', '4,600,000', '0', 'ACB', '2019-03-27'),
('18521198', 1, 2019, '4,600,000', '0','5,260,000', '4,600,000', '0', 'ACB', '2019-03-27'),
('18521198', 2, 2019, '4,600,000', '0','5,260,000', '4,600,000', '0', 'ACB', '2019-03-27'),
('18521198', 1, 2020, '4,600,000', '0','5,260,000', '4,600,000', '0', 'ACB', '2019-03-27');




insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(0,'NT118.L11', 'Phát triển ứng dụng trên thiết bị di động' ,'4', '15-09-2020', '', '', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(3,'', '' ,'', '', '', '', 'Anh/Chị vui lòng cập nhật ứng dụng trên Android, để điểm danh, vui lòng: Bật Location, Cấp quyền access Location, Quyền Get device infomation, sử dụng wifi UIT, UIT');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(0,'NT536.L11', 'Công nghệ truyền thông đa phương tiện' ,'3', '15-09-2020', '', '', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(0,'NT113.L11', 'Thiết kế mạng' ,'6', '2-10-2020', '', '', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(1,'NT113.L11', 'Thiết kế mạng' ,'5', '15-10-2020', '9,10', 'B6.08', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(2,'NT113.L11.1', 'TH Thiết kế mạng' ,'5', '19-11-2020', '9,10', 'B6.08', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(0,'NT536.L11', 'Công nghệ truyền thông đa phương tiện' ,'3', '17-11-2020', '', '', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(1,'NT536.L11', 'Công nghệ truyền thông đa phương tiện' ,'6', '27-11-2020', '6,7,8,9', 'B3.14', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(2,'NT536.L11.1', 'TH Công nghệ truyền thông đa phương tiện' ,'3', '1-12-2020', '9,10', 'B6.08', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(1,'NT113.L11', 'Thiết kế mạng' ,'4', '23-12-2020', '6,7,8,9', 'B6.08', '');
insert into ThongBao(LoaiTB, MaLop, Mon, Thu, Ngay, Tiet, Phong, NoiDung) values(0,'CS231.L11.KHTN', 'Nhập môn thị giác máy tính' ,'3', '29-12-2020', '', '', '');


insert into ThoiKhoaBieu values('NT118.L11', 'Phát triển ứng dụng trên thiết bị di động',1, '23', 'C310', '4', 'Trần Hồng Nghi');
insert into ThoiKhoaBieu values('NT208.L11', 'Lập trình ứng dụng web', 9, '0', 'B5.06', '2', 'Đỗ Thị Hương Lan');
insert into ThoiKhoaBieu values('NT101.L11', 'An toàn mạng máy tính', 1, '3', 'B6.08', '6', 'Tô Nguyễn Nhật Quang');
insert into ThoiKhoaBieu values('CS231.L11.KHTN', 'Nhập môn thị giác máy tính', 8, '90', 'B3.04', '7', 'Ngô Đức Thành');
insert into ThoiKhoaBieu values('IT006.L11', 'Kiến trúc máy tính', 1, '23', 'B5.08', '3', 'Phạm Minh Quân');
insert into ThoiKhoaBieu values('NT536.L11', 'Công nghệ truyền thông đa phương tiện', 4, '5', 'B6.08', '3', 'Lê kim Hùng');
insert into ThoiKhoaBieu values('IE104.L11', 'Internet và công nghệ web', 1, '234', 'B3.04', '5', 'Võ Tấn Khoa');
insert into ThoiKhoaBieu values('NT536.L11.1', 'TH Công nghệ truyền thông đa phương tiện', 6, '7890', 'B5.02', '4', 'Đỗ Thị Hương Lan');
insert into ThoiKhoaBieu values('NT113.L11', 'Thiết kế mạng', 4, '5', 'B6.08', '6', 'Trần Thị Dung');

insert into XepLop(MaLopHP, MaSV, Ki, NienKhoa) values 
('NT118.L11', '18521155', 1, 2020),
('NT101.L11', '18521155', 1, 2020),
('IT006.L11', '18521155', 1, 2020),
('NT536.L11', '18521155', 1, 2020),
('IE104.L11', '18521155', 1, 2020),
('PH001.L11', '18521155', 1, 2020),
('NT208.L11', '18521198', 1, 2020),
('NT118.L11', '18521198', 1, 2020),
('NT101.L11', '18521198', 1, 2020),
('NT208.L11', '18520062', 1, 2020),
('NT118.L11', '18520062', 1, 2020),
('NT101.L11', '18520062', 1, 2020),
('CS231.L11.KHTN', '18520367', 1, 2020),
('NT118.L11', '18520367', 1, 2020),
('NT536.L11.1', '18521155', 1, 2020),
('NT113.L11.1', '18521155', 1, 2020),
('NT113.L11', '18521155', 1, 2020);

INSERT INTO DRL (MaSV, HocKi, Nam, TongDiem, XepLoai) VALUES
('18521155', 1, '2018-2019', 90, 'Xuất sắc'),
('18521155', 2, '2018-2019', 85, 'Giỏi'),
('18521155', 3, '2019-2020', 80, 'Giỏi'),
('18521155', 4, '2019-2020', 110, 'Xuất sắc'),
('18521155', 5, '2020-2021', 100, 'Xuất sắc'),
('18520062', 2, 2019, 95, 'Xuất sắc'),
('18520367', 2, 2019, 90, 'Xuất sắc'),
('18521198', 2, 2019, 85, 'Giỏi');




insert into Game value ('GIT006', 'KTMT - Bộ Xử Lý', 'IT006.L11', '1');
insert into Game value ('G1', 'Game demo 1', 'NT208.L11', '1');
insert into Game value ('G2', 'Game demo 2', 'IT006.L11', '0');

insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'Trong các câu lệnh sau, câu lệnh nào có tín hiệu RegDst = 1.', 'addi', 'lw', 'add', 'beq', 'C');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'Khối nào không cần thiết trong datapath khi thực hiện lệnh beq rs, rt, imm?', 'I-mem', 'Register', 'ALU.', 'D-mem', 'D');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'Những thanh ghi, bộ ALU và những kết nối giữa chúng được gọi chung là:', 'Process route', 'Information trail', 'Information path', 'Data path', 'D');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'Bộ vi xử lí thực thi “fetching” hay “decoding” của một lệnh trong khi nó đang thực thi một lệnh khác thì được gọi là:', 'Supper-scaling', 'Pipe-lining', 'Parallel computation', 'Tất cả đều sai', 'B');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'CISC viết tắt của:', 'Reduced Instruction Sequential Computing', 'Reduced Instruction Set Computing', 'Restricted Instruction Sequential Compiler', 'Restricted Instruction Set Compiler', 'B');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'Kiến trúc máy tính nào hướng đến việc giảm thời gian thực thi lệnh chương trình:', 'CISC', 'RISC', 'ISA', 'ANNA', 'B');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'CPU sẽ làm gì khi nhận được một tín hiệu ngắt', 'Lưu giá trị trạng thái trước đó', 'Lưu giá trị trạng thái hiện tại', 'Lưu giá trị trạng thái kế tiếp', 'Cả a và b', 'A');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'Tập lệnh MIPS thuộc họ tập lệnh:', 'CISC', 'RISC', 'ISA', 'IANA', 'B');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'Thứ tự các bước để thực thi một lệnh:', 'Instruction Fetch => Instruction Decoder => Execute => Operand Fetch', 'Instruction Decoder => Instruction Fetch => Operand Fetch => Execute', 'Instruction Fetch => Instruction Decoder => Operand Fetch => Execute', 'Operand Fetch => Instruction Fetch => Instruction Decoder => Execute', 'C');
insert into CauHoi(IDGame, CauHoi, CauA, CauB, CauC, CauD, CauDung) values ('GIT006', 'Khi cờ Z của CPU được bật lên 1, nó báo hiệu:', 'Phép toán thực thi có kết quả bị lỗi', 'Phép toán thực thi có kết quả bằng 1', 'Phép toán thực thi có kết quả bị tràn', 'Phép toán thực thi có kết quả bằng 0', 'D');


insert into LopHP values
('CS231.L11.', 'CS231', 'Nhập môn thị giác máy tính', 30, 'dungmt', 1, 2020, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'https://docs.google.com/forms/d/e/1FAIpQLSezZQgNpWdnxDIaspPfx-shRfdKpnjRW1aD0-aSxYyUDrWibQ/viewform'),
('NT101.L11', 'NT101', 'An toàn mạng máy tính', 50, 'quangtnn', 1, 2020, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'https://docs.google.com/forms/d/e/1FAIpQLSezZQgNpWdnxDIaspPfx-shRfdKpnjRW1aD0-aSxYyUDrWibQ/viewform'),
('NT118.L11', 'NT118', 'Phát triển ứng dụng trên thiết bị di động', 50, 'nghith', 1, 2020, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'https://docs.google.com/forms/d/e/1FAIpQLSezZQgNpWdnxDIaspPfx-shRfdKpnjRW1aD0-aSxYyUDrWibQ/viewform'),
('NT208.L11', 'NT208', 'Lập trình ứng web', 50, 'landth', 1, 2020, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'https://docs.google.com/forms/d/e/1FAIpQLSezZQgNpWdnxDIaspPfx-shRfdKpnjRW1aD0-aSxYyUDrWibQ/viewform'),
('IT006.L11', 'IT006', 'Kiến trúc máy tính', 50, 'quanpm', 1, 2020, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'https://docs.google.com/forms/d/e/1FAIpQLSezZQgNpWdnxDIaspPfx-shRfdKpnjRW1aD0-aSxYyUDrWibQ/viewform'),
('NT536.L11', 'NT536', 'Công nghệ truyền thông đa phương tiện', 50, 'hunglk', 1, 2020, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'https://docs.google.com/forms/d/e/1FAIpQLSezZQgNpWdnxDIaspPfx-shRfdKpnjRW1aD0-aSxYyUDrWibQ/viewform'),
('IE104.L11', 'IE104', 'Internet và công nghệ web', 50, 'landth', 1, 2020, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'https://docs.google.com/forms/d/e/1FAIpQLSezZQgNpWdnxDIaspPfx-shRfdKpnjRW1aD0-aSxYyUDrWibQ/viewform'),
('PH001.L11', 'PH001', 'Nhập môn điện tử', 50, 'thulnb', 1, 2020, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'https://docs.google.com/forms/d/e/1FAIpQLSezZQgNpWdnxDIaspPfx-shRfdKpnjRW1aD0-aSxYyUDrWibQ/viewform');


insert into NguoiDung values('18521155','$2y$10$z7TyQuOTLsQ4MT8HwBDe.uP.N1HveT4HYBbIjh5bfGXu0FvLqBdLa','SV','');
insert into NguoiDung values('18521198','$2y$10$z7TyQuOTLsQ4MT8HwBDe.uP.N1HveT4HYBbIjh5bfGXu0FvLqBdLa','SV','');
insert into NguoiDung values('18520062','$2y$10$z7TyQuOTLsQ4MT8HwBDe.uP.N1HveT4HYBbIjh5bfGXu0FvLqBdLa','SV','');
insert into NguoiDung values('18520367','$2y$10$z7TyQuOTLsQ4MT8HwBDe.uP.N1HveT4HYBbIjh5bfGXu0FvLqBdLa','SV','');
insert into NguoiDung values('11111111','$2y$10$z7TyQuOTLsQ4MT8HwBDe.uP.N1HveT4HYBbIjh5bfGXu0FvLqBdLa','GV','');
insert into NguoiDung values('22222222','$2y$10$z7TyQuOTLsQ4MT8HwBDe.uP.N1HveT4HYBbIjh5bfGXu0FvLqBdLa','GV','');
insert into NguoiDung values('33333333','$2y$10$z7TyQuOTLsQ4MT8HwBDe.uP.N1HveT4HYBbIjh5bfGXu0FvLqBdLa','GV','');
insert into NguoiDung values('44444444','$2y$10$z7TyQuOTLsQ4MT8HwBDe.uP.N1HveT4HYBbIjh5bfGXu0FvLqBdLa','GV','');

insert into Khoa values('MMTT','Mạng Máy Tính Và Truyền Thông','1/1/2010', 'Lê Trung Quân');
insert into Khoa values('KHMT','Khoa Học Máy Tính','1/1/2010', 'Mai Tiến Dũng');

insert into MonHoc values('NT118','Phát triển ứng dụng trên thiết bị di động','3','1','MMTT');
insert into MonHoc values('NT208','Lập trình ứng dụng web','2','1','MMTT');
insert into MonHoc values('NT101','An toàn mạng máy tính','3','1','MMTT');
insert into MonHoc values('CS231','Nhập môn thị giác máy tính','3','1','KHMT');



insert into LopSH values('MMTT2018','Mạng máy tính truyền thông 2018','70', '', 'MMTT', 2018, 'Chính Quy');
insert into LopSH values('KHTN2018','Khoa học tài năng 2018','30', '', 'KHMT', 2018, 'Chính Quy');

insert into SinhVien  values('18521155','Lê Thị Hồng Ngọc','Nữ','25-09-2000','18521155@gm.uit.edu.vn', 'Đồng Tháp', '0123456789', 'MMTT2018', 'Đang học', 'HK5');
insert into SinhVien  values('18521198','A Nguyễn Thị Yến Nhi','Nữ','1-1-2000','18521198@gm.uit.edu.vn', 'TP HCM', '0123456765', 'MMTT2018', 'Đang học', 'HK5');
insert into SinhVien  values('18520062','Ngô Thái Hưng','Nam','2-2-2000','18520062@gm.uit.edu.vn', 'Phú Yên', '0123456723', 'MMTT2018', 'Đang học', 'HK5');
insert into SinhVien  values('18520367','Nguyễn Vương Thịnh','Nam','3-3-2000','18520367@gm.uit.edu.vn', 'Bình Dương', '0123456787', 'KHMT2018', 'Đang học', 'HK5');



insert into LichThi values
('CS231.L11', 'Nhập môn thị giác máy tính', 1, 11, 1, 2021, 'B6.08'),
('NT101.L11', 'An toàn mạng máy tính',2, 12, 1, 2021, 'B5.08'),
('NT118.L11', 'Phát triển ứng dụng trên thiết bị di động', 3, 13, 1, 2021, 'B4.08'),
('NT208.L11', 'Lập trình ứng dụng web', 4, 14, 1, 2021, 'B3.08'),
('IT006.L11', 'Kiến trúc máy tính', 1, 15, 1, 2021, 'B2.08'),
('NT536.L11', 'Công nghệ truyền thông đa phương tiện', 2, 16, 1, 2021, 'B1.08'),
('IE104.L11', 'Internet và công nghê Web', 3, 17, 1, 2021, 'B7.08'),
('PH001.L11', 'Nhập môn điện tử', 4, 18, 1, 2021, 'B8.08');

insert into GiangVien values('11111111','Trần Hồng Nghi','Thạc sĩ','Nữ','1/1/1985','#NgayLV','nghitr@uit.edu.vn','TP HCM','0771234567', '','', 'MMTT');
insert into GiangVien values('22222222','Đỗ Thị HƯơng Lan','Thạc sĩ','Nữ','10/10/1990','#NgayLV','landth@uit.edu.vn','TP HCM','0771234987','','' , 'MMTT');
insert into GiangVien values('33333333','Tô Nguyễn Nhật Quang','Thạc sĩ','Nam','5/5/1980','#NgayLV','quangtnn@uit.edu.vn','TP HCM','0771234567','','', 'MMTT');
insert into GiangVien values('44444444','Mai Tiến Dũng','Tiến sĩ','Nam','5/5/1980','#NgayLV','dungmt@uit.edu.vn','TP HCM','0771452567','','', 'KHMT');

insert into DieuKien values('NT208','NT106');
insert into DieuKien values('NT118','IT002 & IT005');
insert into DieuKien values('NT101','IT005');
insert into DieuKien values('CS231','Không có');


insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 1, '2018-2019', 'ENGA2','ENGA2.J14','0','','','','', '5.5','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 1, '2018-2019', 'IT001','IT001.J16','4','10','10','10','8.5', '9.3','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 1, '2018-2019', 'IT009','IT009.J16','2','6','','','8', '7','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 1, '2018-2019', 'Ma003','Ma003.J16','3','10','','8','9', '9','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 1, '2018-2019', 'Ma006','Ma006.J16','4','10','','10','5', '7','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 1, '2018-2019', 'PE001','PE001.J16','0','','','9','6.5', '8','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 2, '2018-2019', 'ENG01','ENG01.J24','4','10','','','5.5', '6.9','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 2, '2018-2019', 'IT002','IT002.J26','4','9','9.5','','6.5', '7.9','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 2, '2018-2019', 'IT003','IT003.J25','4','10','7.5','10','8.8', '7.7','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 2, '2018-2019', 'MA005','MA005.J28','3','8.5','','7.5','8', '8','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 2, '2019-2020', 'IT004','IT004.K12','4','','8.5','8.5','9', '8.8','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 2, '2019-2020', 'ENG002','ENG002.K12','4','','8.5','8.5','6', '7','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 3, '2019-2020', 'IT005','IT005.K15','4','','10','8.5','9.5', '9.3','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 3, '2019-2020', 'SS001','SS001.K13','5','','','8.5','6.5', '7.3','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 3, '2019-2020', 'SS004','SS004.K15','2','9','','6.5','8.5', '8','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 3, '2019-2020', 'NT208','NT208.K15','4','','10','8.5','9.5', '9.3','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 3, '2019-2020', 'CS231','CS231.K13','5','','','8.5','6.5', '7.3','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 3, '2019-2020', 'SS002','SS002.K15','2','9','','6.5','8.5', '8','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 4, '2019-2020', 'NT105','NT105.K21','4','8','7.5','9.5','9.5', '8.9','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 4, '2019-2020', 'NT106','NT106.K21','3','','9','8','6', '7.2','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 4, '2019-2020', 'NT132','NT132.K21','4','8.5','9.5','','8.5', '8.8','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 4, '2019-2020', 'ENGA1','ENGA1.J14','0','7','7','7','7', '7','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 4, '2019-2020', 'PH002','PH002.K25','4','7','8.5','','7.5', '7.6','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 4, '2019-2020', 'IE104','IE104.K25','4','8','8.5','','8', '8.1','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 5, '2020-2021', 'IT006','IT006.L11','3','','','9','', '','1');
insert into KetQua(MaSV,Ki,NamHoc,MaMH,MaLop,TinChi,QuaTrinh,GiuaKi,ThucHanh,CuoiKi,DTB,KetQua) values('18521155', 5, '2020-2021', 'NT118','NT118.L11','3','','','9.5','', '','1');
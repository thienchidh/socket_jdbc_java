CREATE DATABASE dbBaiTap CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use dbBaiTap;

create table SinhVien(MSSV nvarchar(15) not null primary key, HoTen nvarchar(250), Lop nvarchar(15), isDelete bit default 0, MSBT nvarchar(15)) ;

create table BaiTap(MSBT nvarchar(15) not null primary key, TenBaiTap nvarchar(250), DeBai text, doKho nvarchar(15), DaHoanThanh bit default 0, isDelete bit default 0);

alter table SinhVien
add constraint FK_MSBT foreign key (MSBT) references BaiTap(MSBT);



DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addBaiTap`($MSBT nvarchar(15), $TenBaiTap nvarchar(250), $DeBai text, $doKho nvarchar(15))
begin
	if exists (select * from BaiTap where MSBT = $MSBT) then
		select 'MSBT has already exists!.'; 
    else
		insert into baitap(MSBT, TenBaiTap, DeBai ,doKho, DaHoanThanh, isDelete) values
			($MSBT, $TenBaiTap, $DeBai, $doKho, 0, 0);
		select 'add ex success!.';
	end if;
end$$
DELIMITER ;

--
call addBaiTap ('bt1', 'Bài Tập 1', '1 + 2' , 'Dễ');
call addBaiTap ('bt2', 'Bài Tập 2', '1 + 3  = 4, hỏi 4 là số tự nhiên addSinhVienthứ mấy?','Trung Bình');
call addBaiTap ('bt3', 'Bài Tập 3', 'trả lời bài tập 2 <bt2> rồi nhân 100, chia 4 , cộng bao nhiêu thì ra kết quả là 0 ?' ,'Khó');

--
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSinhVien`($MSSV nvarchar(15), $HoTen nvarchar(250), $Lop nvarchar(15))
BEGIN
	if exists (select * from Sinhvien where MSSV = $MSSV) then
		select 'MSSV already exists!.';
	else
		insert into SinhVien(MSSV, HoTen, Lop, isDelete, MSBT) values
			($MSSV, $HoTen, $Lop, 0, 'bt1');
		select 'add Success!.';
	end if;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteBaiTap`($MSBT nvarchar(15))
begin
	if not exists (select * from BaiTap where MSBT = $MSBT) then
		select 'MSBT has not already exists!.'; 
    else
		update BaiTap set isDelete = 1
			where MSBT = $MSBT;
		select 'delete success!.';
	end if;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteSinhVien`($MSSV nvarchar(15))
begin
	if not exists (select * from SinhVien where MSSV = $MSSV) then
		select 'MSSV is not already exists!.'; 
    else
		update SinhVien set isDelete = 1
			where MSSV = $MSSV;
		select 'delete success!.';
	end if;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `doneBaiTap`($MSBT nvarchar(15))
begin
	if not exists (select * from BaiTap where MSBT = $MSBT) then
		select 'MSBT is not already exists!.'; 
    else
		update BaiTap set DaHoanThanh = 1
			where MSBT = $MSBT;
		select 'delete success!.';
	end if;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBaiTap`($MSBT nvarchar(15), $TenBaiTap nvarchar(250), $DeBai text, $doKho nvarchar(15))
begin
	if not exists (select * from BaiTap where MSBT = $MSBT) then
		select 'MSBT has not already exists!.'; 
    else
		update BaiTap set TenBaitap = $TenbaiTap, DeBai = $DeBai,doKho = $doKho
			where MSBT = $MSBT;
		select 'update success!.';
	end if;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSinhVien`($MSSV nvarchar(15), $HoTen nvarchar(250), $Lop nvarchar(15), $MSBT nvarchar(15))
BEGIN
	if not exists (select * from Sinhvien where MSSV = $MSSV) then
		select 'MSSV not already exists!.';
	else
		update SinhVien set HoTen = $HoTen, Lop = $Lop, MSBT = $MSBT
			where MSSV = $MSSV;
		select 'update Success!.';
	end if;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getBaiTap`()
BEGIN
	select * from BaiTap where isDelete = 0;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSinhVien`()
BEGIN
	select * from SinhVien where isDelete = 0;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `timKiemSinhVien`($MSSV nvarchar(15))
BEGIN
	select * from SinhVien where isDelete = 0 and mssv = $MSSV;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `timKiemBaiTap`($MSBT nvarchar(15))
BEGIN
	select * from BaiTap where isDelete = 0 and MSBT = $MSBT;
END$$
DELIMITER ;

--

call addSinhVien('sv01', 'Nguyễn Văn An',		'6');
call addSinhVien('sv02', 'Hồ Anh Bình',			'7');
call addSinhVien('sv03', 'Chú Văn Giải',		'8');
call addSinhVien('sv04', 'Lại Cố Thoát',		'9');
call addSinhVien('sv05', 'Trần Nhà Không Yên',	'10');
call addSinhVien('sv06', 'Huỳnh Tỉnh Giấc',		'11');
call addSinhVien('sv07', 'Nguyễn Ngọc Ngàn',	'12');
call addSinhVien('sv08', 'Đặng Thị Thu',		'13');
--

call getSinhVien();
call getBaiTap();

--



/* This comment for MSSQL Server Managerment Studio */
/*
USE MASTER
GO
IF(EXISTS(SELECT * FROM SYSDATABASES WHERE NAME='BTLJava'))
	DROP DATABASE BTLJava
GO
USE MASTER
GO

CREATE DATABASE BTLJava
GO
USE BTLJava
GO

*/

GO
CREATE TABLE CanBo (
  IDCanBo int IDENTITY NOT NULL PRIMARY KEY, 
  HoTen   nvarchar(100) NULL, 
  NamSinh  varchar(50) NULL, 
  GioiTinh  nvarchar(20) NULL, 
  DiaChi   nvarchar(200) NULL,
  ChucVu nvarchar(50) NULL,
  MoTa nvarchar(100) NULL,
  Username   nvarchar(200) NULL,
  Password   nvarchar(200) NULL,
  isAdmin integer NULL,
);

go

/* INSERT DATABASE */
---------------------------------
INSERT INTO CanBo VALUES(N'Hà Quốc Tuấn','2000',N'Nam',	N'Hải Dương',N'Công nhân',N'Bậc 3/7','hqt','1234',1),
(N'An Thanh Thảo','2000',N'Nữ',	N'Hải Dương',N'Kỹ sư',N'CNTT','att','1234',0),
(N'Nguyễn Thị Yến','2000',N'Nữ',	N'Bắc Giang',N'Nhân viên',N'Phục vụ','nty','1234',0),
(N'Thảo Yến','2000',N'Nữ',	N'Hải Phòng',N'Công nhân',N'Bậc 4/7','thaoyen','1234',0),
(N'Hà Tuấn','2000',N'Nam',	N'Hà Nội',N'Kỹ Sư',N'Phần mềm','hatuan','1234',0)



/*
truy van
*/

select * from CanBo

select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa, Username, Password, isAdmin 
from CanBo 

--lay danh sach ky su
select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa 
from CanBo 
where ChucVu = N'Kỹ sư'


--lay danh sach nhan vien
select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa 
from CanBo 
where ChucVu = N'Nhân viên'

--lay danh sach cong nhan
select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa 
from CanBo 
where ChucVu = N'Công nhân'

--isAdmin
select isAdmin 
from CanBo
where Username = 'hqt'and Password = 1234

select isAdmin 
from CanBo
where Username = 'attt' 

--tim kiem theo ten
select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa 
from CanBo 
where HoTen = N'Hà Quốc Tuấn'

--sap xep theo ten
select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa 
from CanBo 
order by HoTen

--sap xep theo nam sinh
select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa 
from CanBo 
order by NamSinh

--xoa CanBo theo id, test ID = 1

delete from CanBo
where IDCanBo = 2
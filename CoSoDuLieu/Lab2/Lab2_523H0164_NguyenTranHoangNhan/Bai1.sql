create database QUANLYSINHVIEN;
use QUANLYSINHVIEN;


-- cau 1
create table SINHVIEN(
	HOSV varchar(50),
	TENSV varchar(50),
	MASV varchar(50) primary key,
	NGAYSINH varchar(50),
	PHAI varchar(5),
	MAKHOA varchar(50)
);

create table KHOA(
	MAKHOA varchar(50) primary key,
	TENKHOA varchar(50)
);

create table KETQUA(
	MASV varchar(50),
	MAMH varchar(50),
	LANTHI int,
	DIEM int,
	primary key(MASV,MAMH,LANTHI)
);

create table MONHOC(
	TENMH varchar(50),
	MAMH varchar(50) primary key,
	SOTIET int
);

alter table SINHVIEN add foreign key (MAKHOA) references KHOA(MAKHOA);
alter table KETQUA add foreign key (MASV) references SINHVIEN(MASV);
alter table KETQUA add foreign key (MAMH) references MONHOC(MAMH);


-- cau 2
alter table KETQUA drop constraint ketqua_mamh_fkey;
alter table KETQUA drop constraint ketqua_masv_fkey;

-- cau 3
drop table KHOA CASCADE;
drop table MONHOC CASCADE;

-- cau 4
create table KHOA(
	MAKHOA varchar(50) primary key,
	TENKHOA varchar(50)
);

create table MONHOC(
	TENMH varchar(50),
	MAMH varchar(50) primary key,
	SOTIET int
);

alter table KETQUA add constraint fk_masv foreign key (MASV) references SINHVIEN(MASV);
alter table KETQUA add constraint fk_mamh foreign key (MAMH) references MONHOC(MAMH);


-- cau 5
insert into SINHVIEN values
('Tran Minh', 'Son', 'S001', '1985-11-05', 'Nam', 'CNTT'),
('Nguyen Quoc', 'Bao', 'S002', '1986-06-15', 'Nam', 'CNTT'),
('Phan Anh', 'Tung', 'S003', '1983-12-20', 'Nam', 'QTKD'),
('Bui Thi anh', 'Thu', 'S004', '1985-02-01', 'Nu', 'QTKD'),
('Le Thi Lan', 'Anh', 'S005', '1987-07-03', 'Nu', 'DTVT'),
('Nguyen Thi', 'Lam', 'S006', '1984-11-25', 'Nu', 'DTVT'),
('Phan Thi', 'Ha', 'S007', '1988-07-03', 'Nu', 'CNTT'),
('Tran The', 'Dung', 'S008', '1985-10-21', 'Nam', 'CNTT');

insert into KHOA values
('AVAN', 'Khoa anh Van'),
('CNTT', 'Cong Nghe Thong tin'),
('DTVT', 'Dien Tu Vien Thong'),
('QTKD', 'Quan Tri Kinh Doanh');

insert into MONHOC values
('Anh Van', 'AV', 45),
('Co So Du Lieu', 'CSDL', 45),
('Ky Thuat Lap Trinh', 'KTLT', 60),
('Ke Toan Tai Chinh', 'KTTC', 45),
('Toan Cao Cap', 'TCC', 60),
('Tin Hoc Van Phong', 'THVP', 30),
('Tri Tue Nhan Tao', 'TTNT', 45);

insert into KETQUA values
('S001', 'CSDL', 1, 4),
('S001', 'TCC', 1, 6),
('S002', 'CSDL', 1, 3),
('S002', 'CSDL', 2, 6),
('S003', 'KTTC', 1, 5),
('S004', 'AV', 1, 8),
('S004', 'THVP', 1, 4),
('S004', 'THVP', 2, 8),
('S006', 'TCC', 1, 5),
('S007', 'AV', 1, 2),
('S007', 'AV', 2, 9),
('S007', 'KTLT', 1, 6),
('S008', 'AV', 1, 7);

-- cau 6
update MONHOC set SOTIET=30 where TENMH='Tri Tue Nhan Tao';

-- cau 7
delete from KETQUA where MASV='S001';

-- cau 8
insert into KETQUA values
('S001', 'CSDL', 1,4)
('S001', 'TCC', 1, 6)

-- cau 9
update SINHVIEN set HOSV='Nguyen Van', PHAI='Nam' where HOSV='Nguyen Thi' and TENSV='LAM';

-- cau 10
update SINHVIEN set MAKHOA='CNTT' where HOSV='Le Thi Lan' and TENSV='Anh';

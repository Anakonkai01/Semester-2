create database QuanLyBanHang;
use QuanLyBanHang;


-- cau 1, cau 2, cau 3, cau 4
create table khachhang (
    makhachhang varchar(50) primary key,
    tencongty varchar(50),
    tengiaodich varchar(50),
    diachi varchar(100),
    email varchar(50),
    dienthoai varchar(50),
    fax varchar(50)
);

create table nhacungcap (
    macongty varchar(50) primary key,
    tencongty varchar(50),
    tengiaodich varchar(50),
    diachi varchar(100),
    dienthoai varchar(50),
    fax varchar(50),
    email varchar(50)
);

create table mathang (
    mahang varchar(50) primary key,
    tenhang varchar(50),
    macongty varchar(50),
    maloaihang varchar(50),
    soluong int,
    donvitinh varchar(50),
    giahang decimal(10, 2),
    foreign key (macongty) references nhacungcap(macongty),
    foreign key (maloaihang) references loaihang(maloaihang)
);

create table loaihang (
    maloaihang varchar(50) primary key,
    tenloaihang varchar(50)
);

create table nhanvien (
    manhanvien varchar(50) primary key,
    ho varchar(50),
    ten varchar(50),
    ngaysinh date,
    ngaylamviec date,
    diachi varchar(100),
    dienthoai varchar(50),
    luongcoban decimal(10, 2),
    phucap decimal(10, 2),
	check (date_part('year', age(current_date, ngaysinh)) >= 18), --cau 4
    check (date_part('year', age(current_date, ngaysinh)) <= 60) --cau 4
);

create table dondathang (
    sohoadon varchar(50) primary key,
    makhachhang varchar(50),
    manhanvien varchar(50),
    ngaydathang date,
    ngaygiaohang date,
    ngaychuyenhang date,
    noigiaohang varchar(100),
    foreign key (makhachhang) references khachhang(makhachhang),
    foreign key (manhanvien) references nhanvien(manhanvien),
    check (ngaygiaohang >= ngaydathang), -- cau 3	
    check (ngaychuyenhang >= ngaydathang) -- cau3
);

create table chitietdathang (
    sohoadon varchar(10),
    mahang varchar(10),
    giaban decimal(10, 2),
    soluong int default 1, -- cau 2
    mucgiamgia decimal(5, 2) default 0, -- cau 2
    primary key (sohoadon, mahang),
    foreign key (sohoadon) references dondathang(sohoadon),
    foreign key (mahang) references mathang(mahang)
);


-- cau 5
alter table mathang drop constraint fk_macongty; 
drop table nhacungcap;

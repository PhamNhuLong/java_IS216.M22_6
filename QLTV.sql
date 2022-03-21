create database QLTV;
use QLTV;

/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2017                    */
/* Created on:     18/03/2022 23:35:29                          */
/*==============================================================*/

/*==============================================================*/
/* Table: CTMS                                                  */
/*==============================================================*/
create table CTMS (
   MASACH               char(6)              not null,
   MAPHIEUMUON          char(6)              not null,
   constraint PK_CTMS primary key (MASACH, MAPHIEUMUON)
)


/*==============================================================*/
/* Table: CTTS                                                  */
/*==============================================================*/
create table CTTS (
   MASACH               char(6)              not null,
   MAPHIEUTRA           char(6)              not null,
   SONGAYTRATRE         int                  null,
   TIENPHAT             numeric              null,
   constraint PK_CTTS primary key (MASACH, MAPHIEUTRA)
)

/*==============================================================*/
/* Table: CUONSACH                                              */
/*==============================================================*/
create table CUONSACH (
   MASACH               char(6)              not null,
   MADAUSACH            char(6)              null,
   TINHTRANG            varchar(20)          null,
   constraint PK_CUONSACH primary key (MASACH)
)

/*==============================================================*/
/* Table: DAUSACH                                               */
/*==============================================================*/
create table DAUSACH (
   MADAUSACH            char(6)              not null,
   TENDAUSACH           varchar(50)          null,
   TACGIA               varchar(200)         null,
   NXB                  varchar(50)          null,
   NAMXB                numeric              null,
   TONGSO               numeric              null,
   VITRI                varchar(20)          null,
   SANCO                numeric              null,
   DANGCHOMUON          numeric              null,
   constraint PK_DAUSACH primary key (MADAUSACH)
)
go

/*==============================================================*/
/* Table: DOCGIA                                                */
/*==============================================================*/
create table DOCGIA (
   MADOCGIA             char(6)              not null,
   HOTEN                varchar(40)          null,
   NGAYSINH             datetime             null,
   LOAIDG               varchar(20)          null,
   DIACHI               varchar(50)          null,
   EMAIL                varchar(40)          null,
   NGLAPTHE             datetime             null,
   TINHTRANGDG          varchar(20)          null,
   constraint PK_DOCGIA primary key (MADOCGIA)
)

/*==============================================================*/
/* Table: HOADON                                                */
/*==============================================================*/
create table HOADON (
   MAHOADON             char(6)              not null,
   MAPHIEUTRA           char(6)              null,
   TIENNO               numeric              null,
   TIENTHU              numeric              null,
   TIENTHUA             numeric              null,
   constraint PK_HOADON primary key (MAHOADON)
)

/*==============================================================*/
/* Table: PHIEUMUONSACH                                         */
/*==============================================================*/
create table PHIEUMUONSACH (
   MAPHIEUMUON          char(6)              not null,
   MADOCGIA             char(6)              null,
   NGAYMUON             datetime             null,
   constraint PK_PHIEUMUONSACH primary key (MAPHIEUMUON)
)

/*==============================================================*/
/* Table: PHIEUTRASACH                                          */
/*==============================================================*/
create table PHIEUTRASACH (
   MAPHIEUTRA           char(6)              not null,
   MADOCGIA             char(6)              null,
   NGAYTRA              datetime             null,
   TIENPHATKINAY        numeric              null,
   constraint PK_PHIEUTRASACH primary key (MAPHIEUTRA)
)
/*==============================================================*/
/*							   KHÓA NGOẠI                       */
/*==============================================================*/
ALTER TABLE CUONSACH
ADD CONSTRAINT FK_CS_DS
  FOREIGN KEY (MADAUSACH)
  REFERENCES DAUSACH (MADAUSACH);

ALTER TABLE PHIEUMUONSACH
ADD CONSTRAINT FK_MS_DG
  FOREIGN KEY (MADOCGIA)
  REFERENCES DOCGIA (MADOCGIA);

ALTER TABLE PHIEUTRASACH
ADD CONSTRAINT FK_TS_DG
  FOREIGN KEY (MADOCGIA)
  REFERENCES DOCGIA (MADOCGIA);

ALTER TABLE HOADON
ADD CONSTRAINT FK_TS_HD
  FOREIGN KEY (MAPHIEUTRA)
  REFERENCES PHIEUTRASACH (MAPHIEUTRA);

ALTER TABLE CTMS
ADD CONSTRAINT FK_CTMS_PM
  FOREIGN KEY (MAPHIEUMUON)
  REFERENCES PHIEUMUONSACH (MAPHIEUMUON);

ALTER TABLE CTMS
ADD CONSTRAINT FK_CTMS_CS
  FOREIGN KEY (MASACH)
  REFERENCES CUONSACH (MASACH);

ALTER TABLE CTTS
ADD CONSTRAINT FK_CTTS_CS
  FOREIGN KEY (MASACH)
  REFERENCES CUONSACH (MASACH);

ALTER TABLE CTTS
ADD CONSTRAINT FK_CTTS_PT
  FOREIGN KEY (MAPHIEUTRA)
  REFERENCES PHIEUTRASACH (MAPHIEUTRA);

/*=================================================*/
/*===				 BANG USER					===*/
/*=================================================*/

CREATE TABLE NGUOIDUNG
(
        TEN VARCHAR(50) NOT NULL,
        MATKHAU VARCHAR(30),
        QUYEN INT, -- 1: QUảN Lý, 2: THủ THư
        CONSTRAINT PK_TEN PRIMARY KEY(TEN)
)
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
   MASACH              int              not null,
   MAPHIEUMUONSACH         int              not null,
   TINHTRANG		nvarchar(20),
   constraint PK_CTMS primary key (MASACH, MAPHIEUMUONSACH)
)


/*==============================================================*/
/* Table: CTTS                                                  */
/*==============================================================*/
create table CTTS (
   MASACH               int              not null,
   MAPHIEUTRA           int              not null,
   SONGAYTRATRE         int                  null,
   TIENPHAT             int              null,
   constraint PK_CTTS primary key (MASACH, MAPHIEUTRA)
)

/*==============================================================*/
/* Table: CUONSACH                                              */
/*==============================================================*/
create table CUONSACH (
   MASACH               int IDENTITY(1,1) PRIMARY KEY,
   MADAUSACH            int             null,
   TINHTRANG            nvarchar(20)          null,
)

/*==============================================================*/
/* Table: DAUSACH                                               */
/*==============================================================*/
create table DAUSACH (
   MADAUSACH            int IDENTITY(1,1) PRIMARY KEY,
   TENDAUSACH           nvarchar(50)          null,
   TACGIA               nvarchar(200)         null,
   NXB                  nvarchar(50)          null,
   NAMXB                int              null,
   TONGSO               int              null,
   VITRI                nvarchar(20)          null,
   SANCO                int              null,
   DANGCHOMUON          int              null,
)
go

/*==============================================================*/
/* Table: DOCGIA                                                */
/*==============================================================*/
create table DOCGIA (
   MADOCGIA             int IDENTITY(1,1) PRIMARY KEY,
   HOTEN                nvarchar(40)          null,
   NGAYSINH             datetime             null,
   LOAIDG               nvarchar(20)          null,
   DIACHI               nvarchar(50)          null,
   EMAIL                nvarchar(40)          null,
   NGLAPTHE             datetime             null,
   TINHTRANGDG          nvarchar(20)          null,
)

/*==============================================================*/
/* Table: HOADON                                                */
/*==============================================================*/
create table HOADON (
   MAHD            int IDENTITY(1,1) PRIMARY KEY,
   MAPHIEUTRA           int             not null,
   TIENNO               int              null,
   TIENTHU              int              null,
)

/*==============================================================*/
/* Table: PHIEUMUONSACH                                         */
/*==============================================================*/
create table PHIEUMUONSACH (
   MAPHIEUMUONSACH      int IDENTITY(1,1) PRIMARY KEY,
   MADOCGIA             int              not null,
   NGAYMUON             datetime             null,
)

/*==============================================================*/
/* Table: PHIEUTRASACH                                          */
/*==============================================================*/
create table PHIEUTRASACH (
   MAPHIEUTRA           int IDENTITY(1,1) PRIMARY KEY,
   MADOCGIA             int              not null,
   NGAYTRA              datetime             null,
   TIENPHATKINAY        int              null,
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
  FOREIGN KEY (MAPHIEUMUONSACH)
  REFERENCES PHIEUMUONSACH (MAPHIEUMUONSACH);

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
);


GO
CREATE PROC THEMCUONSACH (@mads int, @tongso int)
AS
DECLARE @COUNT	INT = 0;
WHILE @COUNT < @tongso
BEGIN
	INSERT INTO CUONSACH(MADAUSACH,TINHTRANG) VALUES (@mads,N'sẵn có');
	SET @COUNT = @COUNT + 1;
END;

go
CREATE TRIGGER TRG_DAUSACH
ON DAUSACH
AFTER INSERT
AS
DECLARE @MDS INT = 0;
DECLARE @TS INT = 0;
BEGIN
   SELECT TOP 1 @MDS =  MADAUSACH  FROM DAUSACH ORDER BY MADAUSACH DESC;
   SELECT TOP 1 @TS =  TONGSO  FROM DAUSACH ORDER BY MADAUSACH DESC;
   EXEC THEMCUONSACH @mads = @MDS,@tongso = @TS
END;



DROP PROCEDURE IF EXISTS XOACUONSACH; 
GO
CREATE PROC XOACUONSACH (@masach int,@mads int)
AS
SET NOCOUNT ON
DECLARE @COUNT INT = 0;
DECLARE @TONGSO INT = 0;
BEGIN
	SELECT @COUNT = COUNT(*) FROM CUONSACH JOIN CTMS ON CUONSACH.MASACH = CTMS.MASACH WHERE CTMS.MASACH = @masach;
	IF(@COUNT = 0)
		BEGIN
			DELETE FROM CUONSACH WHERE MASACH = @masach;
			UPDATE DAUSACH
			SET TONGSO = TONGSO -1,
				SANCO = SANCO -1
			WHERE MADAUSACH = @mads;
			SELECT @TONGSO = TONGSO FROM DAUSACH WHERE MADAUSACH = @mads;
			IF(@TONGSO = 0)
				BEGIN
					DELETE FROM DAUSACH WHERE MADAUSACH = @mads;
				END
		END
END;

DROP PROCEDURE IF EXISTS THEMCTTS; 
GO
CREATE PROC THEMCTTS (@mapts int, @ms int)
AS
DECLARE @mapm INT = 0;
DECLARE @madg INT = 0;
DECLARE @ngmuon DATE;
DECLARE @ngtra DATE;
DECLARE @songay int;
BEGIN
	select @madg = MADOCGIA
	from PHIEUTRASACH
	where MAPHIEUTRA = @mapts;

	select @ngmuon = pms.NGAYMUON, @mapm = pms.MAPHIEUMUONSACH
    from phieumuonsach pms, ctms
    where pms.maphieumuonsach = ctms.maphieumuonsach and pms.madocgia = @madg and ctms.masach = @ms and TINHTRANG = N'chưa trả';

	select @ngtra = NGAYTRA
	from PHIEUTRASACH P, CTTS
	WHERE P.MAPHIEUTRA = CTTS.MAPHIEUTRA AND P.MADOCGIA = @madg and MASACH = @ms;

	SET @songay = DATEDIFF(D,@ngmuon,@ngtra);
	IF @songay > 4
	BEGIN
		UPDATE CTTS
		SET SONGAYTRATRE = @songay - 4, TIENPHAT = (@songay - 4)*1000
		WHERE MAPHIEUTRA = @mapts AND MASACH = @ms;

		UPDATE PHIEUTRASACH
		SET TIENPHATKINAY = TIENPHATKINAY + (@songay - 4)*1000
		WHERE MAPHIEUTRA = @mapts
	END

	UPDATE CTMS
	SET TINHTRANG = N'đã trả'
	WHERE MAPHIEUMUONSACH = @mapm and MASACH = @ms

	UPDATE CUONSACH
	SET TINHTRANG = N'sẵn có'
	WHERE MASACH = @ms

	UPDATE DAUSACH
	SET SANCO = SANCO + 1, DANGCHOMUON = DANGCHOMUON -1
	FROM DAUSACH JOIN CUONSACH ON DAUSACH.MADAUSACH = CUONSACH.MADAUSACH
	WHERE MASACH = @ms

END;

go
CREATE TRIGGER TRG_CTTS
ON CTTS
AFTER INSERT
AS
DECLARE @MAPHIEUTRA INT = 0;
DECLARE @MASACH INT = 0;
BEGIN
  SELECT @MAPHIEUTRA = INSERTED.MAPHIEUTRA FROM INSERTED;
  SELECT @MASACH = INSERTED.MASACH FROM INSERTED;
   EXEC THEMCTTS @mapts = @MAPHIEUTRA,@ms = @MASACH
END;

GO
insert into DAUSACH(TENDAUSACH,NAMXB,NXB,SANCO,TONGSO,DANGCHOMUON,VITRI,TACGIA) VALUES (N'hồng hải', 2014, N'hồng hải', 3,3,0,N'kệ 1',N'hồng hải');
INSERT INTO DOCGIA(HOTEN,NGAYSINH,LOAIDG,DIACHI,NGLAPTHE,TINHTRANGDG,EMAIL) VALUES (N'hồng hải',convert(date,'2001-05-12'),N'sinh viên',N'hồng hải',convert(date,'2022-06-05'),N'còn hạn',N'hai@gmail.com');
INSERT INTO PHIEUMUONSACH(MADOCGIA,NGAYMUON) VALUES (1,convert(date,'2022-06-05'));
INSERT INTO CTMS VALUES (1,1,N'chưa trả');
INSERT INTO CTMS VALUES (2,1,N'chưa trả');
--INSERT INTO PHIEUTRASACH(MADOCGIA,NGAYTRA,TIENPHATKINAY) VALUES (1,convert(date,'2022-06-10'),0);
--insert into CTTS values (1,5,0,0);


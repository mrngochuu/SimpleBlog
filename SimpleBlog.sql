-- Database export via SQLPro (https://www.sqlprostudio.com/allapps.html)
-- Exported by ngochuu at 19-01-2020 14:13.
-- WARNING: This file may contain descructive statements such as DROPs.
-- Please ensure that you are running the script at the proper location.


-- BEGIN TABLE dbo.tblArticles
CREATE TABLE dbo.tblArticles (
	ArticleID int NOT NULL IDENTITY(1,1),
	Title varchar(200) NOT NULL,
	Description varchar(200) NOT NULL,
	Content varchar(max) NOT NULL,
	PostingDate date NOT NULL,
	StatusID int NOT NULL,
	email varchar(50) NOT NULL
);
GO

ALTER TABLE dbo.tblArticles ADD CONSTRAINT PK__tblArtic__9C6270C8CC2D9E89 PRIMARY KEY (ArticleID);
GO

-- Inserting 56 rows into dbo.tblArticles
-- Insert batch #1
INSERT INTO dbo.tblArticles (ArticleID, Title, Description, Content, PostingDate, StatusID, email) VALUES
(1, 'Cuoc doi', 'Song phai', 'Vui ve', '2000-01-04 00:00:00', 1, 'dongochuu95@gmail.com'),
(2, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(3, 'Khong thay do may lam nen', 'Co chi thi nen', 'An qua nho ke trong cay', '2000-01-04 00:00:00', 2, 'dongochuu95@gmail.com'),
(4, 'Cuoc song tuoi dep', 'Cuoc doi vui ve', 'Cuoc doi thanh cong', '2020-01-16 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(5, 'Thien thu', 'Ha Thien', 'Ngoc Huu', '2020-01-16 00:00:00', 3, 'dongochuu95@gmail.com'),
(7, 'Cuoc doi', 'Song phai', 'Vui ve', '2000-01-04 00:00:00', 1, 'dongochuu95@gmail.com'),
(8, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(9, 'Khong thay do may lam nen', 'Co chi thi nen', 'An qua nho ke trong cay', '2000-01-04 00:00:00', 2, 'dongochuu95@gmail.com'),
(10, 'Cuoc song tuoi dep', 'Cuoc doi vui ve', 'Cuoc doi thanh cong', '2020-01-16 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(11, 'Thien thu', 'Ha Thien', 'Ngoc Huu', '2020-01-16 00:00:00', 3, 'dongochuu95@gmail.com'),
(13, 'Cuoc doi', 'Song phai', 'Vui ve', '2000-01-04 00:00:00', 1, 'dongochuu95@gmail.com'),
(14, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(15, 'Khong thay do may lam nen', 'Co chi thi nen', 'An qua nho ke trong cay', '2000-01-04 00:00:00', 2, 'dongochuu95@gmail.com'),
(16, 'Cuoc song tuoi dep', 'Cuoc doi vui ve', 'Cuoc doi thanh cong', '2020-01-16 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(17, 'Thien thu', 'Ha Thien', 'Ngoc Huu', '2020-01-16 00:00:00', 3, 'dongochuu95@gmail.com'),
(19, 'Cuoc doi', 'Song phai', 'Vui ve', '2000-01-04 00:00:00', 1, 'dongochuu95@gmail.com'),
(20, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(21, 'Khong thay do may lam nen', 'Co chi thi nen', 'An qua nho ke trong cay', '2000-01-04 00:00:00', 2, 'dongochuu95@gmail.com'),
(22, 'Cuoc song tuoi dep', 'Cuoc doi vui ve', 'Cuoc doi thanh cong', '2020-01-16 00:00:00', 3, 'huudnse130557@fpt.edu.vn'),
(23, 'Thien thu', 'Ha Thien', 'Ngoc Huu', '2020-01-16 00:00:00', 3, 'dongochuu95@gmail.com'),
(24, 'AFC U23 Championship', 'Tháº¥t báº¡i cá»§a U23 Viá»?t Nam dÃ¹ gÃ¢y khÃ³ chá»?u, nhÆ°ng cáº§n thiáº¿t Ä?á»? chÃºng ta trá»? láº¡i máº·t Ä?áº¥t vÃ  phÃ¡t triá»?n bÃ³ng Ä?Ã¡ bá»?n vá»¯ng', 'KhÃ´ng cÃ³ phÃ©p mÃ u, chá»? cÃ³ thÃªm má»?t tháº¥t báº¡i. U23 Viá»?t Nam Ä?Ã£ bá»? loáº¡i khá»?i VCK U23 chÃ¢u Ã? sau nhá»¯ng mÃ n trÃ¬nh diá»?n khÃ´ng chÃºt thuyáº¿t phá»¥c. Váº­y lÃ½ do Ä?áº±ng sau ná»?i tháº¥t vá»?ng nÃ y lÃ  gÃ¬?', '2020-01-17 00:00:00', 3, 'dongochuu95@gmail.com'),
(25, 'Cuoc doi', 'Song phai', 'Vui ve', '2000-01-04 00:00:00', 1, 'dongochuu95@gmail.com'),
(26, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(27, 'Khong thay do may lam nen', 'Co chi thi nen', 'An qua nho ke trong cay', '2000-01-04 00:00:00', 2, 'dongochuu95@gmail.com'),
(28, 'Cuoc song tuoi dep', 'Cuoc doi vui ve', 'Cuoc doi thanh cong', '2020-01-16 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(29, 'Thien thu', 'Ha Thien', 'Ngoc Huu', '2020-01-16 00:00:00', 3, 'dongochuu95@gmail.com'),
(31, 'SQL GROUP BY Statement', 'SQL GROUP BY Statement\r\n', 'SQL GROUP BY Statement\r\n', '2020-01-18 00:00:00', 3, 'dongochuu95@gmail.com'),
(1006, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1007, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1008, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1009, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1010, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1011, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1012, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1013, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1014, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1015, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1016, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1017, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1018, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1019, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1020, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1021, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1022, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1023, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1024, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1025, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1026, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1027, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1028, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1029, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1030, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1031, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1032, 'Hoc', 'Hoc nua', 'Hoc mai', '2000-01-04 00:00:00', 2, 'huudnse130557@fpt.edu.vn'),
(1033, 'Harry and Meghan drop royal duties and HRH titles', 'Prince Harry and Meghan will no longer use their HRH titles and will not receive public funds for royal duties, Buckingham Palace has announced.', 'The couple will also no longer formally represent the Queen.\r\n\r\nThe Duke and Duchess of Sussex intend to repay Â£2.4m of taxpayer money for the refurbishment of Frogmore Cottage, which will remain their UK family home, the statement added.', '2020-01-19 00:00:00', 3, 'ngochuu.bts@gmail.com'),
(1034, 'Orthodox Christians brave an icy dip to mark Epiphany', 'Worshippers across Russia and Eastern Europe have been braving icy waters for Epiphany, one of the most important holidays in the Orthodox Christian calendar.', 'Celebrated on 19 January, Epiphany commemorates the baptism of Jesus in the River Jordan.', '2020-01-19 00:00:00', 2, 'dongochuu95@gmail.com');

-- END TABLE dbo.tblArticles

-- BEGIN TABLE dbo.tblCodes
CREATE TABLE dbo.tblCodes (
	Email varchar(50) NOT NULL,
	CodeNum int NOT NULL
);
GO

ALTER TABLE dbo.tblCodes ADD CONSTRAINT PK__tblCodes__A9D10535D158BF37 PRIMARY KEY (Email);
GO

-- Table dbo.tblCodes contains no data. No inserts have been genrated.
-- Inserting 0 rows into dbo.tblCodes


-- END TABLE dbo.tblCodes

-- BEGIN TABLE dbo.tblComments
CREATE TABLE dbo.tblComments (
	CommentID int NOT NULL IDENTITY(1,1),
	Content varchar(max) NOT NULL,
	CommentDate date NOT NULL,
	ArticleID int NOT NULL,
	Email varchar(50) NOT NULL
);
GO

ALTER TABLE dbo.tblComments ADD CONSTRAINT PK__tblComme__C3B4DFAAE5860D13 PRIMARY KEY (CommentID);
GO

-- Inserting 12 rows into dbo.tblComments
-- Insert batch #1
INSERT INTO dbo.tblComments (CommentID, Content, CommentDate, ArticleID, Email) VALUES
(1, 'xau qua', '2000-11-11 00:00:00', 1, 'dongochuu95@gmail.com'),
(2, 'xau qua !!', '2000-11-11 00:00:00', 1, 'dongochuu95@gmail.com'),
(3, 'hallo', '2020-01-16 00:00:00', 2, 'dongochuu95@gmail.com'),
(4, 'hallo', '2020-01-16 00:00:00', 2, 'dongochuu95@gmail.com'),
(5, 'hay qua', '2020-01-17 00:00:00', 4, 'dongochuu95@gmail.com'),
(6, 'troi oi la troi', '2020-01-17 00:00:00', 4, 'dongochuu95@gmail.com'),
(7, 'troi oi la troi', '2020-01-17 00:00:00', 4, 'dongochuu95@gmail.com'),
(8, 'hihi', '2020-01-17 00:00:00', 4, 'dongochuu95@gmail.com'),
(1002, 'hihi', '2020-01-19 00:00:00', 28, 'dongochuu95@gmail.com'),
(1003, 'haha', '2020-01-19 00:00:00', 28, 'dongochuu95@gmail.com'),
(1004, 'what the hell ?', '2020-01-19 00:00:00', 1034, 'dongochuu95@gmail.com'),
(1005, 'what do you think ?', '2020-01-19 00:00:00', 1034, 'huudnse130557@fpt.edu.vn');

-- END TABLE dbo.tblComments

-- BEGIN TABLE dbo.tblDomains
CREATE TABLE dbo.tblDomains (
	DomainID int NOT NULL IDENTITY(1,1),
	DomainName varchar(max) NOT NULL
);
GO

ALTER TABLE dbo.tblDomains ADD CONSTRAINT PK__tblDomai__2498D770BF4307F7 PRIMARY KEY (DomainID);
GO

-- Inserting 5 rows into dbo.tblDomains
-- Insert batch #1
INSERT INTO dbo.tblDomains (DomainID, DomainName) VALUES
(2, '@gmail.com'),
(3, '@gmail.com.vn'),
(4, '@fpt.edu.vn'),
(5, '@outlook.com'),
(6, '@outlook.com.vn');

-- END TABLE dbo.tblDomains

-- BEGIN TABLE dbo.tblRoles
CREATE TABLE dbo.tblRoles (
	RoleID int NOT NULL IDENTITY(1,1),
	RoleName varchar(15) NOT NULL
);
GO

ALTER TABLE dbo.tblRoles ADD CONSTRAINT PK__tblRoles__8AFACE3A30795ADA PRIMARY KEY (RoleID);
GO

-- Inserting 2 rows into dbo.tblRoles
-- Insert batch #1
INSERT INTO dbo.tblRoles (RoleID, RoleName) VALUES
(1, 'admin'),
(2, 'member');

-- END TABLE dbo.tblRoles

-- BEGIN TABLE dbo.tblStatuses
CREATE TABLE dbo.tblStatuses (
	statusID int NOT NULL IDENTITY(1,1),
	statusName varchar(20) NOT NULL
);
GO

ALTER TABLE dbo.tblStatuses ADD CONSTRAINT PK__tblStatu__36257A384FBEF89F PRIMARY KEY (statusID);
GO

-- Inserting 3 rows into dbo.tblStatuses
-- Insert batch #1
INSERT INTO dbo.tblStatuses (statusID, statusName) VALUES
(1, 'new'),
(2, 'active'),
(3, 'deleted');

-- END TABLE dbo.tblStatuses

-- BEGIN TABLE dbo.tblUsers
CREATE TABLE dbo.tblUsers (
	Email varchar(50) NOT NULL,
	Name varchar(50) NOT NULL,
	Password varchar(max) NOT NULL,
	StatusID int NOT NULL,
	RoleID int NOT NULL
);
GO

ALTER TABLE dbo.tblUsers ADD CONSTRAINT PK__tblUsers__A9D1053597182D34 PRIMARY KEY (Email);
GO

-- Inserting 3 rows into dbo.tblUsers
-- Insert batch #1
INSERT INTO dbo.tblUsers (Email, Name, Password, StatusID, RoleID) VALUES
('dongochuu95@gmail.com', 'Do Ngoc Huu', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 2, 2),
('huudnse130557@fpt.edu.vn', 'Nguyen Van Teo', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 2, 2),
('ngochuu.bts@gmail.com', 'Mr Huu', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 2, 1);

-- END TABLE dbo.tblUsers

IF OBJECT_ID('dbo.tblArticles', 'U') IS NOT NULL AND OBJECT_ID('dbo.tblUsers', 'U') IS NOT NULL
	ALTER TABLE dbo.tblArticles
	ADD CONSTRAINT FK__tblArticl__email__534D60F1
	FOREIGN KEY (email)
	REFERENCES dbo.tblUsers (Email);

IF OBJECT_ID('dbo.tblArticles', 'U') IS NOT NULL AND OBJECT_ID('dbo.tblStatuses', 'U') IS NOT NULL
	ALTER TABLE dbo.tblArticles
	ADD CONSTRAINT FK__tblArticl__Statu__52593CB8
	FOREIGN KEY (StatusID)
	REFERENCES dbo.tblStatuses (statusID);

IF OBJECT_ID('dbo.tblComments', 'U') IS NOT NULL AND OBJECT_ID('dbo.tblUsers', 'U') IS NOT NULL
	ALTER TABLE dbo.tblComments
	ADD CONSTRAINT FK__tblCommen__Email__628FA481
	FOREIGN KEY (Email)
	REFERENCES dbo.tblUsers (Email);

IF OBJECT_ID('dbo.tblComments', 'U') IS NOT NULL AND OBJECT_ID('dbo.tblArticles', 'U') IS NOT NULL
	ALTER TABLE dbo.tblComments
	ADD CONSTRAINT FK__tblCommen__Artic__619B8048
	FOREIGN KEY (ArticleID)
	REFERENCES dbo.tblArticles (ArticleID);

IF OBJECT_ID('dbo.tblUsers', 'U') IS NOT NULL AND OBJECT_ID('dbo.tblRoles', 'U') IS NOT NULL
	ALTER TABLE dbo.tblUsers
	ADD CONSTRAINT FK__tblUsers__RoleID__5070F446
	FOREIGN KEY (RoleID)
	REFERENCES dbo.tblRoles (RoleID);

IF OBJECT_ID('dbo.tblUsers', 'U') IS NOT NULL AND OBJECT_ID('dbo.tblStatuses', 'U') IS NOT NULL
	ALTER TABLE dbo.tblUsers
	ADD CONSTRAINT FK__tblUsers__Status__4F7CD00D
	FOREIGN KEY (StatusID)
	REFERENCES dbo.tblStatuses (statusID);


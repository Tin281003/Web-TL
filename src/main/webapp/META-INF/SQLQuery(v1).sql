USE Web;
GO

---------------------------------------------------------
-- 1. XÓA DỮ LIỆU CŨ ĐỂ TRÁNH XUNG ĐỘT
---------------------------------------------------------
IF OBJECT_ID('OrderDetails', 'U') IS NOT NULL DROP TABLE OrderDetails;
IF OBJECT_ID('Orders', 'U') IS NOT NULL DROP TABLE Orders;
IF OBJECT_ID('FOOD', 'U') IS NOT NULL DROP TABLE FOOD;
IF OBJECT_ID('CATEGORY', 'U') IS NOT NULL DROP TABLE CATEGORY;
IF OBJECT_ID('TYPE', 'U') IS NOT NULL DROP TABLE [TYPE];
IF OBJECT_ID('ACCOUNT', 'U') IS NOT NULL DROP TABLE ACCOUNT;
IF OBJECT_ID('FeedBacks', 'U') IS NOT NULL DROP TABLE FeedBacks;

-- Xóa hàm cũ nếu tồn tại
IF OBJECT_ID('dbo.ufn_removeMark', 'FN') IS NOT NULL 
    DROP FUNCTION dbo.ufn_removeMark;
GO

---------------------------------------------------------
-- 2. TẠO CẤU TRÚC BẢNG (KHỚP 100% VỚI DAOFOOD.JAVA)
---------------------------------------------------------
CREATE TABLE ACCOUNT (
    a_id INT PRIMARY KEY IDENTITY(1,1),
    a_username VARCHAR(50) NOT NULL,
    a_password VARCHAR(50) NOT NULL,
    a_email VARCHAR(100),
    a_phone VARCHAR(20),
    a_address NVARCHAR(MAX),
    a_name NVARCHAR(100)
);

CREATE TABLE [TYPE] (
    t_type NVARCHAR(100) PRIMARY KEY
);

CREATE TABLE CATEGORY (
    c_category NVARCHAR(100) PRIMARY KEY,
    c_type NVARCHAR(100) FOREIGN KEY REFERENCES [TYPE](t_type)
);

CREATE TABLE FOOD (
    f_id INT PRIMARY KEY IDENTITY(1,1),
    f_name NVARCHAR(200) NOT NULL,
    f_price FLOAT NOT NULL,
    f_discount INT DEFAULT 0,
    f_urlImg VARCHAR(MAX),
    f_describe NVARCHAR(MAX),
    f_category NVARCHAR(100) FOREIGN KEY REFERENCES CATEGORY(c_category),
    f_ingredient NVARCHAR(MAX)
);

CREATE TABLE FeedBacks (
    FeedBackID INT PRIMARY KEY IDENTITY(1,1),
    FullName NVARCHAR(100),
    Email VARCHAR(100),
    Phone VARCHAR(20),
    Content NVARCHAR(MAX)
);
GO

---------------------------------------------------------
-- 3. TẠO HÀM BỎ DẤU (ĐÃ FIX LỖI SYNTAX)
---------------------------------------------------------
CREATE FUNCTION [dbo].[ufn_removeMark] (@strInput NVARCHAR(MAX))
RETURNS NVARCHAR(MAX)
AS
BEGIN
    IF @strInput IS NULL RETURN NULL
    IF @strInput = '' RETURN ''
    
    DECLARE @SIGN_CHARS NCHAR(136)
    DECLARE @UNSIGN_CHARS NCHAR(136)
    DECLARE @COUNTER INT
    DECLARE @COUNTER1 INT
    
    -- Gán giá trị bằng lệnh SET để tránh lỗi Msg 102
    SET @SIGN_CHARS = N'ăâđêôơưàảãáạằẳẵắặầẩẫấậèẻẽéẹềểễếệìỉĩíịòỏõóọồổỗốộờởỡớợùủũúụừửữứựỳỷỹýỵĂÂĐÊÔƠƯÀẢÃÁẠẰẲẴẮẶẦẨẪẤẬÈẺẼÉẸỀỂỄẾỆÌỈĨÍỊÒỎÕÓỌỒỔỖỐỘỜỞỠỚỢÙỦŨÚỤỪỬỮỨỰỲỶỸÝỴ' + NCHAR(272)+ NCHAR(208)
    SET @UNSIGN_CHARS = N'aadeoouaaaaaaaaaaaaaaaeeeeeeeeeeiiiiiooooooooooooooouuuuuuuuuuyyyyyAADEOOUAAAAAAAAAAAAAAAEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOUUUUUUUUUUYYYYY' + NCHAR(65)+ NCHAR(68)
    SET @COUNTER = 1
    
    WHILE (@COUNTER <= LEN(@strInput))
    BEGIN
      SET @COUNTER1 = CHARINDEX(SUBSTRING(@strInput,@COUNTER,1),@SIGN_CHARS)
      IF (@COUNTER1 > 0)
      BEGIN
        SET @strInput = STUFF(@strInput,@COUNTER,1,SUBSTRING(@UNSIGN_CHARS,@COUNTER1,1))
      END
      SET @COUNTER = @COUNTER + 1
    END
    
    RETURN @strInput
END
GO

---------------------------------------------------------
-- 4. CHÈN DỮ LIỆU MẪU (LIÊN KẾT ẢNH TRONG IMGFood)
---------------------------------------------------------

-- Loại món
INSERT INTO [TYPE] (t_type) VALUES (N'Đồ Ăn'), (N'Đồ Uống');

-- Danh mục món (Đã thêm đầy đủ để không bị lỗi Foreign Key)
INSERT INTO CATEGORY (c_category, c_type) VALUES 
(N'Khai Vị', N'Đồ Ăn'), 
(N'Món Chính', N'Đồ Ăn'), 
(N'Hải Sản', N'Đồ Ăn'), 
(N'Món Nước', N'Đồ Ăn'), 
(N'Đồ Uống', N'Đồ Uống'), 
(N'Tráng Miệng', N'Đồ Ăn');

-- Món ăn (Khớp với danh sách file ảnh bạn gửi)
INSERT INTO FOOD (f_name, f_price, f_discount, f_urlImg, f_describe, f_category, f_ingredient) VALUES 
(N'Bánh Chuối Hấp', 35000, 0, 'banhchuoihap.jpg', N'Hương vị quê nhà', N'Tráng Miệng', N'Chuối, Nước cốt dừa'),
(N'Ba Rọi Chiên Mắm', 95000, 5, 'baroichienmamngo.jpg', N'Giòn rụm thơm ngon', N'Món Chính', N'Thịt heo, Nước mắm'),
(N'Bún Bò', 55000, 0, 'bunbo.jpg', N'Chuẩn vị Huế', N'Món Nước', N'Thịt bò, Bún'),
(N'Cháo Bò Bằm', 45000, 0, 'chaobobamvatrungbacthao.jpg', N'Dinh dưỡng cho bé', N'Món Nước', N'Gạo, Bò, Trứng bắc thảo'),
(N'Cơm Chiên Hải Sản', 85000, 0, 'comchienhaisan.jpg', N'Nhiều hải sản', N'Hải Sản', N'Cơm, Tôm, Mực'),
(N'Cơm Sườn Nướng', 55000, 0, 'comsuonnuong.jpg', N'Sườn ướp mật ong', N'Món Chính', N'Cơm, Sườn nướng'),
(N'Dương Chi Cam Lộ', 45000, 0, 'duongchicamlo.jpg', N'Thanh mát ngày hè', N'Tráng Miệng', N'Xoài, Bưởi, Cốt dừa'),
(N'Gà Cuộn Lá Dứa', 125000, 0, 'gacuonladua.jpg', N'Thơm mùi lá dứa', N'Món Chính', N'Gà, Lá dứa'),
(N'Nem Lụi Nướng Mía', 95000, 0, 'nemluinuongmia.jpg', N'Đặc sản miền Trung', N'Khai Vị', N'Thịt heo, Mía'),
(N'Phở Cuốn', 60000, 0, 'phocuon.jpg', N'Đặc sản Hà Nội', N'Khai Vị', N'Bánh phở, Thịt bò'),
(N'Trà Sữa Oolong', 40000, 0, 'trasuaoolong.jpg', N'Đậm vị trà', N'Đồ Uống', N'Trà Oolong, Sữa'),
(N'Ức Gà Đút Lò', 115000, 10, 'ucgadutlophulachanh.jpg', N'Healthy food', N'Món Chính', N'Ức gà, Lá chanh');

-- Tài khoản (Chỉnh lại mật khẩu khớp với ảnh login của bạn)
INSERT INTO ACCOUNT (a_username, a_password, a_email, a_phone, a_address, a_name) VALUES 
('admin', 'sa', 'admin@dola.com', '0911', N'Đồng Nai', N'Vũ Tấn'),
('letha', '123', 'letha@gmail.com', '0922', N'TP.HCM', N'Lê Thả');

-- Phản hồi mẫu
INSERT INTO FeedBacks (FullName, Email, Phone, Content) VALUES 
(N'Khách A', 'a@mail.com', '01', N'Món ăn rất ngon, phục vụ tốt!');
GO
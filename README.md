# java_IS216.M22_6
Đồ án java
GIỚI THIỆU ĐỒ ÁN
Quản lý thư viện là app window được xây dựng bằng ngôn ngữ Java cùng với cơ sở dữ liệu là MS SQL Server. Ứng dụng tích hợp các tính năng cơ bản đáp ứng cho việc quản lý thư viện và một số chức năng nâng cao.

CÁC CHỨC NĂNG ĐÃ LÀM

Chức năng chung: 
- Thêm/xóa/sửa đầu sách: Mỗi đầu sách có những bản sao được gọi là cuốn sách.
- Thêm/xóa/sửa độc giả: Mỗi độc giả phải lập thẻ độc giả để được mượn sách. Hạn thẻ độc giả là 4 tháng, có thể gia hạn khi đến hạn.
- Thêm phiếu mượn: Mỗi độc giải được mượn 4 cuốn sách,mỗi cuốn sách có hạn mượn trong 4 ngày.
- Thêm phiếu trả: Mỗi khi trả sách nếu quá hạn sẽ được tính tiền phạt 1000đ/1 ngày
- Thêm phiếu thu cho phiếu trả sách: Chỉ được trả tiền 1 lần duy nhất, nếu phiếu trả nợ 5000đ thì phiếu thu phải thu vào 5000đ. Sau khi thêm phiếu thu thành công thì hóa đơn sẽ được in ra.
- Chức năng đăng nhập: có 2 nhóm người dùng là quản lý và thủ thư. Thủ thư sẽ được thao tác những quyền như bên trên.

Chức năng của quản lý: Bao gồm các chức năng của thủ thư và có thêm:
- Chức năng báo cáo, thống kê.

GIỚI THIỆU CÔNG NGHỆ MỚI ĐƯỢC SỬ DỤNG
- Nén project thành .exe
- Vẽ biểu đồ khi tra cứu thống kê.

GIỚI THIỆU THÀNH VIÊN TRONG NHÓM:

Nguyễn Thị Hồng Hải - 19521467 - Xây dựng database, xây dựng các chức năng của ứng dụng
Nguyễn Nhật Minh - 19521844 - Xây dựng database, xây dựng các chức năng cơ bản của ứng dụng
Phạm Như Long - 19521798 - Xây dựng database, thực hiện test

CÁC THƯ VIỆN, NỀN TẢNG ĐÃ SỬ DỤNG
- Microsoft SQL Server
- Apache Netbeans IDE 12.6
- Java phiên bản 17.0.2
- rs2xml.jar
- jcalendar-1.4.jar
- mssql-jdbc-10.2.0.jre17.jar
- Jasperreports JAR 6.3.0

CÁC BƯỚC CHẠY ỨNG DỤNG
Bước 1: Clone project về máy
Bước 2: Setup cho cơ sở dữ liệu
- Kích hoạt tài khoản sa với(username: sa, password: 123456789)
- Bật chế độ connect SQL server bằng SQL Server Authentication
- Enable port và đặt port 1433 trong SQL Server Configuration Manager
Bước 3: Chạy file QLTV.sql để tạo cơ sở dữ liệu.
Bước 4: import các thư viện liệt kê ở trên.
Bước 5: Chạy chương trình và trải nghiệm.

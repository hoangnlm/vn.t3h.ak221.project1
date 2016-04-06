package mainPkg;

import utilPkg.ConsoleUtils;

//BT ve nha: hoan thien bai HocVien. Up len GIT dua thay cai link GIT. Yeu cau:
//- Kiem tra du lieu nhap (validate input): ngaysinh, email phai dung dinh dang, so dien thoai dung dinh dang (chi la so, toi da 11 ky tu hoac +84:13 ky tu).
//- Validate exception.
//- Doc ghi chi tren 1 file.
//- Them chuc nang: update lai thong tin hoc vien theo ma so.
//- Them chuc nang: tim kiem hoc vien trong danh sach toan truong (nhieu lop) theo ho ten, so dien thoai, email...
//- Them danh sach lop, chon lop de xem danh sach hoc vien.

public class QuanLyHocVien extends ConsoleUtils {

	public static void main(String[] args) {
		QuanLyHocVien quanLyHocVien = new QuanLyHocVien();
		quanLyHocVien.run(0);
	}

	private void run(int item) {
		switch (item) {
		case 0:
			break;
		case 1:
			themHocVien();
			break;
		case 2:
			xoaHocVien();
			break;
		case 3:
			suaHocVien();
			break;
		case 4:
			timHocVien();
			break;
		default:
			exit();
			return;
		}

		run(printMenu("QUẢN LÝ HỌC VIÊN", "Thêm học viên mới.","Xóa học viên.","Cập nhật học viên.", "Tìm kiếm học viên.", "Thoát."));
	}

	private void themHocVien() {
		do {
			try {
				
			} catch (Exception e) {
				printt(e.getMessage());
			} finally {
				print("Add more? <y/n> ");
			}
		} while (sc.nextLine().trim().toLowerCase().matches("y"));
	}
	
	private void xoaHocVien(){
		
	}
	
	private void suaHocVien(){
		
	}
	
	private void timHocVien(){
		
	}
}

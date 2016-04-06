package mainPkg;

import java.util.LinkedList;
import utilPkg.ConsoleUtils;
import utilPkg.IOUtils2;

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

	private LinkedList<HocVien> hocViens;

	public QuanLyHocVien() {
		try {
			hocViens = IOUtils2.readObjectStream();
		} catch (Exception e) {
			printt(e.getMessage());
			printt("\nLỗi đọc file rồi ... thoát đây ... ");
			System.exit(0);
		}
	}

	private void run(int item) {
		switch (item) {
		case 0:
			break;
		case 1:
			themHocVien();
			break;
		case 2:
			xemDanhSach();
			break;
		case 3:
			xoaHocVien();
			break;
		case 4:
			suaHocVien();
			break;
		case 5:
			timHocVien();
			break;
		default:
			exit();
			return;
		}

		run(printMenu("QUẢN LÝ HỌC VIÊN", "Thêm học viên mới.", "Xem danh sách học viên.",
		"Xóa học viên.", "Cập nhật học viên.", "Tìm kiếm học viên.", "Thoát."));
	}


	private void exit() {
		try {
			IOUtils2.writeObjectStream(hocViens);
		} catch (Exception e) {
			printt(e.getMessage());
			printt("Lỗi ghi file rồi... dữ liệu đã bị mất ... thoát đây...");
		}
		
		printt("\n.................................................");
	}
	
	private void themHocVien() {
		do {
			try {
				println("THÊM HỌC VIÊN MỚI");
				hocViens
				.add(new HocVien(read("Mã HV: "), read("Họ tên: "), read("Ngày sinh: "),
				read("Email: "), read("Địa chỉ: "), read("Điện thoại: "), read("Mã lớp: ")));
				println("\nThêm thành công...");
			} catch (Exception e) {
				printt(e.getMessage());
			}
		} while (read("Thêm nữa? <y/n> ").trim().toLowerCase().matches("y"));
	}

	private void xemDanhSach() {
		if (hocViens.size() == 0) {
			println("Danh sach rong!");
		} else {
			for (HocVien hocVien : hocViens) {
				println(hocVien.toString());
			}
		}
	}

	private void xoaHocVien() {
		if (hocViens.size() == 0) {
			println("Danh sach rong!");
		} else {
			do {
				consoleInput= read("\nNhập mã HV cần xóa: ").trim().toUpperCase();
				boolean found = false;

				for (int i = 0; i < hocViens.size(); i++) {
					if (hocViens.get(i).getMaHV().equals(consoleInput)) {
						hocViens.remove(i);
						print("\nXóa thành công...");
						found = true;
						break;
					}
				}

				if (!found)
					print("\nKhông tìm thấy học viên nào có mã đó!");
			} while (read("\nXóa nữa? <y/n> ").trim().toLowerCase().matches("y"));
		}
	}

	private void suaHocVien() {
		if (hocViens.size() == 0) {
			println("Danh sach rong!");
		} else {
			do {
				consoleInput = read("\nNhập mã HV cần cập nhật: ").trim().toUpperCase();
				boolean found = false;
				HocVien hocVien = null;

				for (int i = 0; i < hocViens.size(); i++) {
					hocVien = hocViens.get(i);
					
					if (hocVien.getMaHV().equals(consoleInput)) {
						do {
							try {
								String maHV = read("Mã HV (cũ: "+hocVien.getMaHV()+"): ").trim().toUpperCase();
								hocVien.setMaHV(maHV.isEmpty()?hocVien.getMaHV():maHV);
								
								String hoTen = read("Họ tên (cũ: "+hocVien.getHoTen()+"): ").trim();
								hocVien.setHoTen(hoTen.isEmpty()?hocVien.getHoTen():hoTen);
								
								String ngaySinh = read("Ngày sinh (cũ: "+hocVien.getNgaySinh()+"): ").trim();
								hocVien.setNgaySinh(ngaySinh.isEmpty()?hocVien.getNgaySinh():ngaySinh);
								
								String email = read("Email (cũ: "+hocVien.getEmail()+"): ").trim();
								hocVien.setEmail(email.isEmpty()?hocVien.getEmail():email);
								
								String diaChi = read("Địa chỉ (cũ: "+hocVien.getDiaChi()+"): ").trim();
								hocVien.setDiaChi(diaChi.isEmpty()?hocVien.getDiaChi():diaChi);
								
								String dienThoai = read("Điện thoại (cũ: "+hocVien.getSoDt()+"): ").trim();
								hocVien.setSoDt(dienThoai.isEmpty()?hocVien.getSoDt():dienThoai);
								
								String maLop = read("Mã lớp (cũ: "+hocVien.getMaLop()+"): ").trim();
								hocVien.setMaLop(maLop.isEmpty()?hocVien.getMaLop():maLop);
								
								println("\nCập nhật thành công...");
								break;
							} catch (Exception e) {
								printt(e.getMessage());
							}
						} while (read("\nLàm lại? <y/n> ").trim().toLowerCase().matches("y"));
						
						found = true;
						break;
					}
				}

				if (found) {
					break;
				} else {
					print("\nKhông tìm thấy học viên nào có mã đó!");
				}
			} while (read("\nThử lại? <y/n> ").trim().toLowerCase().matches("y"));

		}
	}

	private void timHocVien() {
		if (hocViens.size() == 0) {
			println("Danh sach rong!");
		} else {
			do {
				consoleInput = read("\nNhập mã HV cần tìm: ").trim().toUpperCase();
				boolean found = false;

				for (HocVien hv: hocViens) {
					if (hv.getMaHV().equals(consoleInput)) {
						println(hv.toString());
						found = true;
						break;
					}
				}

				if (!found)
					print("\nKhông tìm thấy học viên nào có mã đó!");
			} while (read("\nTìm nữa nữa? <y/n> ").trim().toLowerCase().matches("y"));
		}
	}
}

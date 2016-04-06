package mainPkg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Lop {
	public static void main(String[] args) throws IOException {
//		HocVien.themHocVien();
//		HocVien.xemDanhSachLop();
//		HocVien.xoaHocVien();
		
	}
	
	public static void themHocVien() throws IOException {
		System.out.println("----------------------");
		System.out.println("Them hoc vien: ");
		do {
			System.out.println("Ho ten: ");
			ten = s.nextLine().trim();
		} while (ten.isEmpty());
		do {
			System.out.println("Ngay sinh: ");
			ngaySinh = s.nextLine().trim();
		} while (ngaySinh.isEmpty());
		do {
			System.out.println("Email: ");
			email = s.nextLine().trim();
		} while (email.isEmpty());
		do {
			System.out.println("Dia chi: ");
			diaChi = s.nextLine().trim();
		} while (diaChi.isEmpty());
		do {
			System.out.println("So dien thoai: ");
			sodt = s.nextLine().trim();
		} while (sodt.isEmpty());
		
		String path  = "/Users/Hoang/Documents/Eclipse/workspace/ak221/src/test1803/ak221/output.txt";
		FileReader fileReader = new FileReader(path);
		FileWriter fileWriter = new FileWriter(path, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String i;
		int count = 0;
		while((i=bufferedReader.readLine())!=null){
			count++;
		}
		
		maSo = "HV"+count;
		bufferedWriter.write("Ma_so:"+maSo+";Ho_ten:"+ten+";Ngay_sinh:"+ngaySinh+";Email:"+email+";Dia_chi:"+diaChi+";So_dt:"+sodt);
		bufferedWriter.newLine();
		
		bufferedReader.close();
		bufferedWriter.close();
	} 

	public static void xoaHocVien() throws IOException {
		System.out.println("Nhap ma so can xoa: ");
		String maSo = s.nextLine().trim().toUpperCase();
		
		String path  = "/Users/Hoang/Documents/Eclipse/workspace/ak221/src/test1803/ak221/output.txt";
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		ArrayList<String> danhSach = new ArrayList<String>();
		String str;
		while((str=bufferedReader.readLine())!=null){
			danhSach.add(str);
		}
		
		if(danhSach.toString().equals("[]")){
			System.out.println("Danh sach rong. Khong co gi de xoa!");
		}else{
			for (int i = 0; i < danhSach.size(); i++) {
				if(danhSach.get(i).contains(maSo)){
					danhSach.remove(i);
				}
			}

			FileWriter fileWriter = new FileWriter(path);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < danhSach.size(); i++) {
				bufferedWriter.write(danhSach.get(i));
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		}
		
		bufferedReader.close();
	}
	
	public static void xemDanhSachLop() throws IOException{
		String path  = "/Users/Hoang/Documents/Eclipse/workspace/ak221/src/test1803/ak221/output.txt";
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		ArrayList<String> danhSach = new ArrayList<String>();
		String str;
		while((str=bufferedReader.readLine())!=null){
			danhSach.add(str);
		}
		
		if(danhSach.get(0)==null){
			System.out.println("Danh sach rong.");
		}else{
			System.out.println("Danh sach hoc vien: ");
			System.out.println("--------------------");
			String[] tmp;
			String ms, ht, ns, em, dc, dt;
			for (String hv : danhSach) {
				tmp = hv.split(";");
				ms = tmp[0].split(":")[1];
				ht = tmp[1].split(":")[1];
				ns = tmp[2].split(":")[1];
				em = tmp[3].split(":")[1];
				dc = tmp[4].split(":")[1];
				dt = tmp[5].split(":")[1];
				System.out.println("Ma so: "+ms);
				System.out.println("Ho ten: "+ht);
				System.out.println("Ngay sinh: "+ns);
				System.out.println("Email: "+em);
				System.out.println("Dia chi: "+dc);
				System.out.println("So dien thoai: "+dt);
				System.out.println("--------------------");
			}
		}
		
		bufferedReader.close();
	}
}

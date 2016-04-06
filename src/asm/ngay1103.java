package asm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// BT mang tinh:
// B1: Nhap vao 1 mang n phan tu so nguyen. Hay sap xep mang tang dan.
// B2: Nhap vao 1 mang n phan tu so nguyen. Hay sap xep so le tang dan, so chan giam dan, giu nguyen vi tri trong mang.
// B3: Nhap vao 1 mang n phan tu so nguyen. Hay sap xep so nguyen to tang dan, giu nguyen vi tri trong mang, chi dao vi tri cac so nguyen to.
// B4: Nhap vao 1 mang n phan tu so nguyen. Liet ke so chinh phuong trong mang.
// B5: Nhap vao 1 mang n phan tu so nguyen. Tinh tong tat ca phan tu trong mang.
// B6: Nhap vao 1 mang n phan tu so nguyen. Tinh tich tat ca phan tu trong mang.
// B7: Nhap vao 1 mang n phan tu la phan so. Tinh tong tat ca phan tu trong mang.
// B8: Nhap vao 1 mang n phan tu la phan so. Tinh tich tat ca phan tu trong mang.
// B9: Nhap vao 1 mang 2 chieu (m,n) so nguyen. Sap xep mang tang dan.

// Xuat ra mang 10 phan tu co gia tri la so int random tu [-100,100];
// Sap xep mang tang dan.
class MangSoNguyen {
	private int n, min, max;
	private int a[];
	private Random ran = new Random();

	public MangSoNguyen(int n, int min, int max) {
		setMax(max);
		setMin(min);
		setN(n);
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n >= 1) {
			this.n = n;
			a = new int[n];

			for (int i = 0; i < a.length; i++) {
				a[i] = ran.nextInt(max - min + 1) + min;
			}
		} else {
			System.out.println("Mang so nguyen n thi n phai >=1.");
			System.exit(0);
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (min <= max) {
			this.min = min;
			a = new int[n];

			for (int i = 0; i < a.length; i++) {
				a[i] = ran.nextInt(max - min + 1) + min;
			}
		} else {
			System.out.println("Gia tri min trong mang phai <= gia tri max!");
			System.exit(0);
		}
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		if (min <= max) {
			this.max = max;
			a = new int[n];

			for (int i = 0; i < a.length; i++) {
				a[i] = ran.nextInt(max - min + 1) + min;
			}
		} else {
			System.out.println("Gia tri max trong mang phai >= gia tri min!");
			System.exit(0);
		}
	}

	public int[] xuatMang() {
		return a;
	}

	// Sap xep mang (tang=true: tang dan, default, tang=false: giam dan)
	public void sapXepMang() {
		sapXepMang(true);
	}

	public void sapXepMang(boolean tang) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (tang) {
					if (a[j] < a[i]) {
						swap(a, i, j);
					}
				} else {
					if (a[j] > a[i]) {
						swap(a, i, j);
					}
				}
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// Sap xep so le tang dan, so chan giam dan, giu nguyen vi tri trong mang.
	public void sapXepLeTangChanGiam() {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if ((a[i] % 2 == 0) && (a[j] % 2 == 0)) {
					if (a[j] > a[i]) {
						swap(a, i, j);
					}
				} else if (a[i] % 2 != 0 && a[j] % 2 != 0) {
					if (a[j] < a[i]) {
						swap(a, i, j);
					}
				}
			}
		}
	}

	// Sap xep so nguyen to, giu nguyen vi tri trong mang, chi dao vi
	// tri cac so nguyen to.
	// tang==true: tang dan, default; tang==false: giam dan.
	public void sapXepSoNguyenTo() {
		sapXepSoNguyenTo(true);
	}

	public void sapXepSoNguyenTo(boolean tang) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				SoNguyenTo so1 = new SoNguyenTo(a[i]);
				SoNguyenTo so2 = new SoNguyenTo(a[i]);

				if (so1.check() && so2.check()) {
					if (tang) {
						if (a[j] < a[i]) {
							swap(a, i, j);
						}
					} else {
						if (a[j] > a[i]) {
							swap(a, i, j);
						}
					}
				}
			}
		}
	}

	// Xuat cac so chinh phuong trong mang.
	public int[] xuatMangChinhPhuong() {
		ArrayList<Integer> tmp = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			SoChinhPhuong chinhPhuong = new SoChinhPhuong(a[i]);
			if (chinhPhuong.check()) {
				tmp.add(a[i]);
			}
		}

		int[] kq = new int[tmp.size()];
		for (int i = 0; i < kq.length; i++) {
			kq[i] = tmp.get(i);
		}

		return kq;
	}

	// Tinh tong tat ca phan tu trong mang.
	public int tinhTong() {
		int kq = 0;

		for (int i : a) {
			kq += i;
		}

		return kq;
	}

	// Tinh tich tat ca phan tu trong mang.
	public BigInteger tinhTich() {
		BigInteger kq = BigInteger.ONE;

		for (int i : a) {
			kq = kq.multiply(BigInteger.valueOf(i));
		}

		return kq;
	}

}

class MangPhanSo {
	private PhanSo[] p;

	public MangPhanSo(PhanSo... p) {
		setP(p);
	}

	public PhanSo[] getP() {
		return p;
	}

	public void setP(PhanSo[] p) {
		if (p.length > 0) {
			this.p = p;
		} else {
			System.out.println("Mang phan so khong the rong!");
			System.exit(0);
		}
	}

	public String xuatMang() {
		String kq = "[";

		for (int i = 0; i < p.length; i++) {
			kq += (i != p.length - 1) ? (p[i].xuat() + ", ") : p[i].xuat();
		}

		kq += "]";
		return kq;
	}

	// Mang n phan so. Tinh tong tat ca phan tu trong mang.
	/**
	 * Method tinh tong cac phan so trong mang phan so
	 * 
	 * @return PhanSo
	 */
	public PhanSo tinhTong() {
		PhanSo kq = new PhanSo();

		for (PhanSo phanSo : p) {
			kq = kq.cong(phanSo);
		}

		return kq;
	}

	// Mang n phan so. Tinh tich tat ca phan tu trong mang.
	/**
	 * Method tinh tich cac phan so trong mang phan so
	 * 
	 * @return PhanSo
	 */
	public PhanSo tinhTich() {
		PhanSo kq = new PhanSo(1, 1);

		for (PhanSo phanSo : p) {
			kq = kq.nhan(phanSo);
		}

		return kq;
	}
}

// Mang 2 chieu (m,n) so nguyen. Sap xep mang tang dan.
class Mang2D {
	private int m = 1, n = 1, min = 0, max = 1;
	private int[][] a;
	private Random ran = new Random();

	public Mang2D(int m, int n, int min, int max) {
		setMax(max);
		setMin(min);
		setM(m);
		setN(n);
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		if (m >= 1) {
			this.m = m;
			a = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = ran.nextInt(max - min + 1) + min;
				}
			}
		} else {
			System.out.println("Mang so nguyen n thi m phai >=1.");
			System.exit(0);
		}
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n >= 1) {
			this.n = n;
			a = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = ran.nextInt(max - min + 1) + min;
				}
			}
		} else {
			System.out.println("Mang so nguyen n thi n phai >=1.");
			System.exit(0);
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (min <= max) {
			this.min = min;
			a = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = ran.nextInt(max - min + 1) + min;
				}
			}
		} else {
			System.out.println("Gia tri min trong mang phai <= gia tri max!");
			System.exit(0);
		}
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		if (min <= max) {
			this.max = max;
			a = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = ran.nextInt(max - min + 1) + min;
				}
			}
		} else {
			System.out.println("Gia tri max trong mang phai >= gia tri min!");
			System.exit(0);
		}
	}

	public String xuatMang(){
		String kq = "[";
	
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				kq += (j==0)?("["+a[i][j]+", "):(j==n-1)?(a[i][j]+"]"):(a[i][j]+", ");
			}
			
			kq += (i==m-1)?"":", ";
		}
		
		kq += "]";
		return kq;
	}
	
	public void sapXepMang() {
		sapXepMang(true);
	}

	public void sapXepMang(boolean tang) {
		int[] tmp = new int[m*n];
		int index = 0;
		
		for (int[] i : a) {
			for (int j : i) {
				tmp[index++] = j;
			}
		}

		for (int i = 0; i < tmp.length - 1; i++) {
			for (int j = i + 1; j < tmp.length; j++) {
				if (tang) {
					if (tmp[j] < tmp[i]) {
						swap(tmp, i, j);
					}
				} else {
					if (tmp[j] > tmp[i]) {
						swap(tmp, i, j);
					}
				}
			}
		}
		
		index = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tmp[index++];
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}

public class ngay1103 {
	static void rename(String a) {
		a = "hi";
	}

	public static void main(String[] args) {
		MangSoNguyen n = new MangSoNguyen(9, 50, 100);
		System.out.println("Mang " + n.getN() + " so nguyen trong khoang [" + n.getMin() + ", " + n.getMax() + "]: ");
		System.out.println(Arrays.toString(n.xuatMang()));

		// n.sapXepMang();
		// System.out.println(
		// "Mang " + n.getN() + " so nguyen trong khoang [" + n.getMin() + ", "
		// + n.getMax() + "] tang dan: ");
		// System.out.println(Arrays.toString(n.xuatMang()));

		// n.sapXepMang(false);
		// System.out.println(
		// "Mang " + n.getN() + " so nguyen trong khoang [" + n.getMin() + ", "
		// + n.getMax() + "] giam dan: ");
		// System.out.println(Arrays.toString(n.xuatMang()));

		// n.sapXepLeTangChanGiam();
		// System.out.println("Mang " + n.getN() + " so nguyen trong khoang [" +
		// n.getMin() + ", " + n.getMax()
		// + "] co le tang dan, chan giam dan: ");
		// System.out.println(Arrays.toString(n.xuatMang()));

		System.out.println("Mang " + n.getN() + " so nguyen trong khoang [" + n.getMin() + ", " + n.getMax()
				+ "] co cac so chinh phuong: ");
		System.out.println(Arrays.toString(n.xuatMangChinhPhuong()));

		System.out.println("Mang " + n.getN() + " so nguyen trong khoang [" + n.getMin() + ", " + n.getMax()
				+ "] co tong cac phan tu: " + n.tinhTong());

		System.out.println("Mang " + n.getN() + " so nguyen trong khoang [" + n.getMin() + ", " + n.getMax()
				+ "] co tich cac phan tu: " + n.tinhTich());

		MangPhanSo mangPhanSo = new MangPhanSo(new PhanSo(1, 2), new PhanSo(2, 3), new PhanSo(3, 4));
		System.out.println("Mang phan so: " + mangPhanSo.xuatMang());
		System.out.println("Tong cua mang phan so: " + mangPhanSo.tinhTong().xuat());
		System.out.println("Tich cua mang phan so: " + mangPhanSo.tinhTich().xuat());
		
		Mang2D mang2d = new Mang2D(9, 3, 1, 100);
		System.out.println("Mang 2D: "+mang2d.xuatMang());
		
		mang2d.sapXepMang();
		System.out.println("Mang 2D khi da sap xep: "+mang2d.xuatMang());
		
		byte t = 0;
		t = (byte)-129;
		System.out.println(t);
		

		// int a[] = new int[10];
		// Random ran = new Random();
		//
		// // Insert data
		// for (int i = 0; i < a.length; i++) { // Neu a.length khong co thi
		// // a.count, a.size
		// a[i] = ran.nextInt(100); // Ran dom tu 0 den duoi 100;
		// }

		// Xuat data
		// for (int i = 0; i < a.length; i++) {
		// System.out.println(a[i]);
		// }

		// String s = "hello";
		// rename(s);
		// System.out.println(s);
		// ArrayList<String> arrayList = new ArrayList<>();
		// arrayList.add("H");
		// arrayList.get(9); //a[i];

		// Data2 data2 = new Data2();
		// System.out.println(Data1.TEST);
		// Data1.e();

		// xuLy(new Data1());
		// xuLy(new Data2());

	}

	// static void xuLy(Data1 data1){
	//
	// }
	// static void xuLy(Data2 data2){
	//
	// }

}

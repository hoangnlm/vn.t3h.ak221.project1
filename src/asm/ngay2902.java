package asm;

import java.math.BigInteger;

//1.Cho n, kiem tra n co phai la nam nhuan khong?
class NamNhuan {
	private int nam;

	public NamNhuan(int nam) {
		setNam(nam);
	}

	public boolean check() {
		return nam % 4 == 0 ? true : false;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		if (nam >= 0) {
			this.nam = nam;
		} else {
			System.out.println("Tinh nam nhuan thi nam phai >=0");
			System.exit(0);
		}
	}
}

// 2.Cho so nguyen duong n, kiem tra n co phai la so nguyen to?
class SoNguyenTo {
	private int n;

	public SoNguyenTo(int n) {
		setN(n);
	}

	public boolean check() {
		boolean kq = true;

		if (n != 0) {
			for (int i = n; i > 0; i--) {
				if (n % i == 0 && n != i && i != 1) {
					kq = false;
					break;
				}
			}
		} else {
			kq = false;
		}

		return kq;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n >= 0) {
			this.n = n;
		} else {
			System.out.println("Check n nguyen to n thi n phai >=0");
			System.exit(0);
		}
	}
}

// 3.Cho so nguyen duong n, kiem tra n co phai la so chinh phuong? (so chinh
// phuong la so co can bac hai la so chan)
class SoChinhPhuong {
	private int n;

	public SoChinhPhuong(int n) {
		setN(n);
	}

	public boolean check() {
		int can = (int) Math.sqrt(n);
		return can * can == n ? true : false;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n >= 0) {
			this.n = n;
		} else {
			System.out.println("Check so chinh phuong thi n phai >=0");
			System.exit(0);
		}
	}
}

// 4.Cho so nguyen duong n, kiem tra n co phai la so lap phuong? (so lap phuong
// la so co can bac ba la so chan)
class SoLapPhuong {
	private int n;

	public SoLapPhuong(int n) {
		setN(n);
	}

	public boolean check() {
		int can = (int) Math.cbrt(n);
		return can * can * can == n ? true : false;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n > 0) {
			this.n = n;
		} else {
			System.out.println("Check so lap phuong thi n phai >0");
			System.exit(0);
		}
	}
}

// 5.Cho so nguyen duong n, kiem tra n co phai la so doi xung? (11, 121, 1221,
// dao nguoc thu tu la nhu nhau)
class SoDoiXung {
	private int n;

	public SoDoiXung(int n) {
		setN(n);
	}

	public boolean check() {
		StringBuilder str = new StringBuilder(String.valueOf(Math.abs(n)));
		return str.reverse().toString().equals(String.valueOf(Math.abs(n))) ? true : false;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}

// 6.Cho so nguyen duong n, kiem tra n co phai la so hoan thien? (6,28)(so hoan
// thien la tong tat ca uoc so nho hon no bang chinh no).
class SoHoanThien {
	private int n;

	public SoHoanThien(int n) {
		setN(n);
	}

	public boolean check() {
		int sum = 1;

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}

		return sum == n ? true : false;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n > 2) {
			this.n = n;
		} else {
			System.out.println("Check so hoan thien thi n phai > 2.");
			System.exit(0);
		}
	}
}

// 7.Cho so nguyen duong n, xuat ra man hinh day Fibonacci co n phan tu. (1 1 2
// 3 5 8 13 21)
class Fibonacci {
	private int n;

	public Fibonacci(int n) {
		setN(n);
	}

	public String xuat() {
		String kq = "";

		if (n > 2) {
			int[] arr = new int[n];
			arr[0] = arr[1] = 1;

			for (int i = 2; i < n; i++) {
				arr[i] = arr[i - 1] + arr[i - 2];
			}

			for (int j : arr) {
				kq += j + " ";
			}
		} else if (n == 2) {
			kq = "1 1";
		} else if (n == 1) {
			kq = "1";
		}

		return kq;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n > 0) {
			this.n = n;
		} else {
			System.out.println("Check so hoan thien thi n phai > 0.");
			System.exit(0);
		}
	}
}

// 8.Tinh tong: S(n)=1+2+....+n
class Tong1 {
	private int n;

	public Tong1(int n) {
		setN(n);
	}

	public int tinh() {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n > 0) {
			this.n = n;
		} else {
			System.out.println("Tinh tong n thi n phai >0!");
			System.exit(0);
		}
	}

}

// 9.Tinh tong: S(n)=1/2+2/3+3/4+....+(n-1)/n
class Tong2 {
	private int n;

	public Tong2(int n) {
		setN(n);
	}

	public double tinh() {
		double sum = 0;
		for (int i = 1; i < n; i++) {
			sum += (double) i / (i + 1);
		}
		return sum;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n >= 2) {
			this.n = n;
		} else {
			System.out.println("Tinh tong 1/n thi n phai >=2!");
			System.exit(0);
		}
	}
}

// 10.Tinh giai thua: n! (bai kho)
class GiaiThua {
	private int n;
	public static final int THRESHOLD = 20;

	public GiaiThua(int n) {
		setN(n);
	}

	public String tinh() {
		String kq = "";
		long tmp = 1;

		if (n <= THRESHOLD) {
			if (n > 0) {
				for (int i = 1; i <= n; i++) {
					tmp *= i;
				}
			}

			kq = "" + tmp;
		} else {
			for (int i = 1; i <= THRESHOLD; i++) {
				tmp *= i;
			}
			kq = tinh2(tmp);
		}

		return kq;
	}

	// Xu ly giai thua khi n > 20
	private String tinh2(long tmp) {
		String kq = "" + tmp;
		String hang = "" + tmp;

		for (int i = THRESHOLD + 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				kq = congChuoiSo(kq, hang);
			}
			hang = kq;
		}

		return kq;
	}

	// Cong chuoi so
	private String congChuoiSo(String s1, String s2) {
		StringBuilder r = new StringBuilder();
		String maxS = s1.length() >= s2.length() ? s1 : s2;
		String minS = s1.length() >= s2.length() ? s2 : s1;
		int dev = maxS.length() - minS.length(); // Do lech kich co chuoi
		int digit = 0; // 1 ky tu so trong chuoi
		int remain = 0; // Phan du cua cong 2 ky tu so

		// Vd: "12345" + "567"
		for (int i = maxS.length() - 1; i >= 0; i--) { // Duyet ky tu theo kich
														// co chuoi max
			digit = Integer.parseInt(maxS.substring(i, i + 1));

			if (i - dev >= 0) { // Chuoi min co do lech
				digit += Integer.parseInt(minS.substring(i - dev, i - dev + 1));
			}

			digit += remain;
			remain = digit / 10; // Vd: 5+7 lay 2 luu 1

			// Chen ket qua cong ky tu vao chuoi kq
			r.insert(0, digit < 10 ? digit : (i == 0 ? digit : digit % 10));
		}

		return r.toString();
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (0 <= n) {
			this.n = n;
		} else {
			System.out.println("Tinh giai thua n thi n phai >=0.");
			System.exit(0);
		}
	}
}

class GiaiThua2 {
	private int n;

	public GiaiThua2(int n) {
		setN(n);
	}

	public String tinh() {
		BigInteger b = BigInteger.ONE;
		
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				b = b.multiply(BigInteger.valueOf(i));
			}
		}

		return b.toString();
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (0 <= n) {
			this.n = n;
		} else {
			System.out.println("Tinh giai thua n thi n phai >=0.");
			System.exit(0);
		}
	}
}

public class ngay2902 {
	public static void main(String[] args) {
		NamNhuan nam = new NamNhuan(2013);
		System.out.println("Nam " + nam.getNam() + (nam.check() ? " la nam nhuan." : " khong la nam nhuan."));

		SoNguyenTo so1 = new SoNguyenTo(101);
		System.out.println(so1.getN() + (so1.check() ? " la so nguyen to." : " khong la so nguyen to."));

		SoChinhPhuong so2 = new SoChinhPhuong(25);
		System.out.println(so2.getN() + (so2.check() ? " la so chinh phuong." : " khong la so chinh phuong."));

		SoLapPhuong so3 = new SoLapPhuong(27);
		System.out.println(so3.getN() + (so3.check() ? " la so lap phuong." : " khong la so lap phuong."));

		SoDoiXung so4 = new SoDoiXung(1221);
		System.out.println(so4.getN() + (so4.check() ? " la so doi xung." : " khong la so doi xung."));

		SoHoanThien so5 = new SoHoanThien(28);
		System.out.println(so5.getN() + (so5.check() ? " la so hoan thien." : " khong la so hoan thien."));

		Fibonacci fibonacci = new Fibonacci(9);
		System.out.println("Day Fibonacci " + fibonacci.getN() + " so nguyen: " + fibonacci.xuat());

		Tong1 tong1 = new Tong1(11);
		System.out.println("Tong " + tong1.getN() + " so nguyen: " + tong1.tinh());

		Tong2 tong2 = new Tong2(11);
		System.out.printf("Tong 1/n cua " + tong2.getN() + " so nguyen: %.3f%n", tong2.tinh());

		GiaiThua giaiThua = new GiaiThua(100);
		System.out.println("Giai thua cua " + giaiThua.getN() + ": " + giaiThua.tinh());

		GiaiThua2 giaiThua2 = new GiaiThua2(100);
		System.out.println("Giai thua cua " + giaiThua2.getN() + ": " + giaiThua2.tinh());

	}
}

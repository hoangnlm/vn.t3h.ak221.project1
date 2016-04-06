package asm;

//BT1: viet tru, Nhan, Chia, RutGon phanso
class PhanSo {
	private int tu, mau;

	PhanSo() {
		tu = 0;
		mau = 1;
	}

	PhanSo(int tu, int mau) {
		setTu(tu);
		setMau(mau);
	}

	PhanSo rutGon() {
		PhanSo kq = new PhanSo();
		int tu = this.tu;
		int mau = this.mau;
		int ucln = 1;

		// Tim uoc so chung lon nhat cua tu va mau
		for (int i = 1; i <= Math.min(Math.abs(tu), Math.abs(mau)); i++) {
			if (tu % i == 0 && mau % i == 0) {
				ucln = i;
			}
		}

		// Xu ly dau -
		kq.tu = (tu * mau > 0) ? Math.abs(tu) / ucln : (-Math.abs(tu) / ucln);
		kq.mau = Math.abs(mau) / ucln;
		return kq;
	}

	PhanSo cong(PhanSo a) {
		PhanSo kq = new PhanSo();
		kq.tu = this.tu * a.mau + this.mau * a.tu;
		kq.mau = this.mau * a.mau;
		return kq.rutGon();
	}

	PhanSo tru(PhanSo a) {
		PhanSo kq = new PhanSo();
		kq.tu = this.tu * a.mau - this.mau * a.tu;
		kq.mau = this.mau * a.mau;
		return kq.rutGon();
	}

	PhanSo nhan(PhanSo a) {
		PhanSo kq = new PhanSo();
		kq.tu = this.tu * a.tu;
		kq.mau = this.mau * a.mau;
		return kq.rutGon();
	}

	PhanSo chia(PhanSo a) {
		PhanSo kq = new PhanSo();
		if (a.tu == 0) {
			System.out.println("Khong the chia cho 0!");
			System.exit(0);
		} else {
			kq.tu = this.tu * a.mau;
			kq.mau = this.mau * a.tu;
		}
		return kq.rutGon();
	}

	String xuat() {
		String kq = "";
		if (tu % mau == 0) {
			kq = "" + tu / mau;
		} else {
			kq = rutGon().tu + "/" + rutGon().mau;
		}
		return kq;
	}

	public int getTu() {
		return tu;
	}

	public void setTu(int tu) {
		this.tu = tu;
	}

	public int getMau() {
		return mau;
	}

	public void setMau(int mau) {
		if (mau == 0) {
			// Loi
			System.out.println("Mau khong the bang 0!");
			System.exit(0);
		} else {
			this.mau = mau;
		}
	}
}

// BT2: Hoan thien lop HonSo, cong, tru, nhan, chia, rutgon
class HonSo {
	private int nguyen;
	private PhanSo phanSo = new PhanSo();

	HonSo() {
		phanSo.setTu(0);
		phanSo.setMau(1);
		nguyen = 0;
	}

	HonSo(int nguyen, int tu, int mau) {
		this.phanSo.setTu(tu);
		this.phanSo.setMau(mau);
		this.nguyen = nguyen;
	}

	HonSo rutGon() {
		HonSo honSo = new HonSo();
		int tu = this.phanSo.rutGon().getTu();
		int mau = this.phanSo.rutGon().getMau();
		int nguyen = this.nguyen;

		if (tu % mau == 0) {
			nguyen += tu / mau;
			tu = 0;
			mau = 1;
		}

		honSo.nguyen = nguyen;
		honSo.phanSo.setTu(tu);
		honSo.phanSo.setMau(mau);
		return honSo;
	}

	HonSo cong(HonSo a) {
		HonSo honSo = new HonSo();
		honSo.nguyen = this.nguyen+a.nguyen;
		honSo.phanSo = this.phanSo.cong(a.phanSo);
		return honSo;
	}

	HonSo tru(HonSo a) {
		HonSo honSo = new HonSo();
		honSo.nguyen = this.nguyen - a.nguyen;
		honSo.phanSo = this.phanSo.tru(a.phanSo);
		return honSo;
	}

	HonSo nhan(HonSo a) {
		PhanSo phanSo1 = new PhanSo();
		phanSo1.setTu(this.nguyen*this.phanSo.getMau()+this.phanSo.getTu());
		phanSo1.setMau(this.phanSo.getMau());
		
		PhanSo phanSo2 = new PhanSo();
		phanSo2.setTu(a.nguyen*a.phanSo.getMau()+a.phanSo.getTu());
		phanSo2.setMau(a.phanSo.getMau());
		
		HonSo honSo = new HonSo();
		honSo.phanSo = phanSo1.nhan(phanSo2);
		
		return honSo.rutGon();
	}

	HonSo chia(HonSo a) {
		PhanSo phanSo1 = new PhanSo();
		phanSo1.setTu(this.nguyen*this.phanSo.getMau()+this.phanSo.getTu());
		phanSo1.setMau(this.phanSo.getMau());
		
		PhanSo phanSo2 = new PhanSo();
		phanSo2.setTu(a.nguyen*a.phanSo.getMau()+a.phanSo.getTu());
		phanSo2.setMau(a.phanSo.getMau());
		
		HonSo honSo = new HonSo();
		honSo.phanSo = phanSo1.chia(phanSo2);
		
		return honSo.rutGon();
	}

	String xuat() {
		int nguyen = this.rutGon().nguyen;
		int tu = this.rutGon().phanSo.getTu();
		int mau = this.rutGon().phanSo.getMau();
		String kq = "";
		if (tu % mau == 0) {
			kq = "" + (nguyen + tu / mau);
		} else {
			if(tu>mau){
				nguyen += tu/mau;
				tu = tu%mau;
			}
			kq = nguyen==0?(tu + "/" + mau):(nguyen + "(" + tu + "/" + mau + ")");
		}
		return kq;
	}
}

public class ngay0403 {
	public static void main(String[] args) {
		PhanSo a = new PhanSo(120, 3);
		System.out.println("Phan so a: " + a.xuat());

		PhanSo b = new PhanSo(12, 3);
		System.out.println("Phan so b: " + b.xuat());

		PhanSo c = a.chia(b);
		System.out.println("Phan so c: " + c.xuat());

		// String s1 = "a";
		// String s2 = "a";
		// String s3 = new String("a");
		// String s4 = s3.toString();
		// System.out.println(s1==s2);
		// System.out.println(s1==s3);
		// System.out.println(s1==s4);

		// int i1 = 1;
		// Integer i2 = new Integer(1);
		// System.out.println(i1==i2);

		// PhanSo d= null;
		// System.out.println(d.getTu()); //bao loi NullPointer

		HonSo d = new HonSo(2,5,2);
		System.out.println("Hon so d: "+d.xuat());
		
		HonSo e = new HonSo(0,6,2);
		System.out.println("Hon so e: "+e.xuat());
		
		HonSo f = d.chia(e);
		System.out.println("Hon so f: "+f.xuat());
		// System.out.println(honSo.nguyen);
		// System.out.println(honSo.phanSo.getTu()); //bao loi NullPointer

	}
}

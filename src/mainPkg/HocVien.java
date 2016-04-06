package mainPkg;

import utilPkg.ValUtils;

public class HocVien extends ValUtils {
	private String maHV, hoTen, ngaySinh, email, diaChi, soDt, maLop;
	public static final int HV_MIN_AGE = 17;
	public static final int HV_MAX_AGE = 40;
	
	public HocVien() {
		// TODO Auto-generated constructor stub
	}
	
	public HocVien(String maHV, String hoTen, String ngaySinh, String email, String diaChi, String soDt,
	String maLop) throws Exception{
		setMaHV(maHV);
		setHoTen(hoTen);
		setNgaySinh(ngaySinh);
		setEmail(email);
		setDiaChi(diaChi);
		setSoDt(soDt);
		setMaLop(maLop);
	}

	public String getMaHV() {
		return maHV;
	}

	public void setMaHV(String maHV) throws Exception{
		maHV = maHV.trim().toUpperCase();
		valEmpty(maHV);
		valFormat(maHV, "HV\\d{3}");
		this.maHV = maHV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception{
		hoTen = hoTen.trim();
		valEmpty(hoTen);
		valFormat(hoTen, "[\\p{L} ]{3,20}");
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) throws Exception {
		valAge(ngaySinh, HV_MIN_AGE, HV_MAX_AGE);
		this.ngaySinh = ngaySinh;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception{
		email = email.trim();
		valEmail(email);
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws Exception {
		valEmpty(diaChi);
		this.diaChi = diaChi;
	}

	public String getSoDt() {
		return soDt;
	}

	public void setSoDt(String soDt) throws Exception {
		valPhone(soDt);
		this.soDt = soDt;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
}


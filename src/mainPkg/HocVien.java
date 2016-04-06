package mainPkg;

import java.io.Serializable;

import utilPkg.ValUtils;

public class HocVien extends ValUtils implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maHV, hoTen, ngaySinh, email, diaChi, soDt, maLop;
	public static final int HV_MIN_AGE = 17;
	public static final int HV_MAX_AGE = 40;
	
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
		valFormat(maHV, "HV\\d{3}", "Mã HV phải có định dạng HVxxx.");
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
		valAge(ngaySinh, HV_MIN_AGE, HV_MAX_AGE, null);
		this.ngaySinh = ngaySinh;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception{
		email = email.trim();
		valEmail(email, "Địa chỉ email không hợp lệ!");
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
		valPhone(soDt, "Số điện thoại 10 chữ số hoặc (+84)xxx.");
		this.soDt = soDt;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	@Override
	public String toString() {
		StringBuilder kq = new StringBuilder(150);
		kq.append("\nMã HV: "+getMaHV());
		kq.append("\nHọ tên: "+getHoTen());
		kq.append("\nNgày sinh: "+getNgaySinh());
		kq.append("\nEmail: "+getEmail());
		kq.append("\nĐịa chỉ: "+getDiaChi());
		kq.append("\nĐiện thoại: "+getSoDt());
		kq.append("\nMã lớp: "+getMaLop());
		return kq.toString();
	}
}


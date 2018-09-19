
package model;

import java.io.Serializable;

public class SinhVien implements Serializable {

	String mssv, hoTen, lop, dangLam;

	/**
	 * @param mssv
	 * @param hoTen
	 * @param lop
	 * @param dangLam
	 */
	public SinhVien(String mssv, String hoTen, String lop, String dangLam) {

		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.lop = lop;
		this.dangLam = dangLam;
	}

	/**
	 * 
	 */
	public SinhVien() {

		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the mssv
	 */
	public String getMssv() {

		return mssv;
	}

	/**
	 * @return the hoTen
	 */
	public String getHoTen() {

		return hoTen;
	}

	/**
	 * @return the lop
	 */
	public String getLop() {

		return lop;
	}

	/**
	 * @return the dangLam
	 */
	public String getDangLam() {

		return dangLam;
	}

	/**
	 * @param mssv
	 *            the mssv to set
	 */
	public void setMssv(String mssv) {

		this.mssv = mssv;
	}

	/**
	 * @param hoTen
	 *            the hoTen to set
	 */
	public void setHoTen(String hoTen) {

		this.hoTen = hoTen;
	}

	/**
	 * @param lop
	 *            the lop to set
	 */
	public void setLop(String lop) {

		this.lop = lop;
	}

	/**
	 * @param dangLam
	 *            the dangLam to set
	 */
	public void setDangLam(String dangLam) {

		this.dangLam = dangLam;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {

		return "SinhVien [mssv=" + mssv + ", hoTen=" + hoTen + ", lop=" + lop + ", dangLam=" + dangLam + "]";
	}

}

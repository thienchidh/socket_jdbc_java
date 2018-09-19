
package model;

import java.io.Serializable;

public class BaiTap implements Serializable {

	String msbt, tenBt, debai, doKho, daHoanThanh;

	/**
	 * 
	 */
	public BaiTap() {

		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param msbt
	 * @param tenBt
	 * @param debai
	 * @param doKho
	 * @param daHoanThanh
	 */
	public BaiTap(String msbt, String tenBt, String debai, String doKho, String daHoanThanh) {

		this.msbt = msbt;
		this.tenBt = tenBt;
		this.debai = debai;
		this.doKho = doKho;
		this.daHoanThanh = daHoanThanh;
	}

	/**
	 * @return the daHoanThanh
	 */
	public String getDaHoanThanh() {

		return daHoanThanh;
	}

	/**
	 * @return the debai
	 */
	public String getDebai() {

		return debai;
	}

	/**
	 * @return the doKho
	 */
	public String getDoKho() {

		return doKho;
	}

	/**
	 * @return the msbt
	 */
	public String getMsbt() {

		return msbt;
	}

	/**
	 * @return the tenBt
	 */
	public String getTenBt() {

		return tenBt;
	}

	/**
	 * @param daHoanThanh
	 *            the daHoanThanh to set
	 */
	public void setDaHoanThanh(String daHoanThanh) {

		this.daHoanThanh = daHoanThanh;
	}

	/**
	 * @param debai
	 *            the debai to set
	 */
	public void setDebai(String debai) {

		this.debai = debai;
	}

	/**
	 * @param doKho
	 *            the doKho to set
	 */
	public void setDoKho(String doKho) {

		this.doKho = doKho;
	}

	/**
	 * @param msbt
	 *            the msbt to set
	 */
	public void setMsbt(String msbt) {

		this.msbt = msbt;
	}

	/**
	 * @param tenBt
	 *            the tenBt to set
	 */
	public void setTenBt(String tenBt) {

		this.tenBt = tenBt;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {

		return "BaiTap [msbt=" + msbt + ", tenBt=" + tenBt + ", debai=" + debai + ", doKho=" + doKho + ", daHoanThanh=" + daHoanThanh + "]";
	}

}

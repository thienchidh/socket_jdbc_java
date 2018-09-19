
package controls.client;

import java.io.IOException;
import java.util.ArrayList;

import icontrols.client.IRead;
import model.BaiTap;
import model.SinhVien;

public class Read extends BaseCRUD implements IRead {

	/**
	 * 
	 */

	@Override
	public ArrayList<SinhVien> layTatCaSinhVien() {

		try {
			inititalize();
			truyVanTatCaSinhVien();

			nhanTatCaSinhVienFromServer();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sinhViens;
	}

	@SuppressWarnings("unchecked")
	private void nhanTatCaSinhVienFromServer() throws ClassNotFoundException, IOException {

		sinhViens = (ArrayList<SinhVien>)ois.readObject();

	}

	private void truyVanTatCaSinhVien() throws IOException {

		bfw.write("read");
		bfw.newLine();
		bfw.write("sinhvien");
		bfw.newLine();
		bfw.write("all");
		bfw.newLine();
		bfw.flush();

	}

	@Override
	public ArrayList<BaiTap> layTatCaBaiTap() {

		try {
			inititalize();
			truyVanTatCaBaiTap();

			nhanBaiTapFromServer();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baiTaps;
	}

	@SuppressWarnings("unchecked")
	private void nhanBaiTapFromServer() throws ClassNotFoundException, IOException {

		baiTaps = (ArrayList<BaiTap>)ois.readObject();
	}

	private void truyVanTatCaBaiTap() throws IOException {

		bfw.write("read");
		bfw.newLine();
		bfw.write("baitap");
		bfw.newLine();
		bfw.write("all");
		bfw.newLine();
		bfw.flush();
	}

	@Override
	public ArrayList<SinhVien> timKiemSinhVien(String mssv) {

		try {
			inititalize();
			truyVanTimKiemSinhVien(mssv);

			nhanTatCaSinhVienFromServer();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sinhViens;
	}

	private void truyVanTimKiemSinhVien(String mssv) throws IOException {

		bfw.write("read");
		bfw.newLine();
		bfw.write("sinhvien");
		bfw.newLine();
		bfw.write(mssv);
		bfw.newLine();
		bfw.flush();
		
	}

	@Override
	public ArrayList<BaiTap> timKiemBaiTap(String msbt) {

		try {
			inititalize();
			truyVanTimKiemBaiTap(msbt);

			nhanBaiTapFromServer();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baiTaps;
	}

	private void truyVanTimKiemBaiTap(String msbt) throws IOException {

		bfw.write("read");
		bfw.newLine();
		bfw.write("baitap");
		bfw.newLine();
		bfw.write(msbt);
		bfw.newLine();
		bfw.flush();
		
	}

}

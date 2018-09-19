
package controls.client;

import java.io.IOException;

import icontrols.client.IUpdate;
import model.BaiTap;
import model.SinhVien;

public class Update extends BaseCRUD implements IUpdate {

	@Override
	public boolean suaSinhVien(SinhVien sv) {

		try {
			inititalize();

			this.sv = sv;
			truyVanSuaSinhVien();

			reiceiveMessage();

			System.out.println(stringResult.substring(stringResult.length() - 1));
			return stringToBoolean(stringResult.substring(stringResult.length() - 1));// last index

		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void truyVanSuaSinhVien() throws IOException {

		bfw.write("update");
		bfw.newLine();
		bfw.write("sinhvien");
		bfw.newLine();
		bfw.flush();
		oos.writeObject(sv);
		oos.flush();
	}

	private void reiceiveMessage() throws IOException {

		stringResult = bfr.readLine();

	}

	@Override
	public boolean suaBaiTap(BaiTap bt) {

		try {
			inititalize();

			this.bt = bt;
			truyVanSuaBaiTap();

			reiceiveMessage();

			System.out.println(stringResult.substring(stringResult.length() - 1));
			return stringToBoolean(stringResult.substring(stringResult.length() - 1));// last index

		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void truyVanSuaBaiTap() throws IOException {

		bfw.write("update");
		bfw.newLine();
		bfw.write("baitap");
		bfw.newLine();
		bfw.flush();
		oos.writeObject(bt);
		oos.flush();

	}

	@Override
	public boolean lamXongBaiTap(String maSoBaiTap) {

		try {
			inititalize();

			ms = maSoBaiTap;
			truyVanSuaBaiTap();

			reiceiveMessage();

			System.out.println(stringResult.substring(stringResult.length() - 1));
			return stringToBoolean(stringResult.substring(stringResult.length() - 1));// last index

		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

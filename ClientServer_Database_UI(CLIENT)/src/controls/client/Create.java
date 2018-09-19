
package controls.client;

import java.io.IOException;

import icontrols.client.ICreate;
import model.BaiTap;
import model.SinhVien;

public class Create extends BaseCRUD implements ICreate {

	@Override
	public boolean themMoiSinhVien(SinhVien sv) {

		try {
			inititalize();

			this.sv = sv;
			addSinhVienToServer();

			reiceiveMessage();

			System.out.println(stringResult.substring(stringResult.length() - 1));
			return stringToBoolean(stringResult.substring(stringResult.length() - 1));// last index

		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void reiceiveMessage() throws IOException {

		stringResult = bfr.readLine();

	}

	@Override
	public boolean themMoiBaiTap(BaiTap bt) {

		try {
			inititalize();

			this.bt = bt;
			addBaiTapToServer();

			reiceiveMessage();

			System.out.println(stringResult.substring(stringResult.length() - 1));
			return stringToBoolean(stringResult.substring(stringResult.length() - 1));// last index

		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void addBaiTapToServer() throws IOException {

		bfw.write("add");
		bfw.newLine();
		bfw.write("baitap");
		bfw.newLine();
		bfw.flush();
		oos.writeObject(bt);
		oos.flush();

	}

	private void addSinhVienToServer() throws IOException {

		bfw.write("add");
		bfw.newLine();
		bfw.write("sinhvien");
		bfw.newLine();
		bfw.flush();
		oos.writeObject(sv);
		oos.flush();

	}

}

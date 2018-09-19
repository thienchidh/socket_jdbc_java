
package controls.client;

import java.io.IOException;
import java.sql.SQLException;

import icontrols.client.IDelete;

public class Delete extends BaseCRUD implements IDelete {

	@Override
	public boolean xoaSinhVien(String mssv) throws SQLException {

		try {
			inititalize();

			ms = mssv;
			truyVanXoaSinhVien();

			reiceiveMessage();

			System.out.println(stringResult);
			return stringToBoolean(stringResult.substring(stringResult.length() - 1));// last index
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void truyVanXoaSinhVien() throws IOException {

		bfw.write("delete");
		bfw.newLine();
		bfw.write("sinhvien");
		bfw.newLine();
		bfw.write(ms);
		bfw.newLine();
		bfw.flush();

	}

	private void reiceiveMessage() throws IOException {

		stringResult = bfr.readLine();

	}

	@Override
	public boolean xoaBaiTap(String msbt) throws SQLException {

		try {
			inititalize();
			ms = msbt;
			truyVanXoaBaiTap();

			reiceiveMessage();
			System.out.println(stringResult.substring(stringResult.length() - 1));
			return stringToBoolean(stringResult.substring(stringResult.length() - 1));// last index
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	private void truyVanXoaBaiTap() throws IOException {
		bfw.write("delete");
		bfw.newLine();
		bfw.write("baitap");
		bfw.newLine();
		bfw.write(ms);
		bfw.newLine();
		bfw.flush();

	}

}

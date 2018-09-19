
package controls.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.db.Instances;
import icontroils.db.ICloseConnect;
import icontroils.db.ICreate;
import icontroils.db.IDelete;
import icontroils.db.IOpenConnect;
import icontroils.db.IRead;
import icontroils.db.IServerControls;
import icontroils.db.IUpdate;
import model.BaiTap;
import model.SinhVien;

public class ServerControils implements IServerControls {

	ICloseConnect	iCloseConnect;
	ICreate			iCreate;
	IDelete			iDelete;
	IOpenConnect	iOpenConnect;
	IRead			iRead;
	IUpdate			iUpdate;

	/**
	 * 
	 */
	public ServerControils() {

		super();
		startingServer();

	}

	private void startingServer() {

		iDelete = Instances.getDelete();
		iRead = Instances.getRead();
		iUpdate = Instances.getUpdate();
		iCreate = Instances.getCreate();
		iOpenConnect = Instances.getOpenConnect();
		iCloseConnect = Instances.getCloseConnect();
	}

	@Override
	public void openConnect() {

		try {
			closeConnect();
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}

		System.out.println("ServerControils.openConnect()");
		try {
			Connection connection = iOpenConnect.getConnection(Instances.getHost(), Instances.getDbName(), Instances.getUserName(), Instances.getPassword());
			Instances.setConnection(connection);
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean closeConnect() {

		System.out.println("ServerControils.closeConnect()");
		try {
			return iCloseConnect.closeConnect();
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean themMoiSinhVien(SinhVien sv) throws SQLException {

		return iCreate.themMoiSinhVien(sv);
	}

	@Override
	public boolean chinhSuaSinhVien(SinhVien sv) throws SQLException {

		return iUpdate.suaSinhVien(sv);
	}

	@Override
	public boolean xoaSinhVien(String mssv) throws SQLException {

		return iDelete.xoaSinhVien(mssv);
	}

	@Override
	public ArrayList<SinhVien> layToanBoSinhVien() throws SQLException {

		return iRead.layTatCaSinhVien();
	}

	@Override
	public ArrayList<BaiTap> layToanBoBaiTap() throws SQLException {

		return iRead.layTatCaBaiTap();
	}

	@Override
	public boolean themMoiBaiTap(BaiTap bt) throws SQLException {

		return iCreate.themMoiBaiTap(bt);
	}

	@Override
	public boolean chinhSuaBaiTap(BaiTap bt) throws SQLException {

		return iUpdate.suaBaiTap(bt);
	}

	@Override
	public boolean xoaBaiTap(String msbt) throws SQLException {

		return iDelete.xoaBaiTap(msbt);
	}

	@Override
	public ArrayList<SinhVien> timKiemSinhVien(String mssv) throws SQLException {

		return iRead.timKiemSinhVien(mssv);
	}

	@Override
	public ArrayList<BaiTap> timKiemBaiTap(String msbt) throws SQLException {

		return iRead.timKiemBaiTap(msbt);
	}

}


package controls.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import factory.db.Instances;
import icontroils.db.IUpdate;
import model.BaiTap;
import model.SinhVien;

public class Update implements IUpdate {

	Connection connection;

	/**
	 * 
	 */
	public Update() {

		super();
	}

	@Override
	public boolean suaSinhVien(SinhVien sv) {

		connection = Instances.getConnection();
		CallableStatement callableStatement;
		try {
			callableStatement = connection.prepareCall("{call updateSinhVien(?,?,?,?)}");
			callableStatement.setString(1, sv.getMssv());
			callableStatement.setString(2, sv.getHoTen());
			callableStatement.setString(3, sv.getLop());
			callableStatement.setString(4, sv.getDangLam());

			int x = callableStatement.executeUpdate();
			callableStatement.close();

			return x != 0;

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean suaBaiTap(BaiTap bt) {

		connection = Instances.getConnection();
		CallableStatement callableStatement;
		try {
			callableStatement = connection.prepareCall("{call updateBaiTap(?,?,?,?)}");
			callableStatement.setString(1, bt.getMsbt());
			callableStatement.setString(2, bt.getTenBt());
			callableStatement.setString(3, bt.getDebai());
			callableStatement.setString(4, bt.getDoKho());

			int x = callableStatement.executeUpdate();
			callableStatement.close();

			return x != 0;

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean lamXongBaiTap(String maSoBaiTap) {

		connection = Instances.getConnection();
		CallableStatement callableStatement;
		try {
			callableStatement = connection.prepareCall("{call doneBaiTap(?)}");
			callableStatement.setString(1, maSoBaiTap);

			int x = callableStatement.executeUpdate();
			callableStatement.close();

			return x != 0;

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}

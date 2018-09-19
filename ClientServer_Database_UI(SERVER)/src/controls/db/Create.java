
package controls.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import factory.db.Instances;
import icontroils.db.ICreate;
import model.BaiTap;
import model.SinhVien;

public class Create implements ICreate {

	Connection connection;

	/**
	 * 
	 */
	public Create() {

		super();
	}

	@Override
	public boolean themMoiSinhVien(SinhVien sv) {

		connection = Instances.getConnection();
		// Biết là lãng phí nhưng lỡ rồi
		try {
			CallableStatement callableStatement = connection.prepareCall("{call addSinhVien(?, ?, ?)}");
			callableStatement.setString(1, sv.getMssv());
			callableStatement.setString(2, sv.getHoTen());
			callableStatement.setString(3, sv.getLop());

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
	public boolean themMoiBaiTap(BaiTap bt) {

		connection = Instances.getConnection();
		// Biết là lãng phí nhưng lỡ rồi
		try {
			CallableStatement callableStatement = connection.prepareCall("{call addBaiTap(?, ?, ?, ?)}");
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

}

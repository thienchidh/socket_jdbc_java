
package controls.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import factory.db.Instances;
import icontroils.db.IDelete;

public class Delete implements IDelete {

	Connection connection;

	/**
	 * 
	 */
	public Delete() {

		super();
	}

	@Override
	public boolean xoaSinhVien(String mssv) throws SQLException {

		connection = Instances.getConnection();
		CallableStatement callableStatement = connection.prepareCall("{call deleteSinhVien(?)}");
		callableStatement.setString(1, mssv);

		int x = callableStatement.executeUpdate();

		callableStatement.close();

		return x != 0;
	}

	@Override
	public boolean xoaBaiTap(String msbt) throws SQLException {

		connection = Instances.getConnection();
		CallableStatement callableStatement = connection.prepareCall("{call deleteBaiTap(?)}");
		callableStatement.setString(1, msbt);

		int x = callableStatement.executeUpdate();

		callableStatement.close();

		return x != 0;
	}

}

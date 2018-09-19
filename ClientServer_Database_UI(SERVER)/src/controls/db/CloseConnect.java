
package controls.db;

import java.sql.Connection;
import java.sql.SQLException;

import factory.db.Instances;
import icontroils.db.ICloseConnect;

public class CloseConnect implements ICloseConnect {

	@Override
	public boolean closeConnect() throws SQLException {

		Connection connection = Instances.getConnection();
		if(connection != null) {
			connection.close();
		}
		return false;
	}

}

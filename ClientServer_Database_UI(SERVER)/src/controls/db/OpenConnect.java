
package controls.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import icontroils.db.IOpenConnect;

public class OpenConnect implements IOpenConnect {

	@Override
	public Connection getConnection(String host, String db, String userName, String password) throws SQLException {

		String strConnect = "jdbc:mysql://" + host + "/" + db;
		Properties pro = new Properties();
		pro.put("user", userName);
		pro.put("password", password);

		Driver driver = new Driver();
		return driver.connect(strConnect, pro);
	}

}


package icontroils.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface IOpenConnect {

	public Connection getConnection(String host, String db, String userName, String password) throws SQLException;

}


package factory.db;

import java.sql.Connection;
import java.sql.SQLException;

import controls.db.CloseConnect;
import controls.db.Create;
import controls.db.Delete;
import controls.db.OpenConnect;
import controls.db.Read;
import controls.db.ServerControils;
import controls.db.Update;
import icontroils.db.ICloseConnect;
import icontroils.db.ICreate;
import icontroils.db.IDelete;
import icontroils.db.IOpenConnect;
import icontroils.db.IRead;
import icontroils.db.IServerControls;
import icontroils.db.IUpdate;

public class Instances {

	static ICloseConnect	closeConnect;
	static Connection		connection;
	static ICreate			create;
	static IDelete			delete;
	static IServerControls	iServerControls;
	static IOpenConnect		openConnect;
	static IRead			read;
	static IUpdate			update;
	private static String	dbName;
	private static String	host;
	private static String	password;

	private static String	userName;

	synchronized static public ICloseConnect getCloseConnect() {

		if(closeConnect == null) {
			closeConnect = new CloseConnect();
		}
		return closeConnect;
	}

	public static void setConnection(Connection connection) {

		if(connection != null) {
			Instances.connection = connection;
		}
	}

	public static Connection getConnection() {

		if(connection == null) {
			try {
				connection = getOpenConnect().getConnection(host, dbName, userName, password);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return connection;
	}

	public static ICreate getCreate() {

		if(create == null) {
			create = new Create();
		}
		return create;
	}

	public static String getDbName() {

		return dbName;
	}

	public static IDelete getDelete() {

		if(delete == null) {
			delete = new Delete();
		}

		return delete;
	}

	public static String getHost() {

		return host;
	}

	public static IServerControls getiServerControls() {

		if(iServerControls == null) {
			iServerControls = new ServerControils();
		}
		return iServerControls;
	}

	public static synchronized IOpenConnect getOpenConnect() {

		if(openConnect == null) {
			openConnect = new OpenConnect();
		}
		return openConnect;
	}

	public static String getPassword() {

		return password;
	}

	public static IRead getRead() {

		if(read == null) {
			read = new Read();
		}
		return read;
	}

	public static IUpdate getUpdate() {

		if(update == null) {
			update = new Update();
		}
		return update;
	}

	public static String getUserName() {

		return userName;
	}

	public static void setDbName(String dbName) {

		Instances.dbName = dbName;
	}

	public static void setHost(String host) {

		Instances.host = host;
	}

	public static void setPassword(String password) {

		Instances.password = password;
	}

	public static void setUserName(String userName) {

		Instances.userName = userName;
	}

}

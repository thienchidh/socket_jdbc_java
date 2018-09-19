
package icontrols.client;

import java.sql.SQLException;

public interface IDelete {

	boolean xoaSinhVien(String mssv) throws SQLException;

	boolean xoaBaiTap(String msbt) throws SQLException;
}

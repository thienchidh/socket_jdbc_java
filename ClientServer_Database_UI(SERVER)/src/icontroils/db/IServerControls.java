
package icontroils.db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.BaiTap;
import model.SinhVien;

public interface IServerControls {

	void openConnect();

	boolean closeConnect();

	boolean themMoiSinhVien(SinhVien sv) throws SQLException;

	boolean xoaSinhVien(String mssv) throws SQLException;

	ArrayList<SinhVien> layToanBoSinhVien() throws SQLException;

	ArrayList<BaiTap> layToanBoBaiTap() throws SQLException;

	ArrayList<SinhVien> timKiemSinhVien(String mssv) throws SQLException;

	ArrayList<BaiTap> timKiemBaiTap(String msbt) throws SQLException;

	boolean themMoiBaiTap(BaiTap bt) throws SQLException;

	boolean chinhSuaBaiTap(BaiTap bt) throws SQLException;

	boolean xoaBaiTap(String msbt) throws SQLException;

	boolean chinhSuaSinhVien(SinhVien sv) throws SQLException;

}

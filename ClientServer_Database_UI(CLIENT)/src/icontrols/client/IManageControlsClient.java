
package icontrols.client;

import java.sql.SQLException;
import java.util.ArrayList;

import model.BaiTap;
import model.SinhVien;

public interface IManageControlsClient {

	boolean lamXongBaiTap(String maSoBaiTap);

	ArrayList<BaiTap> layTatCaBaiTap();

	ArrayList<SinhVien> layTatCaSinhVien();

	ArrayList<BaiTap> timKiemBaiTap(String msbt);

	ArrayList<SinhVien> timKiemSinhVien(String mssv);

	boolean suaBaiTap(BaiTap bt);

	boolean suaSinhVien(SinhVien sv);

	boolean themMoiBaiTap(BaiTap bt);

	boolean themMoiSinhVien(SinhVien sv);

	boolean xoaBaiTap(String msbt) throws SQLException;

	boolean xoaSinhVien(String mssv) throws SQLException;

}

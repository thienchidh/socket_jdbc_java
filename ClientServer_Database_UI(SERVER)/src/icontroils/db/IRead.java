
package icontroils.db;

import java.util.ArrayList;

import model.BaiTap;
import model.SinhVien;

public interface IRead {

	ArrayList<SinhVien> layTatCaSinhVien();

	ArrayList<BaiTap> layTatCaBaiTap();

	ArrayList<SinhVien> timKiemSinhVien(String mssv);

	ArrayList<BaiTap> timKiemBaiTap(String msbt);
}


package icontroils.db;

import model.BaiTap;
import model.SinhVien;

public interface IUpdate {

	boolean suaSinhVien(SinhVien sv);

	boolean suaBaiTap(BaiTap bt);

	boolean lamXongBaiTap(String maSoBaiTap);

}

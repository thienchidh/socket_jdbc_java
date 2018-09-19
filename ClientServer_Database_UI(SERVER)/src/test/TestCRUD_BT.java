
package test;

import java.sql.SQLException;
import java.util.ArrayList;

import factory.db.Instances;
import icontroils.db.IServerControls;
import model.BaiTap;
import model.SinhVien;

public class TestCRUD_BT {

	IServerControls controls = Instances.getiServerControls();

	void read() {

//		try {
////			ArrayList<BaiTap> baiTaps = controls.timKiemBaiTap("bt01");
//			ArrayList<BaiTap> baiTaps = controls.layToanBoBaiTap();
//			for(BaiTap baiTap : baiTaps) {
//				System.out.println(baiTap);
//			}
//		} catch(SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
//			ArrayList<SinhVien> sinhViens = controls.layToanBoSinhVien();
			ArrayList<SinhVien> sinhViens = controls.timKiemSinhVien("sv01");
			for(SinhVien sv : sinhViens) {
				System.out.println(sv);
			}
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void create() {

		try {
			controls.themMoiBaiTap(new BaiTap("Bt001", "Bài 1", " ", "Dễ", "0"));
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void delete() {

		try {
			controls.xoaBaiTap("bt001");
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void update() {

		try {
			controls.chinhSuaBaiTap(new BaiTap("Bt001", "Bài 1", "12 + 12 = ? ", "Vừa", "0"));
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Instances.setDbName("dbBaiTap");
		Instances.setHost("localhost:3306");
		Instances.setUserName("root");
		Instances.setPassword("123456");

		TestCRUD_BT bt = new TestCRUD_BT();
		bt.delete();
		bt.read();
	}
}

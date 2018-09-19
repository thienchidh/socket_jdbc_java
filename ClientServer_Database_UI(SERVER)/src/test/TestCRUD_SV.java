
package test;

import java.sql.SQLException;
import java.util.ArrayList;

import factory.db.Instances;
import icontroils.db.IServerControls;
import model.SinhVien;

public class TestCRUD_SV {

	IServerControls controls = Instances.getiServerControls();

	void create() {

		System.out.println("TestCRUD.create()");

		try {
			controls.themMoiSinhVien(new SinhVien("sv001", "Nguyễn Văn Tí", "1", "0"));

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void update() {

		try {
			controls.chinhSuaSinhVien(new SinhVien("sv001", "Nguyễn Văn Tí", "1", null));
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void read() {

		try {
			ArrayList<SinhVien> sinhViens = controls.layToanBoSinhVien();
			for(SinhVien sv : sinhViens) {
				System.out.println(sv);
			}
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void delete() {

		try {
			controls.xoaSinhVien("sv001");
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TestCRUD.delete()");
	}

	public static void main(String[] args) {

		Instances.setDbName("dbBaiTap");
		Instances.setHost("localhost:3306");
		Instances.setUserName("root");
		Instances.setPassword("123456");

		TestCRUD_SV crud = new TestCRUD_SV();
		// crud.create();
		// crud.read();

//		crud.update();
//		crud.read();

		crud.delete();
		crud.read();

	}

}

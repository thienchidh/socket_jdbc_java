
package controls.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.client.Instances;
import icontrols.client.ICreate;
import icontrols.client.IDelete;
import icontrols.client.IManageControlsClient;
import icontrols.client.IRead;
import icontrols.client.IUpdate;
import model.BaiTap;
import model.SinhVien;

public class ManageControlsClient implements IManageControlsClient {

	ICreate	create;
	IDelete	delete;
	IRead	read;
	IUpdate	update;

	public ManageControlsClient() {

		try {
			Instances.initialize();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.create = Instances.getCreate();
		this.update = Instances.getUpdate();
		this.read = Instances.getRead();
		this.delete = Instances.getDelete();
	}

	public void cleanUp() {

		Instances.cleanUp();
	}

	@Override
	public boolean lamXongBaiTap(String maSoBaiTap) {

		return update.lamXongBaiTap(maSoBaiTap);
	}

	@Override
	public ArrayList<BaiTap> layTatCaBaiTap() {

		return read.layTatCaBaiTap();
	}

	@Override
	public ArrayList<SinhVien> layTatCaSinhVien() {

		return read.layTatCaSinhVien();
	}

	@Override
	public boolean suaBaiTap(BaiTap bt) {

		return update.suaBaiTap(bt);
	}

	@Override
	public boolean suaSinhVien(SinhVien sv) {

		return update.suaSinhVien(sv);
	}

	@Override
	public boolean themMoiBaiTap(BaiTap bt) {

		return create.themMoiBaiTap(bt);
	}

	@Override
	public boolean themMoiSinhVien(SinhVien sv) {

		return create.themMoiSinhVien(sv);
	}

	@Override
	public boolean xoaBaiTap(String msbt) throws SQLException {

		return delete.xoaBaiTap(msbt);
	}

	@Override
	public boolean xoaSinhVien(String mssv) throws SQLException {

		return delete.xoaSinhVien(mssv);
	}

	@Override
	public ArrayList<BaiTap> timKiemBaiTap(String msbt) {

		return read.timKiemBaiTap(msbt);
	}

	@Override
	public ArrayList<SinhVien> timKiemSinhVien(String mssv) {

		return read.timKiemSinhVien(mssv);
	}

}

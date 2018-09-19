
package controls.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.db.Instances;
import icontroils.db.IRead;
import model.BaiTap;
import model.SinhVien;

public class Read implements IRead {

	Connection connection;

	/**
	 * 
	 */
	public Read() {

		super();
	}

	@Override
	public ArrayList<SinhVien> layTatCaSinhVien() {

		connection = Instances.getConnection();
		ArrayList<SinhVien> res = new ArrayList<>();

		try {
			CallableStatement callableStatement = connection.prepareCall("{call getSinhVien()}");
			ResultSet resultSet = callableStatement.executeQuery();
			SinhVien sv;

			while(resultSet.next()) {

				String mssv = resultSet.getString("MSSV");
				String hoTen = resultSet.getString("hoTen");
				String lop = resultSet.getString("lop");
				String dangLam = resultSet.getString("msbt");

				sv = new SinhVien(mssv, hoTen, lop, dangLam);
				res.add(sv);

			}
			resultSet.close();
			callableStatement.close();

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public ArrayList<BaiTap> layTatCaBaiTap() {

		connection = Instances.getConnection();
		ArrayList<BaiTap> res = new ArrayList<>();

		try {
			CallableStatement callableStatement = connection.prepareCall("{call getBaiTap()}");
			ResultSet resultSet = callableStatement.executeQuery();
			BaiTap bt;

			while(resultSet.next()) {

				String MSBT = resultSet.getString("MSBT");
				String TenBaiTap = resultSet.getString("TenBaiTap");
				String DeBai = resultSet.getString("DeBai");
				String doKho = resultSet.getString("doKho");
				String DaHoanThanh = resultSet.getString("DaHoanThanh");

				bt = new BaiTap(MSBT, TenBaiTap, DeBai, doKho, DaHoanThanh);
				res.add(bt);

			}

			resultSet.close();
			callableStatement.close();

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public ArrayList<SinhVien> timKiemSinhVien(String mssv) {

		connection = Instances.getConnection();
		ArrayList<SinhVien> res = new ArrayList<>();

		try {
			CallableStatement callableStatement = connection.prepareCall("{call timKiemSinhVien(?)}");
			callableStatement.setString(1, mssv);
			ResultSet resultSet = callableStatement.executeQuery();
			SinhVien sv;

			while(resultSet.next()) {

				String ms = resultSet.getString("MSSV");
				String hoTen = resultSet.getString("hoTen");
				String lop = resultSet.getString("lop");
				String dangLam = resultSet.getString("msbt");

				sv = new SinhVien(ms, hoTen, lop, dangLam);
				res.add(sv);

			}
			resultSet.close();
			callableStatement.close();

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public ArrayList<BaiTap> timKiemBaiTap(String msbt) {

		connection = Instances.getConnection();
		ArrayList<BaiTap> res = new ArrayList<>();

		try {
			CallableStatement callableStatement = connection.prepareCall("{call timKiemBaiTap(?)}");
			callableStatement.setString(1, msbt);
			ResultSet resultSet = callableStatement.executeQuery();
			BaiTap bt;

			while(resultSet.next()) {

				String MSBT = resultSet.getString("MSBT");
				String TenBaiTap = resultSet.getString("TenBaiTap");
				String DeBai = resultSet.getString("DeBai");
				String doKho = resultSet.getString("doKho");
				String DaHoanThanh = resultSet.getString("DaHoanThanh");

				bt = new BaiTap(MSBT, TenBaiTap, DeBai, doKho, DaHoanThanh);
				res.add(bt);

			}

			resultSet.close();
			callableStatement.close();

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

}

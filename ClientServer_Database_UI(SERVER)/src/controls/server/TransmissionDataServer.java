
package controls.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.db.Instances;
import icontroils.db.IServerControls;
import model.BaiTap;
import model.SinhVien;

public class TransmissionDataServer implements Runnable {

	IServerControls				controls;
	boolean						flagInterrupt	= false;
	Socket						socket;
	private ArrayList<BaiTap>	baiTaps;
	private BufferedReader		bfr;
	private BufferedWriter		bfw;
	private BaiTap				bt;
	private boolean				flagActionSuccess;
	private InputStream			is;
	private InputStreamReader	isr;
	private String				keyWord;

	private String				maso;
	private String				nameClass;
	private ObjectInputStream	ois;
	private ObjectOutputStream	oos;
	private OutputStream		os;
	private OutputStreamWriter	osw;
	private ArrayList<SinhVien>	sinhViens;
	private SinhVien			sv;

	/**
	 * @param socket
	 */
	public TransmissionDataServer(Socket socket) {

		System.out.println("TransmissionDataServer.TransmissionDataServer()");
		this.socket = socket;
	}

	@Override
	public void run() {

		System.out.println("TransmissionDataServer.run()");
		try {
			initialize();

			while(!flagInterrupt) {
				System.out.println("TransmissionDataServer.run()1");
				processing();
			}
			cleanUp();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String booleanToString(boolean b) {

		return b == true ? "1" : "0";
	}

	private void cleanUp() throws IOException {

		ois.close();
		bfr.close();
		isr.close();
		is.close();

		oos.close();
		bfw.close();
		osw.close();
		os.close();

		controls.closeConnect();
	}

	private void guiKetQuaChinhSuaSinhVien(boolean b) throws IOException {

		bfw.write("update sinhvien " + booleanToString(b));
		bfw.newLine();
		bfw.flush();

	}

	private void guiKetQuaThemMoiBaiTap(boolean b) throws IOException {

		bfw.write("add baitap " + booleanToString(b));
		bfw.newLine();
		bfw.flush();
	}

	private void guiKetQuaThemMoiSinhVien(boolean b) throws IOException {

		bfw.write("add sinhvien " + booleanToString(b));
		bfw.newLine();
		bfw.flush();
	}

	private void guiKetQuaXoaBaiTap(boolean b) throws IOException {

		bfw.write("delete baitap " + booleanToString(b));
		bfw.newLine();
		bfw.flush();
	}

	private void guiKetQuaXoaSinhVien(boolean b) throws IOException {

		bfw.write("delete sinhvien " + booleanToString(b));
		bfw.newLine();
		bfw.flush();
	}

	private void guiToanBoBaiTap(ArrayList<BaiTap> baiTaps2) throws IOException {

		oos.writeObject(baiTaps2);
		oos.flush();
	}

	private void guiToanBoSinhVien(ArrayList<SinhVien> sinhViens2) throws IOException {

		oos.writeObject(sinhViens2);
		oos.flush();
	}

	private void initialize() throws IOException {

		System.out.println("TransmissionDataServer.initialize()");

		// Nhớ là k đc thay đổi thứ tự dòng nào

		controls = Instances.getiServerControls();
		is = socket.getInputStream();
		isr = new InputStreamReader(is);
		bfr = new BufferedReader(isr);

		os = socket.getOutputStream();
		osw = new OutputStreamWriter(os, "UTF-8");
		bfw = new BufferedWriter(osw);

		oos = new ObjectOutputStream(os);

		ois = new ObjectInputStream(is);

	}

	private void processing() throws IOException, SQLException, ClassNotFoundException {

		System.out.println("TransmissionDataServer.processing()");
		keyWord = bfr.readLine();
		switch(keyWord.toLowerCase()) {
		case "add":

			nameClass = bfr.readLine();

			switch(nameClass.toUpperCase()) {
			case "SINHVIEN":

				sv = (SinhVien)ois.readObject();
				flagActionSuccess = controls.themMoiSinhVien(sv);
				guiKetQuaThemMoiSinhVien(flagActionSuccess);
				break;
			case "BAITAP":

				bt = (BaiTap)ois.readObject();
				flagActionSuccess = controls.themMoiBaiTap(bt);
				guiKetQuaThemMoiBaiTap(flagActionSuccess);
				break;
			}
		case "update":

			nameClass = bfr.readLine();

			switch(nameClass.toUpperCase()) {
			case "SINHVIEN":

				sv = (SinhVien)ois.readObject();
				flagActionSuccess = controls.chinhSuaSinhVien(sv);
				guiKetQuaChinhSuaSinhVien(flagActionSuccess);
				break;
			case "BAITAP":

				bt = (BaiTap)ois.readObject();
				flagActionSuccess = controls.chinhSuaBaiTap(bt);
				guiKetQuaChinhSuaBaiTap(flagActionSuccess);
				break;
			}

		case "read":

			nameClass = bfr.readLine();

			switch(nameClass.toUpperCase()) {
			case "SINHVIEN":
				maso = bfr.readLine();
				switch(maso) {
				case "all":
					sinhViens = controls.layToanBoSinhVien();
					guiToanBoSinhVien(sinhViens);
					break;

				default:
					sinhViens = controls.timKiemSinhVien(maso);
					guiToanBoSinhVien(sinhViens);
					break;
				}

			case "BAITAP":

				maso = bfr.readLine();
				switch(maso.toLowerCase()) {
				case "all":
					baiTaps = controls.layToanBoBaiTap();
					guiToanBoBaiTap(baiTaps);
					break;

				default:
					baiTaps = controls.timKiemBaiTap(maso);
					guiToanBoBaiTap(baiTaps);
					break;
				}
				break;
			}
			break;
		case "delete":

			nameClass = bfr.readLine();

			switch(nameClass.toUpperCase()) {
			case "SINHVIEN":

				maso = bfr.readLine();

				flagActionSuccess = controls.xoaSinhVien(maso);
				guiKetQuaXoaSinhVien(flagActionSuccess);
				break;
			case "BAITAP":

				maso = bfr.readLine();
				flagActionSuccess = controls.xoaBaiTap(maso);
				guiKetQuaXoaBaiTap(flagActionSuccess);
				break;
			}
			break;
		}

	}

	private void guiKetQuaChinhSuaBaiTap(boolean b) throws IOException {

		bfw.write("update baitap " + booleanToString(b));
		bfw.newLine();
		bfw.flush();

	}

}

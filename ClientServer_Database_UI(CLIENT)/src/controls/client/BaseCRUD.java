
package controls.client;

import static factory.client.Instances.getBfr;
import static factory.client.Instances.getBfw;
import static factory.client.Instances.getIs;
import static factory.client.Instances.getIsr;
import static factory.client.Instances.getOis;
import static factory.client.Instances.getOos;
import static factory.client.Instances.getOs;
import static factory.client.Instances.getOsw;
import static factory.client.Instances.getSocket;

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
import java.net.UnknownHostException;
import java.util.ArrayList;

import factory.client.Instances;
import model.BaiTap;
import model.SinhVien;

public abstract class BaseCRUD {

	protected BufferedReader		bfr;
	protected BufferedWriter		bfw;
	protected InputStream			is;
	protected InputStreamReader		isr;
	protected ObjectInputStream		ois;
	protected ObjectOutputStream	oos;
	protected OutputStream			os;
	protected OutputStreamWriter	osw;
	protected Socket				socket;

	// Biến dùng để chứa các giá trị trong các lớp con mà các lớp con cần dùng
	protected SinhVien				sv;
	protected BaiTap				bt;
	protected ArrayList<SinhVien>	sinhViens;
	protected ArrayList<BaiTap>		baiTaps;
	protected String				stringResult;
	protected String				ms;

	/**
	 * 
	 */
	public BaseCRUD() {

		super();
		try {
			inititalize();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void inititalize() throws UnknownHostException, IOException {

		Instances.initialize();
		socket = getSocket();
		is = getIs();
		isr = getIsr();
		bfr = getBfr();
		os = getOs();
		osw = getOsw();
		bfw = getBfw();
		oos = getOos();
		ois = getOis();

	}

	protected boolean stringToBoolean(String s) {

		return s.equals("1");
	}

}

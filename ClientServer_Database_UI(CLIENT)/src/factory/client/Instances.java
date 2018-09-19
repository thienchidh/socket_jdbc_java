
package factory.client;

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

import controls.client.Create;
import controls.client.Delete;
import controls.client.ManageControlsClient;
import controls.client.Read;
import controls.client.Update;
import icontrols.client.ICreate;
import icontrols.client.IDelete;
import icontrols.client.IManageControlsClient;
import icontrols.client.IRead;
import icontrols.client.IUpdate;
import model.BaiTap;
import model.SinhVien;

/**
 * Phí mà chạy đc còn đỡ hơn là tiết kiệm <sửa mệt ^^ >
 * 
 * @author chi
 *
 */
public class Instances {

	static ArrayList<BaiTap>		baiTaps;
	static BufferedReader			bfr;
	static BufferedWriter			bfw;
	static BaiTap					bt;
	static IManageControlsClient	controlsClient;
	static ICreate					create;
	static IDelete					delete;
	static String					host	= "localhost";
	private static InputStream		is;
	static InputStreamReader		isr;
	static String					keyWord;
	static String					maso;
	static String					nameClass;
	static ObjectInputStream		ois;
	static ObjectOutputStream		oos;
	static OutputStream				os;
	static OutputStreamWriter		osw;
	static int						port	= 8192;
	static IRead					read;
	static ArrayList<SinhVien>		sinhViens;
	static Socket					socket;
	static SinhVien					sv;
	static IUpdate					update;

	/**
	 * @throws IOException
	 * 
	 */
	public static void initialize() throws IOException {

		setHost(host);
		setPort(port);

		is = socket.getInputStream();
		isr = new InputStreamReader(is);
		bfr = new BufferedReader(isr);

		os = socket.getOutputStream();
		osw = new OutputStreamWriter(os, "UTF-8");
		bfw = new BufferedWriter(osw);

		oos = new ObjectOutputStream(os);
		ois = new ObjectInputStream(is);
	}

	public static void cleanUp() {

		System.out.println("Instances.cleanUp()");
		try {
			oos.close();
		} catch(IOException e) {}
		try {
			ois.close();
		} catch(IOException e) {}

		try {
			bfr.close();
		} catch(IOException e) {}
		try {
			isr.close();
		} catch(IOException e) {}

		try {
			bfw.close();
		} catch(IOException e) {}
		try {
			osw.close();
		} catch(IOException e) {}

		try {
			is.close();
		} catch(IOException e) {}
		try {
			os.close();
		} catch(IOException e) {}
		try {
			socket.close();
		} catch(IOException e) {}

	}

	public static ArrayList<BaiTap> getBaiTaps() {

		return baiTaps;
	}

	public static BufferedReader getBfr() {

		return bfr;
	}

	public static BufferedWriter getBfw() {

		return bfw;
	}

	public static BaiTap getBt() {

		return bt;
	}

	public static IManageControlsClient getControlsClient() {

		if(controlsClient == null) {
			controlsClient = new ManageControlsClient();

		}
		return controlsClient;
	}

	public static ICreate getCreate() {

		if(create == null) {
			create = new Create();
		}

		return create;
	}

	public static IDelete getDelete() {

		if(delete == null) {
			delete = new Delete();
		}
		return delete;
	}

	public static String getHost() {

		return host;
	}

	public static InputStream getIs() {

		return is;
	}

	public static InputStreamReader getIsr() {

		return isr;
	}

	public static String getKeyWord() {

		return keyWord;
	}

	public static String getMaso() {

		return maso;
	}

	public static String getNameClass() {

		return nameClass;
	}

	public static ObjectInputStream getOis() {

		return ois;
	}

	public static ObjectOutputStream getOos() {

		return oos;
	}

	public static OutputStream getOs() {

		return os;
	}

	public static OutputStreamWriter getOsw() {

		return osw;
	}

	public static int getPort() {

		return port;
	}

	public static IRead getRead() {

		if(read == null) {
			read = new Read();

		}
		return read;
	}

	public static ArrayList<SinhVien> getSinhViens() {

		return sinhViens;
	}

	public static Socket getSocket() throws UnknownHostException, IOException {

		if(socket == null) {
			socket = new Socket(host, port);
		}
		return socket;
	}

	public static SinhVien getSv() {

		return sv;
	}

	public static IUpdate getUpdate() {

		if(update == null) {
			update = new Update();
		}

		return update;
	}

	public static void setHost(String host) throws UnknownHostException, IOException {

		Instances.host = host;
		try {
			Socket soc = new Socket(host, port);
//			cleanUp();// bugs :v
			socket = soc;
		} catch(Exception e) {
			// TODO: handle exception
		}

	}

	public static void setPort(int port) throws UnknownHostException, IOException {

		Instances.port = port;
		try {
			Socket soc = new Socket(host, port);
//			cleanUp();// bugs :v
			socket = soc;
		} catch(Exception e) {
			// TODO: handle exception
		}
	}

}

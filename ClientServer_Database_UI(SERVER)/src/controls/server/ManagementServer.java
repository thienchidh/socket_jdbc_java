
package controls.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ManagementServer {

	private ServerSocket			serverSocket;
	private Socket					socket;

	private int						port;
	private Thread					thread;
	private TransmissionDataServer	target;

	/**
	 * 
	 */
	public ManagementServer(int port) {

		super();
		this.port = port;
	}

	public int getPort() {

		return port;
	}

	public void setPort(int port) {

		this.port = port;
	}

	public void startServer() {

		System.out.println("Server starting!");
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					serverSocket = new ServerSocket(port);
					System.out.println("Server started!");

					while(true) {
						socket = serverSocket.accept();
						target = new TransmissionDataServer(socket);
						thread = new Thread(target);
						thread.start();
					}

				} catch(IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.out);
					System.out.println("Shutdown server!");
				}

			}
		}).start();

	}

	public void stopServer() {

		try {
			serverSocket.close();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

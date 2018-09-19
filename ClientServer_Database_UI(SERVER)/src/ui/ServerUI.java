
package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controls.server.ManagementServer;
import factory.db.Instances;
import icontroils.db.IServerControls;

public class ServerUI extends JFrame {

	private JPanel				contentPane;
	private JButton				btnStartServer;
	private JButton				btnStopServer;
	private JButton				btnConnectDB;
	private JButton				btnDisconnectDB;
	private IServerControls		iServerControls;
	private int					portServer;
	private ManagementServer	managementServer;
	private JPanel				panel;
	private JPanel				panel_1;
	private JButton				btnOneClickStart;
	private JButton				btnOneClickToStop;

	/**
	 * Create the frame.
	 */
	public ServerUI(String title) {

		super(title);
		addControls();
		addEvents();

	}

	private void addControls() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		panel_1 = new JPanel();
		contentPane.add(panel_1);

		btnOneClickStart = new JButton("one click to Start");
		panel_1.add(btnOneClickStart);

		btnOneClickToStop = new JButton("one click to Stop");
		btnOneClickToStop.setEnabled(false);
		panel_1.add(btnOneClickToStop);

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		btnStartServer = new JButton("Start Server");
		panel.add(btnStartServer);

		btnStopServer = new JButton("StopServer");
		panel.add(btnStopServer);
		btnStopServer.setEnabled(false);

		btnConnectDB = new JButton("ConnectDB");
		panel.add(btnConnectDB);

		btnDisconnectDB = new JButton("DisConnect");
		panel.add(btnDisconnectDB);
		btnDisconnectDB.setEnabled(false);

	}

	private void addEvents() {

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				xuLyThoat();
			}
		});
		btnStartServer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyStartServer();
			}
		});
		btnStopServer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyStopServer();
			}
		});

		btnConnectDB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyConnectDatabase();
			}
		});
		btnDisconnectDB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyDongConnectDatabase();
			}
		});

		btnOneClickStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyConnectDatabase();
				xuLyStartServer();

				btnOneClickStart.setEnabled(false);
				btnOneClickToStop.setEnabled(true);
			}
		});

		btnOneClickToStop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyDongConnectDatabase();
				xuLyStopServer();

				btnOneClickStart.setEnabled(true);
				btnOneClickToStop.setEnabled(false);
			}
		});

	}

	protected void xuLyThoat() {

		// TODO Auto-generated method stub
		int ret = JOptionPane.showConfirmDialog(null, "Exit?", "Yes?", JOptionPane.YES_NO_OPTION);
		if(ret == JOptionPane.YES_OPTION) {
			try {
				xuLyDongConnectDatabase();
				xuLyStopServer();
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
			System.exit(0);
		}

	}

	protected void xuLyDongConnectDatabase() {

		System.out.println("ServerUI.xuLyDongConnectDatabase()");
		// TODO Auto-generated method stub
		btnConnectDB.setEnabled(true);
		btnDisconnectDB.setEnabled(false);

		if(iServerControls != null) {
			iServerControls.closeConnect();
		}

	}

	protected void xuLyConnectDatabase() {

		// TODO Auto-generated method stub

		String dbName = "dbBaiTap";
		String host = JOptionPane.showInputDialog("host: ", "localhost:3306");
		if((host == null)) { return; }
		String userName = JOptionPane.showInputDialog("username: ", "root");
		if(userName == null) { return; }
		String password = JOptionPane.showInputDialog("password", "123456");
		if(password == null) { return; }

		Instances.setDbName(dbName);
		Instances.setHost(host);
		Instances.setUserName(userName);
		Instances.setPassword(password);

		btnConnectDB.setEnabled(false);
		btnDisconnectDB.setEnabled(true);

		iServerControls = Instances.getiServerControls();
		iServerControls.openConnect();

	}

	protected void xuLyStopServer() {

		managementServer.stopServer();

		btnStartServer.setEnabled(true);
		btnStopServer.setEnabled(false);

	}

	protected void xuLyStartServer() {

		try {
			portServer = Integer.parseInt(JOptionPane.showInputDialog("Port:", "8199"));
		} catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
		if(managementServer == null) {
			managementServer = new ManagementServer(portServer);
		}
		managementServer.startServer();

		btnStartServer.setEnabled(false);
		btnStopServer.setEnabled(true);

	}

	public void showWindow() {

		setSize(450, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}

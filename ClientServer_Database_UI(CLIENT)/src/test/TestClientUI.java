
package test;

import javax.swing.JOptionPane;

import factory.client.Instances;
import ui.ClientUI;

public class TestClientUI {

	public static void main(String[] args) {

		String host = JOptionPane.showInputDialog(null, "Máy chủ: ", "localhost");
		String sport = JOptionPane.showInputDialog(null, "Port: ", "8199");

		if(host == null || sport == null) {
			System.exit(1);
		}

		int port;

		try {
			port = Integer.parseInt(sport);

			Instances.setHost(host);
			Instances.setPort(port);

			ClientUI ui = new ClientUI("ClientUI - " + host + " - " + port);
			ui.showWindow();

		} catch(Exception e) {
			e.printStackTrace(System.out);
			System.exit(1);
		}

	}
}

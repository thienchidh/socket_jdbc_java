
package test;

import java.awt.EventQueue;

import ui.ServerUI;

public class TestServerUI {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					ServerUI ui = new ServerUI("server");
					ui.showWindow();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

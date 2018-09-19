
package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import factory.client.Instances;
import icontrols.client.IManageControlsClient;
import model.BaiTap;
import model.SinhVien;

public class ClientUI extends JFrame {

	private JButton				btnBaiTap;
	private JButton				btnEmptyLabel;
	private JButton				btnEmptyLabelSinhVien;
	private JButton				btnLuuBaiTap;
	private JButton				btnLuuSinhVien;
	private JButton				btnMainMenu;
	private JButton				btnMainMenu_1;
	private JButton				btnSinhVien;
	private JButton				btnThoat;
	private JButton				btnTimBaiTap;
	private JButton				btnTimKiemSinhVien;
	private JButton				btnXoaBaiTap;
	private JButton				btnXoaSinhVien;
	private CardLayout			cardLayout;
	private Container			con;
	private DefaultTableModel	dtmBaiTap;
	private DefaultTableModel	dtmSinhVien;
	private JTable				tblBaiTap;
	private JTable				tblSinhVien;
	private JTextField			txtDangLam;
	private JTextPane			txtDeBai;
	private JTextField			txtDoKho;
	private JTextField			txtLop;
	private JTextField			txtMaSoBaiTap;
	private JTextField			txtMssv;
	private JTextField			txtTenBai;
	private JTextField			txtTenSinhVien;

	IManageControlsClient		controlsClient;
	private JTextField			txtDaHoanThanh;

	/**
	 * @throws HeadlessException
	 */
	public ClientUI(String title) throws HeadlessException {

		super(title);
		addControils();
		addEvents();
		connectServer();

	}

	private void connectServer() {

		// TODO Auto-generated method stub
		controlsClient = Instances.getControlsClient();
	}

	public void showWindow() {

		pack();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected void xuLyQuanLyBaiTap() {

		// TODO Auto-generated method stub
		showCard(con, "CardBaiTap");
		hienThiTatCaBaiTap();

	}

	private void hienThiTatCaBaiTap() {

		dtmBaiTap.setRowCount(0);
		ArrayList<BaiTap> baiTaps = controlsClient.layTatCaBaiTap();
		for(BaiTap bt : baiTaps) {
			Object[] obj = { bt.getMsbt(), bt.getTenBt(), bt.getDebai(), bt.getDoKho(), bt.getDaHoanThanh() };
			dtmBaiTap.addRow(obj);
		}

	}

	protected void xuLyQuanLySinhVien() {

		// TODO Auto-generated method stub
		showCard(con, "CardSinhVien");

		hienThiToanBoSinhVien();

	}

	private void hienThiToanBoSinhVien() {

		dtmSinhVien.setRowCount(0);
		ArrayList<SinhVien> sinhViens = controlsClient.layTatCaSinhVien();
		for(SinhVien sv : sinhViens) {
			Object[] obj = { sv.getMssv(), sv.getHoTen(), sv.getLop(), sv.getDangLam() };
			dtmSinhVien.addRow(obj);
		}

	}

	protected void xuLyThoat() {

		int ret = JOptionPane.showConfirmDialog(null, "Thoát?", "Đúng sai - yes no", JOptionPane.YES_NO_OPTION);
		if(ret == JOptionPane.YES_OPTION) {
			Instances.cleanUp();
			System.exit(0);
		}

	}

	protected void xuLyTroVeMainMenu() {

		// TODO Auto-generated method stub
		showCard(con, "CardMain");

	}

	protected void xuLyXoaTextBaiTap() {

		// TODO Auto-generated method stub
		txtMaSoBaiTap.setText("");
		txtTenBai.setText("");
		txtDeBai.setText("");
		txtDoKho.setText("");
		txtMaSoBaiTap.requestFocus();

	}

	protected void xuLyXoaTextSinhVien() {

		// TODO Auto-generated method stub
		txtMssv.setText("");
		txtTenSinhVien.setText("");
		txtLop.setText("");
		txtDangLam.setText("");
		txtMssv.requestFocus();

	}

	private void addControils() {

		con = getContentPane();
		cardLayout = new CardLayout();
		con.setLayout(cardLayout);

		JPanel pn1 = new JPanel();
		con.add(pn1, "CardMain");
		pn1.setLayout(new BorderLayout(0, 0));

		JPanel pnTitle = new JPanel();
		pn1.add(pnTitle, BorderLayout.NORTH);
		pnTitle.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0)), "Mu\u1ED1n G\u00EC?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JLabel lblTitle = new JLabel("Muốn Gì?");
		lblTitle.setForeground(Color.RED);

		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		pnTitle.add(lblTitle);

		JPanel pnCenter = new JPanel();
		pn1.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new GridLayout(0, 2, 0, 0));

		btnSinhVien = new JButton("Xem Sinh Viên");
		pnCenter.add(btnSinhVien);

		btnBaiTap = new JButton("Xem Bài Tập");
		pnCenter.add(btnBaiTap);

		JPanel pnExit = new JPanel();
		pn1.add(pnExit, BorderLayout.SOUTH);
		pnExit.setLayout(new BorderLayout(0, 0));

		btnThoat = new JButton("Thoát");
		pnExit.add(btnThoat);

		JPanel pnSinhVien = new JPanel();
		con.add(pnSinhVien, "CardSinhVien");
		pnSinhVien.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		pnSinhVien.add(panel, BorderLayout.NORTH);

		JLabel lblSinhVin = new JLabel("Sinh Viên");
		panel.add(lblSinhVin);

		JPanel panel_5 = new JPanel();
		pnSinhVien.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setOneTouchExpandable(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_5.add(splitPane, BorderLayout.CENTER);

		JPanel panel_6 = new JPanel();
		splitPane.setLeftComponent(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane);

		dtmSinhVien = new DefaultTableModel();

		dtmSinhVien.addColumn("Mssv");
		dtmSinhVien.addColumn("Họ Tên");
		dtmSinhVien.addColumn("Lớp");
		dtmSinhVien.addColumn("Đang Làm");

		tblSinhVien = new JTable(dtmSinhVien) {

			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		scrollPane.setViewportView(tblSinhVien);

		JPanel panel_7 = new JPanel();
		splitPane.setRightComponent(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setLayout(new FlowLayout());

		JLabel lblMssv = new JLabel("Mã Số Sinh Viên:");
		lblMssv.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_8.add(lblMssv);

		txtMssv = new JTextField(20);
		panel_8.add(txtMssv);
		txtMssv.setColumns(10);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new FlowLayout());

		JLabel lblHoTen = new JLabel("Họ Tên:");
		lblHoTen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoTen.setPreferredSize(lblMssv.getPreferredSize());
		panel_9.add(lblHoTen);

		txtTenSinhVien = new JTextField(20);
		txtTenSinhVien.setColumns(10);
		panel_9.add(txtTenSinhVien);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);
		panel_10.setLayout(new FlowLayout());

		JLabel lblLop = new JLabel("Lớp:");
		lblLop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLop.setPreferredSize(lblMssv.getPreferredSize());
		panel_10.add(lblLop);

		txtLop = new JTextField(20);
		txtLop.setColumns(10);
		panel_10.add(txtLop);

		JPanel panel_17 = new JPanel();
		panel_7.add(panel_17);
		panel_17.setLayout(new FlowLayout());

		JLabel lblangLm = new JLabel("Đang Làm:");
		lblangLm.setPreferredSize(new Dimension(94, 16));
		lblangLm.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_17.add(lblangLm);

		txtDangLam = new JTextField(10);
		panel_17.add(txtDangLam);

		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);
		panel_11.setLayout(new FlowLayout());

		btnLuuSinhVien = new JButton("Lưu");
		panel_11.add(btnLuuSinhVien);

		btnEmptyLabelSinhVien = new JButton("Trống");
		panel_11.add(btnEmptyLabelSinhVien);

		btnXoaSinhVien = new JButton("Xóa");
		panel_11.add(btnXoaSinhVien);

		btnTimKiemSinhVien = new JButton("Tìm");
		panel_11.add(btnTimKiemSinhVien);

		btnMainMenu = new JButton("Main Menu");
		panel_11.add(btnMainMenu);

		JPanel pnBaiTap = new JPanel();
		con.add(pnBaiTap, "CardBaiTap");
		pnBaiTap.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		pnBaiTap.add(panel_2, BorderLayout.NORTH);

		JLabel lblBiTp = new JLabel("Bài Tập");
		panel_2.add(lblBiTp);

		JPanel panel_3 = new JPanel();
		pnBaiTap.add(panel_3, BorderLayout.SOUTH);

		btnLuuBaiTap = new JButton("Lưu");
		panel_3.add(btnLuuBaiTap);

		btnEmptyLabel = new JButton("Làm Sạch");
		panel_3.add(btnEmptyLabel);

		btnXoaBaiTap = new JButton("Xóa");
		panel_3.add(btnXoaBaiTap);

		btnTimBaiTap = new JButton("Tìm theo Mã");
		panel_3.add(btnTimBaiTap);

		btnMainMenu_1 = new JButton("Main Menu");
		panel_3.add(btnMainMenu_1);

		JPanel panel_4 = new JPanel();
		pnBaiTap.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setContinuousLayout(true);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setOneTouchExpandable(true);
		panel_4.add(splitPane_1, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		splitPane_1.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);

		dtmBaiTap = new DefaultTableModel();

		dtmBaiTap.addColumn("MSBT");
		dtmBaiTap.addColumn("Tên Bài");
		dtmBaiTap.addColumn("Đề Bài");
		dtmBaiTap.addColumn("Độ Khó");
		dtmBaiTap.addColumn("Đã Hoàn Thành");

		tblBaiTap = new JTable(dtmBaiTap) {

			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		scrollPane_1.setViewportView(tblBaiTap);

		JPanel panel_12 = new JPanel();
		splitPane_1.setRightComponent(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));

		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13);

		JLabel lblMaSoBaiTap = new JLabel("Mã Số Bài Tập:");
		lblMaSoBaiTap.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_13.add(lblMaSoBaiTap);

		txtMaSoBaiTap = new JTextField();
		panel_13.add(txtMaSoBaiTap);
		txtMaSoBaiTap.setColumns(10);

		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14);

		JLabel lblTenBai = new JLabel("Tên Bài:");
		lblTenBai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenBai.setPreferredSize(lblMaSoBaiTap.getPreferredSize());
		panel_14.add(lblTenBai);

		txtTenBai = new JTextField();
		txtTenBai.setColumns(10);
		panel_14.add(txtTenBai);

		JPanel panel_16 = new JPanel();
		panel_12.add(panel_16);

		JLabel lblDeBai = new JLabel("Đề Bài:");
		lblDeBai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeBai.setPreferredSize(lblMaSoBaiTap.getPreferredSize());
		panel_16.add(lblDeBai);

		JPanel panel_18 = new JPanel();
		panel_16.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_18.add(scrollPane_2);

		txtDeBai = new JTextPane();
		scrollPane_2.setViewportView(txtDeBai);
		txtDeBai.setPreferredSize(new Dimension((int)txtMaSoBaiTap.getPreferredSize().getWidth(), 50));

		JPanel panel_15 = new JPanel();
		panel_12.add(panel_15);

		JLabel lblDoKho = new JLabel("Độ Khó:");
		lblDoKho.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDoKho.setPreferredSize(lblMaSoBaiTap.getPreferredSize());
		panel_15.add(lblDoKho);

		txtDoKho = new JTextField();
		txtDoKho.setColumns(10);
		panel_15.add(txtDoKho);

		JPanel panel_19 = new JPanel();
		panel_12.add(panel_19);

		JLabel lblDaHoanThanh = new JLabel("Đã Xong:");
		lblDaHoanThanh.setPreferredSize(new Dimension(83, 16));
		lblDaHoanThanh.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_19.add(lblDaHoanThanh);

		txtDaHoanThanh = new JTextField();
		txtDaHoanThanh.setColumns(10);
		panel_19.add(txtDaHoanThanh);

	}

	private void addEvents() {

		// TODO Auto-generated method stub
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {

				xuLyThoat();
			}
		});

		btnThoat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyThoat();
			}
		});
		btnSinhVien.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyQuanLySinhVien();
			}
		});

		btnBaiTap.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyQuanLyBaiTap();
			}
		});
		btnMainMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyTroVeMainMenu();
			}
		});
		btnMainMenu_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyTroVeMainMenu();
			}
		});
		btnEmptyLabel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyXoaTextBaiTap();
			}
		});
		btnEmptyLabelSinhVien.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyXoaTextSinhVien();
			}
		});
		tblSinhVien.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				xuLyChonSinhVienTrongBang();
			}
		});
		tblSinhVien.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				xuLyChonSinhVienTrongBang();
			}

			@Override
			public void keyReleased(KeyEvent e) {

				xuLyChonSinhVienTrongBang();
			}
		});

		tblBaiTap.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				xuLyChonBaiTapTrongBang();
			}
		});
		tblBaiTap.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				xuLyChonBaiTapTrongBang();
			}

			@Override
			public void keyReleased(KeyEvent e) {

				xuLyChonBaiTapTrongBang();
			}
		});
		btnLuuBaiTap.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyLuuBaiTap();
			}
		});
		btnXoaBaiTap.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyXoaBaiTap();
			}
		});
		btnTimBaiTap.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyTimKiemBaiTap();
			}
		});

		btnLuuSinhVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				xuLyLuuSinhVien();

			}
		});
		btnTimKiemSinhVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				xuLyTimKiemSinhVien();

			}
		});

		btnXoaSinhVien.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				xuLyXoaSinhVien();
			}
		});

	}

	protected void xuLyXoaSinhVien() {

		String mssv = txtMssv.getText();
		if(mssv == null || mssv.isEmpty()) { return; }

		boolean b;
		try {
			b = controlsClient.xoaSinhVien(mssv);
			if(b) {
				JOptionPane.showMessageDialog(null, "Xóa Sinh Viên thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "Xóa Sinh Viên thất bại!");
			}
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hienThiToanBoSinhVien();
	}

	protected void xuLyLuuSinhVien() {

		String mssv = txtMssv.getText();
		if(mssv == null || mssv.isEmpty()) { return; }

		String tenSv = txtTenSinhVien.getText();
		String lop = txtLop.getText();
		String dangLam = txtDangLam.getText();

		SinhVien sv = new SinhVien(mssv, tenSv, lop, dangLam);

		if(controlsClient.timKiemSinhVien(mssv).isEmpty()) {
			xuLyThemMoiSinhVien(sv);
		} else {
			xuLyChinhSuaSinhVien(sv);
		}
		hienThiToanBoSinhVien();

	}

	private void xuLyThemMoiSinhVien(SinhVien sv) {

		// TODO Auto-generated method stub
		boolean b = controlsClient.themMoiSinhVien(sv);
		if(b) {
			JOptionPane.showMessageDialog(null, "Thêm mới sv thành công!");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm mới sv thất bại!");
		}

	}

	private void xuLyChinhSuaSinhVien(SinhVien sv) {

		// TODO Auto-generated method stub
		boolean b = controlsClient.suaSinhVien(sv);
		if(b) {
			JOptionPane.showMessageDialog(null, "Chỉnh sửa sv thành công!");
		} else {
			JOptionPane.showMessageDialog(null, "Chỉnh sửa sv thất bại!");
		}
	}

	protected void xuLyTimKiemSinhVien() {

		String mssv = txtMssv.getText();
		if(mssv == null || mssv.isEmpty()) { return; }

		ArrayList<SinhVien> sinhViens = controlsClient.timKiemSinhVien(mssv);

		dtmSinhVien.setRowCount(0);

		for(SinhVien sv : sinhViens) {
			Object[] obj = { sv.getMssv(), sv.getHoTen(), sv.getLop(), sv.getDangLam() };
			dtmSinhVien.addRow(obj);
		}
	}

	protected void xuLyTimKiemBaiTap() {

		String msbt = txtMaSoBaiTap.getText();
		if(msbt == null || msbt.isEmpty()) { return; }

		ArrayList<BaiTap> baiTaps = controlsClient.timKiemBaiTap(msbt);

		dtmBaiTap.setRowCount(0);

		for(BaiTap bt : baiTaps) {
			Object[] obj = { bt.getMsbt(), bt.getTenBt(), bt.getDebai(), bt.getDoKho(), bt.getDaHoanThanh() };
			dtmBaiTap.addRow(obj);
		}

	}

	protected void xuLyXoaBaiTap() {

		String msbt = txtMaSoBaiTap.getText();
		if(msbt == null || msbt.isEmpty()) { return; }

		boolean b;
		try {
			b = controlsClient.xoaBaiTap(msbt);
			if(b) {
				JOptionPane.showMessageDialog(null, "Xóa Bài Tập thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "Xóa Bài Tập thất bại!");
			}
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hienThiTatCaBaiTap();

	}

	protected void xuLyLuuBaiTap() {

		String msbt = txtMaSoBaiTap.getText();
		if(msbt == null || msbt.isEmpty()) { return; }
		String tenBai = txtTenBai.getText();
		String DeBai = txtDeBai.getText();
		String doKho = txtDoKho.getText();
		String daHoanThanh = txtDaHoanThanh.getText();

		BaiTap baiTap = new BaiTap(msbt, tenBai, DeBai, doKho, daHoanThanh);
		if(controlsClient.timKiemBaiTap(msbt).isEmpty()) {
			xuLyThemMoiBaiTap(baiTap);
		} else {
			xuLyChinhSuaBaiTap(baiTap);
		}
		hienThiTatCaBaiTap();
	}

	private void xuLyChinhSuaBaiTap(BaiTap baiTap) {

		boolean b = controlsClient.suaBaiTap(baiTap);

		if(b) {
			JOptionPane.showMessageDialog(null, "Update thành công!");
		} else {
			JOptionPane.showMessageDialog(null, "Update thất bại!");
		}

	}

	private void xuLyThemMoiBaiTap(BaiTap baiTap) {

		boolean b = controlsClient.themMoiBaiTap(baiTap);

		if(b) {
			JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm mới thất bại!");
		}

	}

	protected void xuLyChonBaiTapTrongBang() {

		int row = tblBaiTap.getSelectedRow();
		if(row < 0) { return; }

		String msbt = (String)tblBaiTap.getValueAt(row, 0);
		String title = (String)tblBaiTap.getValueAt(row, 1);
		String question = (String)tblBaiTap.getValueAt(row, 2);
		String level = (String)tblBaiTap.getValueAt(row, 3);
		String completed = (String)tblBaiTap.getValueAt(row, 4);

		txtMaSoBaiTap.setText(msbt);
		txtTenBai.setText(title);
		txtDeBai.setText(question);
		txtDoKho.setText(level);
		txtDaHoanThanh.setText(completed);
		txtMaSoBaiTap.requestFocus();

	}

	protected void xuLyChonSinhVienTrongBang() {

		int row = tblSinhVien.getSelectedRow();
		if(row < 0) { return; }

		String mssv = (String)tblSinhVien.getValueAt(row, 0);
		String name = (String)tblSinhVien.getValueAt(row, 1);
		String lop = (String)tblSinhVien.getValueAt(row, 2);
		String dangLam = (String)tblSinhVien.getValueAt(row, 3);

		txtMssv.setText(mssv);
		txtTenSinhVien.setText(name);
		txtLop.setText(lop);
		txtDangLam.setText(dangLam);
		txtMssv.requestFocus();

	}

	private void showCard(Container con, String cardName) {

		cardLayout.show(con, cardName);
	}

}

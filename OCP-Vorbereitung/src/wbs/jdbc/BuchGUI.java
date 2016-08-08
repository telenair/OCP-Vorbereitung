package wbs.jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuchGUI {

	private JFrame frmBcher;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JInternalFrame iFSuchen;
	private JInternalFrame iFEintragen;
	private JInternalFrame iFLoeschen;
	private JInternalFrame iFListSuchen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuchGUI window = new BuchGUI();
					window.frmBcher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuchGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBcher = new JFrame();
		frmBcher.setTitle("Bücher");
		frmBcher.setBounds(100, 100, 631, 464);
		frmBcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmBcher.setJMenuBar(menuBar);
		
		JMenu mnHauptMenu = new JMenu("Menu");
		menuBar.add(mnHauptMenu);
		
		JMenuItem mntmBuchSuchen = new JMenuItem("Buch suchen");
		mntmBuchSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iFListSuchen.setVisible(false);
				iFLoeschen.setVisible(false);
				iFEintragen.setVisible(false);
				iFSuchen.setVisible(true);
			}
		});
		mnHauptMenu.add(mntmBuchSuchen);
		
		JMenuItem mntmBuchEintragen = new JMenuItem("Buch eintragen");
		mntmBuchEintragen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFListSuchen.setVisible(false);
				iFLoeschen.setVisible(false);
				iFEintragen.setVisible(true);
				iFSuchen.setVisible(false);
			}
		});
		mnHauptMenu.add(mntmBuchEintragen);
		
		JMenuItem mntmBuchLschen = new JMenuItem("Buch löschen");
		mntmBuchLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFListSuchen.setVisible(false);
				iFLoeschen.setVisible(true);
				iFEintragen.setVisible(false);
				iFSuchen.setVisible(false);
			}
		});
		mnHauptMenu.add(mntmBuchLschen);
		
		JSeparator separator = new JSeparator();
		mnHauptMenu.add(separator);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnHauptMenu.add(mntmBeenden);
		frmBcher.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 615, 405);
		frmBcher.getContentPane().add(layeredPane);
		
		iFSuchen = new JInternalFrame("Buch suchen");
		iFSuchen.setBounds(0, 0, 615, 405);
		layeredPane.add(iFSuchen);
		iFSuchen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISB:");
		lblNewLabel.setBounds(30, 40, 60, 15);
		iFSuchen.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor:");
		lblNewLabel_1.setBounds(30, 80, 60, 15);
		iFSuchen.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Titel");
		lblNewLabel_2.setBounds(30, 120, 60, 15);
		iFSuchen.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Preis:");
		lblNewLabel_3.setBounds(30, 160, 60, 15);
		iFSuchen.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(75, 37, 200, 20);
		iFSuchen.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 77, 200, 20);
		iFSuchen.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(75, 117, 440, 20);
		iFSuchen.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setBounds(75, 157, 60, 20);
		iFSuchen.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("€");
		label.setBounds(138, 160, 46, 14);
		iFSuchen.getContentPane().add(label);
		
		JButton btnSuchen = new JButton("suchen");
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFListSuchen.setVisible(true);
				iFLoeschen.setVisible(false);
				iFEintragen.setVisible(false);
				iFSuchen.setVisible(false);
			}
		});
		btnSuchen.setBounds(426, 322, 120, 20);
		iFSuchen.getContentPane().add(btnSuchen);
		
		iFEintragen = new JInternalFrame("Buch eintragen");
		layeredPane.setLayer(iFEintragen, 1);
		iFEintragen.setBounds(0, 0, 615, 405);
		layeredPane.add(iFEintragen);
		iFEintragen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("ISBN:");
		lblNewLabel_4.setBounds(30, 40, 60, 15);
		iFEintragen.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Autor:");
		lblNewLabel_5.setBounds(30, 80, 60, 15);
		iFEintragen.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Titel:");
		lblNewLabel_6.setBounds(30, 120, 60, 15);
		iFEintragen.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Preis:");
		lblNewLabel_7.setBounds(30, 160, 60, 15);
		iFEintragen.getContentPane().add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(75, 37, 200, 20);
		iFEintragen.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(75, 77, 200, 20);
		iFEintragen.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(75, 117, 440, 20);
		iFEintragen.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setBounds(75, 157, 60, 20);
		iFEintragen.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("€");
		lblNewLabel_8.setBounds(138, 160, 46, 14);
		iFEintragen.getContentPane().add(lblNewLabel_8);
		
		JButton btnSpeichern = new JButton("speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFListSuchen.setVisible(false);
				iFLoeschen.setVisible(false);
				iFEintragen.setVisible(false);
				iFSuchen.setVisible(false);
			}
		});
		btnSpeichern.setBounds(426, 322, 120, 20);
		iFEintragen.getContentPane().add(btnSpeichern);
		
		iFLoeschen = new JInternalFrame("Buch löschen");
		layeredPane.setLayer(iFLoeschen, 2);
		iFLoeschen.setBounds(0, 0, 615, 405);
		layeredPane.add(iFLoeschen);
		iFLoeschen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("ISBN:");
		lblNewLabel_9.setBounds(30, 40, 60, 15);
		iFLoeschen.getContentPane().add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(75, 37, 200, 20);
		iFLoeschen.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnLoeschen = new JButton("löschen");
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFListSuchen.setVisible(false);
				iFLoeschen.setVisible(false);
				iFEintragen.setVisible(false);
				iFSuchen.setVisible(false);
			}
		});
		btnLoeschen.setBounds(426, 322, 120, 20);
		iFLoeschen.getContentPane().add(btnLoeschen);
		
		iFListSuchen = new JInternalFrame("Suchergenis");
		layeredPane.setLayer(iFListSuchen, 3);
		iFListSuchen.setBounds(0, 0, 615, 405);
		layeredPane.add(iFListSuchen);
		iFListSuchen.getContentPane().setLayout(null);
		
		JList suchList = new JList();
		suchList.setBounds(0, 0, 599, 334);
		iFListSuchen.getContentPane().add(suchList);
		
		JButton btnSchliessen = new JButton("schliessen");
		btnSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFListSuchen.setVisible(false);
				iFLoeschen.setVisible(false);
				iFEintragen.setVisible(false);
				iFSuchen.setVisible(false);
			}
		});
		btnSchliessen.setBounds(426, 345, 120, 20);
		iFListSuchen.getContentPane().add(btnSchliessen);
		iFListSuchen.setVisible(false);
		iFLoeschen.setVisible(false);
		iFEintragen.setVisible(false);
		iFSuchen.setVisible(false);
	}
}

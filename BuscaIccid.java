package com.iccid;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

class BuscaIccid {
	public static void main(String args[]) {
		FormDetails formObject = new FormDetails();

	}
}

class FormDetails extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// Components of the Form
	private Container c;
	private JLabel regional_Name_lbl;
	private JTextField regional_Name_txf;
	private JLabel quantidade_lbl;
	private JTextField quantidade_txf;
	private JTextArea tadd;
	private JButton buscar_btn;
	private JButton copiar_btn;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel panel;

	private ArrayList<String> icValue = new ArrayList<>();
	private ArrayList<String> ibValue = new ArrayList<>();

	public FormDetails() {

		setTitle("Busca Iccid");
		setBounds(200, 80, 700, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		regional_Name_lbl = new JLabel("Regional:");
		regional_Name_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
		regional_Name_lbl.setSize(100, 20);
		regional_Name_lbl.setLocation(40, 100);
		c.add(regional_Name_lbl);

		regional_Name_txf = new JTextField();
		regional_Name_txf.setFont(new Font("Arial", Font.PLAIN, 15));
		regional_Name_txf.setSize(450, 30);
		regional_Name_txf.setLocation(200, 100);
		c.add(regional_Name_txf);

		((AbstractDocument) regional_Name_txf.getDocument()).setDocumentFilter(new DocumentFilter() {
			Pattern regEx = Pattern.compile("\\d*");

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				Matcher matcher = regEx.matcher(text);
				if (!matcher.matches()) {
					return;
				}
				super.replace(fb, offset, length, text, attrs);
			}
		});

		quantidade_lbl = new JLabel("Quantidade:");
		quantidade_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
		quantidade_lbl.setSize(170, 20);
		quantidade_lbl.setLocation(40, 150);
		c.add(quantidade_lbl);

		quantidade_txf = new JTextField();
		quantidade_txf.setFont(new Font("Arial", Font.PLAIN, 15));
		quantidade_txf.setSize(450, 30);
		quantidade_txf.setLocation(200, 150);
		c.add(quantidade_txf);

		((AbstractDocument) quantidade_txf.getDocument()).setDocumentFilter(new DocumentFilter() {
			Pattern regEx = Pattern.compile("\\d*");

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				Matcher matcher = regEx.matcher(text);
				if (!matcher.matches()) {
					return;
				}
				super.replace(fb, offset, length, text, attrs);
			}
		});

		buscar_btn = new JButton("Buscar");
		buscar_btn.setFont(new Font("Arial", Font.PLAIN, 15));
		buscar_btn.setSize(100, 20);
		buscar_btn.setLocation(550, 200);
		buscar_btn.addActionListener(this);
		c.add(buscar_btn);

		table = new JTable();
		Object[] columnsName = new Object[2];
		columnsName[0] = "ICCID";
		columnsName[1] = "IMSI";
		model = new DefaultTableModel();
		panel = new JPanel();
		panel.setSize(600, 200);
		panel.setLocation(40, 240);
		model.setColumnIdentifiers(columnsName);

		table.setModel(model);
		panel.setLayout(new BorderLayout());
		scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		c.add(panel);

		copiar_btn = new JButton("Copiar");
		copiar_btn.setFont(new Font("Arial", Font.PLAIN, 15));
		copiar_btn.setSize(100, 20);
		copiar_btn.setLocation(550, 480);
		copiar_btn.addActionListener(this);
		c.add(copiar_btn);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		int rowCount = 0;
		if (ae.getSource() == copiar_btn) {
			StringSelection stringSelection = new StringSelection(tadd.getText());
			Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
			clpbrd.setContents(stringSelection, null);
		}
		if (ae.getSource() == buscar_btn) {
			try {
				BuscarIccidDBConnection BuscarIccidDBConnectionobj = new BuscarIccidDBConnection();
				ResultSet dbValues = BuscarIccidDBConnectionobj.getBuscalccid(
						Integer.parseInt(regional_Name_txf.getText()), Integer.parseInt(quantidade_txf.getText()));

				ResultSetMetaData rsmd = dbValues.getMetaData();
                    
				for (int j = 1; j <= Integer.parseInt(quantidade_txf.getText()); j++) {
					outerloop: while (dbValues.next()) {
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							if (i > 1)
								System.out.print(",  ");
							String iccidDBValue = dbValues.getString("ICCID");
							String imsiDBValue = dbValues.getString("IMSI");
							icValue.add(iccidDBValue);
							ibValue.add(imsiDBValue);
							System.out.print(iccidDBValue+" "+imsiDBValue);

						}
						System.out.println("\n");
						break outerloop;
					}
				

				}

				Object[] rowData = new Object[2];

				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					rowData[0] = icValue.get(i);
					rowData[1] = ibValue.get(i);
					model.addRow(rowData);
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

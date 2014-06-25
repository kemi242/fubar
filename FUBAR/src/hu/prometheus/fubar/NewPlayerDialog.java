package hu.prometheus.fubar;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NewPlayerDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3552997187622774468L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JLabel lblPicture;
	private JLabel lblPadlo;
	private JLabel lblNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewPlayerDialog dialog = new NewPlayerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewPlayerDialog() {
		setModal(true);
		setBounds(100, 100, 480, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(30, 30, 350, 29);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_textField_actionPerformed(arg0);
			}
		});
		contentPanel.setLayout(null);
		
		lblNum = new JLabel("8");
		lblNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNum.setForeground(Color.WHITE);
		lblNum.setBounds(10, 33, 10, 23);
		contentPanel.add(lblNum);
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		contentPanel.add(textField);
		textField.setColumns(10);
		
		lblPicture = new JLabel("");
		lblPicture.setBounds(390, 11, 64, 48);
		contentPanel.add(lblPicture);
		
		lblPadlo = new JLabel("");
		lblPadlo.setBounds(0, 0, 480, 800);
		lblPadlo.setIcon(new ImageIcon(NewPlayerDialog.class.getResource("/hu/prometheus/fubar/res/Padlo.png")));
		contentPanel.add(lblPadlo);
		
		lblNum.setText(Integer.toString(DataBase.players.size() + 1));
		
	}
	
	private String makePicture() {
		/*CameraDialog cd = new CameraDialog(name);
		cd.setVisible(true);
		
		File f = new File(cd.fileName);
		String fileName = f.getCanonicalPath();
		return fileName;*/
		
		FileDialog fd = new FileDialog(this);
		fd.setVisible(true);
		
		return fd.getDirectory() + fd.getFile();
	}
	
	protected void do_textField_actionPerformed(ActionEvent arg0) {
		String name = textField.getText();
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			
			if (s.executeQuery("select kepfajl from jatekosok where nev = '" + name + "';").getObject(1) == null) {
				
				File f = new File(makePicture());
				String fileName = f.getCanonicalPath();
				s.executeUpdate("insert into jatekosok values ('" + name + "', '" + fileName + "');");
				c.close();
			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			
			String fileName = s.executeQuery("select kepfajl from jatekosok where nev = '" + name + "';").getString(1);
			c.close();
			DataBase.players.add(new Player(name, fileName));
			Image img = ImageIO.read(new File(fileName)).getScaledInstance(64, 48, Image.SCALE_SMOOTH);
			
			lblPicture.setIcon(new ImageIcon(img));
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}

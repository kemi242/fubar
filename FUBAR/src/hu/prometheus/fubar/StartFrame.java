package hu.prometheus.fubar;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;











import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class StartFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3174628689725863978L;
	private JPanel contentPane;
	private JLabel label1;
	private JTextField textField1;
	private JLabel lblPicture1;
	private JLabel label2;
	private JTextField textField2;
	private JLabel lblPicture2;
	private JLabel label3;
	private JTextField textField3;
	private JLabel lblPicture3;
	private JLabel label4;
	private JTextField textField4;
	private JLabel lblPicture4;
	private JLabel label5;
	private JTextField textField5;
	private JLabel lblPicture5;
	private JLabel label6;
	private JTextField textField6;
	private JLabel lblPicture6;
	private JLabel label7;
	private JTextField textField7;
	private JLabel lblPicture7;
	private JLabel label8;
	private JTextField textField8;
	private JLabel lblPicture8;
	private JLabel lblKikJatszanak;
	private JLabel lblMehet;
	private JLabel lblBar;
	
	//private LinkedList<Player> players;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartFrame.class.getResource("/hu/prometheus/fubar/res/Ikon kicsi.png")));
		setResizable(false);
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblKikJatszanak = new JLabel("KIK J\u00C1TSZANAK?");
		lblKikJatszanak.setHorizontalAlignment(SwingConstants.CENTER);
		lblKikJatszanak.setForeground(Color.WHITE);
		lblKikJatszanak.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblKikJatszanak.setBounds(10, 11, 454, 23);
		contentPane.add(lblKikJatszanak);
		
		label1 = new JLabel("1.");
		label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label1.setForeground(Color.WHITE);
		label1.setBounds(10, 73, 14, 20);
		contentPane.add(label1);
		
		textField1 = new JTextField();
		textField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_textField1_actionPerformed(arg0);
			}
		});
		textField1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField1.setBounds(34, 70, 356, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		lblPicture1 = new JLabel("");
		lblPicture1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_lblPicture1_mouseClicked(arg0);
			}
		});
		lblPicture1.setIcon(null);
		lblPicture1.setBounds(400, 45, 64, 48);
		contentPane.add(lblPicture1);
		
		label2 = new JLabel("2.");
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label2.setBounds(10, 132, 14, 20);
		contentPane.add(label2);
		
		textField2 = new JTextField();
		textField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_textField2_actionPerformed(arg0);
			}
		});
		textField2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField2.setColumns(10);
		textField2.setBounds(34, 129, 356, 26);
		contentPane.add(textField2);
		
		lblPicture2 = new JLabel("");
		lblPicture2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_lblPicture2_mouseClicked(arg0);
			}
		});
		lblPicture2.setBounds(400, 104, 64, 48);
		contentPane.add(lblPicture2);
		
		label3 = new JLabel("3.");
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label3.setBounds(10, 191, 14, 20);
		contentPane.add(label3);
		
		textField3 = new JTextField();
		textField3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_textField3_actionPerformed(e);
			}
		});
		textField3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField3.setColumns(10);
		textField3.setBounds(34, 188, 356, 26);
		contentPane.add(textField3);
		
		lblPicture3 = new JLabel("");
		lblPicture3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPicture3_mouseClicked(e);
			}
		});
		lblPicture3.setBounds(400, 163, 64, 48);
		contentPane.add(lblPicture3);
		
		label4 = new JLabel("4.");
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label4.setBounds(10, 250, 14, 20);
		contentPane.add(label4);
		
		textField4 = new JTextField();
		textField4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_textField4_actionPerformed(e);
			}
		});
		textField4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField4.setColumns(10);
		textField4.setBounds(34, 247, 356, 26);
		contentPane.add(textField4);
		
		lblPicture4 = new JLabel("");
		lblPicture4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPicture4_mouseClicked(e);
			}
		});
		lblPicture4.setBounds(400, 222, 64, 48);
		contentPane.add(lblPicture4);
		
		label5 = new JLabel("5.");
		label5.setForeground(Color.WHITE);
		label5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label5.setBounds(10, 309, 14, 20);
		contentPane.add(label5);
		
		textField5 = new JTextField();
		textField5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_textField5_actionPerformed(e);
			}
		});
		textField5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField5.setColumns(10);
		textField5.setBounds(34, 306, 356, 26);
		contentPane.add(textField5);
		
		lblPicture5 = new JLabel("");
		lblPicture5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPicture5_mouseClicked(e);
			}
		});
		lblPicture5.setBounds(400, 281, 64, 48);
		contentPane.add(lblPicture5);
		
		label6 = new JLabel("6.");
		label6.setForeground(Color.WHITE);
		label6.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label6.setBounds(10, 368, 14, 20);
		contentPane.add(label6);
		
		textField6 = new JTextField();
		textField6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_textField6_actionPerformed(e);
			}
		});
		textField6.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField6.setColumns(10);
		textField6.setBounds(34, 365, 356, 26);
		contentPane.add(textField6);
		
		lblPicture6 = new JLabel("");
		lblPicture6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPicture6_mouseClicked(e);
			}
		});
		lblPicture6.setBounds(400, 340, 64, 48);
		contentPane.add(lblPicture6);
		
		label7 = new JLabel("7.");
		label7.setForeground(Color.WHITE);
		label7.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label7.setBounds(10, 427, 14, 20);
		contentPane.add(label7);
		
		textField7 = new JTextField();
		textField7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_textField7_actionPerformed(e);
			}
		});
		textField7.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField7.setColumns(10);
		textField7.setBounds(34, 424, 356, 26);
		contentPane.add(textField7);
		
		lblPicture7 = new JLabel("");
		lblPicture7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPicture7_mouseClicked(e);
			}
		});
		lblPicture7.setBounds(400, 399, 64, 48);
		contentPane.add(lblPicture7);
		
		label8 = new JLabel("8.");
		label8.setForeground(Color.WHITE);
		label8.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label8.setBounds(10, 483, 14, 20);
		contentPane.add(label8);
		
		textField8 = new JTextField();
		textField8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_textField8_actionPerformed(e);
			}
		});
		textField8.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField8.setColumns(10);
		textField8.setBounds(34, 480, 356, 26);
		contentPane.add(textField8);
		
		lblPicture8 = new JLabel("");
		lblPicture8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPicture8_mouseClicked(e);
			}
		});
		lblPicture8.setBounds(400, 455, 64, 48);
		contentPane.add(lblPicture8);
		
		lblMehet = new JLabel("");
		lblMehet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblMehet_mouseClicked(e);
			}
		});
		lblMehet.setIcon(new ImageIcon(StartFrame.class.getResource("/hu/prometheus/fubar/res/Mehet gomb.png")));
		lblMehet.setBounds(138, 685, 204, 76);
		contentPane.add(lblMehet);
		
		lblBar = new JLabel("");
		lblBar.setIcon(new ImageIcon(StartFrame.class.getResource("/hu/prometheus/fubar/res/Bar.jpg")));
		lblBar.setBounds(0, 0, 480, 800);
		contentPane.add(lblBar);
		
		label2.setVisible(false);
		textField2.setVisible(false);
		lblPicture2.setVisible(false);
		
		label3.setVisible(false);
		textField3.setVisible(false);
		lblPicture3.setVisible(false);
		
		label4.setVisible(false);
		textField4.setVisible(false);
		lblPicture4.setVisible(false);
		
		label5.setVisible(false);
		textField5.setVisible(false);
		lblPicture5.setVisible(false);
		
		label6.setVisible(false);
		textField6.setVisible(false);
		lblPicture6.setVisible(false);
		
		label7.setVisible(false);
		textField7.setVisible(false);
		lblPicture7.setVisible(false);
		
		label8.setVisible(false);
		textField8.setVisible(false);
		lblPicture8.setVisible(false);
		
		lblMehet.setVisible(false);

		DataBase.init();
	}
	
	String selectFileName(String name) {
		return "select kepfajl from jatekosok where nev = '" + name + "';";
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
	
	protected void do_textField1_actionPerformed(ActionEvent e) {
		String name = textField1.getText();
		Player p;
		if (!DataBase.playerExists(name)) {
			String fileName = makePicture();
			p = DataBase.insertPlayer(name, fileName);
		} else {
			p = DataBase.getPlayer(name, this);
		}
		lblPicture1.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		label2.setVisible(true);
		textField2.setVisible(true);
		lblPicture2.setVisible(true);
		textField2.requestFocus();
		
	}
	protected void do_textField2_actionPerformed(ActionEvent e) {
		String name = textField2.getText();
		Player p;
		if (!DataBase.playerExists(name)) {
			String fileName = makePicture();
			p = DataBase.insertPlayer(name, fileName);
		} else {
			p = DataBase.getPlayer(name, this);
		}
		lblPicture2.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		label3.setVisible(true);
		textField3.setVisible(true);
		lblPicture3.setVisible(true);
		textField3.requestFocus();
	}
	protected void do_textField3_actionPerformed(ActionEvent e) {
		String name = textField3.getText();
		Player p;
		if (!DataBase.playerExists(name)) {
			String fileName = makePicture();
			p = DataBase.insertPlayer(name, fileName);
		} else {
			p = DataBase.getPlayer(name, this);
		}
		lblPicture3.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		label4.setVisible(true);
		textField4.setVisible(true);
		lblPicture4.setVisible(true);
		textField4.requestFocus();
		lblMehet.setVisible(true);
	}
	protected void do_textField4_actionPerformed(ActionEvent e) {
		String name = textField4.getText();
		Player p;
		if (!DataBase.playerExists(name)) {
			String fileName = makePicture();
			p = DataBase.insertPlayer(name, fileName);
		} else {
			p = DataBase.getPlayer(name, this);
		}
		lblPicture4.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		label5.setVisible(true);
		textField5.setVisible(true);
		lblPicture5.setVisible(true);
		textField5.requestFocus();
	}
	protected void do_textField5_actionPerformed(ActionEvent e) {
		String name = textField5.getText();
		Player p;
		if (!DataBase.playerExists(name)) {
			String fileName = makePicture();
			p = DataBase.insertPlayer(name, fileName);
		} else {
			p = DataBase.getPlayer(name, this);
		}
		lblPicture5.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		label6.setVisible(true);
		textField6.setVisible(true);
		lblPicture6.setVisible(true);
		textField6.requestFocus();
	}
	protected void do_textField6_actionPerformed(ActionEvent e) {
		String name = textField6.getText();
		Player p;
		if (!DataBase.playerExists(name)) {
			String fileName = makePicture();
			p = DataBase.insertPlayer(name, fileName);
		} else {
			p = DataBase.getPlayer(name, this);
		}
		lblPicture6.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		label7.setVisible(true);
		textField7.setVisible(true);
		lblPicture7.setVisible(true);
		textField7.requestFocus();
	}
	protected void do_textField7_actionPerformed(ActionEvent e) {
		String name = textField7.getText();
		Player p;
		if (!DataBase.playerExists(name)) {
			String fileName = makePicture();
			p = DataBase.insertPlayer(name, fileName);
		} else {
			p = DataBase.getPlayer(name, this);
		}
		lblPicture7.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		label8.setVisible(true);
		textField8.setVisible(true);
		lblPicture8.setVisible(true);
		textField8.requestFocus();
	}
	protected void do_textField8_actionPerformed(ActionEvent e) {
		String name = textField8.getText();
		Player p;
		if (!DataBase.playerExists(name)) {
			String fileName = makePicture();
			p = DataBase.insertPlayer(name, fileName);
		} else {
			p = DataBase.getPlayer(name, this);
		}
		lblPicture8.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblPicture1_mouseClicked(MouseEvent arg0) {
		String name = textField1.getText();
		String newFileName = makePicture();
		Player p = DataBase.updatePlayer(name, newFileName);
		lblPicture1.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblPicture2_mouseClicked(MouseEvent arg0) {
		String name = textField2.getText();
		String newFileName = makePicture();
		Player p = DataBase.updatePlayer(name, newFileName);
		lblPicture2.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblPicture3_mouseClicked(MouseEvent e) {
		String name = textField3.getText();
		String newFileName = makePicture();
		Player p = DataBase.updatePlayer(name, newFileName);
		lblPicture3.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblPicture4_mouseClicked(MouseEvent e) {
		String name = textField4.getText();
		String newFileName = makePicture();
		Player p = DataBase.updatePlayer(name, newFileName);
		lblPicture4.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblPicture5_mouseClicked(MouseEvent e) {
		String name = textField5.getText();
		String newFileName = makePicture();
		Player p = DataBase.updatePlayer(name, newFileName);
		lblPicture5.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblPicture6_mouseClicked(MouseEvent e) {
		String name = textField6.getText();
		String newFileName = makePicture();
		Player p = DataBase.updatePlayer(name, newFileName);
		lblPicture6.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblPicture7_mouseClicked(MouseEvent e) {
		String name = textField7.getText();
		String newFileName = makePicture();
		Player p = DataBase.updatePlayer(name, newFileName);
		lblPicture7.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblPicture8_mouseClicked(MouseEvent e) {
		String name = textField8.getText();
		String newFileName = makePicture();
		Player p = DataBase.updatePlayer(name, newFileName);
		lblPicture8.setIcon(new ImageIcon(p.getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
	}
	protected void do_lblMehet_mouseClicked(MouseEvent e) {
		SoundPlayer.play(StartFrame.class.getResource("/hu/prometheus/fubar/res/Kezdes.wav"));
		
		GameFrame gf = new GameFrame();
		gf.setVisible(true);
		this.setVisible(false);
	}
}

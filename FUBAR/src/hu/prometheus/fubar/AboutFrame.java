package hu.prometheus.fubar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class AboutFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -796004906256419542L;
	private JPanel contentPane;
	private JTextArea txtrInfo;
	private JLabel lblBackground;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutFrame frame = new AboutFrame();
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
	public AboutFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutFrame.class.getResource("/hu/prometheus/fubar/res/Ikon kicsi.png")));
		setResizable(false);
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtrInfo = new JTextArea();
		txtrInfo.setTabSize(2);
		txtrInfo.setEditable(false);
		txtrInfo.setWrapStyleWord(true);
		txtrInfo.setLineWrap(true);
		txtrInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtrInfo.setText("\tEz a j\u00E1t\u00E9k a \u201Efelelsz vagy mersz\u201D, az \u00FCvegez\u00E9s \u00E9s b\u00E1rmely pi\u00E1l\u00F3s j\u00E1t\u00E9k egy k\u00E1rtyaj\u00E1t\u00E9kba gy\u00FArva. \u00DCljetek k\u00F6rbe, sorban h\u00FAzzatok k\u00E1rty\u00E1t \u00E9s k\u00F6vess\u00E9tek az utas\u00EDt\u00E1sokat!\r\n\r\n\tA j\u00E1t\u00E9k addig tart, am\u00EDg a piak\u00E9szlet. Az italt egys\u00E9gekben m\u00E9ritek. Ez lehet 1 dl s\u00F6r, egy korty bor  \u00E9s\\vagy 2 cl t\u00F6m\u00E9ny, a pia fajt\u00E1j\u00E1t szabadon ki lehet v\u00E1lasztani csak ne keverj\u00E9tek!\r\n\r\n\tMinden k\u00E1rtya, amit h\u00FAztok, egy feladatot jelent. Ez lehet iv\u00E1szat, k\u00E9rdezz-felelek vagy ak\u00E1rmi. Aki nem teljes\u00EDti, b\u00FCntet\u0151t kap (4 cl p\u00E1linka 10 m\u00E1sodpercig a sz\u00E1jban, esetleg egy ruha lev\u00E9tele).");
		txtrInfo.setBounds(10, 11, 454, 319);
		contentPane.add(txtrInfo);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(AboutFrame.class.getResource("/hu/prometheus/fubar/res/Info.png")));
		lblBackground.setBounds(0, 517, 480, 255);
		contentPane.add(lblBackground);
	}

}

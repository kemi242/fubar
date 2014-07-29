package hu.prometheus.fubar;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TippDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7755383477176479494L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblInfo;
	private JTextArea textArea;
	
	private String tipp;
	private int tipus;
	private JLabel lblEzjo;

	/*
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			TippDialog dialog = new TippDialog("", 0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public TippDialog(String tipp, int tipus) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 480, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblInfo = new JLabel("");
		lblInfo.setIcon(new ImageIcon(TippDialog.class.getResource("/hu/prometheus/fubar/res/Info.png")));
		lblInfo.setBounds(0, 517, 480, 255);
		contentPanel.add(lblInfo);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 454, 410);
		contentPanel.add(textArea);
		
		this.tipp = tipp;
		this.tipus = tipus;
		textArea.setText(tipp);
		
		lblEzjo = new JLabel("");
		lblEzjo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_lblEzjo_mouseClicked(arg0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				do_lblEzjo_mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblEzjo_mouseReleased(e);
			}
		});
		lblEzjo.setIcon(new ImageIcon(TippDialog.class.getResource("/hu/prometheus/fubar/res/Ez jo gomb.png")));
		lblEzjo.setBounds(64, 443, 351, 63);
		contentPanel.add(lblEzjo);
	}
	protected void do_lblEzjo_mouseClicked(MouseEvent arg0) {
		EzJoDialog ezd = new EzJoDialog(tipus);
		ezd.setVisible(true);
		this.dispose();
	}
	protected void do_lblEzjo_mousePressed(MouseEvent e) {
		lblEzjo.setIcon(new ImageIcon(TippDialog.class.getResource("/hu/prometheus/fubar/res/Ez jo gomb L.png")));
	}
	protected void do_lblEzjo_mouseReleased(MouseEvent e) {
		lblEzjo.setIcon(new ImageIcon(TippDialog.class.getResource("/hu/prometheus/fubar/res/Ez jo gomb.png")));
	}
}

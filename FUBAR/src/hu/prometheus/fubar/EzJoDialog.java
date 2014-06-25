package hu.prometheus.fubar;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EzJoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -185158676787915294L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblInfo;
	private JLabel lblEzjo;
	private JEditorPane editorPane;
	
	private int tipus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EzJoDialog dialog = new EzJoDialog(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EzJoDialog(int tipus) {
		setModal(true);
		setBounds(100, 100, 480, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblInfo = new JLabel("");
		lblInfo.setIcon(new ImageIcon(EzJoDialog.class.getResource("/hu/prometheus/fubar/res/Info.png")));
		lblInfo.setBounds(0, 507, 480, 255);
		contentPanel.add(lblInfo);
		
		lblEzjo = new JLabel("");
		lblEzjo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblEzjo_mouseClicked(e);
			}
		});
		lblEzjo.setIcon(new ImageIcon(EzJoDialog.class.getResource("/hu/prometheus/fubar/res/Ez jo gomb.png")));
		lblEzjo.setBounds(64, 433, 351, 63);
		contentPanel.add(lblEzjo);
		
		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		editorPane.setBounds(10, 11, 444, 411);
		contentPanel.add(editorPane);
		
		this.tipus = tipus;
	}
	protected void do_lblEzjo_mouseClicked(MouseEvent e) {
		String tipp = editorPane.getText();
		if      (tipus == Kartya.KERDES)    DataBase.insertKerdesTipp(tipp);
		else if (tipus == Kartya.AKCIO)     DataBase.insertAkcioTipp(tipp);
		else if (tipus == Kartya.IGYON_AKI) DataBase.insertIgyonAkiTipp(tipp);
		this.dispose();
	}
}

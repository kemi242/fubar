package hu.prometheus.fubar;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3718723039324237660L;
	private JPanel contentPane;
	private JLabel lblUjjatekos;
	private JLabel lblKiall;
	private JLabel lblPadlo;

	/*
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDialog frame = new MenuDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MenuDialog() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUjjatekos = new JLabel("");
		lblUjjatekos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_lblUjjatekos_mouseClicked(arg0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				do_lblUjjatekos_mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblUjjatekos_mouseReleased(e);
			}
		});
		lblUjjatekos.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/uj jatekos gomb.png")));
		lblUjjatekos.setBounds(92, 237, 295, 126);
		contentPane.add(lblUjjatekos);
		
		lblKiall = new JLabel("");
		lblKiall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblKiall_mouseClicked(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				do_lblKiall_mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblKiall_mouseReleased(e);
			}
		});
		lblKiall.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/kiall gomb.png")));
		lblKiall.setBounds(103, 435, 274, 130);
		contentPane.add(lblKiall);
		
		lblPadlo = new JLabel("");
		lblPadlo.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/Padlo.png")));
		lblPadlo.setBounds(0, 0, 480, 800);
		contentPane.add(lblPadlo);
		
		
		checkPlayers();
	}
	
	private void checkPlayers() {
		if (DataBase.players.size() == 8) lblUjjatekos.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/uj jatekos gomb letiltva.png")));
		else lblUjjatekos.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/uj jatekos gomb.png")));
		if (DataBase.players.size() == 3) lblKiall.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/kiall gomb letiltva.png")));
		else lblKiall.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/kiall gomb.png")));
	}

	protected void do_lblUjjatekos_mouseClicked(MouseEvent arg0) {
		if (DataBase.players.size() < 8) {
			NewPlayerDialog npd = new NewPlayerDialog();
			npd.setVisible(true);
			this.dispose();
		}
	}
	protected void do_lblKiall_mouseClicked(MouseEvent e) {
		if (DataBase.players.size() > 3) {
			PlayerExitDialog ped = new PlayerExitDialog();
			ped.setVisible(true);
			this.dispose();
		}
	}
	protected void do_lblUjjatekos_mousePressed(MouseEvent e) {
		if (DataBase.players.size() < 8) {
			lblUjjatekos.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/uj jatekos gomb L.png")));
		}
	}
	protected void do_lblUjjatekos_mouseReleased(MouseEvent e) {
		if (DataBase.players.size() < 8) {
			lblUjjatekos.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/uj jatekos gomb.png")));
		}
	}
	protected void do_lblKiall_mousePressed(MouseEvent e) {
		if (DataBase.players.size() > 3) {
			lblKiall.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/kiall gomb L.png")));
		}
	}
	protected void do_lblKiall_mouseReleased(MouseEvent e) {
		if (DataBase.players.size() > 3) {
			lblKiall.setIcon(new ImageIcon(MenuDialog.class.getResource("/hu/prometheus/fubar/res/kiall gomb.png")));
		}
	}
}

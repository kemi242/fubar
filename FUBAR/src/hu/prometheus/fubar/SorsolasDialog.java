package hu.prometheus.fubar;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SorsolasDialog extends JDialog {
	private JLabel lblPlayerpic;
	private JLabel lblPlayer;
	private JLabel lblMegvolt;
	private JLabel lblBar;

	/*
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SorsolasDialog dialog = new SorsolasDialog(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the dialog.
	 */
	public SorsolasDialog(Player player) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 480, 800);
		getContentPane().setLayout(null);
		
		lblPlayerpic = new JLabel("");
		lblPlayerpic.setBounds(80, 11, 320, 240);
		getContentPane().add(lblPlayerpic);
		
		lblPlayer = new JLabel("Player");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setForeground(Color.WHITE);
		lblPlayer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer.setBounds(10, 262, 444, 23);
		getContentPane().add(lblPlayer);
		
		lblMegvolt = new JLabel("");
		lblMegvolt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblMegvolt_mouseClicked(e);
			}
		});
		lblMegvolt.setIcon(new ImageIcon(SorsolasDialog.class.getResource("/hu/prometheus/fubar/res/Megvolt gomb.png")));
		lblMegvolt.setBounds(112, 675, 256, 76);
		getContentPane().add(lblMegvolt);
		
		lblBar = new JLabel("");
		lblBar.setIcon(new ImageIcon(SorsolasDialog.class.getResource("/hu/prometheus/fubar/res/Bar.jpg")));
		lblBar.setBounds(0, 0, 480, 800);
		getContentPane().add(lblBar);
		
		lblPlayerpic.setIcon(new ImageIcon(player.getImage().getScaledInstance(320, 240, Image.SCALE_SMOOTH)));
		lblPlayer.setText(player.getName());

	}

	protected void do_lblMegvolt_mouseClicked(MouseEvent e) {
		SoundPlayer.play(SorsolasDialog.class.getResource("/hu/prometheus/fubar/res/Sorsol.wav"));
		this.dispose();
	}
}

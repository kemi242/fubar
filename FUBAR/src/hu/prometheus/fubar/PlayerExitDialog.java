package hu.prometheus.fubar;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerExitDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 643015574517329685L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblPlayer1;
	private JLabel lblPlayer2;
	private JLabel lblPlayer3;
	private JLabel lblPlayer4;
	private JLabel lblPlayer5;
	private JLabel lblPlayer6;
	private JLabel lblPlayer7;
	private JLabel lblPlayer8;
	
	private JLabel[] playerLabels;
	
	private JLabel lblPadlo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PlayerExitDialog dialog = new PlayerExitDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PlayerExitDialog() {
		setModal(true);
		setBounds(100, 100, 480, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblPlayer1 = new JLabel("");
		lblPlayer1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPlayer1_mouseClicked(e);
			}
		});
		lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer1.setForeground(Color.WHITE);
		lblPlayer1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer1.setBounds(10, 11, 444, 48);
		contentPanel.add(lblPlayer1);
		
		lblPlayer2 = new JLabel("");
		lblPlayer2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPlayer2_mouseClicked(e);
			}
		});
		lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer2.setForeground(Color.WHITE);
		lblPlayer2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer2.setBounds(10, 70, 444, 48);
		contentPanel.add(lblPlayer2);
		
		lblPlayer3 = new JLabel("");
		lblPlayer3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPlayer3_mouseClicked(e);
			}
		});
		lblPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer3.setForeground(Color.WHITE);
		lblPlayer3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer3.setBounds(10, 129, 444, 48);
		contentPanel.add(lblPlayer3);
		
		lblPlayer4 = new JLabel("");
		lblPlayer4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPlayer4_mouseClicked(e);
			}
		});
		lblPlayer4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer4.setForeground(Color.WHITE);
		lblPlayer4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer4.setBounds(10, 188, 444, 48);
		contentPanel.add(lblPlayer4);
		
		lblPlayer5 = new JLabel("");
		lblPlayer5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPlayer5_mouseClicked(e);
			}
		});
		lblPlayer5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer5.setForeground(Color.WHITE);
		lblPlayer5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer5.setBounds(10, 247, 444, 48);
		contentPanel.add(lblPlayer5);
		
		lblPlayer6 = new JLabel("");
		lblPlayer6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPlayer6_mouseClicked(e);
			}
		});
		lblPlayer6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer6.setForeground(Color.WHITE);
		lblPlayer6.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer6.setBounds(10, 306, 444, 48);
		contentPanel.add(lblPlayer6);
		
		lblPlayer7 = new JLabel("");
		lblPlayer7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPlayer7_mouseClicked(e);
			}
		});
		lblPlayer7.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer7.setForeground(Color.WHITE);
		lblPlayer7.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer7.setBounds(10, 365, 444, 48);
		contentPanel.add(lblPlayer7);
		
		lblPlayer8 = new JLabel("");
		lblPlayer8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblPlayer8_mouseClicked(e);
			}
		});
		lblPlayer8.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer8.setForeground(Color.WHITE);
		lblPlayer8.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer8.setBounds(10, 424, 444, 48);
		contentPanel.add(lblPlayer8);
		
		lblPadlo = new JLabel("padlo");
		lblPadlo.setIcon(new ImageIcon(PlayerExitDialog.class.getResource("/hu/prometheus/fubar/res/Padlo.png")));
		lblPadlo.setBounds(0, 0, 480, 800);
		contentPanel.add(lblPadlo);
		
		
		playerLabels = new JLabel[8];
		
		playerLabels[0] = lblPlayer1;
		playerLabels[1] = lblPlayer2;
		playerLabels[2] = lblPlayer3;
		playerLabels[3] = lblPlayer4;
		playerLabels[4] = lblPlayer5;
		playerLabels[5] = lblPlayer6;
		playerLabels[6] = lblPlayer7;
		playerLabels[7] = lblPlayer8;
		
		
		
		for (int i = 0; i < DataBase.players.size(); i++) {
			playerLabels[i].setText(DataBase.players.get(i).getName());
			playerLabels[i].setIcon(new ImageIcon(DataBase.players.get(i).getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		}
	}
	protected void do_lblPlayer1_mouseClicked(MouseEvent e) {
		DataBase.players.remove(0);
		this.dispose();
	}
	protected void do_lblPlayer2_mouseClicked(MouseEvent e) {
		DataBase.players.remove(1);
		this.dispose();
	}
	protected void do_lblPlayer3_mouseClicked(MouseEvent e) {
		DataBase.players.remove(2);
		this.dispose();
	}
	protected void do_lblPlayer4_mouseClicked(MouseEvent e) {
		DataBase.players.remove(3);
		this.dispose();
	}
	protected void do_lblPlayer5_mouseClicked(MouseEvent e) {
		DataBase.players.remove(4);
		this.dispose();
	}
	protected void do_lblPlayer6_mouseClicked(MouseEvent e) {
		DataBase.players.remove(5);
		this.dispose();
	}
	protected void do_lblPlayer7_mouseClicked(MouseEvent e) {
		DataBase.players.remove(6);
		this.dispose();
	}
	protected void do_lblPlayer8_mouseClicked(MouseEvent e) {
		DataBase.players.remove(7);
		this.dispose();
	}
}

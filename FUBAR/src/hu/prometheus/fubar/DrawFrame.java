package hu.prometheus.fubar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6885073191166891969L;
	private JPanel contentPane;
	private JLabel lblNincsjelen;
	private JLabel lblPlayer;
	private JLabel lblKartyakez;
	private JLabel lblKartyahat;
	
	private Timer timerKartyaKez;
	private Timer timerKartyaHat;
	private JLabel lblBar;

	/*
	 * Launch the application.
	 *
	public static void main(String[] args) {
		
		DataBase.init();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawFrame frame = new DrawFrame(null);
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
	public DrawFrame(Player player) {
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNincsjelen = new JLabel("");
		lblNincsjelen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_lblNincsjelen_mouseClicked(arg0);
			}
		});
		
		lblKartyahat = new JLabel("");
		lblKartyahat.setIcon(new ImageIcon(DrawFrame.class.getResource("/hu/prometheus/fubar/res/Kartya hat.png")));
		lblKartyahat.setBounds(100, 423, 149, 225);
		lblKartyahat.setVisible(false);
		contentPane.add(lblKartyahat);
		lblNincsjelen.setIcon(new ImageIcon(DrawFrame.class.getResource("/hu/prometheus/fubar/res/Nincs jelen.png")));
		lblNincsjelen.setBounds(83, 11, 314, 76);
		contentPane.add(lblNincsjelen);
		
		lblPlayer = new JLabel("");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setForeground(Color.WHITE);
		lblPlayer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayer.setBounds(80, 99, 320, 240);
		lblPlayer.setText(player.getName());
		lblPlayer.setIcon(new ImageIcon(player.getImage().getScaledInstance(320, 240, Image.SCALE_SMOOTH)));
		contentPane.add(lblPlayer);
		
		lblKartyakez = new JLabel("");
		lblKartyakez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblKartyakez_mouseClicked(e);
			}
		});
		lblKartyakez.setIcon(new ImageIcon(DrawFrame.class.getResource("/hu/prometheus/fubar/res/Kartya kez.png")));
		lblKartyakez.setBounds(0, 762, 350, 350);
		contentPane.add(lblKartyakez);
		
		lblBar = new JLabel("");
		lblBar.setIcon(new ImageIcon(DrawFrame.class.getResource("/hu/prometheus/fubar/res/Bar.jpg")));
		lblBar.setBounds(0, 0, 480, 800);
		contentPane.add(lblBar);
		
		timerKartyaKez = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_timerKartyaKez_actionPerformed();
				
			}
			
		});
		
		timerKartyaHat = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_timerKartyaHat_actionPerformed();
				
			}
			
		});
		
		timerKartyaKez.start();
	}
	
	protected void do_timerKartyaKez_actionPerformed() {
		if (lblKartyakez.getY() > 412) {
			lblKartyakez.setBounds(lblKartyakez.getX(), lblKartyakez.getY() - 4, lblKartyakez.getWidth(), lblKartyakez.getHeight());
		} else {
			timerKartyaKez.stop();
		}
	}
	protected void do_lblNincsjelen_mouseClicked(MouseEvent arg0) {
		SoundPlayer.play(MainFrame.class.getResource("/hu/prometheus/fubar/res/Sorsol.wav"));
		this.setVisible(false);
	}
	protected void do_lblKartyakez_mouseClicked(MouseEvent e) {
		
		SoundPlayer.play(MainFrame.class.getResource("/hu/prometheus/fubar/res/huzas.wav"));
		
		lblKartyahat.setVisible(true);
		timerKartyaHat.start();
	}
	
	protected void do_timerKartyaHat_actionPerformed() {
		lblKartyahat.setBounds(lblKartyahat.getX(), lblKartyahat.getY() - 24, lblKartyahat.getWidth(), lblKartyahat.getHeight());
		if (lblKartyahat.getY() <= -225) {
			timerKartyaHat.stop();
			Random r = new Random();
			Kartya kartya = DataBase.kartyak.get(r.nextInt(DataBase.kartyak.size()));
			CardDialog cd = new CardDialog(kartya);
			cd.setVisible(true);
			this.dispose();
		}
	}
}

package hu.prometheus.fubar;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.event.MouseMotionAdapter;

import javax.swing.SwingConstants;

import java.awt.Color;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 891406863051600261L;
	private JPanel contentPane;
	private JLabel lblPalack;
	private JLabel lblPlayer1;
	private JLabel lblPlayer2;
	private JLabel lblPlayer3;
	private JLabel lblPlayer4;
	private JLabel lblPlayer5;
	private JLabel lblPlayer6;
	private JLabel lblPlayer7;
	private JLabel lblPlayer8;
	private Timer timerPalack;
	
	private Image img;
	
	private int prevX;
	private double dragSpd;

	private double deg;
	private double inc;
	
	public JLabel[] playerLabels;
	private JLabel lblPadlo;
	private JLabel lblMenu;

	
	public boolean sorsol;
	
	private Line bottle;
	private Line perp;
	private int lastx, lasty;
	
	/*
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
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
	public GameFrame() {
		
		setResizable(false);
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPalack = new JLabel("");
		lblPalack.setVerticalAlignment(SwingConstants.TOP);
		lblPalack.setHorizontalAlignment(SwingConstants.LEFT);
		lblPalack.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				do_lblPalack_mouseDragged(arg0);
			}
		});
		lblPalack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblPalack_mouseReleased(e);
			}
		});
		lblPalack.setIcon(new ImageIcon(GameFrame.class.getResource("/hu/prometheus/fubar/res/Palack.png")));
		lblPalack.setBounds(165, 325, 150, 150);
		contentPane.add(lblPalack);
		
		lblPlayer1 = new JLabel("");
		lblPlayer1.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer1);
		
		lblPlayer2 = new JLabel("");
		lblPlayer2.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer2);
		
		lblPlayer3 = new JLabel("");
		lblPlayer3.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer3);
		
		lblPlayer4 = new JLabel("");
		lblPlayer4.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer4);
		
		lblPlayer5 = new JLabel("");
		lblPlayer5.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer5);
		
		lblPlayer6 = new JLabel("");
		lblPlayer6.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer6);
		
		lblPlayer7 = new JLabel("");
		lblPlayer7.setBackground(Color.BLACK);
		lblPlayer7.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer7);
		
		lblPlayer8 = new JLabel("");
		lblPlayer8.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer8);
		
		lblMenu = new JLabel("");
		lblMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblMenu_mouseClicked(e);
			}
		});
		lblMenu.setIcon(new ImageIcon(GameFrame.class.getResource("/hu/prometheus/fubar/res/Men\u00FC gomb.png")));
		lblMenu.setBounds(10, 696, 126, 65);
		contentPane.add(lblMenu);
		
		lblPadlo = new JLabel("");
		lblPadlo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				do_lblPadlo_mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblPadlo_mouseReleased(e);
			}
		});
		lblPadlo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				do_lblPadlo_mouseDragged(e);
			}
		});
		lblPadlo.setIcon(new ImageIcon(GameFrame.class.getResource("/hu/prometheus/fubar/res/Padlo.png")));
		lblPadlo.setBounds(0, 0, 480, 800);
		contentPane.add(lblPadlo);
		
		timerPalack = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_timerPalack_actionPerformed();
			}
			
		});
		
		sorsol = false;
		
		deg = 0;
		prevX = 0;
		
		bottle = new Line(this.getWidth() / 2, this.getHeight() / 2, deg);
		
		img = ((ImageIcon)lblPalack.getIcon()).getImage();
		
		
		playerLabels = new JLabel[8];
		
		playerLabels[0] = lblPlayer1;
		playerLabels[1] = lblPlayer2;
		playerLabels[2] = lblPlayer3;
		playerLabels[3] = lblPlayer4;
		playerLabels[4] = lblPlayer5;
		playerLabels[5] = lblPlayer6;
		playerLabels[6] = lblPlayer7;
		playerLabels[7] = lblPlayer8;

		arrangePlayers();
	}
	
public GameFrame(boolean start) {
		
		setResizable(false);
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPalack = new JLabel("");
		lblPalack.setVerticalAlignment(SwingConstants.TOP);
		lblPalack.setHorizontalAlignment(SwingConstants.LEFT);
		lblPalack.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				do_lblPalack_mouseDragged(arg0);
			}
		});
		lblPalack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblPalack_mouseReleased(e);
			}
		});
		lblPalack.setIcon(new ImageIcon(GameFrame.class.getResource("/hu/prometheus/fubar/res/Palack.png")));
		lblPalack.setBounds(165, 325, 150, 150);
		contentPane.add(lblPalack);
		
		lblPlayer1 = new JLabel("");
		lblPlayer1.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer1);
		
		lblPlayer2 = new JLabel("");
		lblPlayer2.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer2);
		
		lblPlayer3 = new JLabel("");
		lblPlayer3.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer3);
		
		lblPlayer4 = new JLabel("");
		lblPlayer4.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer4);
		
		lblPlayer5 = new JLabel("");
		lblPlayer5.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer5);
		
		lblPlayer6 = new JLabel("");
		lblPlayer6.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer6);
		
		lblPlayer7 = new JLabel("");
		lblPlayer7.setBackground(Color.BLACK);
		lblPlayer7.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer7);
		
		lblPlayer8 = new JLabel("");
		lblPlayer8.setBounds(0, 0, 64, 48);
		contentPane.add(lblPlayer8);
		
		lblMenu = new JLabel("");
		lblMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblMenu_mouseClicked(e);
			}
		});
		lblMenu.setIcon(new ImageIcon(GameFrame.class.getResource("/hu/prometheus/fubar/res/Men\u00FC gomb.png")));
		lblMenu.setBounds(10, 696, 126, 65);
		contentPane.add(lblMenu);
		
		lblPadlo = new JLabel("");
		lblPadlo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				do_lblPadlo_mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblPadlo_mouseReleased(e);
			}
		});
		lblPadlo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				do_lblPadlo_mouseDragged(e);
			}
		});
		lblPadlo.setIcon(new ImageIcon(GameFrame.class.getResource("/hu/prometheus/fubar/res/Padlo.png")));
		lblPadlo.setBounds(0, 0, 480, 800);
		contentPane.add(lblPadlo);
		
		timerPalack = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_timerPalack_actionPerformed();
			}
			
		});
		
		sorsol = false;
		
		deg = 0;
		prevX = 0;
		
		bottle = new Line(this.getWidth() / 2, this.getHeight() / 2, deg);
		
		img = ((ImageIcon)lblPalack.getIcon()).getImage();
		
		
		playerLabels = new JLabel[8];
		
		playerLabels[0] = lblPlayer1;
		playerLabels[1] = lblPlayer2;
		playerLabels[2] = lblPlayer3;
		playerLabels[3] = lblPlayer4;
		playerLabels[4] = lblPlayer5;
		playerLabels[5] = lblPlayer6;
		playerLabels[6] = lblPlayer7;
		playerLabels[7] = lblPlayer8;

		arrangePlayers();
		
		if (start) {
			SoundPlayer.play(StartFrame.class.getResource("/hu/prometheus/fubar/res/Hangulat.wav"));
		}
		
	}
	
	
	
	private void arrange3() {
		lblPlayer1.setBounds(208, 167, 64, 48);
		lblPlayer2.setBounds(27, 481, 64, 48);
		lblPlayer3.setBounds(389, 481, 64, 48);
		
		lblPlayer1.setVisible(true);
		lblPlayer2.setVisible(true);
		lblPlayer3.setVisible(true);
		
		lblPlayer4.setVisible(false);
		lblPlayer5.setVisible(false);
		lblPlayer6.setVisible(false);
		lblPlayer7.setVisible(false);
		lblPlayer8.setVisible(false);
	}
	
	private void arrange4() {
		lblPlayer1.setBounds(208, 167, 64, 48);
		lblPlayer2.setBounds(41, 376, 64, 48);
		lblPlayer3.setBounds(208, 561, 64, 48);
		lblPlayer4.setBounds(343, 376, 64, 48);
		
		lblPlayer1.setVisible(true);
		lblPlayer2.setVisible(true);
		lblPlayer3.setVisible(true);
		lblPlayer4.setVisible(true);
		
		lblPlayer5.setVisible(false);
		lblPlayer6.setVisible(false);
		lblPlayer7.setVisible(false);
		lblPlayer8.setVisible(false);
		
	}
	
	private void arrange5() {
		lblPlayer1.setBounds(208, 167, 64, 48);
		lblPlayer2.setBounds(33, 319, 64, 48);
		lblPlayer3.setBounds(110, 511, 64, 48);
		lblPlayer4.setBounds(306, 511, 64, 48);
		lblPlayer5.setBounds(383, 319, 64, 48);
		
		lblPlayer1.setVisible(true);
		lblPlayer2.setVisible(true);
		lblPlayer3.setVisible(true);
		lblPlayer4.setVisible(true);
		lblPlayer5.setVisible(true);
		
		lblPlayer6.setVisible(false);
		lblPlayer7.setVisible(false);
		lblPlayer8.setVisible(false);
	}
	
	private void arrange6() {
		lblPlayer1.setBounds(208, 167, 64, 48);
		lblPlayer2.setBounds(27, 271, 64, 48);
		lblPlayer3.setBounds(24, 481, 64, 48);
		lblPlayer4.setBounds(209, 585, 64, 48);
		lblPlayer5.setBounds(389, 481, 64, 48);
		lblPlayer6.setBounds(389, 271, 64, 48);
		
		lblPlayer1.setVisible(true);
		lblPlayer2.setVisible(true);
		lblPlayer3.setVisible(true);
		lblPlayer4.setVisible(true);
		lblPlayer5.setVisible(true);
		lblPlayer6.setVisible(true);
		
		lblPlayer7.setVisible(false);
		lblPlayer8.setVisible(false);
	}
	
	private void arrange7() {
		lblPlayer1.setBounds(208, 167, 64, 48);
		lblPlayer2.setBounds(45, 245, 64, 48);
		lblPlayer3.setBounds(5, 422, 64, 48);
		lblPlayer4.setBounds(118, 564, 64, 48);
		lblPlayer5.setBounds(306, 564, 64, 48);
		lblPlayer6.setBounds(401, 422, 64, 48);
		lblPlayer7.setBounds(371, 245, 64, 48);
		
		lblPlayer1.setVisible(true);
		lblPlayer2.setVisible(true);
		lblPlayer3.setVisible(true);
		lblPlayer4.setVisible(true);
		lblPlayer5.setVisible(true);
		lblPlayer6.setVisible(true);
		lblPlayer7.setVisible(true);
		
		lblPlayer8.setVisible(false);
	}
	
	private void arrange8() {
		lblPlayer1.setBounds(208, 167, 64, 48);
		lblPlayer2.setBounds(60, 228, 64, 48);
		lblPlayer3.setBounds(10, 376, 64, 48);
		lblPlayer4.setBounds(60, 524, 64, 48);
		lblPlayer5.setBounds(208, 585, 64, 48);
		lblPlayer6.setBounds(356, 524, 64, 48);
		lblPlayer7.setBounds(400, 376, 64, 48);
		lblPlayer8.setBounds(356, 228, 64, 48);
		
		lblPlayer1.setVisible(true);
		lblPlayer2.setVisible(true);
		lblPlayer3.setVisible(true);
		lblPlayer4.setVisible(true);
		lblPlayer5.setVisible(true);
		lblPlayer6.setVisible(true);
		lblPlayer7.setVisible(true);
		lblPlayer8.setVisible(true);
		
		
	}
	
	private void arrangePlayers() {
		for (int i = 0; i < DataBase.players.size(); i++) {
			playerLabels[i].setIcon(new ImageIcon(DataBase.players.get(i).getImage().getScaledInstance(64, 48, Image.SCALE_SMOOTH)));
		}
		
		if (DataBase.players.size() == 3) arrange3();
		else if (DataBase.players.size() == 4) arrange4();
		else if (DataBase.players.size() == 5) arrange5();
		else if (DataBase.players.size() == 6) arrange6();
		else if (DataBase.players.size() == 7) arrange7();
		else arrange8();
	}
	
	
	private void rotateBottle() {
		double theta = Math.toRadians(deg);
		
		double x = img.getWidth(null) / 2;
		double y = img.getHeight(null) / 2;
		
		AffineTransform tx = AffineTransform.getRotateInstance(theta, x, y);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_4BYTE_ABGR);
		bimg.getGraphics().drawImage(img, 0, 0, null);
		
		BufferedImage rotated = op.filter(bimg, null);
		lblPalack.setIcon(new ImageIcon(rotated));
	}
	
	private Player degToPlayer() {
		int deg = getDeg();
		if (DataBase.players.size() == 3) {
			if (deg >= 300 && deg <= 360 || deg >= 0 && deg <= 60) return DataBase.players.get(0);
			else if (deg >= 180 && deg <= 300) return DataBase.players.get(1);
			else if (deg >= 60 && deg <= 180) return DataBase.players.get(2);
		} else if (DataBase.players.size() == 4) {
			if (deg >= 315 && deg <= 360 || deg >= 0 && deg <= 45) return DataBase.players.get(0);
			else if (deg >= 225 && deg <= 315) return DataBase.players.get(1);
			else if (deg >= 135 && deg <= 225) return DataBase.players.get(2);
			else if (deg >= 45 && deg <= 135) return DataBase.players.get(3);
			
		} else if (DataBase.players.size() == 5) {
			if (deg >= 324 && deg <= 360 || deg >= 0 && deg <= 36) return DataBase.players.get(0);
			else if (deg >= 252 && deg <= 324) return DataBase.players.get(1);
			else if (deg >= 180 && deg <= 252) return DataBase.players.get(2);
			else if (deg >= 108 && deg <= 180) return DataBase.players.get(3);
			else if (deg >= 36 && deg <= 108) return DataBase.players.get(4);
		} else if (DataBase.players.size() == 6) {
			if (deg >= 330 && deg <= 360 || deg >= 0 && deg <= 30) return DataBase.players.get(0);
			else if (deg >= 270 && deg <= 330) return DataBase.players.get(1);
			else if (deg >= 210 && deg <= 270) return DataBase.players.get(2);
			else if (deg >= 150 && deg <= 270) return DataBase.players.get(3);
			else if (deg >= 90 && deg <= 150) return DataBase.players.get(4);
			else if (deg >= 30 && deg <= 90) return DataBase.players.get(5);
		} else if (DataBase.players.size() == 7) {
			if (deg >= 334 && deg <= 360 || deg >= 0 && deg <= 26) return DataBase.players.get(0);
			else if (deg >= 282 && deg <= 334) return DataBase.players.get(1);
			else if (deg >= 230 && deg <= 282) return DataBase.players.get(2);
			else if (deg >= 178 && deg <= 230) return DataBase.players.get(3);
			else if (deg >= 126 && deg <= 178) return DataBase.players.get(4);
			else if (deg >= 74 && deg <= 126) return DataBase.players.get(5);
			else if (deg >= 26 && deg <= 74) return DataBase.players.get(6);
		} else {
			if (deg >= 338 && deg <= 360 || deg >= 0 && deg <= 23) return DataBase.players.get(0);
			else if (deg >= 293 && deg <= 338) return DataBase.players.get(1);
			else if (deg >= 248 && deg <= 293) return DataBase.players.get(2);
			else if (deg >= 203 && deg <= 248) return DataBase.players.get(3);
			else if (deg >= 158 && deg <= 203) return DataBase.players.get(4);
			else if (deg >= 113 && deg <= 158) return DataBase.players.get(5);
			else if (deg >= 68 && deg <= 113) return DataBase.players.get(6);
			else if (deg >= 23 && deg <= 68) return DataBase.players.get(7);
		}
		
		return null;
	}
	
	private int getDeg() {
		int r = (int)(deg % 360);
		if (r > 0) return r;
		else return 360 + r;
	}
	
	protected void do_lblPalack_mouseDragged(MouseEvent e) {
		/*dragSpd = e.getX() - prevX;
		if (Math.abs(dragSpd) < 50) {
			deg += dragSpd;
		}
		rotateBottle();
		prevX = e.getX();*/
		
	}
	
	protected void do_timerPalack_actionPerformed() {
		rotateBottle();
		if (Math.abs(inc) > 0.1) {
			deg += inc;
			if (inc > 0) inc -= 0.1;
			else inc += 0.1;
		} else {
			if (!sorsol) {
				DrawFrame df = new DrawFrame(degToPlayer());
				df.setVisible(true);
			} else {
				SorsolasDialog sd = new SorsolasDialog(degToPlayer());
				sd.setVisible(true);
				this.dispose();
			}
			timerPalack.stop();
		}
	}
	protected void do_lblPalack_mouseReleased(MouseEvent e) {
		/*SoundPlayer.play(MainFrame.class.getResource("/hu/prometheus/fubar/res/porget.wav"));
		
		inc = dragSpd / 2;
		timerPalack.start();*/
		
	}
	protected void do_lblMenu_mouseClicked(MouseEvent e) {
		MenuDialog md = new MenuDialog();
		md.setVisible(true);
		arrangePlayers();
	}

	protected void do_lblPadlo_mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		double[] point = perp.pointOnLine(x, y);
		dragSpd = Math.sqrt(x * x + y * y) - Math.sqrt(lastx * lastx + lasty * lasty);
		//System.out.println(dragSpd);

		if (Math.abs(dragSpd) < 50) {
			deg += dragSpd;
		}
		
		rotateBottle();

		lastx = x;
		lasty = y;
	}
	protected void do_lblPadlo_mousePressed(MouseEvent e) {
		perp = bottle.perp(e.getX(), e.getY());
		lastx = e.getX();
		lasty = e.getY();
		
	}
	protected void do_lblPadlo_mouseReleased(MouseEvent e) {
		//System.out.println(dragSpd);
		if (Math.abs(dragSpd) > 5) {
			inc = dragSpd / 2;
			if (Math.abs(inc) > 30) {
				inc = Math.signum(inc) * 30;
			}
			//System.out.println(inc);
			SoundPlayer.play(MainFrame.class.getResource("/hu/prometheus/fubar/res/porget.wav"));
			timerPalack.start();
		}
	}
}

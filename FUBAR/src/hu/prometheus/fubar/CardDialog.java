package hu.prometheus.fubar;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class CardDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3447929397298766730L;

	private JLabel lblKartya;
	
	private Timer timerKartya;
	private Timer timerKartyaMegvolt;
	private JLabel lblTipp;
	
	private Kartya kartya;
	private JLabel lblMegvolt;
	private JLabel lblSorsolas;
	private JLabel lblBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardDialog dialog = new CardDialog(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public CardDialog(Kartya kartya) {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 480, 800);
		getContentPane().setLayout(null);
		
		lblTipp = new JLabel("");
		lblTipp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_lblTipp_mouseClicked(arg0);
			}
		});
		lblTipp.setIcon(new ImageIcon(CardDialog.class.getResource("/hu/prometheus/fubar/res/Tipp.png")));
		lblTipp.setBounds(274, 572, 200, 200);
		getContentPane().add(lblTipp);
		
		if (kartya.getTipus() != Kartya.AKCIO && kartya.getTipus() != Kartya.KERDES && kartya.getTipus() != Kartya.IGYON_AKI) lblTipp.setVisible(false);
		
		lblMegvolt = new JLabel("");
		lblMegvolt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblMegvolt_mouseClicked(e);
			}
		});
		lblMegvolt.setIcon(new ImageIcon(CardDialog.class.getResource("/hu/prometheus/fubar/res/Megvolt gomb.png")));
		lblMegvolt.setBounds(20, 685, 256, 76);
		getContentPane().add(lblMegvolt);
		
		lblSorsolas = new JLabel("");
		lblSorsolas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_lblSorsolas_mouseClicked(arg0);
			}
		});
		lblSorsolas.setIcon(new ImageIcon(CardDialog.class.getResource("/hu/prometheus/fubar/res/Sorsolas gomb.png")));
		lblSorsolas.setBounds(20, 685, 256, 76);
		lblSorsolas.setVisible(false);
		getContentPane().add(lblSorsolas);
		
		lblKartya = new JLabel("");
		lblKartya.setBounds(20, -760, 440, 760);
		lblKartya.setIcon(new ImageIcon(kartya.getImage()));
		
		getContentPane().add(lblKartya);
		
		lblBar = new JLabel("");
		lblBar.setIcon(new ImageIcon(CardDialog.class.getResource("/hu/prometheus/fubar/res/Bar.jpg")));
		lblBar.setBounds(0, 0, 480, 800);
		getContentPane().add(lblBar);
		
		if (kartya.getTipus() == Kartya.SORSOL) {
			lblMegvolt.setVisible(false);
			lblSorsolas.setVisible(true);
		}
		
		
		timerKartya = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_timerKartya_actionPerformed();
				
			}
			
		});
		
		timerKartyaMegvolt = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_timerKartyaMegvolt_actionPerformed();
				
			}
			
		});
		
		this.kartya = kartya;
		
		SoundPlayer.play(CardDialog.class.getResource("/hu/prometheus/fubar/res/Hangulat.wav"));
		timerKartya.start();

	}
	
	protected void do_timerKartya_actionPerformed() {
		lblKartya.setBounds(lblKartya.getX(), lblKartya.getY() + 24, lblKartya.getWidth(), lblKartya.getHeight());
		if (lblKartya.getY() >= 10) {
			lblKartya.setBounds(lblKartya.getX(), 10, lblKartya.getWidth(), lblKartya.getHeight());
			timerKartya.stop();
		}
	}
	protected void do_lblTipp_mouseClicked(MouseEvent arg0) {
		Random r = new Random();
		if (kartya.getTipus() == Kartya.KERDES) {
			String tipp = DataBase.kerdesTippek.get(r.nextInt(DataBase.kerdesTippek.size()));
			TippDialog td = new TippDialog(tipp, kartya.getTipus());
			td.setVisible(true);
		} else if (kartya.getTipus() == Kartya.AKCIO) {
			String tipp = DataBase.akcioTippek.get(r.nextInt(DataBase.akcioTippek.size()));
			TippDialog td = new TippDialog(tipp, kartya.getTipus());
			td.setVisible(true);
		} else {
			String tipp = DataBase.igyonAkiTippek.get(r.nextInt(DataBase.igyonAkiTippek.size()));
			TippDialog td = new TippDialog(tipp, kartya.getTipus());
			td.setVisible(true);
		}
	}
	protected void do_lblMegvolt_mouseClicked(MouseEvent e) {
		timerKartyaMegvolt.start();
	}
	
	protected void do_timerKartyaMegvolt_actionPerformed() {
		lblKartya.setBounds(lblKartya.getX(), lblKartya.getY() + 24, lblKartya.getWidth(), lblKartya.getHeight());
		if (lblKartya.getY() >= 800) {
			lblKartya.setBounds(lblKartya.getX(), 10, lblKartya.getWidth(), lblKartya.getHeight());
			timerKartyaMegvolt.stop();
			SoundPlayer.play(MainFrame.class.getResource("/hu/prometheus/fubar/res/Sorsol.wav"));
			this.dispose();
		}
	}
	protected void do_lblSorsolas_mouseClicked(MouseEvent arg0) {
		GameFrame gf = new GameFrame();
		gf.sorsol = true;
		gf.setVisible(true);
		this.dispose();
	}
}

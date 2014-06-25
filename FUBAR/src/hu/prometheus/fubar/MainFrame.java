package hu.prometheus.fubar;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 292849667861435862L;
	
	private JPanel contentPane;
	private JLabel lblHatter;
	private JLabel lblJatekmester;
	private Timer timerJatekmester;
	private JLabel lblFubarKez;
	private Timer timerFubarKezDelay;
	private Timer timerFubarKez;
	private JLabel lblStart;
	private JLabel lblKerdes;
	

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
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/hu/prometheus/fubar/res/Ikon kicsi.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblKerdes = new JLabel("");
		lblKerdes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_lblKerdes_mouseClicked(arg0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				do_lblKerdes_mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblKerdes_mouseReleased(e);
			}
		});
		lblKerdes.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/Kerdes gomb.png")));
		lblKerdes.setBounds(399, 11, 65, 105);
		contentPane.add(lblKerdes);
		
		lblStart = new JLabel("");
		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblStart_mouseClicked(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				do_lblStart_mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblStart_mouseReleased(e);
			}
		});
		lblStart.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/Start gomb.png")));
		lblStart.setBounds(10, 11, 100, 130);
		contentPane.add(lblStart);
		
		lblFubarKez = new JLabel("");
		lblFubarKez.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/Fubar kez.png")));
		lblFubarKez.setBounds(0, 800, 350, 350);
		contentPane.add(lblFubarKez);
		
		lblJatekmester = new JLabel("");
		lblJatekmester.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/Jatekmester.png")));
		lblJatekmester.setBounds(0, 800, 480, 800);
		contentPane.add(lblJatekmester);
		
		lblHatter = new JLabel("");
		lblHatter.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/hatter.gif")));
		lblHatter.setBounds(0, 0, 480, 800);
		contentPane.add(lblHatter);
		
		timerJatekmester = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				on_timerJatekmester_tick();
			}
			
		});
		
		timerFubarKezDelay = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				on_timerFubarKezDelay_tick();
				
			}
			
		});
		
		timerFubarKez = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				on_timerFubarKez_tick();
				
			}
			
		});
		
		
		
		timerJatekmester.start();
		
		SoundPlayer.play(MainFrame.class.getResource("/hu/prometheus/fubar/res/Focimdal.wav"));
	}
	
	private void on_timerJatekmester_tick() {
		lblJatekmester.setBounds(lblJatekmester.getX(), lblJatekmester.getY() - 8, lblJatekmester.getWidth(), lblJatekmester.getHeight());
		if (lblJatekmester.getY() <= 0) {
			timerFubarKezDelay.start();
			timerJatekmester.stop();
		}
	}
	
	private void on_timerFubarKezDelay_tick() {
		timerFubarKez.start();
		timerFubarKezDelay.stop();
	}
	
	private void on_timerFubarKez_tick() {
		lblFubarKez.setBounds(lblFubarKez.getX(), lblFubarKez.getY() - 4, lblFubarKez.getWidth(), lblFubarKez.getHeight());
		if (lblFubarKez.getY() <= 450) {
			timerFubarKez.stop();
		}
	}

	protected void do_lblKerdes_mouseClicked(MouseEvent arg0) {
		AboutFrame about = new AboutFrame();
		about.setVisible(true);
	}
	protected void do_lblStart_mouseClicked(MouseEvent e) {
		StartFrame sf = new StartFrame();
		sf.setVisible(true);
	}
	protected void do_lblStart_mousePressed(MouseEvent e) {
		lblStart.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/Start gomb lenyomva.png")));
	}
	protected void do_lblStart_mouseReleased(MouseEvent e) {
		lblStart.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/Start gomb.png")));
	}
	protected void do_lblKerdes_mousePressed(MouseEvent e) {
		lblKerdes.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/Kerdes gomb lenyomva.png")));
	}
	protected void do_lblKerdes_mouseReleased(MouseEvent e) {
		lblKerdes.setIcon(new ImageIcon(MainFrame.class.getResource("/hu/prometheus/fubar/res/Kerdes gomb.png")));
	}
}

package hu.prometheus.fubar;

import java.awt.BorderLayout;
import java.io.File;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;

import javax.swing.UIManager;

import com.sun.jna.NativeLibrary;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CameraDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9113679964778340135L;
	private final JPanel contentPanel = new JPanel();
	private MediaPlayer player;
	
	public String fileName;
	
	private String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CameraDialog dialog = new CameraDialog("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public CameraDialog(String name) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(CameraDialog.class.getResource("/hu/prometheus/fubar/res/Ikon kicsi.png")));
		setModal(true);
		
		this.name = name;
		
		NativeLibrary.addSearchPath("libvlc", System.getenv("PROGRAMFILES") + "\\VideoLAN\\VLC");
		System.setProperty("jna.library.path", System.getenv("PROGRAMFILES") + "\\VideoLAN\\VLC");
		
		setResizable(false);
		setBounds(100, 100, 480, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JButton btnSnapshot = new JButton("F\u00E9nyk\u00E9pez");
			btnSnapshot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_btnSnapshot_actionPerformed(arg0);
				}
			});
			contentPanel.add(btnSnapshot, BorderLayout.SOUTH);
		}
		{
			JLabel lblCamera = new JLabel("");
			contentPanel.add(lblCamera, BorderLayout.CENTER);
		}
		
		try {
			MediaPlayerFactory factory = new MediaPlayerFactory();
			player = factory.newEmbeddedMediaPlayer();
			player.startMedia("dshow://");
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
	}

	protected void do_btnSnapshot_actionPerformed(ActionEvent arg0) {
		
		fileName = name + "_" + Calendar.getInstance().getTime().toString().replace(' ', '_').replace(":", "") + ".jpg";
		
		File f = new File(fileName);
		player.saveSnapshot(f);
		player.stop();
		this.setVisible(false);
	}
}

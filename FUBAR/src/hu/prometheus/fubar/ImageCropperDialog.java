package hu.prometheus.fubar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageCropperDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private BufferedImage image;
	private ImageCropperLabel lblImage;

	private boolean drag;
	private boolean resize;
	private int lastX;
	private int lastY;
	private File file;
	private Rectangle rect;
	
	public String fileName;

	/*
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ImageCropperDialog dialog = new ImageCropperDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ImageCropperDialog() {
		setBounds(100, 100, 680, 570);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		lblImage = new ImageCropperLabel("");
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				do_lblImage_mousePressed(arg0);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				do_lblImage_mouseReleased(e);
			}
		});
		lblImage.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				do_lblImage_mouseDragged(arg0);
			}
		});
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblImage, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						do_okButton_actionPerformed(arg0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_cancelButton_actionPerformed(e);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		rect = new Rectangle(270, 190, 100, 100);

		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				file = chooser.getSelectedFile();
				image = ImageIO.read(file);
				lblImage.setImage(((Image) image).getScaledInstance(640, 480,
						Image.SCALE_SMOOTH));
				lblImage.setRect(rect);
				lblImage.repaint();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void do_lblImage_mouseDragged(MouseEvent e) {
		rect = lblImage.getRect();
		int xdiff = e.getX() - lastX;
		int ydiff = e.getY() - lastY;

		if (drag) {

			rect.setX(rect.getX() + xdiff);
			rect.setY(rect.getY() + ydiff);
			if (rect.getX() < 0)
				rect.setX(0);
			if (rect.getX() > lblImage.getImage().getWidth(null)
					- rect.getWidth())
				rect.setX(lblImage.getImage().getWidth(null) - rect.getWidth());
			if (rect.getY() < 0)
				rect.setY(0);
			if (rect.getY() > lblImage.getImage().getHeight(null)
					- rect.getHeight())
				rect.setY(lblImage.getImage().getHeight(null)
						- rect.getHeight());
		}

		if (resize) {
			int diff = xdiff + ydiff;
			rect.setWidth(rect.getWidth() + diff);
			rect.setHeight(rect.getHeight() + diff);
			
			if (rect.getWidth() < 100) {
				rect.setWidth(100);
				rect.setHeight(100);
			}
		}

		lblImage.setRect(rect);
		lblImage.repaint();

		lastX = e.getX();
		lastY = e.getY();
	}

	protected void do_lblImage_mousePressed(MouseEvent e) {

		lastX = e.getX();
		lastY = e.getY();

		rect = lblImage.getRect();
		if (e.getX() >= rect.getX()
				&& e.getX() <= rect.getX() + rect.getWidth()
				&& e.getY() == rect.getY()) {
			drag = true;
		}

		if ((e.getX() == rect.getX() + rect.getWidth() && e.getY() >= rect.getY() && e.getY() <= rect.getY() + rect.getHeight()) || 
			(e.getX() >= rect.getX() && e.getX() <= rect.getX() + rect.getWidth() && e.getY() == rect.getY() + rect.getHeight())) {

			resize = true;
		}
	}

	protected void do_lblImage_mouseReleased(MouseEvent e) {
		drag = false;
		resize = false;
	}
	protected void do_okButton_actionPerformed(ActionEvent arg0) {
		BufferedImage bimg = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
		bimg.getGraphics().drawImage(image.getScaledInstance(640, 480, Image.SCALE_SMOOTH), 0, 0, null);
		Image croppedImage = bimg.getSubimage(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight()).getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		BufferedImage bCroppedImage = new BufferedImage(croppedImage.getWidth(null), croppedImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
		bCroppedImage.getGraphics().drawImage(croppedImage, 0, 0, null);
		String[] fileName = file.getName().split("\\.");
		String name = "";
		for (int i = 0; i < fileName.length - 1; i++) {
			name += fileName[i];
		}
		name += "_cropped." + fileName[fileName.length - 1];
		
		
		File f = new File(name);
		try {
			ImageIO.write(bCroppedImage, fileName[fileName.length - 1].toLowerCase(), f);
			this.fileName = name;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.dispose();
		}
	}
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}

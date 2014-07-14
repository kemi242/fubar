package hu.prometheus.fubar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;

public class ImageCropperLabel extends JLabel {

	private Rectangle rect;
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawImage(image, 0, 0, null);
		g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
	}
	
	public ImageCropperLabel(String text) {
		super(text);
	}
	
	
	
}

package hu.prometheus.fubar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private String name;
	private BufferedImage image;
	
	public Player(String name, String fileName) {
		this.name = name;
		try {
			Image img = ImageIO.read(new File(fileName)).getScaledInstance(640, 480, Image.SCALE_SMOOTH);
			this.image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
			this.image.getGraphics().drawImage(img, 0, 0, null);
			img = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}

package hu.prometheus.fubar;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Kartya {
	
	public static final int NORMAL = 0;
	public static final int KERDES = 1;
	public static final int AKCIO = 2;
	public static final int IGYON_AKI = 3;
	public static final int SORSOL = 4;
	public static final int F_V_M = 5;
	
	private BufferedImage image;
	private int tipus;
	
	public Kartya(InputStream input, int tipus) {
		try {
			this.image = ImageIO.read(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tipus = tipus;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public int getTipus() {
		return this.tipus;
	}
	
	
}

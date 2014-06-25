package hu.prometheus.fubar;

import java.awt.Graphics;

public class Line {
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getY1() {
		return y1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public double getY2() {
		return y2;
	}
	public void setY2(double y2) {
		this.y2 = y2;
	}
	
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	private double deg2Rad(double deg) {
		return deg * (Math.PI / 180);
	}
	
	public Line(double x1, double y1, double alpha) {
		double theta = deg2Rad(alpha);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = (x1 * Math.cos(theta) - (Integer.MAX_VALUE) * Math.sin(theta));
		this.y2 = (x1 * Math.sin(theta) + (Integer.MAX_VALUE) * Math.cos(theta));
	}
	
	public void draw(Graphics g, int width) {
		for (double x = 0; x < width; x++) {
			double y = (x - x1) * ((y2 - y1) / (x2 - x1)) + y1;
			g.drawRect((int)x, (int)y, 1, 1);
		}
		
	}
	
	public Line perp(double x3, double y3) {
		double k = ((y2 - y1) * (x3 - x1) - (x2 - x1) * (y3 - y1)) / ((y2 - y1) * (y2 - y1) + (x1 - x1) * (x2 - x1));
		double x4 = x3 - k * (y2 - y1);
		double y4 = y3 + k * (x2 - x1);
		return new Line(x3, y3, x4, y4);
	}
	
	public  double[] pointOnLine(double x, double y) {
		double m = (y2 - y1) / (x2 - x1);
		double b = y1 - (m * x1);
		
		double _x = (m * y + x - m * b) / (m * m + 1);
		double _y = (m * m * y + m * x + b) / (m * m + 1);
		
		double[] point = {_x, _y};
		return point;
		
	}
}
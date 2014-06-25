package hu.prometheus.fubar;

import java.awt.FileDialog;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class DataBase {
	
	public static ArrayList<Player> players;
	public static ArrayList<Kartya> kartyak;
	public static ArrayList<String> kerdesTippek;
	public static ArrayList<String> akcioTippek;
	public static ArrayList<String> igyonAkiTippek;

	public static void init() {
		File f = new File("fubar.db");
		try {
			Class.forName("org.sqlite.JDBC");  
			if (!f.exists()) {
				Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
				Statement s = c.createStatement();
				s.executeUpdate("create table jatekosok (nev varchar(255), kepfajl varchar(255));");
				c.close();
			}
			/*if (f.exists()) {
				f.delete();
			}
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			s.executeUpdate("create table jatekosok (nev varchar(255), kepfajl varchar(255));");
			c.close();*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		players = new ArrayList<Player>();
		
		kartyak = new ArrayList<Kartya>();
		
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 0ka.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 0ko.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 0p.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 0t.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 2.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 2ko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 3.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 3ko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 4.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 4ko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 5.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 5ko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 6.png"), Kartya.KERDES));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 6ko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 7.png"), Kartya.AKCIO));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 7ko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 8.png"), Kartya.F_V_M));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 8ko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 9.png"), Kartya.IGYON_AKI));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya 9ko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya A.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya Ako.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya J.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya Jko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya K.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya Kko.png"), Kartya.SORSOL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya Q.png"), Kartya.NORMAL));
		kartyak.add(new Kartya(DataBase.class.getResourceAsStream("/hu/prometheus/fubar/res/Kartya Qko.png"), Kartya.SORSOL));
				
		try { 
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			if (!c.getMetaData().getTables(null, null, "KerdesTippek", null).next()) {
				s.executeUpdate("create table KerdesTippek (szoveg varchar(255));");
				
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legmer�szebb dolog, amit valaha tett�l?');");
				s.executeUpdate("insert into KerdesTippek values ('Tetszik valaki a k�rben �l�k k�z�l?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi lenn�l, ha testfolyad�k lenn�l?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legfurcs�bb �lmod?');");
				s.executeUpdate("insert into KerdesTippek values ('A k�rben �l�k k�z�l kit fogadn�l el rabszolg�dk�nt, �s mit csin�ltatn�l vele?');");
				s.executeUpdate("insert into KerdesTippek values ('Ha egy napig a m�sik nemb�l val� lenn�l, milyen lenn�l k�ls�leg �s bels�leg?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legfurcs�bb, legtitokzatosabb �lm�nyed az �letedben?');");
				s.executeUpdate("insert into KerdesTippek values ('Ki a p�ldak�ped, ki inspir�l legink�bb?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legdurv�bb dolog, amit r�szegen csin�lt�l?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legizgat�bb szexvide�, amit megn�zt�l?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legjobb vicc, amit hallott�l?');");
				s.executeUpdate("insert into KerdesTippek values ('�lt�zt�l-e m�s az ellenkez� nem viselet�be?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi a legs�t�tebb titkod, amit el mersz mondani?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legcikibb beceneved?');");
				s.executeUpdate("insert into KerdesTippek values ('Mit tal�lsz legink�bb vonz�nak a m�sik nemben?');");
				s.executeUpdate("insert into KerdesTippek values ('Ha v�laszthatn�l egy veled ellenkez� nem� id�s, ig�nytelen ember �s egy veled megegyez� nem�, fiatal, ig�nyes ember k�z�tt, melyikkel fek�dn�l le ink�bb?');");
				s.executeUpdate("insert into KerdesTippek values ('Mit v�lasztan�l: soha t�bb� nem �rinthetsz sz�m�t�g�pet, vagy soha t�bb� nem �rinthetsz ellenkez� nem�t?');");
				s.executeUpdate("insert into KerdesTippek values ('Ki a legszexibb � veled ellenkez� nem� � h�ress�g, szerinted?');");
				s.executeUpdate("insert into KerdesTippek values ('H�ny �vesen cs�kol�zt�l el�sz�r?');");
				s.executeUpdate("insert into KerdesTippek values ('Van-e olyan k�l�nleges dolog, ami t�ged az �tlagn�l jobban ideges�t?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legjobb k�nyv, amit olvast�l?');");
				s.executeUpdate("insert into KerdesTippek values ('Hol l�tod magad 5 �v m�lva?');");
				s.executeUpdate("insert into KerdesTippek values ('Hogy zajlott �leted legpocs�kabb randija?');");
				s.executeUpdate("insert into KerdesTippek values ('Borotv�lkozol\borotv�lkot�l-e � l�nyoknak: nyakt�l f�lfel�, fi�knak: nyakt�l lefel�?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt az �vodai jeled?');");				
			}
			
			
			c.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try { 
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			if (!c.getMetaData().getTables(null, null, "AkcioTippek", null).next()) {
				s.executeUpdate("create table AkcioTippek (szoveg varchar(255));");
				
				s.executeUpdate("insert into AkcioTippek values ('�nekelj el egy sl�gert, amit a t�bbiek v�lasztanak, zen�re!');");
				s.executeUpdate("insert into AkcioTippek values ('A t�bbiek egy deci hideg vizet �ntenek a fejedre, vagy a p�l�dra!');");
				s.executeUpdate("insert into AkcioTippek values ('Ut�nozz el egy �llatot, amit a t�bbiek kital�lnak!');");
				s.executeUpdate("insert into AkcioTippek values ('A t�rsas�g legfiatalabb tagj�t oda-vissza kell vinned a h�tadon n�gyk�zl�b a folyos�n! Ha te vagy a legfiatalabb, akkor a m�sodik legfiatalabbat!');");
				s.executeUpdate("insert into AkcioTippek values ('A t�rsas�g legm�v�szibb tagja rajzoljon a homlokodra valamit!');");
				s.executeUpdate("insert into AkcioTippek values ('Massz�rozd meg annak a h�t�t a j�t�kosok k�z�l, akinek legink�bb sz�ks�ge van r�!');");
				s.executeUpdate("insert into AkcioTippek values ('J�tssz el valakit a csapatb�l, a t�bbiek pedig tal�lj�k ki, hogy ki az!');");
				s.executeUpdate("insert into AkcioTippek values ('Firk�ld f�l a legk�zelebbi alkalmas falra a telefonsz�mod �s a neved, valami k�s�r�sz�veggel!');");
				s.executeUpdate("insert into AkcioTippek values ('Szkanderezz a t�rsas�g legid�sebb f�rfi tagj�val! Ha l�ny vagy, mindk�t kezed haszn�lhatod!');");
				s.executeUpdate("insert into AkcioTippek values ('Ha van Facebook profilod, �ll�tsd be a szerelmi �rdekl�d�sedet hasonl� nem�re egy napig!');");
				s.executeUpdate("insert into AkcioTippek values ('Mer�tsd a kezed csukl�ig a WC viz�be, majd mosd meg a mosd�ban!');");
				s.executeUpdate("insert into AkcioTippek values ('Nyalj meg egy szappant, majd mosd ki a sz�d!');");			
			}
			
			
			c.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try { 
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			if (!c.getMetaData().getTables(null, null, "IgyonAkiTippek", null).next()) {
				s.executeUpdate("create table IgyonAkiTippek (szoveg varchar(255));");
				
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r vert el �gy embert, hogy ottmaradt!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r r�szes�lt olyan er�s ver�sben, hogy ottmaradt!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r �lt�z�tt �s kifestette mag�t ellenkez� nem�nek!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r volt Eur�p�n k�v�l!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r cs�kol�zott k�lf�ldivel!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r ivott annyit, hogy ne tudjon mag�r�l!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r �rt egy komplett zenesz�mot!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r t�bb, mint 1 �ve vezet napl�t, vagy blogot!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r evett szusit!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r aludt s�torban 3, vagy t�bb �jszak�n kereszt�l!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r volt bungee-jumpingolni!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r �lt �t, vagy l�tott megmagyar�zhatatlan esem�nyt!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r esett �t m�t�ten!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r volt 1 �vn�l hosszabb id�szakig kapcsolatban!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r kapott komoly hal�lfenyeget�st!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r l�tott meghalni embert!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r s�rt egy zenesz�m hat�s�ra!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki m�r csin�lt kamu telefonh�v�st!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki l�tt m�r fegyverrel!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki szingli!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki k�lt�tt m�r verset, vagy �rt novell�t!');");				
			}
			
			
			c.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		kerdesTippek = new ArrayList<String>();
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			
			ResultSet res = s.executeQuery("select szoveg from KerdesTippek;");
			
			do {
				kerdesTippek.add(res.getString(1));
			} while (res.next());
			c.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		akcioTippek = new ArrayList<String>();
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			
			ResultSet res = s.executeQuery("select szoveg from AkcioTippek;");
			
			do {
				akcioTippek.add(res.getString(1));
			} while (res.next());
			c.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		igyonAkiTippek = new ArrayList<String>();
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			
			ResultSet res = s.executeQuery("select szoveg from IgyonAkiTippek;");
			
			do {
				igyonAkiTippek.add(res.getString(1));
			} while (res.next());
			c.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Player insertPlayer(String name, String fileName) {
		Player p = new Player(name, fileName);
		players.add(p);
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			s.executeUpdate("insert into jatekosok values ('" + name + "', '" + fileName + "');");
			c.close();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return p;
	}
	
	public static Player getPlayer(String name, JFrame frame) {
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			String fileName = s.executeQuery("select kepfajl from jatekosok where nev = '" + name + "';").getString(1);
			File f = new File(fileName);
			if (!f.exists()) {
				FileDialog fd = new FileDialog(frame);
				fd.setVisible(true);
				fileName = fd.getDirectory() + fd.getFile();
				s.executeUpdate("update jatekosok set kepfajl = '" + fileName + "' where nev = '" + name + "';");
			}
			c.close();
			Player p = new Player(name, fileName);
			players.add(p);
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean playerExists(String name) {
		boolean res = false;
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			res = s.executeQuery("select kepfajl from jatekosok where nev = '" + name + "';").getObject(1) != null;
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	public static Player updatePlayer(String name, String newFileName) {
		try {			
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			s.executeUpdate("update jatekosok set kepfajl = '" + newFileName + "' where nev = '" + name + "';");
			c.close();
			
			for (Player p : players) {
				if (p.getName().equals(name)) {
					p.setImage(ImageIO.read(new File(newFileName)));
					return p;
				}
			}
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void insertKerdesTipp(String tipp) {
		kerdesTippek.add(tipp);
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			s.executeUpdate("insert into KerdesTippek values ('" + tipp + "');");
			c.close();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public static void insertAkcioTipp(String tipp) {
		akcioTippek.add(tipp);
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			s.executeUpdate("insert into AkcioTippek values ('" + tipp + "');");
			c.close();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public static void insertIgyonAkiTipp(String tipp) {
		igyonAkiTippek.add(tipp);
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlite:fubar.db");
			Statement s = c.createStatement();
			s.executeUpdate("insert into IgyonAkiTippek values ('" + tipp + "');");
			c.close();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}

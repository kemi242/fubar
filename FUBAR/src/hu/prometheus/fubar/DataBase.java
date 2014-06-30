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
				
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legmerészebb dolog, amit valaha tettél?');");
				s.executeUpdate("insert into KerdesTippek values ('Tetszik valaki a körben ülők közül?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi lennél, ha testfolyadék lennél?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legfurcsább álmod?');");
				s.executeUpdate("insert into KerdesTippek values ('A körben ülők közül kit fogadnál el rabszolgádként, és mit csináltatnál vele?');");
				s.executeUpdate("insert into KerdesTippek values ('Ha egy napig a másik nemből való lennél, milyen lennél külsőleg és belsőleg?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legfurcsább, legtitokzatosabb élményed az életedben?');");
				s.executeUpdate("insert into KerdesTippek values ('Ki a példaképed, ki inspirál leginkább?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legdurvább dolog, amit részegen csináltál?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legizgatóbb szexvideó, amit megnéztél?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legjobb vicc, amit hallottál?');");
				s.executeUpdate("insert into KerdesTippek values ('Öltöztél-e már az ellenkező nem viseletébe?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi a legsötétebb titkod, amit el mersz mondani?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legcikibb beceneved?');");
				s.executeUpdate("insert into KerdesTippek values ('Mit találsz leginkább vonzónak a másik nemben?');");
				s.executeUpdate("insert into KerdesTippek values ('Ha választhatnál egy veled ellenkező nemű idős, igénytelen ember és egy veled megegyező nemű, fiatal, igényes ember között, melyikkel fekédnél le inkább?');");
				s.executeUpdate("insert into KerdesTippek values ('Mit választanál: soha többé nem érinthetsz számítógépet, vagy soha többé nem érinthetsz ellenkező neműt?');");
				s.executeUpdate("insert into KerdesTippek values ('Ki a legszexibb veled ellenkező nemű híresség, szerinted?');");
				s.executeUpdate("insert into KerdesTippek values ('Hány évesen csókolóztál először?');");
				s.executeUpdate("insert into KerdesTippek values ('Van-e olyan különleges dolog, ami téged az átlagnál jobban idegesít?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt a legjobb könyv, amit olvastál?');");
				s.executeUpdate("insert into KerdesTippek values ('Hol látod magad 5 év múlva?');");
				s.executeUpdate("insert into KerdesTippek values ('Hogy zajlott életed legpocsékabb randija?');");
				s.executeUpdate("insert into KerdesTippek values ('Borotválkozol\borotválkotál-e (lányoknak: nyaktól fölfelé, fiúknak: nyaktól lefelé?');");
				s.executeUpdate("insert into KerdesTippek values ('Mi volt az óvodai jeled?');");				
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
				
				s.executeUpdate("insert into AkcioTippek values ('Énekelj el egy slágert, amit a többiek választanak, zenére!');");
				s.executeUpdate("insert into AkcioTippek values ('A többiek egy deci hideg vizet öntenek a fejedre, vagy a pólódra!');");
				s.executeUpdate("insert into AkcioTippek values ('Utánozz el egy állatot, amit a többiek kitalálnak!');");
				s.executeUpdate("insert into AkcioTippek values ('A társaság legfiatalabb tagját oda-vissza kell vinned a hátadon négykézláb a folyosón! Ha te vagy a legfiatalabb, akkor a második legfiatalabbat!');");
				s.executeUpdate("insert into AkcioTippek values ('A társaság legművészibb tagja rajzoljon a homlokodra valamit!');");
				s.executeUpdate("insert into AkcioTippek values ('Masszírozd meg annak a hátát a játékosok közül, akinek leginkább szüksége van rá!');");
				s.executeUpdate("insert into AkcioTippek values ('Játssz el valakit a csapatból, a többiek pedig találják ki, hogy ki az!');");
				s.executeUpdate("insert into AkcioTippek values ('Firkáld föl a legközelebbi alkalmas falra a telefonszámod és a neved, valami kísérőszöveggel!');");
				s.executeUpdate("insert into AkcioTippek values ('Szkanderezz a társaság legidősebb férfi tagjával! Ha lány vagy, mindkét kezed használhatod!');");
				s.executeUpdate("insert into AkcioTippek values ('Ha van Facebook profilod, állítsd be a szerelmi érdeklődésedet hasonló neműre egy napig!');");
				s.executeUpdate("insert into AkcioTippek values ('Merítsd a kezed csuklóig a WC vizébe, majd mosd meg a mosdóban!');");
				s.executeUpdate("insert into AkcioTippek values ('Nyalj meg egy szappant, majd mosd ki a szád!');");			
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
				
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már vert el úgy embert, hogy ottmaradt!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már részesült olyan erős verésben, hogy ottmaradt!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már öltözött és kifestette magát ellenkező neműnek!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már volt Európán kívül!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már csókolózott külföldivel!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már ivott annyit, hogy ne tudjon magáról!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már �rt egy komplett zenesz�mot!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már több, mint 1 éve vezet naplót, vagy blogot!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már evett szusit!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már aludt sátorban 3, vagy több éjszakán keresztül!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már volt bungee-jumpingolni!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már élt át, vagy látott megmagyarázhatatlan eseményt!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már esett át műtéten!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már volt 1 évnél hosszabb időszakig kapcsolatban!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már kapott komoly halálfenyegetést!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már látott meghalni embert!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már sírt egy zeneszám hatására!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki már csinált kamu telefonhívást!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki lőtt már fegyverrel!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki szingli!');");
				s.executeUpdate("insert into IgyonAkiTippek values ('Igyon, aki költött már verset, vagy írt novellát!');");				
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

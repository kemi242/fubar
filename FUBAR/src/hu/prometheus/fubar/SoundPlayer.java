package hu.prometheus.fubar;

import java.io.IOException;
import java.net.URL;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.protocol.URLDataSource;

public class SoundPlayer {
	static void play(URL fileName) {
		try {
			URLDataSource uds = new URLDataSource(fileName);
			uds.connect();
			javax.media.Player p = Manager.createPlayer(uds);
			p.start();
		} catch (NoPlayerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

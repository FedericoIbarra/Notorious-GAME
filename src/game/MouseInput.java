package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import audio.Player;
import highscore.TabladeRegistros;
import pages.Game;

public class MouseInput implements MouseListener{
	
	public void mousePressed(MouseEvent e) {
		int mx=e.getX();
		int my=e.getY();
		TabladeRegistros h = null;
		h=new TabladeRegistros();
		//System.out.println(mx);
		//System.out.println(my+"\n");
		//*******************MENU***********************//
		//PLAY
		if(mx>= Game.WIDTH/2+120 && mx<=Game.WIDTH/2+220 && Game.State==Game.STATE.MENU){
			if(my>=160 && my<= 180){
				Game.State=Game.STATE.SONG;
			}
		}
		//HELP
		if(mx>= Game.WIDTH/2+120 && mx<=Game.WIDTH/2+220 && Game.State==Game.STATE.MENU){
			if(my>=260 && my<= 280){
				Game.State=Game.STATE.HELP;
			}
		}
		//QUIT
		if(mx>= Game.WIDTH/2+120 && mx<=Game.WIDTH/2+220 && Game.State==Game.STATE.MENU){
			if(my>=360 && my<= 380){
				System.exit(1);
			}
		}
		//HIGHSCORES
		if(mx>= 469 && mx<=635 && Game.State==Game.STATE.MENU){
			if(my>=14 && my<= 33){
				Game.State=Game.STATE.HIGHSC;
			}
		}
		//*******************SONG***********************//
		//SELECT
		if(mx>= 59 && mx<=176 && Game.State==Game.STATE.SONG){
			if(my>=277 && my<= 300){
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Musica", "mp3", "wav");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(chooser);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	GameStat.path = chooser.getSelectedFile().getPath();
			    	GameStat.songName = chooser.getSelectedFile().getName();
			    }
			}
		}
		//START
		if(mx>= 260 && mx<=430 && Game.State==Game.STATE.SONG){
			if(my>=277 && my<= 300){
				Game.State=Game.STATE.LEVEL;
			}
		}
		//RETURN
		if(mx>= 450 && mx<=600 && Game.State==Game.STATE.SONG){
			if(my>=410 && my<= 430){
				Game.State=Game.STATE.MENU;
			}
		}
		//*******************HELP***********************//
		//RETURN
		if(mx>= 450 && mx<=600 && Game.State==Game.STATE.HELP){
			if(my>=410 && my<= 430){
				Game.State=Game.STATE.MENU;
			}
		}
		//*******************HIGHSCORES***********************//
		//RESET
		if(mx>= 102 && mx<=197 && Game.State==Game.STATE.HIGHSC){
			if(my>=410 && my<= 430){
				h.LimpiarPuntuajes();
			}
		}
		//RETURN
		if(mx>= 450 && mx<=600 && Game.State==Game.STATE.HIGHSC){
			if(my>=410 && my<= 430){
				Game.State=Game.STATE.MENU;
			}
		}	
		//*******************GAME***********************//
		//PAUSA
		if(mx>= 450 && mx<=600 && Game.State==Game.STATE.GAME){
			if(my>=410 && my<= 430){
				Game.State=Game.STATE.PAUSE;
				Player.pauseSong();
			}
		}
		//*******************PAUSE***********************//
		//KEEP
		if(mx>=220 && mx<=400 && Game.State==Game.STATE.PAUSE){
			if(my>=180 && my<= 230){
				Game.State=Game.STATE.GAME;
				GameStat.keep=0;
			}
		}
		//BAIL
		if(mx>=220 && mx<=400 && Game.State==Game.STATE.PAUSE){
			if(my>=280 && my<= 330){
				Game.State=Game.STATE.GAME;
				GameStat.setEnd(1);
				GameStat.setEStat(2);
				try{Thread.sleep(50);}catch(Exception ex){}
				Game.State=Game.STATE.ENDG;
				Player.player.close();
			}
		}
		//******************LEVEL**********************
		//EASY-A
		if(mx>=  302 && mx<=374 && Game.State==Game.STATE.LEVEL){
			if(my>=208 && my<= 229){
				GameStat.setDifficulty(5);
				GameStat.keep=0;
				GameStat.position=0;
				GameStat.setSDif(1);
				GameStat.setEnd(0);
				audio.AudioProcessor.main();
				audio.Player.main();
				try{Thread.sleep(1000);}catch(Exception ex){}
				Game.State=Game.STATE.GAME;
			}
		}
		//MEDIUM
		if(mx>= 287 && mx<=403 && Game.State==Game.STATE.LEVEL){
			if(my>=308 && my<= 329){
				GameStat.setDifficulty(5);
				GameStat.keep=0;
				GameStat.position=0;
				GameStat.setSDif(2);
				GameStat.setEnd(0);
				audio.AudioProcessor.main();
				audio.Player.main();
				try{Thread.sleep(1000);}catch(Exception ex){}
				Game.State=Game.STATE.GAME;
			}
		}
		//HARD
		if(mx>= 302 && mx<=384 && Game.State==Game.STATE.LEVEL){
			if(my>=408 && my<= 431){
				GameStat.setDifficulty(5);
				GameStat.keep=0;
				GameStat.position=0;
				GameStat.setSDif(3);
				GameStat.setEnd(0);
				audio.AudioProcessor.main();
				audio.Player.main();
				try{Thread.sleep(1000);}catch(Exception ex){}
				Game.State=Game.STATE.GAME;
			}
		}
		//RETURN
		else if(mx>= 502 && mx<=625 && Game.State==Game.STATE.LEVEL){
			if(my>=428 && my<= 450){
				Game.State=Game.STATE.SONG;
			}
		}	
		//*******************ENDGAME***********************//
		//RETURN
		if(mx>= 450 && mx<=600 && Game.State==Game.STATE.ENDG){
			if(my>=410 && my<= 430){
				GameStat.i=0;
				GameStat.setScore(0);
				GameStat.setEnd(1);
				GameStat.setStatus(50);
				try{Thread.sleep(5);}catch(Exception ex){}
				Game.State=Game.STATE.MENU;
			}
		}
	}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}

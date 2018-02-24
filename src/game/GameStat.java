package game;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class GameStat {
	private static int statDif=3;
	private static int score=0;
	private static int status=50;
	private static int endstat=0;
	private static int endgame=0;
	private static double difficulty = 0;
	private static int value;
	
	public static Queue <Integer> cola = new ArrayDeque<Integer>();
	public static String path = "/Users/federicoibarra/Music/iTunes/iTunes Media/Music/Beach Boys/Greatest Hits/08 Surfin' U.S.A..mp3";//magnets_(ft._lorde)//Hasta que te conoci
	//04 The Proclaimers - I'm Gonna Be (500 Miles)
	public static int i=0;
	public static int position=0;
	public static int keep=0;
	public static int lenght=0;
	public static String songName;
	
	public static int getValue() {
		return value;
	}
	
	public static void setValue(int nvalue) {
		value=nvalue;
	}
	
	///////////////////////////////////////
	public static int getScore() {
		return score;
	}
	
	public  static void setScore(int nscore) {
		score = nscore;
	}
	///////////////////////////////////////
	public static int getEStat() {
		return endstat;
	}
	
	public  static void setEStat(int nendstat) {
		endstat = nendstat;
	}
	///////////////////////////////////////
	public static int getEnd() {
		return endgame;
	}
	
	public  static void setEnd(int egame) {
		endgame = egame;
	}
	///////////////////////////////////////
	public static int getStatus() {
		return status;
	}
	
	public  static void setStatus(int nsucces) {
		status = (nsucces<=101)?nsucces:status;
	}
	///////////////////////////////////////
	public static double getDifficulty() {
		return difficulty;
	}
	
	public  static void setDifficulty(double dif) {
		difficulty = dif;
	}
	//////////////////////////////////////
	public static int getSDif() {
		return statDif;
	}
	
	public  static void setSDif(int sd) {
		statDif = sd;
	}
	
	public static String getNameSong(){
		File f= new File(path);
		
		return f.getName();
	}
	
}

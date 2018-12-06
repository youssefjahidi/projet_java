package myUber;

import java.util.Date;

public class Calcul {
	
	public static String hour() {
		Date maDate = new Date();
		String heure;
		heure = maDate.toString().split(" ")[3];
		return heure;
	}

	
	// Donne la duréé du trajet en min donnée en argument
	public static int duration(double length, int hour) {
		if(hour > 23 || hour <0) {
			String time = Calcul.hour();
			String[] time2 = time.split(":");
			hour = Integer.parseInt(time2[0]);
		}
		
		double averagespeed;
		
		if(hour<7 || hour>22) {averagespeed = 0.95*15 + 0.04*7.5 + 0.01*3;}
		else if(hour>=7 && hour<11) {averagespeed = 0.05*15 + 0.20*7.5 + 0.75*3;}
		else if(hour>=7 && hour<11) {averagespeed = 0.15*15 + 0.70*7.5 + 0.15*3;}
		else  {averagespeed = 0.01*15 + 0.04*7.5 + 0.95*3;}
		
		return (int) (60/averagespeed * length);
	}
	// Donne l'heure d'arrivé du trajet
	public static String arrival_time(double length) {
		int durée = Calcul.duration(length,-1);
		String temps = Calcul.hour();
		String[] temps2 = temps.split(":");
		int heure = Integer.parseInt(temps2[0]);
		int minute = Integer.parseInt(temps2[1]);
		minute += durée %60;
		heure += durée/60;
		return heure + ":" +minute + ":"+temps2[2];
	}
	
	public static String arrival_time(double length, String time) {
		String temps = time;
		String[] temps2 = temps.split(":");
		int heure = Integer.parseInt(temps2[0]);
		int minute = Integer.parseInt(temps2[1]);
		int durée = Calcul.duration(length,heure);
		minute += durée %60;
		heure += durée/60;
		return heure + ":" +minute + ":"+temps2[2];
	}
	
	public static int arrival_hour(double length) {
		int durée = Calcul.duration(length,-1);
		String temps = Calcul.hour();
		String[] temps2 = temps.split(":");
		int heure = Integer.parseInt(temps2[0]);
		int minute = Integer.parseInt(temps2[1]);
		minute += durée %60;
		heure += durée/60;
		return heure ;
		
	}
	

}
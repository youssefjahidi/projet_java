package myUber;

import java.util.Date;

public class Calcul {
	// coordonn�e gps d'un point : int�int'int", int�int'int"
	// la premi�re partie correspond � la latitude et la deuxi�me partie � la longitude
	public static double distance(String GPS1, String GPS2) {
		// On s�pare la longitude et la latidude de la premi�re coordonn�e
		String[] part1 = GPS1.split(", ");		
		
		// Puis on s�pare chaque partie pour pouvoir calculer la vrai latidude
		String[] part1_1 = part1[0].split("�");
		String[] part1_2 = part1_1[1].split("'");
		String[] part1_3 = part1_2[1].split("\"");
				
		double lat1 = Integer.parseInt(part1_1[0])
		+(double)  Integer.parseInt(part1_2[0])/60 
		+ (double) Float.parseFloat(part1_3[0])/3600;		
		
		// Puis on s�pare chaque partie pour pouvoir calculer la vrai longitude
		String[] part2_1 = part1[1].split("�");
		String[] part2_2 = part2_1[1].split("'");
		String[] part2_3 = part2_2[1].split("\"");
				
		double long1 = Integer.parseInt(part2_1[0])
		+(double)  Integer.parseInt(part2_2[0])/60 
		+ (double) Float.parseFloat(part2_3[0])/3600;
		

		
		// On fait de m�me avec la deuxi�me chaine de caract�re
		String[] part2 = GPS2.split(", ");		
		
		part1_1 = part2[0].split("�");
		part1_2 = part1_1[1].split("'");
		part1_3 = part1_2[1].split("\"");
				
		double lat2 = Integer.parseInt(part1_1[0])
		+(double)  Integer.parseInt(part1_2[0])/60 
		+ (double) Float.parseFloat(part1_3[0])/3600;		
		
		
		part2_1 = part2[1].split("�");
		part2_2 = part2_1[1].split("'");
		part2_3 = part2_2[1].split("\"");
		
		double long2 = Integer.parseInt(part2_1[0])
		+(double)  Integer.parseInt(part2_2[0])/60 
		+ (double) Float.parseFloat(part2_3[0])/3600;
		
		// On calcule la distance en km avec toutes les longitudes et latitudes
		double rad = Math.PI /180;
		
		double ini = Math.sin(rad *lat1) * Math.sin(rad*lat2) + Math.cos(rad*lat1) * Math.cos(rad*lat2) * Math.cos(rad *(long1-long2));
		double acos = Math.acos(ini);
		double dist = acos * 180/Math.PI * 60 * 1.1515;
		
		return(dist* 1.609344);

	}
	
	public static String heure() {
		Date maDate = new Date();
		String heure;
		heure = maDate.toString().split(" ")[3];
		return heure;
	}

}

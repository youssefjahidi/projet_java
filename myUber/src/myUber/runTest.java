package myUber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import Car.Berline;
import Car.CarFactory;
import Car.Standard;
import Car.*;
import Rides.Rides;
import Users.Customer;
import Users.Driver;


public class runTest {

	public static void main(String[] args) {
	      FileInputStream fis = null;
          String string = "";

	      try {
	      fis = new FileInputStream(new File("C:\\Users\\axel\\eclipse-workspace\\myUber2\\ini.ini"));
    	  int n = 0;
          byte[] buf = new byte[8];

	      while ((n = fis.read(buf)) >= 0) {
	            // On affiche ce qu'a lu notre boucle au format byte et au
	            // format char
	            for (byte bit : buf) {
	            	string = string + (char)bit;
	            }

	            //Nous réinitialisons le buffer à vide
	            //au cas où les derniers byte lus ne soient pas un multiple de 8
	            //Ceci permet d'avoir un buffer vierge à chaque lecture et ne pas avoir de doublon en fin de fichier
	            buf = new byte[8];

	         }
	      }
	      catch (FileNotFoundException e) {
	          // Cette exception est levée si l'objet FileInputStream ne trouve
	          // aucun fichier
	          e.printStackTrace();
	       }
	      catch (IOException e) {
	            e.printStackTrace();
	         }
	    String[] parsed = string.split("\n");
		System.out.println(parsed[1] );
	}

}
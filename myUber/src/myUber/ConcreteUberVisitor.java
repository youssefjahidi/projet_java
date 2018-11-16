package myUber;

public class ConcreteUberVisitor implements UberVisitor {

	@Override
	public double visit(UberX uberX) {
		double basicRate;
		double trafficRate;
		double length = uberX.getlength();
		String time = Calcul.heure();
		int heure = Integer.parseInt(time.split(":")[0]);
		
		if(length<=5) {basicRate = 3.3; }
		else if(length<=10) {basicRate =4.2;}
		else if(length<=20) {basicRate =1.91;}
		else {basicRate =1.5;}
		
		if(heure<7 || heure>22) {trafficRate = 0.95 + 0.04*1.1 + 0.01*1.5;}
		else if(heure>=7 && heure<11) {trafficRate = 0.05 + 0.20*1.1 + 0.75*1.5;}
		else if(heure>=7 && heure<11) {trafficRate = 0.15 + 0.70*1.1 + 0.15*1.5;}
		else  {trafficRate = 0.01 + 0.04*1.1 + 0.95*1.5;}
		
		return trafficRate*basicRate*length;

		}

	@Override
	public double visit(UberVan uberVan) {
		double basicRate;
		double trafficRate;
		double length = uberVan.getlength();
		String time = Calcul.heure();
		int heure = Integer.parseInt(time.split(":")[0]);
		
		if(length<=5) {basicRate = 6.2; }
		else if(length<=10) {basicRate =7.7;}
		else if(length<=20) {basicRate =3.25;}
		else {basicRate =2.6;}
		
		if(heure<7 || heure>22) {trafficRate = 0.95 + 0.04*1.5 + 0.01*1.8;}
		else if(heure>=7 && heure<11) {trafficRate = 0.05 + 0.20*1.5 + 0.75*1.8;}
		else if(heure>=7 && heure<11) {trafficRate = 0.15 + 0.70*1.5 + 0.15*1.8;}
		else  {trafficRate = 0.01 + 0.04*1.5 + 0.95*1.8;}
		
		return trafficRate*basicRate*length;
	}

	@Override
	public double visit(UberPool uberPool) {
		double basicRate;
		double trafficRate;
		double length = uberPool.getlength();
		String time = Calcul.heure();
		int heure = Integer.parseInt(time.split(":")[0]);
		
		if(length<=5) {basicRate = 2.4; }
		else if(length<=10) {basicRate =3;}
		else if(length<=20) {basicRate =1.3;}
		else {basicRate =1.1;}
		
		if(heure<7 || heure>22) {trafficRate = 0.95 + 0.04*1.1 + 0.01*1.2;}
		else if(heure>=7 && heure<11) {trafficRate = 0.05 + 0.20*1.1 + 0.75*1.2;}
		else if(heure>=7 && heure<11) {trafficRate = 0.15 + 0.70*1.1 + 0.15*1.2;}
		else  {trafficRate = 0.01 + 0.04*1.1 + 0.95*1.2;}
		
		return trafficRate*basicRate*length;
	}


	@Override
	public double visit(UberBlack uberBlack) {
		double basicRate;
		double trafficRate;
		double length = uberBlack.getlength();
		String time = Calcul.heure();
		int heure = Integer.parseInt(time.split(":")[0]);
		
		if(length<=5) {basicRate = 6.2; }
		else if(length<=10) {basicRate =5.5;}
		else if(length<=20) {basicRate =3.25;}
		else {basicRate =2.6;}
		
		if(heure<7 || heure>22) {trafficRate = 0.95 + 0.04*1.3 + 0.01*1.6;}
		else if(heure>=7 && heure<11) {trafficRate = 0.05 + 0.20*1.3 + 0.75*1.6;}
		else if(heure>=7 && heure<11) {trafficRate = 0.15 + 0.70*1.3 + 0.15*1.6;}
		else  {trafficRate = 0.01 + 0.04*1.3 + 0.95*1.6;}
		
		return trafficRate*basicRate*length;
	}
}

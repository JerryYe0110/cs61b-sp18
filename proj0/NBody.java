/**
* NBody
*/

public class NBody {

	public static double readRadius(String PATH) {
		In data = new In(PATH);
		String R = data.readLine();
		R = data.readLine();
		return Double.parseDouble(R);
	}

	public static Planet[] readPlanets(String PATH) {
		In data = new In(PATH);
		int length = data.readInt();
		double xxPos, yyPos, xxVel, yyVel, mass;
		String img;
		img = data.readLine();
		img = data.readLine();
		Planet[] AllPlanet= new Planet[length];
		for (int i = 0; i<length ; i++) {
		  xxPos = data.readDouble();
		  yyPos = data.readDouble();
		  xxVel = data.readDouble();
		  yyVel = data.readDouble();
		  mass = data.readDouble();
		  img = data.readString();
		  AllPlanet[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,img);
		  img = data.readLine();
		}
		return AllPlanet;
	}
	public static void main(String[] args) {
		double T  = Double.parseDouble(args[0]); 
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double R  = readRadius(filename);
		Planet[] AllPlanet = readPlanets(filename);
		String imageToDraw = "images/starfield.jpg";
		StdDraw.enableDoubleBuffering();
		double currTime = 0;
		double[] xForces = new double[AllPlanet.length];
		double[] yForces = new double[AllPlanet.length];
		while (currTime <= T) {
		  StdDraw.clear();
		  StdDraw.setScale(-R, R);
		  StdDraw.picture(0, 0, imageToDraw);
		  for (int i = 0; i < AllPlanet.length; i++) {
			 AllPlanet[i].draw();
		  }
		  for (int i = 0; i < yForces.length; i++) {
			 xForces[i] = AllPlanet[i].calcNetForceExertedByX(AllPlanet);
			 yForces[i] = AllPlanet[i].calcNetForceExertedByY(AllPlanet);
		  }
		  for (int i = 0; i < yForces.length; i++) {
			 AllPlanet[i].update(dt, xForces[i], yForces[i]);
		  }
		  StdDraw.show();
		  StdDraw.pause(10);
		  currTime += dt;
		}
		StdOut.printf("%d\n", AllPlanet.length);
		StdOut.printf("%.2e\n", R);
		for (int i = 0; i < AllPlanet.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  AllPlanet[i].xxPos, AllPlanet[i].yyPos, AllPlanet[i].xxVel,
                  AllPlanet[i].yyVel, AllPlanet[i].mass,  AllPlanet[i].imgFileName);   
		}
		}
	}

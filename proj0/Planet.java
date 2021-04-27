/**
* Planet
*/
public class Planet extends Body{
  static final double G = 6.67e-11;
  public Planet(double xP, double yP, double xV, double yV, double m, String img ){
			 super(xP, yP, xV, yV, m, img);
  }
  public Planet(Body b){
	 super(b);
  }
	 public double calcDistance(Body b) {
			 double dx = this.xxPos - b.xxPos;
			 double dy = this.yyPos - b.yyPos;
			 return Math.sqrt(dx*dx +dy*dy);
	 }
	 public double calcForceExertedBy(Body b) {
		double distance = this.calcDistance(b);
		return G * this.mass * b.mass /(distance*distance);
	 }
	 public double calcForceExertedByX(Body b) {
	 	double distance = this.calcDistance(b);
		double Force = this.calcForceExertedBy(b);
		double dx = b.xxPos - this.xxPos;
		return Force * dx / distance;
	 }
	 public double calcForceExertedByY(Body b) {
	 	double distance = this.calcDistance(b);
		double Force = this.calcForceExertedBy(b);
		double dy = b.yyPos - this.yyPos;
		return Force * dy / distance;
	 }
	 public double calcNetForceExertedByX(Body[] Bodys) {
		double sum = 0;
	 	for (int i = 0; i < Bodys.length; i++) {
	 		if (!this.equals(Bodys[i])) {
	 			sum += this.calcForceExertedByX(Bodys[i]);
	 		}
	 	}
		return sum;
	 }
	 public double calcNetForceExertedByY(Body[] Bodys) {
		double sum = 0;
	 	for (int i = 0; i < Bodys.length; i++) {
	 		if (!this.equals(Bodys[i])) {
	 			sum += this.calcForceExertedByY(Bodys[i]);
	 		}
	 	}
		return sum;
	 }
	 public void update(double dt, double fX, double fY) {
	 	double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel += aX*dt;
		this.yyVel += aY*dt;
		this.xxPos += xxVel*dt;
		this.yyPos += yyVel*dt;
	 }
}

/**
* Planet
*/
public class Planet{
   static final double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	String imgFileName;
  public Planet(double xP, double yP, double xV, double yV, double m, String img ){
	 	this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
  }
  public Planet(Planet b){
	 	this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
  }
	 public double calcDistance(Planet b) {
			 double dx = this.xxPos - b.xxPos;
			 double dy = this.yyPos - b.yyPos;
			 return Math.sqrt(dx*dx +dy*dy);
	 }
	 public double calcForceExertedBy(Planet b) {
		double distance = this.calcDistance(b);
		return G * this.mass * b.mass /(distance*distance);
	 }
	 public double calcForceExertedByX(Planet b) {
	 	double distance = this.calcDistance(b);
		double Force = this.calcForceExertedBy(b);
		double dx = b.xxPos - this.xxPos;
		return Force * dx / distance;
	 }
	 public double calcForceExertedByY(Planet b) {
	 	double distance = this.calcDistance(b);
		double Force = this.calcForceExertedBy(b);
		double dy = b.yyPos - this.yyPos;
		return Force * dy / distance;
	 }
	 public double calcNetForceExertedByX(Planet[] Bodys) {
		double sum = 0;
	 	for (int i = 0; i < Bodys.length; i++) {
	 		if (!this.equals(Bodys[i])) {
	 			sum += this.calcForceExertedByX(Bodys[i]);
	 		}
	 	}
		return sum;
	 }
	 public double calcNetForceExertedByY(Planet[] Bodys) {
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

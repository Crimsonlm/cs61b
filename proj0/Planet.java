public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	private static final double G = 6.67e-11;

	public Planet(double xP,double yP , double xV, double yV,double m, String img){
	this.xxPos = xP;
	this.yyPos = yP;
	this.xxVel = xV;
	this.yyVel = yV;
	this.mass = m;
	this.imgFileName = img;
	}
	public Planet(Planet p){
	this.xxPos = p.xxPos;
	this.yyPos = p.yyPos;
	this.xxVel = p.xxVel;
	this.yyVel = p.yyVel;
	this.mass = p.mass;
	this. imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		double dx = this.xxPos-p.xxPos;
		double dy = this.yyPos-p.yyPos;
		return Math.sqrt(dx*dx+dy*dy);
	}
	public double calcForceExertedBy(Planet p){
		return G*this.mass*p.mass/this.calcDistance(p)/this.calcDistance(p);

	}
	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}
		public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double F = 0 ;
		for(int i =0;i<allPlanets.length;i++){
			if((this.equals(allPlanets[i])!=true)){
				F+= this.calcForceExertedByX(allPlanets[i]);
			}
		}
		return F;
	}
		public double calcNetForceExertedByY(Planet[] allPlanets){
		double F = 0 ;
		for(int i =0;i<allPlanets.length;i++){
			if((this.equals(allPlanets[i])!=true)){
				F+= this.calcForceExertedByY(allPlanets[i]);
			}
		}
		return F;
	}
	public void update(double dt,double fX, double fY){
		double ax = fX/this.mass;
		double ay = fY/this.mass;
		xxVel = xxVel + dt * ax;
		yyVel = yyVel +dt * ay;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;

	}
	public void draw(){
		StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
	}
}
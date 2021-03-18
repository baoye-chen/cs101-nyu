
public class QuadraticEquation 
{
	private double a;
	private double b;
	private double c;

	QuadraticEquation(double aval, double bval, double cval)
	{
		this.a = aval;
		this.b = bval;
		this.c = cval;
	}
	
	double geta()
	{
		return this.a;
	}
	
	double getb()
	{
		return this.b;
	}
	
	double getc()
	{
		return this.c;
	}
	
	void seta(double newa)
	{
		this.a = newa;
	}
	
	void setb(double newb)
	{
		this.b = newb;
	}
	
	void setc(double newc)
	{
		this.c = newc;
	}

	double getDiscriminant() 
	{
		return Math.pow(this.b, 2) - 4*this.a*this.c;
	}
	
	boolean hasRealSolution()
	{
		return this.getDiscriminant() >= 0;
	}
	
	boolean isQuadratic()
	{
		return this.a != 0;
	}
	
	boolean hasDuplicateSolution()
	{
		return this.getDiscriminant() == 0;
	}
	
	double getSolution1()
	{
		double out = (-this.b + Math.sqrt(this.getDiscriminant()))/(2*this.a);
		
		return out;
	}
	
	double getSolution2()
	{
		double out = (-this.b - Math.sqrt(this.getDiscriminant()))/(2*this.a);
		
		return out;
	}
	
	public static void main(String[] args)
	{
		QuadraticEquation noSolution = new QuadraticEquation(1, 1, 2);
		QuadraticEquation oneSolution = new QuadraticEquation(1, 2, 1);
		QuadraticEquation twoSolution = new QuadraticEquation(1, 2, -8);
		QuadraticEquation notQuadratic = new QuadraticEquation(0, 1, 2);
		
		System.out.println("noSolution: f(x) = " + noSolution.geta() + "x^2 + " + noSolution.getb() + "x + " + noSolution.getc());
		System.out.println("Is noSolution quadratic? " + noSolution.isQuadratic());
		System.out.println("Does noSolution have real solution? " + noSolution.hasRealSolution());
		System.out.println("Does noSolution have duplicate solution? " + noSolution.hasDuplicateSolution());
		System.out.println("Discriminant = " + noSolution.getDiscriminant());
		System.out.println("The solution to this equation is: x1 = " + noSolution.getSolution1());
		System.out.println("The solution to this equation is: x2 = " + noSolution.getSolution2());
		System.out.println("");
		
		System.out.println("oneSolution: f(x) = " + oneSolution.geta() + "x^2 + " + oneSolution.getb() + "x + " + oneSolution.getc());
		System.out.println("Is oneSolution quadratic? " + oneSolution.isQuadratic());
		System.out.println("Does oneSolution have real solution? " + oneSolution.hasRealSolution());
		System.out.println("Does oneSolution have duplicate solution? " + oneSolution.hasDuplicateSolution());
		System.out.println("Discriminant = " + oneSolution.getDiscriminant());
		System.out.println("The solution to this equation is: x1 = " + oneSolution.getSolution1());
		System.out.println("The solution to this equation is: x2 = " + oneSolution.getSolution2());
		System.out.println("");
		
		System.out.println("twoSolution: f(x) = " + twoSolution.geta() + "x^2 + " + twoSolution.getb() + "x + " + twoSolution.getc());
		System.out.println("Is twoSolution quadratic? " + twoSolution.isQuadratic());
		System.out.println("Does twoSolution have real solution? " + twoSolution.hasRealSolution());
		System.out.println("Does twoSolution have duplicate solution? " + twoSolution.hasDuplicateSolution());
		System.out.println("Discriminant = " + twoSolution.getDiscriminant());
		System.out.println("The solution to this equation is: x1 = " + twoSolution.getSolution1());
		System.out.println("The solution to this equation is: x2 = " + twoSolution.getSolution2());
		System.out.println("");
		
		System.out.println("notQuadratic: f(x) = " + notQuadratic.geta() + "x^2 + " + notQuadratic.getb() + "x + " + notQuadratic.getc());
		System.out.println("Is notQuadratic quadratic? " + notQuadratic.isQuadratic());
		System.out.println("Does notQuadratic have real solution? " + notQuadratic.hasRealSolution());
		System.out.println("Does notQuadratic have duplicate solution? " + notQuadratic.hasDuplicateSolution());
		//System.out.println("The solution to this equation is: x1 = " + notQuadratic.getSolution1());
		//System.out.println("The solution to this equation is: x2 = " + notQuadratic.getSolution2());
	}
}


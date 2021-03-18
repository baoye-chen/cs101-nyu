
public class Triangle extends GeometricObject
{	
	double base;
	double line2, line3;
	
	public Triangle(double base, double line2, double line3, double x, double y)
	{
		super(x,y);
		this.base = base;
		this.line2 = line2;
		this.line3 = line3;
	}
	
	public double getBase()
	{
		return this.base;
	}
	
	public void setBase(double base)
	{
		this.base = base;
	}
	
	public double getline2()
	{
		return this.line2;
	}
	
	public void setline2(double line2)
	{
		this.line2 = line2;
	}
	
	public double getline3()
	{
		return this.line2;
	}
	
	public void setline3(double line3)
	{
		this.line3 = line3;
	}
	
	@Override
	public double getArea()
	{
		double p = this.getPerimeter() / 2;
		return Math.sqrt(p * ((p - this.base) * (p - this.line2) * (p - this.line3)));
	}
	
	@Override
	public double getPerimeter() 
	{
		return this.base + this.line2 + this.line3;
	}
}

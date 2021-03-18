
public class Triangle 
{
	double line1, line2, line3;
	
	public Triangle(double line1, double line2, double line3) throws IllegalTriangleException
	{
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		
		if(line1 + line2 <= line3 || line1 + line3 <= line2 || line2 + line3 <= line1)
		{
			throw new IllegalTriangleException(line1, line2, line3);
		}
	}
	
	public double getline1()
	{
		return this.line1;
	}
	
	public void setline1(double line1)
	{
		this.line1 = line1;
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
	
	public double getArea()
	{
		double p = this.getPerimeter() / 2;
		return Math.sqrt(p * ((p - this.line1) * (p - this.line2) * (p - this.line3)));
	}
	
	public double getPerimeter() 
	{
		return this.line1 + this.line2 + this.line3;
	}
}

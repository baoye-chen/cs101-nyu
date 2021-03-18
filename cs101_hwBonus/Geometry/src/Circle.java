
public class Circle extends GeometricObject
{
	double radius;
	
	public Circle(double radius, double x, double y)
	{
		super(x,y);
		this.radius = radius;
	}
	
	public double getRadius() 
	{
		return this.radius;
	}
	
	public void setRadius(double radius) 
	{
		this.radius = radius;
	}
	
	@Override
	public double getArea()
	{
		if(this.radius <= 0)
		{
			return -1;
		}
		else
		{
			return this.radius * this.radius * Math.PI;
		}
	}
	
	@Override
	public double getPerimeter()
	{
		if(radius <= 0)
		{
			return -1;
		}
		else
		{
			return 2 * this.radius * Math.PI;
		}
	}
}

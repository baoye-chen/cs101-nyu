
public class Rectangle extends GeometricObject
{
	public double width;
	public double length;

	public double getWidth()
	{
		return width;
	}
	
	public double getLength() 
	{
		return length;
	}
	
	public void setWidth(double width) 
	{
		this.width = width;
	}
	
	public void setLength(double length) 
	{
		this.length = length;
	}
	
	public Rectangle(double length, double width, double x, double y) 
	{
		super(x,y);
		this.width = width;
		this.length = length;
	}
	
	@Override
	public double getArea() 
	{
		if(this.width <= 0 || this.length <= 0) 
		{
			return -1;
			
		}
		else 
		{
			return this.width * this.length;
		}
	}
	
	@Override
	public double getPerimeter() 
	{
		if(width <= 0 || length <= 0) 
		{
			return -1;
			
		}
		else 
		{
			return 2 * (width + length);
		}
	}
}

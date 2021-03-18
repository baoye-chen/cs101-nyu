
public abstract class GeometricObject {
	private double x;
	private double y;
	
	public GeometricObject()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public GeometricObject(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
}

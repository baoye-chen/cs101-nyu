
public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Triangle Tria = new Triangle(1, 1, 10);
		}
		catch(IllegalTriangleException ex)
		{
			ex.getMessage();
		}
		
	}

}

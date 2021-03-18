
public class Student 
{
	private String name;
	private int id;
	
	public Student(String name, int id)
	{
		this.name = name;
		this.id = id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getid()
	{
		return this.id;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void setid(int newid)
	{
		this.id = newid;
	}
}

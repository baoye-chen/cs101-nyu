
public class Professor 
{
	private String name;
	private Course[] courseTaught;
	private int NumOfClass;
	
	public Professor(String name)
	{
		this.name = name;
		Course[] teaching = new Course[0];
		this.courseTaught = teaching;
		this.NumOfClass = this.courseTaught.length;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Course[] getcourseTaught()
	{
		return this.courseTaught;
	}
	
	public void removeCourseTaught(Course remove)
	{
		Course[] newCourseTaught = new Course[this.courseTaught.length - 1];
		int removeIndex = 0;
		for(int i = 0; i < this.courseTaught.length; i++)
		{
			if(remove.getCourseName().equalsIgnoreCase(this.courseTaught[i].getCourseName())) 
			{
				removeIndex = i;
			}
		}
		for(int i = 0; i < removeIndex; ++i)
		{
			newCourseTaught[i] = this.courseTaught[i];
		}
		for(int i = removeIndex + 1; i <= newCourseTaught.length; ++i)
		{
			newCourseTaught[i-1] = this.courseTaught[i];
		}
		this.courseTaught = newCourseTaught;
		this.NumOfClass--;
	}
	
	public int getNumOfClass()
	{
		return this.NumOfClass;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void addCourseTaught(Course newCourse)
	{
		if(this.NumOfClass < 3)
		{
			Course[] newCourseTaught = new Course[this.courseTaught.length + 1];
			for(int i = 0; i < this.courseTaught.length; i++)
			{
				newCourseTaught[i] = this.courseTaught[i];
			}
			newCourseTaught[newCourseTaught.length - 1] = newCourse;
			this.courseTaught = newCourseTaught;
			this.NumOfClass++;
		}
	}
	
	public void printProfInfo()
	{
		System.out.println("------------------------------");
		System.out.println("Professor name: " + this.name);
		System.out.println("The Professor is teaching " + this.getNumOfClass() + " classes:");
		for(int i = 0; i < this.courseTaught.length; i++)
		{
			System.out.println(courseTaught[i].getCourseName());
		}
		System.out.println("------------------------------");
	}
}

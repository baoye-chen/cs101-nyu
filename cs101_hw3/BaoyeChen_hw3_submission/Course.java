
class Student 
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

class Professor 
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
		int removeIndex = -1;
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



public class Course 
{
	
	private String name;
	private Professor Professor;
	private Student[] students;
	
	Course(String name, Student[] students, Professor professor)
	{
		this.name = name;
		this.students = students;
		this.Professor = professor;
		this.Professor.addCourseTaught(this);
	}
	
	public int getNumberOfstu()
	{
		return this.students.length;
	}
	
	public void setProf(Professor newProf)
	{
		if (newProf.getNumOfClass() < 3)
		{
			this.Professor.removeCourseTaught(this);
			newProf.addCourseTaught(this);
			this.Professor = newProf;
		}
		else
		{
			System.out.println("A professor can only teach 3 classes!");
		}
	}
	
	public void addStudent(Student newStu)
	{
		if(this.getNumberOfstu() < 60)
		{
			Student[] newStudents = new Student[this.students.length + 1];
			for(int i = 0; i < this.students.length; i++)
			{
				newStudents[i] = students[i];
			}
			newStudents[newStudents.length-1] = newStu;
			this.students = newStudents;
			System.out.println(newStu.getName() + " is added to " + this.name);
		}
		else
		{
			System.out.println("The class is full!");
		}
	}
	
	public void removeStudent(Student stu)
	{
		if(this.getNumberOfstu() > 5)
		{
			Student[] newStudents = new Student[this.students.length - 1];
			int removeIndex = -1;
			for(int i = 0; i < this.students.length; i++)
			{
				if(stu.getName().equalsIgnoreCase(this.students[i].getName())) 
				{
					removeIndex = i;
				}
				else
				{
					System.out.println("This student is not erolled in the course!");
					break;
				}
			}
			if(removeIndex != -1)
			{
				for(int i = 0; i < removeIndex; ++i)
				{
					newStudents[i] = this.students[i];
				}
				for(int i = removeIndex + 1; i <= newStudents.length; ++i)
				{
					newStudents[i-1] = this.students[i];
				}
				this.students = newStudents;
				System.out.println(stu.getName() + " is removed from " + this.name);
			}
		}
		else
		{
			System.out.println("A class must have at least 5 students.");
		}
	}
	
	public Professor getProfessor()
	{
		return this.Professor;
	}
	
	public String getCourseName()
	{
		return this.name;
	}
	
	public Student[] getStudents()
	{
		return this.students;
	}
	
	public void printCourseInfo()
	{
		System.out.println("******************************");
		System.out.println("Courese Title: " + this.name);
		System.out.println("Instructor: " + this.Professor.getName());
		System.out.println("Class size: " + this.getNumberOfstu());
		System.out.println("The student list: ");
		for(int i = 0; i < this.students.length; i++)
		{
			System.out.println(this.students[i].getName());
		}
		System.out.println("******************************");
	}
	
	public static void main(String args[])
	{
		Professor Professor1 = new Professor("John");
		Professor Professor2 = new Professor("Jane");
				
		Student[] stuList = new Student[58];
		for(int i = 0; i < stuList.length; i++)
		{
			stuList[i] = new Student("Student " + (i+1), i+1);
		}
		
		Student[] stuList2 = new Student[6];
		for(int i = 0; i < stuList2.length; i++)
		{
			stuList2[i] = new Student("Student " + (i+1), i+1);
		}
		
		Course cs101 = new Course("cs101", stuList, Professor1);
		Course cs102 = new Course("cs102", stuList2, Professor1);
		Course cs103 = new Course("cs103", stuList2, Professor1);
		Course cs104 = new Course("cs104", stuList2, Professor2);
		
		Professor1.printProfInfo();
		System.out.println("");
		Professor2.printProfInfo();
		System.out.println("");
		
		cs101.printCourseInfo();
		System.out.println("");
		cs102.printCourseInfo();
		System.out.println("");
		cs103.printCourseInfo();
		System.out.println("");
		cs104.printCourseInfo();
		System.out.println("");
		
		System.out.println("Try to add two students to cs101");
		cs101.addStudent(new Student("add1", 59));
		cs101.addStudent(new Student("add2", 60));
		System.out.println("New course information: ");
		cs101.printCourseInfo();
		System.out.println("We see they are added successfully");
		System.out.println("");
		
		System.out.println("Try add another student to cs101");
		cs101.addStudent(new Student("add3", 61));
		System.out.println("New course information: ");
		cs101.printCourseInfo();
		System.out.println("We cannot do that since the class is full");
		System.out.println("");
		
		System.out.println("Try to remove a student from cs102");
		cs102.removeStudent(cs102.students[3]);
		System.out.println("New course information: ");
		cs102.printCourseInfo();
		System.out.println("We see the student is successfully removed");
		System.out.println("");
		
		System.out.println("Try to remove another student from cs102");
		cs102.removeStudent(cs102.students[4]);
		System.out.println("New course information: ");
		cs102.printCourseInfo();
		System.out.println("No one is removed this time because we've set that a class must have at lest 5 students");
		System.out.println("");

		System.out.println("Now, try to remove a student who's not enrolled in cs103.");
		Student outOfNowhere = new Student("Josh", 404);
		System.out.println("The student is: " + outOfNowhere.getName());
		cs103.removeStudent(outOfNowhere);
		System.out.println("New course information: ");
		cs103.printCourseInfo();
		System.out.println("So we can see nothing's changed");
		System.out.println("");
		
		System.out.println("Try to let John teach cs104 as well");
		cs104.setProf(Professor1);
		cs104.printCourseInfo();
		System.out.println("We see we cannot do that since John is already teaching 3 classes!");
		System.out.println("");
		
		Professor1.printProfInfo();
		System.out.println("");
		Professor2.printProfInfo();
		System.out.println("We can see nothing is changed. They are still teaching the same classes.");
		System.out.println("");
		
		System.out.println("Let Jane teach cs102, and then try assign John to cs104");
		cs102.setProf(Professor2);
		cs104.setProf(Professor1);
		System.out.println("");
		
		Professor1.printProfInfo();
		System.out.println("");
		Professor2.printProfInfo();
		System.out.println("");
		System.out.println("So we can see it changes as we expected.");
	}
}

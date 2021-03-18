

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
			System.out.println("A professor can only teach 3 classes!");	
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
			int removeIndex = 0;
			for(int i = 0; i < this.students.length; i++)
			{
				if(stu.getName().equalsIgnoreCase(this.students[i].getName())) 
				{
					removeIndex = i;
				}
			}
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
		
		System.out.println("Try to let John teach cs104 as well");
		cs104.setProf(Professor1);
		cs104.printCourseInfo();
		System.out.println("");
		
		Professor1.printProfInfo();
		System.out.println("");
		Professor2.printProfInfo();
		System.out.println("");
		
		System.out.println("Let Jane teach cs101, and then try assign John to cs104");
		cs102.setProf(Professor2);
		cs104.setProf(Professor1);
		System.out.println("");
		
		Professor1.printProfInfo();
		System.out.println("");
		Professor2.printProfInfo();
		System.out.println("");
	}
}

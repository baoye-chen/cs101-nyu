
public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Rectangle Rec = new Rectangle(4, 2, 0, 0);
		Circle Circ = new Circle(2, 1, 1);
		Triangle Tria = new Triangle(3, 4, 5, 2, 2);
		
		System.out.println("The Recrangle at (" + Rec.getX() + ", " + Rec.getY()  + "): \n \t Length = " 
				+ Rec.getLength() + "\t Width = " + Rec.getWidth()
				+ "\n \t Perimeter = " + Rec.getPerimeter() + "\t Area = " + Rec.getArea() + "\n");
		
		System.out.println("The Circle at (" + Circ.getX() + ", " + Circ.getY()  + "): \n \t Radius = " 
				+ Circ.getRadius()
				+ "\n \t Perimeter = " + Circ.getPerimeter() + "\t Area = " + Circ.getArea() + "\n");
		
		System.out.println("The Triangle at (" + Tria.getX() + ", " + Tria.getY()  + "): \n \t Base = " 
				+ Tria.getBase() + "\t Line2 = " + Tria.getline2() + "\t Line3 = " + Tria.getline3()
				+ "\n \t Perimeter = " + Tria.getPerimeter() + "\t Area = " + Tria.getArea() + "\n");
	}
}

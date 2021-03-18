public class Cube {
	// depth, width, and height are three private data fields of the Cube class
	// all of them have the type double
	private double depth = 10; 
	private double width = 10; 
	private double height = 10;

	// numOfCubes is also a private data field with type int
	private static int numOfCubes = 0;

	// this is a public static method with return type int
	// it returns numOfCubes
 	public static int getNoOfCubes() {
    	return numOfCubes;
	}

	// this is the constructor of Cube class
	// the numOfCubes would plus one after the constructor is called
 	public Cube() {
    	numOfCubes++;
	}

	// this is a method that scales the depth, width, and height by a factor
	// the depth, width, and height would be changed when this method is called
	public void scale(double scaling) { 
		depth *= scaling;
		width *= scaling;
		height *= scaling;
	}

	// this is a method that gets the volume of the cube
	public double getVolume() {
		return depth * width * height;
	}

	// this is a method that gets the depth of the cube
	public double getDepth() {
		return depth;
	}

	// this is a method that sets the depth of the Cube to the value "depth"
	// it uses "this." to explicitly reference the data field "depth" of the object constructed
	public void setDepth(double depth) { 
		this.depth = depth;
	} 
}
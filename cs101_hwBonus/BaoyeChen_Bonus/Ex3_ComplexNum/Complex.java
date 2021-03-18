

public class Complex extends java.lang.Number
{
	public double real;
	public double imaginary;
	
	public Complex()
	{
		this.real = 0;
		this.imaginary = 0;
	}
	
	public Complex(double real)
	{
		this.real = real;
		this.imaginary = 0;
	}
	
	public Complex(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public double real()
	{
		return this.real;
	}
	
	public double imaginary()
	{
		return this.imaginary;
	}
	
	public Complex conjugate()
	{
		return new Complex(this.real, this.imaginary);
	}
	
	public Complex addition(Complex A)
	{
		return new Complex(this.real + A.real, this.imaginary + A.imaginary);
	}
	
	public Complex subtraction(Complex A)
	{
		return new Complex(this.real - A.real, this.imaginary - A.imaginary);
	}
	
	public Complex multiplication(Complex A)
	{
		return new Complex(this.real*A.real-this.imaginary*A.imaginary, A.real*this.imaginary + A.imaginary*this.real);
	}
	
	public String toString()
	{
		String out;
		out = this.real() + " + " + this.imaginary() + "i ";
		return out;
	}
	

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String Args[])
	{
		Complex A = new Complex(1.5, 2.5);
		Complex B = new Complex(3.5, 4.5);
		System.out.println("A = " + A.real() + " + " + A.imaginary() + "i");
		System.out.println("B = " + B.real() + " + " + B.imaginary() + "i");
		System.out.println("A+B = " + A.addition(B).toString());
		System.out.println("A-B = " + A.subtraction(B).toString());
		System.out.println("A*B = " + A.multiplication(B).toString());
	}
}

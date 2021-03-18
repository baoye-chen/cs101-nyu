import java.util.Arrays;
import java.util.Scanner;

public class InfinitArray
{
	// the data fields
	private double[] storage; 
	private int length;

	// the constructor
	public InfinitArray()
	{
		storage = new double[1];
		length = 0;
	}

	// the method to add value
	public void add(double valueToAdd)
	{
		if(length == storage.length)
		{
			// if the storage is full, create a new storage twice as big
			// and copy all values from the old one to the new one
			double[] newStorage = new double[storage.length * 2];
			for (int i = 0; i < storage.length; i++)
			{
				newStorage[i] = storage[i];
			}
			storage = newStorage;
		}
		// append the added value
		storage[length] = valueToAdd;
		// add the length by 1
		length ++;
	}

	// the method to calculate the average
	public double average()
	{
		// if nothing is entered, the average is 0 by default
		if(length == 0)
		{
			return 0;
		}

		double sum = 0;

		for(int i = 0; i < storage.length; i++)
		{
			sum = sum + storage[i];
		}

		return sum/length;
	}

	// the method to get the maximum number
	public double maximum()
	{
		// if nothing is entered, the max is 0 by default
		if(length == 0)
		{
			return 0;
		}

		int maxIndex = 0;
		for(int i = 0; i < length; i++)
		{
			if(storage[i] > storage[maxIndex])
			{
				maxIndex = i;
			}
		}
		return storage[maxIndex];
	}

	// the method to get the minimum number
	public double minimum()
	{
		// if nothing is entered, the min is 0 by default
		if(length == 0)
		{
			return 0;
		}

		int minIndex = 0;
		for(int i = 0; i < length; i++)
		{
			if(storage[i] < storage[minIndex])
			{
				minIndex = i;
			}
		}
		return storage[minIndex];
	}

	// the method to get the standard deviation
	public double std()
	{
		// if nothing is entered, the standard deviation is 0 by default
		if(length == 0)
		{
			return 0;
		}

		double avg = average();
		double sqSum = 0;

		for(int i = 0; i < length; i++)
		{
			sqSum = sqSum + Math.pow(storage[i]-avg,2);
		}

		/*
			Based on the sample output, the formula used to calculate stdev is:
				square root of the sum of the squared differences from the mean divided by total
				i.e., the population standard deviation
			NOT:
				square root of the sum of the squared differences from the mean divided by total minus 1
				i.e., the sample standard deviation

			So I used the formula that produces the same result as the sample output (population standard deviation)
		*/
		double variance = sqSum / length;
		return Math.sqrt(variance);
	}

	// the method to get the median
	public double median()
	{
		// if nothing is entered, the median is 0 by default
		if(length == 0)
		{
			return 0;
		}

		double[] temp = new double[length];
		for(int i = 0; i < length; i++)
		{
			temp[i] = storage[i];
		}
		Arrays.sort(temp);
		if(length % 2 == 0)
		{
			return (temp[length/2] + temp[(length/2) - 1]) / 2;
		}
		else
		{
			return temp[length/2];
		}
	}

	// the main method 
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		InfinitArray infarray = new InfinitArray();

		System.out.println("Insert numbers (terminate with negative number):");

		// prompt the user for input until a negative number is entered
		while(true)
		{
			double newNum = scanner.nextDouble();
			if(newNum < 0)
			{
				break;
			}
			infarray.add(newNum);
		}

		System.out.println("\n");
		System.out.println("Their average is " + infarray.average());
		System.out.println("Their min/max is " + infarray.minimum() + "/" + infarray.maximum());
		System.out.println("Their standard deviation is " + infarray.std());
		System.out.println("Their median is "+ infarray.median());
	}
}
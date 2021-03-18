/*
	Part II (1) (2)
	This is the game of life with hexagonal grid
*/

public class HEX {
	public static void init(boolean[][] alive, double alivePerc)
	{
		
		int n = alive.length; //len(alive)

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				alive[i][j] = Math.random() < alivePerc;
			}
		}
	}
	
	// prints out the first line of the hexagons, which is ' / \ / \ / \ / \ / \ / \ / \ / / \ / \'
	public static void print1(int n)
	{
		for(int i = 0; i < n; i++)
		{
			System.out.print(" / \\");
		}
	}

	// prints out the second line of the hexagons, which should be something like this
	// '|   | • |   |   | • |   | • | • | • |   | • '
	// the one with dot means it is alive
	public static void printAlive(boolean[][] alive, int i, int j)
	{
		if(alive[i][j] == true)
		{
			System.out.print("| • ");
		}
		else
		{
			System.out.print("|   ");
		}
	}

	// prints out the last line of the hexagonls, which is ' \ / \ / \ / \ / \ / \ / \ / \/ \ /'
	public static void print3(int n)
	{
		for(int i = 0; i < n; i++)
		{
			System.out.print(" \\ /");
		}
	}

	// assemble the three parts of the hexagons 
	public static void printTogether(boolean[][] alive)
	{
		// get the size of the grid
		int n = alive.length;

		// iterate through each row
		for(int j = 0; j < n; j++)
		{
			// if the row is even row
			if(j % 2 == 0)
			{
				// first print out the first line
				print1(n);
				// print a new line
				System.out.println("");

				// then iterate through each column
				for(int i = 0; i < n; i++)
				{
					// print out the middle part based on whether alive
					printAlive(alive, i, j);
				}
				// then print another new line
				System.out.println("");

				// lastly, print out the last line of the hexagons
				print3(n);
			}
			// if the row is odd row
			else if(j % 2 != 0)
			{
				// don't need to print first line and last line in this case
				// because last line in the previous row is the first line in this row
				// and first line in the next row will be the last line of this row

				// first print a new line
				System.out.println("");
				// then, shift to the right by adding two spaces
				System.out.print("  ");
				// iterate through each column
				for(int i = 0; i < n; i++)
				{
					// prints out the middle part based on whether alive
					printAlive(alive, i, j);
				}
				// lastly, print out a new line
				System.out.println("");
			}
		}
	}

	public static boolean isAlive(boolean[][] alive, int i, int j)
	{
		//what do we do with negative indices (or >= n)
		int n = alive.length;
		//i = n -> i -> 0
		//i=n+1->i -> i
		// i=-1 -> i -> n-1

		// + 0 // a + 0 = a
		// * 1
		// a % n = (a+kn) % n

		//a=2, n=3 a%n = 2 4%3 =1

		//assume that i,j >= -n
		int x = (i+n) % n;
		int y = (j+n) % n;

		return alive[x][y];
	}

	// modified getNeighs
	public static int[][] getNeighs(int i, int j)
	{
		// if it is even line, the neightbors are the following
		if(j % 2 == 0)
		{
			int[][] coordinates = {{i, j-1}, {i+1, j-1}, {i-1, j}, {i+1, j}, {i, j+1}, {i+1, j+1}};
			return coordinates;
		}
		// if it is odd line, the neightbors are the following
		else
		{
			int[][] coordinates = {{i-1, j-1}, {i, j-1}, {i-1, j}, {i+1, j}, {i-1, j+1}, {i, j+1}};
			return coordinates;
		}
	}

	public static int countAliveNeighs(boolean[][] alive, int i, int j)
	{
		int nAlive = 0;

		int[][] coordinates = getNeighs(i, j);

		for(int index = 0; index < coordinates.length; index++)
		{
			if(isAlive(alive, coordinates[index][0], coordinates[index][1]))
				nAlive++;
		}

		/*for(int x = i-1; x <= i+1; x++)
		{
			for(int y = j-1; y <= j+1; y++)
			{
				if(x == i && y == j)
					continue;

				if(isAlive(alive, x, y)) //alive[x][y]
					nAlive++;
			}
		}*/

		return nAlive;
	}


	// this method checks if an integer is in an array or not
	public static boolean contains(int a, int[] list)
	{
		boolean ifIn = false;

		for(int i : list)
		{
			if(i == a)
			{
				ifIn = true;
			}
		}
		return ifIn;
	}

	public static void update(boolean[][] alive, int[] born, int[] surviving)
	{
		//assume the grid is squared
		int n = alive.length; //len(alive)

		boolean[][] newAlive = new boolean[n][n];

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				int nAlive = countAliveNeighs(alive, i, j);
				if(isAlive(alive, i, j))
				{
					if(contains(nAlive, surviving)) // check if nAlive is in the list with the rule for surviving
					{
						newAlive[i][j] = true;
					}
					else
					{
						newAlive[i][j] = false;
					}
					/*if(nAlive < 2)
						newAlive[i][j] = false;
					else if(nAlive == 2 || nAlive == 3)
						newAlive[i][j] = true;
					else
						newAlive[i][j] = false;*/
				}
				else
				{
					if(contains(nAlive, born)) // check if nAlive is in the list with the rule for born
					{
						newAlive[i][j] = true;
					}
					else
					{
						newAlive[i][j] = false;
					}
					/*if(nAlive == 3)
						newAlive[i][j] = true;
					else
						newAlive[i][j] = false;*/
				}
			}
		}

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				alive[i][j] = newAlive[i][j];
			}
		}
	}

	public static void main(String[] args) {

		/*
			My assumption is the user can enter a list of integer,
			when number of survivors equals to any number in the list,
			the cell will survive.
			Same goes for born.

			e.g. "java GOL B34/S123":
				if number of alive near a dead cell is 3 or 4, the dead cell will be born
				if number of alive near an alive cell is 1,2, or 3, the alive cell survives
		*/

		int n = Integer.parseInt(args[0]);

		// read any number between "B" and "/" and store it in a string
		int iend1 = args[1].indexOf("/");
		String bornstr = args[1].substring(1, iend1);
		int bornstrLen = bornstr.length();

		// read any number between "S" to the end and store it in a string
		int iend2 = args[1].indexOf("S");
		String survivingstr = args[1].substring(iend2+1, args[1].length());
		int survivingstrLen = survivingstr.length();

		// create two arrays to store the user's rules
		int[] born = new int[bornstrLen];
		int[] surviving = new int [survivingstrLen];

		// loop through the string that stores the rule for born and make it into an array
		for(int i = 0; i < born.length; i++)
		{
			int s = Integer.parseInt(bornstr.substring(i, i+1));

			born[i] = s;
			
		}

		// loop through the string that stores the rule for survive and make it into an array
		for(int j = 0; j < surviving.length; j++)
		{
			int s = Integer.parseInt(survivingstr.substring(j, j+1));

			surviving[j] = s;
		}

		//System.out.println(Arrays.toString(born));
		//System.out.println(Arrays.toString(surviving));	

		boolean[][] alive = new boolean[n][n];
		init(alive, 0.2);
		// alive[0][0] = true;
		// alive[0][1] = true;
		// alive[1][0] = true;
		// alive[1][1] = true;

		while(true)
		{
			printTogether(alive);
			update(alive, born, surviving);

			try 
			{
			    Thread.sleep(200);
			} 
			catch(InterruptedException e)
			{
			     // this part is executed when an exception (in this example InterruptedException) occurs
			}

			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
	}
}
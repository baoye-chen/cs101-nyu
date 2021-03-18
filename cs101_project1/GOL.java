/*
	Part II (3)
	This is the one that the user can choose between hexagonal and regular GOL.
	If want hexagonal, just add "hex" at the end of the command line argument.
*/

public class GOL
{
	public static void main(String[] args)
	{
		// check if there is a third word that says hex
		if(args.length == 3)
		{
			// if there is, use the HEX main
			if(args[2].equals("hex"))
			{
				HEX.main(args);
			}
			// if there is an extra word entered, but something other than "hex"
			// still use REC main
			else
			{
				REC.main(args);
			}
		}
		// if there is no extra word at all, just use REC main
		else
		{
			REC.main(args);
		}
	}
}
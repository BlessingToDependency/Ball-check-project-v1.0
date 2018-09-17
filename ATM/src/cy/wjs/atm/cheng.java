package cy.wjs.atm;

public class cheng
{
	public static void main(String[] args)
	{
		int j = 1;
		int i = 1;
		for (; i < 9; i++)
		{
			System.out.println(i + "*" + j + "=" + (i * j) + "\t");
			if (j == i)
			{
				i=0;
				j++;
               System.out.println();
				
			} 
		}

	}
}

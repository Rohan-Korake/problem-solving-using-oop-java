// Burgers
// Chef is fond of burgers and decided to make as many burgers as possible. 
// Chef has A patties and B buns. To make 1 burger, Chef needs  1 patty and 1 bun. 
// Find the maximum number of burgers that Chef can make.

import java.util.Scanner;

class burger
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for(int i=0;i<t;i++)
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            System.out.println(Math.min(a,b));
        }
        scanner.close();
	}
}

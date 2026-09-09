// According to a recent survey, Biryani is the most ordered food. 
// Chef wants to learn how to make world-class Biryani from a MasterChef. 
// Chef will be required to attend the MasterChef's classes for X weeks, and the cost of classes per week is Y coins. 
// What is the total amount of money that Chef will have to pay?

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
    	 Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for(int i=0;i<t;i++)
        {
            int weekCount=scanner.nextInt();
            int weekFees=scanner.nextInt();
            
            System.out.println(weekCount*weekFees);
        }
            scanner.close();
	}
}

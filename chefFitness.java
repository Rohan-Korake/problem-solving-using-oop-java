// Chef wants to become fit for which he decided to walk to the office and return home by walking. 
// It is known that Chef's office is X km away from his home. If his office is open on 5 days in a week, 
// find the number of kilometers Chef travels through office trips in a week.

import java.util.Scanner;

public class chefFitness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int x = scanner.nextInt();
            int totalDistance=0;
            
            for(int i=0;i<5;i++)
            {
                totalDistance+=x+x;
            }
            System.out.println(totalDistance);
        }
        scanner.close();
    }
}

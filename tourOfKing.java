// King loves to go on tours with his friends.
// King has N cars that can seat 5 people each and M cars that can seat 7 people each.
// Determine the maximum number of people that can travel together in these cars.
import java.util.Scanner;

class tourOfKing
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int M_CarPassenger = 0, N_CarPassenger = 0;
            N_CarPassenger = N * 5;
            M_CarPassenger = M * 7;
            System.out.println(N_CarPassenger + M_CarPassenger);
        }
        scanner.close();
    }
}
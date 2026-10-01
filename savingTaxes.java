import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buffer.readLine());

        while (t-- > 0) {
            String[] line = buffer.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            System.out.println(x - y);
        }
    }
}
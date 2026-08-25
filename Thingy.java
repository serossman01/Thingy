import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class Thingy {
    static boolean[] sieveIndex(int num) {
        boolean[] isPrime = new boolean[num + 1];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p*p <= num; ++p) {
            if (isPrime[p]) {
                for (int mult = p*p; mult <= num + 1; mult += p) {
                    isPrime[mult] = false;
                }
            }
        }

        return isPrime;
    }


    public static void main(String[] args) {
        boolean[] indexBools = sieveIndex(100);
        System.out.println(java.util.Arrays.toString(indexBools));


    }
}
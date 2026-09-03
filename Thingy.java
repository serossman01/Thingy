import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

public class Thingy {
    static boolean[] sieveIndex(int num) {
        boolean[] isPrime = new boolean[num + 1];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p*p <= num; ++p) {
            if (isPrime[p]) {
                for (int mult = p*p; mult < num + 1; mult += p) {
                    isPrime[mult] = false;
                }
            }
        }

        return isPrime;
    }

    static int[] convertToPList(boolean[] isPrime) {
        LinkedList<Integer> pList = new LinkedList<Integer>();
        
        int pLen = isPrime.length;
        for (int i = 0; i < pLen; ++i) {
            if (isPrime[i]) {
                pList.add(i);
            }
        }

        int[] finList = pList.stream().mapToInt(Integer::intValue).toArray();
        return finList;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Whats the max value of the primes you want to find?");

        int pMax = scan.nextInt();
        scan.nextLine();

        System.out.print("Press enter to calulate them. ");
        scan.nextLine();

        boolean[] indexBools = sieveIndex(pMax);
        //System.out.println(Arrays.toString(indexBools));
        
        System.out.print("Calculated primes. Press enter to convert indexes into a prime list.");
        scan.nextLine();

        int[] finalPrimes = convertToPList(indexBools);

        System.out.println("Made prime list. Press enter to print it.");
        scan.nextLine();

        System.out.println(Arrays.toString(finalPrimes));


    }
}
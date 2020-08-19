package codeasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CountPrimes {

/*
Write a program that takes L and R as input
and displays the number of prime numbers that lie between L and R(L and R inclusive)
and can be represented as sum of two consecutive prime numbers + 1.

Example:
Case 1 :

    For the input provided as follows : [1 20]

    Output of the program will be : 2

    Explanation

    13 is a prime number which can be expressed like 5 + 7 + 1.
    19 is a prime number which can be expressed like 7 + 11 + 1.
    So output is 2.
    Note that 5 and 7 are consecutive primes.Similarly 7 and 11 are consecutive primes.

Case 2:

    For the input provided as follows : [1 10]

    Output of the program will be : 0

    Explanation

    No prime numbers lie between 1 and 10 that
    can be represented as sum of two consecutive prime numbers + 1, hence 0 is displayed.
*/

    public static int[] getPrimesBetween(int lo, int hi) {

        if (lo < 1 || hi < 2 || lo >= hi) {
            return new int[0];
        }

        int i = 0;
        int n = 0;
        List<Integer> result = new ArrayList<>();
        for (i = lo; i <= hi; i++) {
            int count = 0;
            for (n = i; n >= 1; n--) {
                if (i % n == 0) {
                    count++;
                }
            }

            if (count == 2) {
                result.add(i);
            }
        }
        System.out.println("hi");

        return result.stream().mapToInt(a -> a).toArray();
    }

    private static boolean isSumOfTwoConsecutiveNumbers(int[] nums, int n) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 0; i < nums.length -1; i++) {
            if (n == nums[i] + nums[i + 1] + 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final int[] primesBetween = getPrimesBetween(2, 20);

        int count = 0;
        for (int i : primesBetween) {
            System.out.println(i);
            if (isSumOfTwoConsecutiveNumbers(primesBetween, i)) {
                count++;
            }
        }

        System.out.println(count);
    }

}

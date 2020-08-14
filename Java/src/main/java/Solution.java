import java.util.Arrays;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 3};
        int target = 6;

        final int[] ints = twoSum(nums, 6);
        System.out.println("hi");

        System.out.println(ints);

    }

    // Q1
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Q167
    public static int[] twoSum2(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        throw new IllegalArgumentException("No two sum result");
    }

    // Q633
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int)Math.sqrt(c);

        while (i <= j) {
            final int result = i * i + j * j;
            if (result == c) {
                return Boolean.TRUE;
            } else if (result < c) {
                i++;
            } else {
                j--;
            }
        }
        return Boolean.FALSE;
    }


    // Q345. Reverse Vowels of a String

    private static final HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {

    }

}

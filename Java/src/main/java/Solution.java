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

        int min = numbers[0];
        int max = numbers[numbers.length - 1];

        if (min * max > 0) {
            for (int i = 0; i < numbers.length && numbers[i] < target; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    return new int[]{(i + 1), (j + 1)};
                }
            }
        } else if (min * max < 0) {
            for (int i = 0; i < numbers &&  ; i++) {

            }
        }


        for (int i = 0; i < numbers.length ; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] * numbers[j] > 0) {
                    if (numbers[i] <= target && numbers[i] + numbers[j] == target) {
                        return new int[]{(i + 1), (j + 1)};
                    }
                } else if (numbers[i] * numbers[j] < 0) {
                    if (numbers[i] <= target && numbers[i] + numbers[j] == target) {
                        return new int[]{(i + 1), (j + 1)};
                    }
                }

            }


        }
        throw new IllegalArgumentException("No two sum result");
    }
}

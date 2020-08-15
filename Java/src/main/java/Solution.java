import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 3};
        int target = 6;

        final int[] ints = twoSum(nums, 6);
        System.out.println("hi");

        System.out.println(ints);

        String ss = "hello";
        reverseVowels(ss);

    }

    // Q1
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
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
                return new int[]{i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("No two sum result");
    }

    // Q633
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);

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

    public static String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];

        while (i <= j) {
            char chari = s.charAt(i);
            char charj = s.charAt(j);

            if (!vowels.contains(chari)) {
                result[i] = chari;
                i++;
            } else if (!vowels.contains(charj)) {
                result[j] = charj;
                j--;
            } else if (vowels.contains(chari) && vowels.contains(charj)) {
                result[i] = charj;
                result[j] = chari;
                i++;
                j--;
            }

        }

        final String s1 = result.toString();
        final String s2 = new String(result);
        return new String(result);
    }

    // Q680. Valid Palindrome II (Easy)

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return (isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1));
            }
        }
        return true;
    }

    // Q88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[index] = nums1[p1];
                p1--;
            } else {
                nums1[index] = nums2[p2];
                p2--;
            }
            index--;
        }

        while (p2 >= 0) {
            nums1[p2] = nums2[p2];
            p2--;
        }
    }

    // Q141. Linked List Cycle (Easy)
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> seen = new HashSet<>();
//
//        while (head != null) {
//            if (seen.contains(head)) {
//                return true;
//            } else {
//                seen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    // Q524. Longest Word in Dictionary through Deleting
    private static boolean isSubString(String s, String target) {
        // s = applepie,
        // target = apple
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public String findLongestWord(String s, List<String> d) {

        String longestWord = "";
        // s = "applepie"
        // d = ["a", "apple", "pie"]
        for (String target : d) {
            int l1 = longestWord.length();
            int l2 = target.length();
            if (l1 < l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                // got a longest word here
                // if it's a substring if s, keep it
                // else continue
                if (isSubString(s, target)) {
                    longestWord = target;
                }
            }
        }
        return longestWord;
    }

    // Q215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Q347. Top K Frequent Elements
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyForNumber = new HashMap<>();

        for (int num : nums) {
            frequencyForNumber.put(num, frequencyForNumber.getOrDefault(num, 0) + 1); // todo moss
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1]; // why +1? todo
        for (Map.Entry<Integer, Integer> entry : frequencyForNumber.entrySet()) {
            int index = entry.getKey();
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(index);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length -1; i>= 0 && topK.size()< k; i--) {
            if (buckets[i] != null) {
                topK.addAll(buckets[i]);
            }
        }
        return topK.stream().mapToInt(i->i).toArray();
    }

    // Q451. Sort Characters By Frequency (Medium)
    public String frequencySort(String s) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length()+ 1];

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            Integer frequency = entry.getValue();
            Character key = entry.getKey();

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {

            if (bucket[i] == null) {
                continue;
            }

            for (char c : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }

    // Q75. Sort Colors
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[i] = tmp;
    }
    public void sortColors(int[] nums) {

        //[2,0,2,1,1,0]
        int zero = -1;
        int one = 0;
        int two = nums.length;

        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, one, --two);
            } else {
                // number  = 1
                one++;
            }
        }
    }

}

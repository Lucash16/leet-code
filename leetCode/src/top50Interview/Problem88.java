package top50Interview;


import java.util.Arrays;

public class Problem88 {

    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function,
    but instead be stored inside the array nums1. To accommodate this,
    nums1 has a length of m + n, where the first m elements denote the elements
    that should be merged, and the last n elements are set to 0 and should be
    ignored. nums2 has a length of n.
     */

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];
        for (int i = 0; i < mergedArray.length; i++) {
            if(nums1[i] != 0) {
                mergedArray[i] = nums1[i];
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(nums2[i] != 0) {
                mergedArray[m + i] = nums2[i];
            }
        }

        Arrays.sort(mergedArray);
        System.arraycopy(mergedArray, 0, nums1, 0, mergedArray.length);
    }

}

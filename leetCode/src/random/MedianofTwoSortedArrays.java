package random;

import java.util.Arrays;

public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        int[] array1 = {-2, 3};
        int[] array2 = {0, -1};
        findMedianSortedArrays(array1, array2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);
        Arrays.sort(mergedArray);
        if(mergedArray.length%2 != 0) {
            double result =  mergedArray[(mergedArray.length/2)];
            return result;
        } else {
            int firstElement = mergedArray[(mergedArray.length/2) - 1];
            double result = (double) (firstElement + mergedArray[(mergedArray.length / 2)]) /2 ;
            return result;
        }
    }

}

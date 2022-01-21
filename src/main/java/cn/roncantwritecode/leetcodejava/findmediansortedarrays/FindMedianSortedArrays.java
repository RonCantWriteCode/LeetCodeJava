package cn.roncantwritecode.leetcodejava.findmediansortedarrays;

/**
 * @author Ron Wu
 * @date 2020/3/25
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    /**
     * 二分法 O(log(m + n))
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        

        return 1;
    }
}

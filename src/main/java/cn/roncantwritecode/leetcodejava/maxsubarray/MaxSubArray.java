package cn.roncantwritecode.leetcodejava.maxsubarray;

/**
 * @author wurunlong
 * @date 2020/3/26
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray.maxSubArray(nums);
        System.out.println(result);
        int[] nums2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        result = maxSubArray.maxSubArrayDivide(nums2);
        System.out.println(result);

    }

    /**
     * 动态规划 O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(nums[i], max);
        }

        return max;
    }

    /**
     * 分治算法 O(n*log(n))
     * @param nums
     * @return
     */
    public int maxSubArrayDivide(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) {
            return nums[left];
        }

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

}

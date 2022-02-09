package cn.roncantwritecode.leetcodejava.nextpermutation;

import cn.roncantwritecode.leetcodejava.utils.IntArrayUtils;

/**
 * @author Ron Wu
 * @date 2022/2/9
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {3, 2, 1};
        nextPermutation.nextPermutation(nums);
        IntArrayUtils.printIntArray(nums);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 倒序查询第一个需要替换的数字num[i]，num[i]之后的数字是已经满足从大到小排列了
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        // 目前已经是最大排列，需要反转数组
        if (i < 0) {
            reverse(nums, 0);
            return;
        }
        // 倒序查询第一个大于num[i]的数（可理解为查询一个后面最小的且大于num[i]的数来替换），即为需要替换的第二个数，替换之后将num[i+1]做倒序即可（num[i+1]之后为从大到小，替换之后后面需要调整为从小到大）
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package cn.roncantwritecode.leetcodejava.search;

/**
 * @author Ron Wu
 * @date 2022/2/18
 */
public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {3,1};
        int target = 1;
        int result = search.search(nums, target);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[left] <= target && target < nums[middle]) {
                // 左边有序，且匹配
                right = middle - 1;
            } else if (nums[middle] < target && target <= nums[right]) {
                // 右边有序，且匹配
                left = middle + 1;
            } else {
                // 确定有序的没有匹配，对不确定是否有序的做二分
                if (nums[left] <= nums[middle]) {
                    left = middle + 1;
                } else  {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}

package cn.roncantwritecode.leetcodejava.rob;

/**
 * @author Ron Wu
 * @date 2020/4/9
 */
public class Rob {

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {10, 1, 2, 5};
        int result = rob.rob(nums);
        System.out.println(result);
    }

    /**
     * 动态规划 O(n)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int prev = 0;
        int result = 0;
        for (int num : nums) {
            int temp = result;
            result = Math.max(prev + num, result);
            prev = temp;
        }
        return result;
    }
}

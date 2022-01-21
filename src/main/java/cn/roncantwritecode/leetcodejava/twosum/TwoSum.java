package cn.roncantwritecode.leetcodejava.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ron Wu
 * @date 2020/3/23
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
        int[] resultHash = twoSum.twoSumHash(nums, target);
        System.out.println(resultHash[0] + "," + resultHash[1]);
    }

    /**
     * 枚举 时间复杂度O(n*n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i < nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 哈希 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target) {
        int[] result = new int[2];
        // key为数值，value为数值下标
        Map<Integer, Integer> map = new HashMap<>(nums.length-1);
        for (int i=0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                result[0] = map.get(other);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}

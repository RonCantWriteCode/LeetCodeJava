package cn.roncantwritecode.leetcodejava.singlenumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wurunlong
 * @date 2020/4/1
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4,1,2,1,2};
        int result = singleNumber.singleNumber(nums);
        System.out.println(result);
        result = singleNumber.singleNumberXOR(nums);
        System.out.println(result);
    }

    /**
     * 哈希 O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Object> map = new HashMap<>(nums.length/2+1);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, null);
            }
        }

        return map.keySet().iterator().next();
    }

    /**
     * 位运算异或 O(n)
     * @param nums
     * @return
     */
    public int singleNumberXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}

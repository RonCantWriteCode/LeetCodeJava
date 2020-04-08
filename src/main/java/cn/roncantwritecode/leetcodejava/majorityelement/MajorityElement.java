package cn.roncantwritecode.leetcodejava.majorityelement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wurunlong
 * @date 2020/4/7
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement getIntersectionNode = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int result = getIntersectionNode.majorityElement(nums);
        System.out.println(result);
        result = getIntersectionNode.majorityElementCandidate(nums);
        System.out.println(result);
    }

    /**
     * 哈希 O(n)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        // 记录出现次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        // 循环hash获取次数最多值
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue() ) {
                maxEntry = entry;
            }
        }


        return maxEntry.getKey();
    }

    /**
     * 投票法 O(n)
     * @param nums
     * @return
     */
    public int majorityElementCandidate(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count ++;
            } else {
                count --;
            }
        }

        return candidate;
    }
}

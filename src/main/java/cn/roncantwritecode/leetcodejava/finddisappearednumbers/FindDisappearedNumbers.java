package cn.roncantwritecode.leetcodejava.finddisappearednumbers;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ron Wu
 * @date 2020/4/20
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> resultList = findDisappearedNumbers.findDisappearedNumbers(nums);
        for (Integer result : resultList) {
            System.out.println(result);
        }

    }

    /**
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 插入使用LinkedList效率较高
        List<Integer> result = new LinkedList<Integer>();

        for (int num : nums) {
            int keyIndex = Math.abs(num) - 1;
            // 把当前数字的绝对值-1所在下标数字修改成负数
            if (nums[keyIndex] > 0) {
                nums[keyIndex] = -1 * nums[keyIndex];
            }
        }

        // 为正数的数组下标+1即为未出现数字
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }
}

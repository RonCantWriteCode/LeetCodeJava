package cn.roncantwritecode.leetcodejava.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ron Wu
 * @date 2022/1/26
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        //数组排序
        Arrays.sort(nums);

        // 循环迭代第一个数字，第一个数字最小，所以i < nums.length - 2
        for (int i=0; i < nums.length - 2; i++) {
            // 重复的数字跳过
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            //初始化左右两个指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                if(nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    // 用一个list记录每次循环找到的结果
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    // 指针同时移动，寻找其他符合条件结果
                    left++;
                    right--;
                    // 如果下一个相同的话直接跳过，否则会返回重复结果
                    while (left < right && nums[right+1] == nums[right]) {
                        right--;
                        continue;
                    }
                    while (left < right && nums[left-1] == nums[left]) {
                        left++;
                        continue;
                    }
                }


            }
        }

        return result;
    }
}

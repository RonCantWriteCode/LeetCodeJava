package cn.roncantwritecode.leetcodejava.movezeroes;

/**
 * @author wurunlong
 * @date 2020/4/20
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {1, 0, 0, 3, 0, 4, 5, 0, 6, 8, 0, 12};
        moveZeroes.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    /**
     * 非零移动 O(n)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroLength++;
            } else if (zeroLength > 0) {
                nums[i - zeroLength] = nums[i];
                nums[i] = 0;
            }
        }
    }
}

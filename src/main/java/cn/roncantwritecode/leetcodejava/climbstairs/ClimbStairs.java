package cn.roncantwritecode.leetcodejava.climbstairs;

/**
 * @author Ron Wu
 * @date 2020/4/1
 */
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = 6;
        int result = climbStairs.climbStairs(6);
        System.out.println(result);

    }

    /**
     * 动态规划，斐波那契数列 O(n)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] resultArray = new int[n];
        resultArray[0] = 1;
        resultArray[1] = 2;
        for (int i=2; i<n; i++) {
            resultArray[i] = resultArray[i - 1] + resultArray[i - 2];
        }
        return resultArray[n - 1];
    }
}

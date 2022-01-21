package cn.roncantwritecode.leetcodejava.maxprofit;

/**
 * @author Ron Wu
 * @date 2020/4/1
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxDepth = new MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxDepth.maxProfit(prices);
        System.out.println(result);
    }

    /**
     * 遍历 O(n)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                result = Math.max(result, prices[i] - min);
            }
        }

        return result;
    }
}

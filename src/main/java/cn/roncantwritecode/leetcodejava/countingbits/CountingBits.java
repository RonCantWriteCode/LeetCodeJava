package cn.roncantwritecode.leetcodejava.countingbits;

import cn.roncantwritecode.leetcodejava.utils.IntArrayUtils;

/**
 * @author Ron Wu
 * @date 2022/1/21
 */
public class CountingBits {

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] result = countingBits.countBits(5);
        IntArrayUtils.printIntArray(result);
    }

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
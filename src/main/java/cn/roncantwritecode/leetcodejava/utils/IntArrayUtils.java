package cn.roncantwritecode.leetcodejava.utils;

/**
 * @author Ron
 * @date 2022/1/21
 */
public class IntArrayUtils {
    public static void printIntArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i< array.length; i++) {
            System.out.print(array[i]);
            if (i< array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}

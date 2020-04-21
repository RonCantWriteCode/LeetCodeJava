package cn.roncantwritecode.leetcodejava.hammingdistance;

/**
 * @author wurunlong
 * @date 2020/4/21
 */
public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        int x = 2;
        int y = 4;
        int result = hammingDistance.hammingDistance(x, y);
        System.out.println(result);

    }

    /**
     * 异或 O(1)
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        return Integer.bitCount(result);
//        int count = 0;
//        while (result != 0) {
//            if ((result & 1) == 1) {
//                count++;
//            }
//            result = result >> 1;
//        }
//        return count;
    }
}

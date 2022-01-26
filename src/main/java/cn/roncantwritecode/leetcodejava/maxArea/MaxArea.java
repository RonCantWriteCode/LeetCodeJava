package cn.roncantwritecode.leetcodejava.maxArea;

/**
 * @author Ron Wu
 * @date 2022/1/26
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height = {4, 3, 2, 1, 4};
        int result = maxArea.maxArea(height);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        int area = 0;

        while (left < right) {
            // 计算面积
            area = Math.min(height[left], height[right]) * (right - left);

            // 记录最大面积
            maxArea = Math.max(maxArea, area);

            // 判断左右指针，小的往中间移动
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

### 题目描述
11. 盛最多水的容器

给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器。

示例1:

![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/maxArea/question_11.jpg)

```
输入：[1,8,6,2,5,4,8,3,7]
输出：49 
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
```

示例2:
```
输入：height = [1,1]
输出：1
```

示例3:
```
输入：height = [4,3,2,1,4]
输出：16
```

示例4:
```
输入：height = [1,2,1]
输出：2
```

提示：

* n == height.length
* 2 <= n <= 105
* 0 <= height[i] <= 104



### 题解

#### 算法1 双指针 O(n)

双指针，初始位置左右指针指向数组两端，面积就是 min(左右指针的值) * 长度。核心移动就是移动左右指针中小的值，原因是：假设保持小的值不变，移动较大的值，那么其实是长度是一直变小的，并且后续以小的值为一个边界的时候边界最小的值也不会超过min(左右指针的值)，所以可以判断以最小值为其中一个端点的最大面积其实就是目前面积。双指针时间复杂度O(n)

```$java
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
```

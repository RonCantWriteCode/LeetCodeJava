### 题目描述
53.最大子序和

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
```
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

### 题解

#### 算法1 动态规划 O(n)
从左到右计算每个位置的最大值，如max(nums(i-1))>0，则max(nums(i)) = nums(i) + max(nums(i-1))，否则max(nums(i)) = nums(i)。

注意:
1. 可以用原数组存每个位置最大值，节省空间

```$java
/**
 * 动态规划 O(n)
 * @param nums
 * @return
 */
public int maxSubArray(int[] nums) {
    int max = nums[0];
    for (int i=1; i<nums.length; i++) {
        if (nums[i-1] > 0) {
            nums[i] += nums[i - 1];
        }
        max = Math.max(nums[i], max);
    }

    return max;
}
```

#### 算法2 分治法 O(n*log(n))
最大子序和，分成了三个情况：都在左边、都在右边和包含中间字符，然后递推处理。递归总共log(n)层，每层O(n)，所以时间复杂度是O(n*log(n))

```$java
/**
 * 分治算法 O(n*log(n))
 * @param nums
 * @return
 */
public int maxSubArrayDivide(int[] nums) {
    return helper(nums, 0, nums.length - 1);
}
public int crossSum(int[] nums, int left, int right, int p) {
    if (left == right) {
        return nums[left];
    }

    int leftSubsum = Integer.MIN_VALUE;
    int currSum = 0;
    for(int i = p; i > left - 1; --i) {
        currSum += nums[i];
        leftSubsum = Math.max(leftSubsum, currSum);
    }

    int rightSubsum = Integer.MIN_VALUE;
    currSum = 0;
    for(int i = p + 1; i < right + 1; ++i) {
        currSum += nums[i];
        rightSubsum = Math.max(rightSubsum, currSum);
    }

    return leftSubsum + rightSubsum;
}

public int helper(int[] nums, int left, int right) {
    if (left == right) {
        return nums[left];
    }

    int p = (left + right) / 2;

    int leftSum = helper(nums, left, p);
    int rightSum = helper(nums, p + 1, right);
    int crossSum = crossSum(nums, left, right, p);

    return Math.max(Math.max(leftSum, rightSum), crossSum);
}
```

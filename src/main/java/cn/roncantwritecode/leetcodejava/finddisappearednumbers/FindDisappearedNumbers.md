### 题目描述
448.找到所有数组中消失的数字

给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:
```
输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
```


### 题解

#### 算法1 数组修改 O(n)

遍历数组，把当前数字的绝对值-1所在下标数字修改成负数。再遍历一遍数组，为正数的数组下标+1即为未出现数字。实际上相当于利用下标和数值的正负构建了一个简易的哈希表,用来存储每个数字的状态。时间复杂度O(n)，空间复杂度O(1)。


```$java
/**
 * @param nums
 * @return
 */
public List<Integer> findDisappearedNumbers(int[] nums) {
    // 插入使用LinkedList效率较高
    List<Integer> result = new LinkedList<Integer>();

    for (int num : nums) {
        int keyIndex = Math.abs(num) - 1;
        // 把当前数字的绝对值-1所在下标数字修改成负数
        if (nums[keyIndex] > 0) {
            nums[keyIndex] = -1 * nums[keyIndex];
        }
    }

    // 为正数的数组下标+1即为未出现数字
    for (int i = 1; i <= nums.length; i++) {
        if (nums[i - 1] > 0) {
            result.add(i);
        }
    }

    return result;
}
```
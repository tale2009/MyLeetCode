# 1. 两数之和

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]

---

这个题目目前想到的最好的时间复杂度为O(n)。但是如果我们用字典法以数组值为key，坐标为value构建字典map的话，当出现示例3的情况下，故不能出现下面代码中预先初始化map的写法

```
        int[] indexs = new int[2];
        Map<Integer,Integer> dictMap=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            dictMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(dictMap.get(target-nums[i])!=null)
            {
                indexs[0]=dictMap.get(target-nums[i]);
                indexs[1]=i;
                return indexs;
            }
            else
            {
                dictMap.put(nums[i],i);
            }
        }
        return null;
```

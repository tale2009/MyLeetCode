# 3. 无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0



---
本题的解答最优方法就是滑动窗口算法，它使该题的的时间复杂度为O(n)，如下图中最长的连续的绿色段（窗口）的长度则为题解。

<div align='center'>

![](https://github.com/tale2009/MyLeetCode/blob/master/LeetCodeSolution/3.%20Longest%20Substring%20Without%20Repeating%20Characters/1.png?raw=true)
</div>

以下是本题利用滑动窗口算法写出的题解
```
        Map<Character, Integer> strMap=new HashMap<>();
        int length=0;//字符串长度
        int currentIndex=0;//当前窗口左起起始位置下标
        for(int i=0;i<s.length();i++)
        {
            if(strMap.containsKey(s.charAt(i)))
            {
                currentIndex=Math.max(currentIndex,strMap.get(s.charAt(i))+1);
            }
            strMap.put(s.charAt(i),i);
            length=Math.max(length,i-currentIndex+1);
        }
```
（1）每当content.containsKey(s.charAt(i))找到重复数据的时候我们就要调整窗口的位置，这里会有两种情况

1.当重复数据坐标大于窗口左侧下标的时候，那么窗口下标就移动到该下标的下一格位置即content.get(s.charAt(i))+1。
<div align='center'>

![](https://github.com/tale2009/MyLeetCode/blob/master/LeetCodeSolution/3.%20Longest%20Substring%20Without%20Repeating%20Characters/2.png?raw=true)
</div>
2.当重复数据的坐标位置小于窗口当前左标下标的时候则不移动下标位置。
<div align='center'>

![](https://github.com/tale2009/MyLeetCode/blob/master/LeetCodeSolution/3.%20Longest%20Substring%20Without%20Repeating%20Characters/3.png?raw=true)
</div>

（2）strMap.put(s.charAt(i),i)即记录字符位置，帮助判断窗口左标是否移动。

（3）maxlength=Math.max(maxlength,i-currentIndex+1)的i-currentIndex+1中的+1，就是为了算出当前字符串的长度。
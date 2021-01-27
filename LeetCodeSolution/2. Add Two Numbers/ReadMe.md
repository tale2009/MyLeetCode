### 2. 两数相加
给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 

示例 1：


输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]



---
![](https://github.com/tale2009/MyLeetCode/blob/master/LeetCodeSolution/2.%20Add%20Two%20Numbers/diagram.png?raw=true)
给定的链表已经为我们进行逆序了所以我们直接进行相加就可以了，运算的进位方向则由右到左，本题目主要就是考察链表的操作，只要代码同时从两个链表相同的index读取数字相加，处理好进位就能解决该问题，下图是解答的初版代码，其中可优化点1.就是通过求余和求商来减少if判断的消耗 2.是把结果链表的操作并入计算循环当中。
```
        List<Integer> result=new ArrayList<>();
        int over=0;//10进制计数
        while(true)
        {
            int NodeIntValue1=0;
            int NodeIntValue2=0;
            if(l1!=null)
                NodeIntValue1=l1.val;
            if(l2!=null)
                NodeIntValue2=l2.val;
            int nodesum=NodeIntValue1+NodeIntValue2+over;
            if(nodesum>9) {
                result.add(Integer.valueOf(String.valueOf(nodesum).substring(1,2)));
                over = 1;
            }
            else {
                result.add(nodesum);
                over = 0;
            }
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            if(l1==null && l2==null) {
                if(over==1)
                    result.add(over);
                break;
            }
        }
        ListNode head=new ListNode(result.get(0));
        ListNode currentNpode=head;
        for(int i=1;i<result.size();i++)
        {
            ListNode temp=new ListNode(result.get(i));
            currentNpode.next=temp;
            currentNpode=temp;
        }
        return head;     
```
这个题目目前想到的最好的时间复杂度为O(max(l1.length,l2.length))l1和l2链表中较长的链表长度。优化见同文件夹代码
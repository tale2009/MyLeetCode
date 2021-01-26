import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode currentNpode=head;//链表操作的临时字段
        int over=0;//10进制计数
        while(true)
        {

            int NodeIntValue1=0;
            int NodeIntValue2=0;
            if(l1!=null)
                NodeIntValue1=l1.val;
            if(l2!=null)
                NodeIntValue2=l2.val;
            //over代表着上一index的计算是否满10进1
            currentNpode.val=(NodeIntValue1+NodeIntValue2+over)%10;
            over=(NodeIntValue1+NodeIntValue2+over)/10;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            if(l1==null && l2==null) {
                if(over==1)
                    currentNpode.next=new ListNode(1);
                break;
            }
            currentNpode.next=new ListNode(0);//建立下一个链表点
            currentNpode=currentNpode.next;//设定下次操作链点
        }
        return head;
    }
}

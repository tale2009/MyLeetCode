import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode currentNpode=head;
        int over=0;//10进制计数
        while(true)
        {

            int NodeIntValue1=0;
            int NodeIntValue2=0;
            if(l1!=null)
                NodeIntValue1=l1.val;
            if(l2!=null)
                NodeIntValue2=l2.val;
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
            currentNpode.next=new ListNode(0);
            currentNpode=currentNpode.next;
        }
        return head;
    }
}

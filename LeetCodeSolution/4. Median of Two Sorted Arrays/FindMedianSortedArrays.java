import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> intlist=new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            intlist.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            intlist.add(nums2[i]);
        }
        Collections.sort(intlist);
        if(intlist.size()==1)
            return intlist.get(0);
        else if(intlist.size()%2==1)
            return intlist.get(intlist.size()/2);
        else
            return (Double.valueOf(intlist.get(intlist.size()/2-1))+
                    Double.valueOf(intlist.get(intlist.size()/2)))/Double.valueOf(2);
    }
}

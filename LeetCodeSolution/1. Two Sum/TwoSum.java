import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer,Integer> dictMap=new HashMap<>();
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
    }
}

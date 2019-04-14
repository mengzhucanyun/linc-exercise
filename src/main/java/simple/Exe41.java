package simple;

/**
 * Created by linc on 2018/11/12.
 */
public class Exe41 {
    public int firstMissingPositive(int[] nums) {
        int [] nums1=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<=nums.length){
                nums1[nums[i]-1]=1;
            }
        }
        for (int j=0;j<nums1.length;j++){
            if (nums1[j]==0){
                return j+1;
            }
        }
        return nums.length+1;
    }
}

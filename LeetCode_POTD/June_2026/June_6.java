/*
Computed sum of all elements (in ls)       (Left Sum)
Changing value itself in nums with maintaing left sum(ls) and right sum(rs)
TC- O(n), SC- O(1)

(Even if we take array for output seperately- space will be occupied same as output and input storage is not counted)
*/

package Leetcode_POTD.June_2026;

public class June_6 {
    public int[] leftRightDifference(int[] nums) {
        int ls=0, rs=0;
        for(int i=0;i<nums.length;i++) ls+=nums[i];
        for(int i=nums.length-1;i>=0;i--){
            int t=nums[i];
            ls-=t;
            nums[i]=Math.abs(ls-rs);
            rs+=t;
        }
        return nums;
    }
}

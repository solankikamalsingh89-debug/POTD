package Leetcode_POTD.June_2026;

/*
We first sorted array in ascending order
Then traverse in increasing order to keep check tiil this number maximumLength with help of storing length with numbers appeared in HashMap(It also helped in checking if sqrt appeared or not)
Also special check on 1 in starting as its sqrt is not less than itself
*/

public June_27 {
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> f2=new HashMap<>();
        int i=0;
        while(i<nums.length && nums[i]==1) i+=1;
        int m=Math.max(1, (i&1)==0 ? i-1 : i );
        while (i<nums.length){ 
            int j=(int)Math.sqrt(nums[i]);
            if (j*j==nums[i] && f2.containsKey(j)){
                if(i+1<nums.length && nums[i]==nums[i+1]){
                    f2.put(nums[i],f2.get(j)+2);
                    while(i+1<nums.length && nums[i]==nums[i+1]) i+=1;
                }
                m=Math.max(m,f2.get(j)+1);
            }
            else if(i+1<nums.length && nums[i]==nums[i+1]){
                f2.put(nums[i],2);
                while (i+1<nums.length && nums[i]==nums[i+1]) i+=1;
            }
            i+=1;
        }
        return m;
    }
}

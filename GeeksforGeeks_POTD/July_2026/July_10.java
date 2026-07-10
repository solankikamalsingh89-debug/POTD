package GeeksforGeeks_POTD.July_2026;

/*
Optimized Code(PYTHON CODE):
Checking from length 2 if of this number of consecutive number could give lesser(proceed to +1 length) or equal to n(add 1 and proceed to +1 length) 
How to Check:
    BaseSum is acting as - if we choose any k terms- then make all of them equal by substracting 0,1..k-1 from respective terms-- now all k terms equal first term so should be divided by k if exists
TC - O(sqrt(n)), SC -  O(1)

2-pointer question, handling condition if sum <,>,= n and adjusting pointer accordingly(JAVA CODE- Gave TLE in python)
TC - O(n), SC - O(1)
*/

public class July_10 {
    public int getCount(int n) {
        if(n==1) return 0;
        int ans=0;
        int i=1,j=1;
        int sum=1;
        while(j<n){
            if(sum==n) { ans++; sum+=++j; sum-=i++;}
            else if(sum<n) sum+=++j;
            else sum-=i++;
        }
        return ans;
    }
}

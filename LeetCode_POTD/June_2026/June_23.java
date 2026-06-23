package Leetcode_POTD.June_2026;

/*
With few examples, i found pattern and reason to pattern as:
e.g (r-l=5), then let's think first 5 numbers and notice pattern on length given n
 
Inc(k) means reached at 'k'(no.) as increasing
(When n=1, there are 'r-l+1' paths(starting with 1,2...(r-l+1) ))
n       2   3   4 ....
Inc2    1   4   10
Inc3    2   7   19
Inc4    3   9   26
Inc5    4   10  30
Dec1    4   10  30
Dec2    3   9   26
Dec3    2   7   19
Dec4    1   4   10

So, we can it's happening/increasing in a way previous array elemnts getting added to new
So we will maintain array of number of Inc and Dec (1 to (r-l+1)) and when reach the required 'n' sum element of array and double it to cover symmetry
(Also at each step we have to keep check on MOD)

TC - O(n*(r-l)), SC - O(r-l)

*/

public class June_23 {
    int MOD=1_000_000_007;

    public int zigZagArrays1(int n, int l, int r) { //Only 1 array is used, this time flg to choose array is used as flg of array inverted or not
        long[] h1=new long[r-l];
        for(int i=0;i<r-l;i++) h1[i]=r-l-i;
        for(int i=2;i<n;i++){
            if(i%2==0){
                for(int j=1;j<r-l;j++){
                    h1[j]=(h1[j]+h1[j-1])%MOD;
                }
            }else{
                for(int j=r-l-2;j>=0;j--){
                    h1[j]=(h1[j]+h1[j+1])%MOD;
                }
            }
        }
        long sum=0L;
        for(int j=0;j<r-l;j++) sum=(sum+2*h1[j])%MOD;
        return (int)sum;
    }

    public int zigZagArrays2(int n, int l, int r) { //In this used 2 array to maintain array
        long[] h1=new long[r-l];
        long[] h2=new long[r-l];
        for(int i=0;i<r-l;i++) h1[i]=r-l-i;
        for(int i=2;i<n;i++){
            long sum=0L;
            if(i%2==0){
                for(int j=0;j<r-l;j++){
                    sum=(sum+h1[j])%MOD;
                    h2[r-l-j-1]=sum;
                }
            }else{
                for(int j=0;j<r-l;j++){
                    sum=(sum+h2[j])%MOD;
                    h1[r-l-j-1]=sum;
                }
            }
        }
        if(n%2==1){
            long sum=0L;
            for(int j=0;j<r-l;j++) sum=(sum+2*h2[j])%MOD;
            return (int)sum;
        }else{
            long sum=0L;
            for(int j=0;j<r-l;j++) sum=(sum+2*h1[j])%MOD;
            return (int)sum;
        }
    }
}

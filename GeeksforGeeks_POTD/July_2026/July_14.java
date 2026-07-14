package GeeksforGeeks_POTD.July_2026;

/*
Storing the minmum must value and as x depends on previous numbers so reverse traversal(to avoid multiple depency and work with threshold x only)
x at traversal point -- this should be atleast output- find the at least input

TC - O(n), SC - O(1)
*/

public class July_14 {
    public int find(int[] arr) {
        int x=0;
        for(int i=arr.length-1;i>=0;i--){
            if(x<arr[i]) x+=(arr[i]-x+1)/2;
            else x-=(x-arr[i])/2;
        }
        return x;
    }
}
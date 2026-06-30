package GeeksforGeeks_POTD.June_2026;

/*
I can be done with 2^n choosing either multiplying with 0 or next b's element
So to optimize it I tried with dot[i][j] showing till length 'i' of 'a', we have used 'j' zeroes in multiplication and value represents maximum value attained in so
To optimize more (Memory)- 2D to 1D array

TC - O(n*(n-m)), SC - O(n)
*/

public class June_29 {
    public int maxDotProduct(int[] a, int[] b) {
        int n=a.length;
        int nm=n-b.length;
        int[] dot=new int[n+1]; //Till idx i how many 0 used--dot product
        for(int j=1;j<=n-nm;j++) dot[j]=dot[j-1]+a[j-1]*b[j-1];
        int prev=0;
        for(int j=1;j<=nm;j++){
            prev=dot[0];
            for(int i=1;i<=n;i++){
                int prev1=dot[i];
                if(i-j>0 && i-j-1<n-nm) dot[i]=Math.max(dot[i-1]+a[i-1]*b[i-j-1],prev);
                else dot[i]=prev;
                prev=prev1;
            }
        }
        return dot[n];
    }
}

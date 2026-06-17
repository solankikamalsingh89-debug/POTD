package GeeksforGeeks_POTD.June_2026;
/*
Take maximum number of 3 with remaining 2 only.
(As 6=(2*2*2=8),(3*3=9))--Similarly for others
*/
public class June_17 {
    public int maxProduct(int n) {
        if (n<4) return n-1;
        if (n%3==1) return (int)(4*Math.pow(3,(n-4)/3));
        if (n%3==2) return (int)(2*Math.pow(3,n/3));
        return (int)Math.pow(3,n/3);
    }
}

package GeeksforGeeks_POTD.June_2026;
/*
Just count either closing bracket and then print count(as for each iteration (no. of (- no. of ) )will dec no matter which bracket is this)
Or count opening bracket and print (n-count) as this time traversal will be made from back to compare
*/
public class June_11 {
    public int findIndex(String s) {
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')') c++;
        }
        return c;
    }
}

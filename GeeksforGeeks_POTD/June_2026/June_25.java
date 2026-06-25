package GeeksforGeeks_POTD.June_2026;

/*
Clearly if n is 1 then  only we can use 0, else not(As 0 can be used in staarting only-- which will interrupt to make it n-digit number)--> so, define it's result sepeartely
So, if n greater than 9 -> Can't make number(as only 9 digits to use)
For rest cases: ( n = 2 to 9 )
    Using helper function keep a number maker each time adding a last digit in it(which is strictly increasing) with recursion

TC - O(n^2), SC - O(n){ Recursion stack }
*/

import java.util.ArrayList;
import java.util.Arrays;

public class June_25 {
    public static ArrayList<Integer> increasingNumbers(int n) {
        if(n>9) return new ArrayList<>();
        if(n==1) return new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> ans=new ArrayList<>();
        increasingNumbers(0, 0, n, ans);
        return ans;
    }
    private static void increasingNumbers(int a, int l, int n, ArrayList<Integer> ans){
        if(l==n){
            ans.add(a);
            return;
        }
        for(int i=a%10+1;i<10;i++){
            increasingNumbers(a*10+i, l+1, n, ans);
        }
    }
}

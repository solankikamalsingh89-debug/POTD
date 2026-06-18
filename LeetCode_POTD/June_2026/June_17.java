package Leetcode_POTD.June_2026;

/*
Firstly check the final length of result. 
-If length <= k --> return '.' (As k is 0-indexed)
-Else
    Traverse string in reverse (undoing operation)-- maintain the length of result after undoing each operation
    for alphabet --> As answer will be any of added alphabet for sure, so check when undoing this operation if k+1==length (As k is 0-indexed), otherwise length--
    for * --> Add 1 i length
    for # --> Length will be halved, but if doing this length becomes <= k, means k is included in repeated string (so substract k by (length/2) as well)
    for % --> Make k reaching from back (k=l-k-1)
*/

public class June_17 {
    public char processStr(String s, long k) {
        long l=0;
        for(int i=0;i<s.length();i++){
            char q=s.charAt(i);
            if(q=='*'){
                l=Math.max(0,l-1);
            }
            else if(q=='#') l*=2;
            else if(q=='%'){continue;}
            else{
                l++;
            }
        }
        if(k>=l) return '.';
        for(int i = s.length() - 1; i >= 0; i--) {
            char q=s.charAt(i);
            if(q == '*') l++;
            else if(q == '#') {
                if(k + 1 > (l + 1) / 2) k -= l / 2;
                l = (l + 1) / 2;
            } else if(q == '%') {
                k = l - k - 1;
            } else {
                if(k + 1 == l) return q;
                l--;
            }
        }
        return '.';
    }
}

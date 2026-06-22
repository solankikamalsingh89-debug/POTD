package Leetcode_POTD.June_2026;

/*
Easy
TC - O(n), SC - O(1)
*/

public class June_22 {
    public int maxNumberOfBalloons(String text) {
        int[]a=new int[26];
        for(int i=0;i<text.length();i++){
            a[text.charAt(i)-'a']++;
        }
        return (int)Math.min(Math.min(a['l'-'a']/2,a['o'-'a']/2),Math.min(a[1],Math.min(a[0],a['n'-'a'])));
    }
}

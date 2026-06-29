package Leetcode_POTD.June_2026;

/*
Easy
New Learning: str.contains(str2)
*/

public class June_29 {
    public int numOfStrings(String[] patterns, String word) {
        int a=0;
        for(String i: patterns){
            if(word.contains(i))a++;
        }
        return a;
    }
}

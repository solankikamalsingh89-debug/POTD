package Leetcode_POTD.June_2026;

import java.util.ArrayDeque;

/* 
Just did as mentioned: Use StringBUilder to prevent excessive copying of string everytime 
Better method: processStr1(Deque + reverse flag + StringBuilder)
*/
public class June_16 {
    public String processStr(String s) {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                if(res.length()>0) res.deleteCharAt(res.length() - 1); 
            }
            else if(s.charAt(i)=='#'){
                res.append(res);
            }
            else if(s.charAt(i)=='%'){
                res.reverse();
            }
            else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public String processStr1(String s) {
        ArrayDeque<Character> dq = new ArrayDeque<>();
        boolean rev = false;
        for (char ch : s.toCharArray()) {
            if (ch == '%') {
                rev = !rev;                          // O(1) — just flip flag
            } else if (ch == '#') {
                Character[] copy = dq.toArray(new Character[0]);
                for (char c : copy) dq.addLast(c);  // O(n) — unavoidable
            } else if (ch == '*') {
                if (!dq.isEmpty()) {
                    if (rev) dq.pollFirst();          // O(1)
                    else     dq.pollLast();           // O(1)
                }
            } else {
                if (rev) dq.addFirst(ch);            // O(1)
                else     dq.addLast(ch);             // O(1)
            }
        }
        // Final output: respect the rev flag
        StringBuilder sb = new StringBuilder();
        if (rev) {
            Iterator<Character> it = dq.descendingIterator();
            while (it.hasNext()) sb.append(it.next());
        } else {
            for (char c : dq) sb.append(c);
        }
        return sb.toString();
    }
}
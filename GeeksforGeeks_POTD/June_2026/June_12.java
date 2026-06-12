package GeeksforGeeks_POTD.June_2026;
/*
Define hashmap to keep track of number of diiferent strings occuring with what frequency
With traversal, if number of string>2 or number of strings with frequency>1 return false
Otherwise return true
*/

import java.util.HashMap;

public class June_12 {
    public boolean kSubstr(String s, int k) {
        HashMap<String,Integer> a=new HashMap<>();
        boolean o=false;
        int i=0;
        while(i<s.length()){
            String q=s.substring(i,i+k);
            if(a.containsKey(q)){
                int q1=a.get(q);
                if(q1==1){
                    if(o) return false;
                    else o=true;
                }
                a.put(q,q1+1);
            }
            else a.put(q,1);
            if(a.size()>2) return false;
            i+=k;
        }
        return true;
    }
}

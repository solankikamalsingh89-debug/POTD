package Leetcode_POTD.July_2026;

/*
To avoid check for lower limit at each iteration, make the lowest required number(not considering high limit for now), then iterate until high limit
How we iterate: By keeping first digit fix and number of digits, then each time increement first digit (if last digit exceed 9- not possible, start from length+1 and intitial digit 1)

TC - O(log10(n)), SC - O(1)
*/

import java.util.ArrayList;
import java.util.List;

public class July_13 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        int n=(int)(Math.log(low)/Math.log(10));
        int i=low/(int)Math.pow(10,n);
        // Creating lowest number
        if(n+i>9){
            n++;
            if(n>=9) return ans; 
            i=1;
        }
        long num=0;
        for(int k=0;k<=n;k++){
            num=num*10+i+k;
        }
        if(num<low){
            i++;
            if(n+i>9){
                n++;
                if(n>=9) return ans; 
                i=1;
            }
            num=0;
            for(int k=0;k<=n;k++){
                num=num*10+i+k;
            }
        }
        //Add satisfying number and increase to upper level
        while(n<9 && num<=high){
            ans.add((int)num);
            i++;
            if(n+i>9){
                n++;
                if(n>=9) return ans; 
                i=1;
            }
            num=0;
            for(int k=0;k<=n;k++){
                num=num*10+i+k;
            }
        }
        return ans;
    }
}

package GeeksforGeeks_POTD.June_2026;

/*
total0=(All 0's * 4(as 4 direction) i.e. Coverage)
Firstly loop horizontally to count total0 with keeping track of horizontal 0 not to be counted (Remeber case: 0 in all columns(Don't count twice))
Then loop vertically to substrract not in coverage 0(Similarly here also remember same case to not substract twice)
*/

public class June_18 {
    public int findCoverage(int[][] mat) {
        int total0=0;
        boolean f1=true;
        for(int i[]:mat){
            int j=0;
            while(j<i.length && i[j]==0) j++;
            if(j==i.length){total0+=2*j; continue;}
            total0+=3*j;
            int cnt0=0;
            while(j<i.length){
                if(i[j]==0){
                    cnt0++;
                }
                else {
                    total0+=4*cnt0;
                    cnt0=0;
                }
                j++;
            }
            total0+=3*cnt0;
        }
        for(int i=0;i<mat[0].length;i++){
            int j=0;
            while(j<mat.length){
                if(mat[j][i]==0) total0--;
                else{
                    j=mat.length-1;
                    while(mat[j][i]==0){
                        total0--;
                        j--;
                    }
                    break;
                }
                j++;
            }
            if(j==mat.length) total0-=j;
        }
        return total0;
    }
}

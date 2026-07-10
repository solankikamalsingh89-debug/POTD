package GeeksforGeeks_POTD.July_2026;

/*
Make a boolean of rows and columns sepeately to represent which row is not occupied
Then find max gap in rows and columns seperately to find maximum gap area

TC - O(n+m), SC(n+m)
*/

public class July_7 {
    public int largestArea(int n, int m, int[][] arr) {
        boolean[] c=new boolean[n];
        boolean[] r=new boolean[m];
        for(int[] i:arr) c[i[0]-1]=r[i[1]-1]=true;
        int c1=0,r1=0,cc=0;
        for(boolean i:c){
            if(!i) cc++;
            else{
                if(c1<cc) c1=cc;
                cc=0;
            }
        }
        if(c1<cc) c1=cc;
        cc=0;
        for(boolean i:r){
            if(!i) cc++;
            else{
                if(r1<cc) r1=cc;
                cc=0;
            }
        }
        if(r1<cc) r1=cc;
        return c1*r1;
    }
}

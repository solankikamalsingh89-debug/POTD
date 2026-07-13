package GeeksforGeeks_POTD.July_2026

/*
Simple question as in Maths 7th class book to get all runners on circular track meet again.
So find all circular steps and get all of their lcm. -- To avoid multiple times lcm for same circle, made a visited array

TC - O(n*log(n)){logn for worst case hcf}, SC - O(n)
*/

public class July_13 {
    int minOperations(int[] b) {
        int n=b.length;
        boolean[] vis=new boolean[n];
        int lcm=1;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int j=b[i]-1;
                int steps=1;
                while(j!=i){
                    vis[j]=true;
                    j=b[j]-1;
                    steps++;
                }
                lcm=lcm*steps/(hcf(lcm,steps));
            }
        }
        return lcm;
    }
    private int hcf(int a,int b){
        if(a==0) return b;
        return hcf(b%a,a);
    }
}

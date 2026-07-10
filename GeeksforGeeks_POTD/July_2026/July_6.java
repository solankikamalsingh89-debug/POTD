package GeeksforGeeks_POTD.July_2026;

/*
Whenever becomes equal take the maximum previous to it and then check for furhter-- Making partition by equal elements and choosing larger sum of part

TC - O(n), SC - O(1)
*/

public class July_6 {
    public int maxPathSum(int[] a, int[] b) {
        int i=0,j=0;
        int sum=0;
        int s1=0,s2=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                s1+=a[i];
                i++;
            }
            else if(a[i]>b[j]){
                s2+=b[j];
                j++;
            }
            else{
                sum+=Math.max(s1,s2)+a[i];
                i++;
                j++;
                s1=s2=0;
            }
        }
        while(i<a.length) s1+=a[i++];
        while(j<b.length) s2+=b[j++];
        sum+=Math.max(s1,s2);
        return sum;
    }
}

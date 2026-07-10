package GeeksforGeeks_POTD.July_2026;

/*
Make pairs for remainder
And for middle and rem=0--> act differently

TC - O(n), SC - O(k)
*/

public class July_9 {
    public int countKdivPairs(int[] arr, int k) {
        int rem[]=new int[k];
        for(int i:arr){
            rem[i%k]++;
        }
        int ans=(rem[0]*(rem[0]-1))/2;
        int l=1, h=k-1;
        while(l<h){
            ans+=rem[l]*rem[h];
            l++; h--;
        }
        if(l==h){
            ans+=(rem[l]*(rem[l]-1))/2;
        }
        return ans;
    }
}

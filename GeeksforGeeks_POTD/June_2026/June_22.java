package GeeksforGeeks_POTD.June_2026;

/*
Firstly tried brute force with O(n^2), get TLE(Finding all possible area values)
Later:
    Mark starting block index in ArrayList 'i', either 1st block or if maximum from front traversal
    Similarly mark ArrayList 'j' by back traversal

    Now looped over j(as removing from last done in O(1) without extra variable) nesting loop over i to find all possbile area under these blobk to get maxiimum area as answer

TC - O(n^2), SC - O(n)
*/

import java.util.ArrayList;
import java.util.List;

public class June_22 {
    public int maxArea(List<Integer> height) {
        int l=height.size();
        int ans=Math.min(height.get(0),height.get(l-1))*(l-2);
        ArrayList<Integer> i=new ArrayList<>();
        int mi=height.get(0);
        ArrayList<Integer> j=new ArrayList<>();
        int mj=height.get(l-1);
        for(int k=l-2;k>=2;k--){
            if(height.get(k)>mj){
                mj=height.get(k);
                j.add(k);
                ans=Math.max(ans,Math.min(height.get(0),mj)*(k-1));
            }
        }
        for(int k=1;k<l-2;k++){
            if(height.get(k)>mi){
                mi=height.get(k);
                i.add(k);
                ans=Math.max(ans,Math.min(height.get(l-1),mi)*(l-k-2));
            }
        }
        while(j.size()>0){ //Choosen j, so that can removeLast() i.e. in O(1)
            int j1=j.removeLast();
            int k=0;
            while(k<i.size() && i.get(k)<j1-1){
                ans=Math.max(ans,Math.min(height.get(j1),height.get(i.get(k)))*(j1-i.get(k)-1));
                k++;
            }
        }
        return ans;
    }
}

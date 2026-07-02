package GeeksforGeeks_POTD.June_2026;

/*
We created an arraylist to store number coming at index after deleting other elements.
So, if a number is bigger than last element, just add it in the end. Else, traverse backward until find number just larger or equal to it to replace it with previous index holding(Because if any is going to take the further sequence with more length, it have t overcome previous sequence length )

TC - O(n^2), SC - O(n)
*/

public class June_30 {
    public int minInsAndDel(int[] a, int[] b) {
        HashSet<Integer> B=new HashSet<>();
        for(int i:b) B.add(i);
        ArrayList<Integer>ans=new ArrayList<>(); //Stores maximum value at that index
        ans.add(0); //At 0 length maximum=0
        int j=0; //Stores last index value
        for(int i:a){
            if(B.contains(i)){
                if(ans.get(j)<i){
                    ans.add(i);
                    j++;
                }
                else{
                    int k=j-1;
                    while(ans.get(k)>=i) k--;
                    ans.set(k+1,i);
                }
            }
        }
        return a.length+b.length-2*(ans.size()-1);
    }
}

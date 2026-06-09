package GeeksforGeeks_POTD.June_2026;
/*
We keep condition with prev element to be empty or no restriction
From index 0, we checked for empty with next to be 0(empty), then seat one person. -> Then one idx is skipped
If idx is occupied, check if next is also occupied-> false else sikp next idx
At the end check for last idx if also can be seated
Then check condition for at least k get seated
TC - O(n), SC - O(1)
*/
public class June_9 {
    public boolean canSeatAllPeople(int k, int[] seats) {
        if(seats.length==1){
            if(k==0 || (k==1 && seats[0]==0)) return true;
            else return false;
        }
        int i=0;
        for(;i<seats.length-1;i++){
            if(seats[i]==seats[i+1]){
                if(seats[i]==0){
                    k-=1;
                    i++;
                }
                else return false;
            }
            if(seats[i]==1) i++;
        }
        if(i==seats.length-1 && seats[seats.length-1]==0) k-=1;
        if(k<=0) return true;
        return false;
    }
}

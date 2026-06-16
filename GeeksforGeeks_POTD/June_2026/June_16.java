package GeeksforGeeks_POTD.June_2026;

/*
Traversed in reverse in queries so that maintain overall xor needed to do on element added previously in query (Later if back traversed)(At end don't forget query(0,0))
(Doing front traversal gave TLE)

TC - O(qlogq){Sorting}, SC - O(1)
*/
import java.util.ArrayList;
import java.util.Collections;

public class June_16 {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> a=new ArrayList<>();
        int xor=0;
        for (int i=queries.length-1;i>=0;i--){
            if(queries[i][0]==0){
                a.add(queries[i][1]^xor);
            }
            else{
                xor^=queries[i][1];
            }
        }
        a.add(xor);
        Collections.sort(a);
        return a;
    }
}

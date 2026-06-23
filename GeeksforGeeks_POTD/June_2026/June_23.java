package GeeksforGeeks_POTD.June_2026;

/*
Brute force- Easy
*/

public class June_23 {
    int maxPeopleDefeated(int p) {
        //Let's say n can be defeated--> p-(n(n+1)(2n+1)/6)<(n+1)^2
        //n^3+(9/2)n^2+(13/2)n+(6-p)/2>0 //May solve it via completing the square method
        //let's check by p=10: n3+4.5n2+6.5n-2>0 -->n(n+root(6.5))2...... too hectic--numbers are not too large, so do it by brute force
        int k=0;
        while(p>=0){
            k++;
            p-=k*k;
        }
        return k-1;
    }
}
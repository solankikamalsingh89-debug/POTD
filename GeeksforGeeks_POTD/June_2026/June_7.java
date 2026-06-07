package GeeksforGeeks_POTD.June_2026;
/*
Bit Method:(Soomething new to learn)
As it is 0-indexed so (pos-1)
So, this is becoming direct 0 for 0,10,100,1000,10000 and counting 1 to remove from front to become this(From this level same is maintained)
(means showing how many time proffesion changes from parent to child)-similar to my code but different way
Ex-(
1E
n=0

2D
n=1 - 1&0=0

4E
n=3 - 11&10=10(2)
n=2 - 10&01=0

5D
n=4 - 100&011=0

6E
n=5 - 101&100=100(4)
n=4 - 100&011=0

22D
n=21 - 10101&10100=10100(20)
n=20 - 10100&10011=10000(16)
n=16 - 10000&01111=0
)

TC - O(log2(pos)), SC - O(1)


MyCode
Irrespective of level, that position if exist are same profession(As seen from pattern- in half it repeats previous level output as input are same)
So, we'll work with position only:
    We declare (l = Elements in no. of prior level to minimum level for given pos)
    (Why taken 1 prior level- To check whether lies in first half or second half)-->If first half remains same, else profession change (maintained by ans) 
    As pos=1 bit_length=1, so we took previously checked itself
TC - O(log2(pos)), SC - O(1)

*/
public class June_7 {
    public String profession(int level, int pos) { //MyCode
        if(pos==1) return "Engineer";
        boolean ans=true; //Engineer
        int l=(int)Math.pow(2,(int)(Math.log(pos-1)/Math.log(2)));
        while(l>0){
            if(pos>l){
                pos-=l;
                ans=!ans;
            }
            l/=2;
        }
        if(ans) return "Engineer";
        else return "Doctor";
    }

    public String profession1(int level, int pos) { //Bit Method
        int n=pos-1; //Starting with 0-indexed
        int c = 0;
        while (n > 0) {
            n &= (n - 1); 
            c++;
        }
        return (c % 2 == 1) ? "Doctor" : "Engineer";
    }
}
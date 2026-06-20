package GeeksforGeeks_POTD.June_2026;

/*
For case b=0--> retun 1
Checked that only 1,2 or 4 digits can appear for every digit coming in last of 'a'
1(1), 2(2,4,8,6), 3(3,9,7,1), 4(4,6), 5(5), 6(6), 7(7,9,3,1), 8(8,4,2,6), 9(9,1)
1,5,6 (same), 4,9(2), 2,3,7,8(4)

So, maximium dvisibility to check by 2 and 4, so took last 2 digits of 'b' to check that
*/

public class June_20 {
    public int getLastDigit(String a, String b) {
        if(b.equals("0")) return 1;
        int j=a.charAt(a.length()-1)-'0';
        int end[]=new int[4];
        end[0]=j;
        end[1]=(j*j)%10;
        end[2]=(end[1]*j)%10;
        end[3]=(end[2]*j)%10;
        if(b.length()<=9) return end[(Integer.parseInt(b)+3)%4];
        else return end[(Integer.parseInt(b.substring(b.length()-2))+3)%4];
    }
}

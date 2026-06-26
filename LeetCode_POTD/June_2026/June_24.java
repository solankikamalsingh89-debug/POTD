package Leetcode_POTD.June_2026;

/*
In th previous version, 'n' was small, so n*(r-l) was not exceeding time limit.
This time it's multiplication is going out for time limit.

# n is (n-1) here ()
So, adding up things (r-l things) n-times is replaced by n-times matrix multiplication
We're making matrix B equals n-times multiplication of matrix( All diagonal elements and upper half element are 1 ) - Let's say matrix C
Now how we will reover time limit here-- By multiplying it maximum log2(n) times only (As matrix can be multiplied according to bits of n) as:
    Use power so that iterationd could be decreased while multiplying (C^4=C*C*C*C=(C^2)^2)

TC - O( log2(n)*(r-l) ), SC - O( (r-l)^2 )
*/

public class June_24 {
    public int zigZagArrays(int n, int l, int r) {
        long A[][] = new long[r - l][r - l], B[][] = new long[r - l][r - l], result = 0;
        for (int i = 0; i < r - l; i++) {
            A[i][i] = 1;
            for (int j = r - l - 1; i + j >= r - l - 1 && j >= 0; j--) {
                B[i][j] = 1;
            }
        }
        for (n--; n > 0; n /= 2) {
            if (n % 2 == 1) {
                A = zigZagArrays(A, B);
            }
            B = zigZagArrays(B, B);
        }
        for (int i = 0; i < r - l; i++) {
            for (int j = 0; j < r - l; j++) {
                result += A[i][j];
            }
        }
        return (int) (result * 2 % 1000000007);
    }
    private long[][] zigZagArrays(long[][] A, long[][] B) {
        long[][] C = new long[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < A.length; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % 1000000007;
                }
            }
        }
        return C;
    }
}

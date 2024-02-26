//recursive program in java to determine st(n,m) para n>=m>=1
//st(n,m) = st(n-1,m-1) + m*st(n-1,m) 
//st(n,1)=1 y st(n,n)=1 

public class Stirling {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println("st(" + n + "," + m + ") = " + st(n, m));
    }

    public static int st(int n, int m) {
        if (n == m) {
            return 1;
        } else if (m == 1) {
            return 1;
        } else {
            return st(n - 1, m - 1) + m * st(n - 1, m);
        }
    }
}




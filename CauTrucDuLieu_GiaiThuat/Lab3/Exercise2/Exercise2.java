package Lab3.Exercise2;

public class Exercise2 {
    // a
    public static long factorial(int n){
        long res = 1;
        for(int i = 1; i <= n;i++){
            res *= n;
        }
        return res;
    }

    //b
    public static long computeXPowerN(int x, int n){
        int res = 1;
        for(int i = 1; i <= n; i++){
            res = res*x;
        }
        return res;
    }

    //c
    public static int countPositive(int[] a){
        int n = a.length;
        int res = 0;
        for(int i = 0; i < n; ++i){
            if(a[i] > 0) ++res;
        }
        return res;
    }

    //d
    public static boolean checkPrime(int n){
        for(int i = 0; i <= n/2; ++i){
            if(n % i == 0) return false;
        }
        return true;
    }

    //e
    public static int gcd(int a,int b){
        while(a != b){
            if(a > b) a = a -b;
            else b = b - a;
        }
        return a;
    }
}



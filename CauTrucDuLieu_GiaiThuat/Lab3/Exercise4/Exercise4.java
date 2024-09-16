package Lab3.Exercise4;

public class Exercise4 {


    // a
    public static int a(int n, int i){
        if(i == 1) return 3;
        return 2*i+1 + a(n, --i);
    }
    
    // b
    public static int b(int n, int i){
        if(i == 1) return 1;
        return factorial(i)+b(n, --i);
    }
    public static int factorial(int n){
        if(n <= 2) return 1;
        return n*factorial(n-1);
    }

    // c
    public static int c(int n, int i){
        if(i == 1) return 1;
        return factorial(i)*c(n, --i);
    }

    // d
    public static int d(int n,int r){
        return factorial(n)/factorial(n-r);
    }
    
    // e
    public static long e(int n){
        if(n == 1){
            return 3;
        }
        return (long) (Math.pow(2, n) + n*n + e(n - 1));
    }
    
    public static void main(String[] args) {
        
    }
}

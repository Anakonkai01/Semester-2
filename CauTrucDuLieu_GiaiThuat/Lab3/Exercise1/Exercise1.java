package Lab3.Exercise1;

class Exercise1{

    // a
    public static long factorial(int n){
        if( n <= 1){
            return 1;
        }
        return n*factorial(n-1);
    } 
    // recursion
    // b
    public static long computeXPowerN(int x, int n){
        if(n <= 1) return x;
        return x*computeXPowerN(x, n - 1);
    }

    // c
    public static int countPositive(int[] a,int i){
        if(a.length - 1 < i){
            return 0;
        }
        if(a[i] > 0) return 1 + countPositive(a, ++i);
        return countPositive(a, ++i);
    }

    // d
    public static boolean checkPrime (int n,int i){
        if( i ==  n/2) return true;
        if(n % i == 0) return false;
        return checkPrime(n, ++i);
    }
    
    // e
    public static int gcd(int a,int b){
        if(a == b){
            return a;
        }
        if(a > b) return gcd(a - b, b);
        else return gcd(a, b - a);
    }

    // 

    public static void main(String[] args) {
        // int[] a = {-1,2,3,4,-2,3,4,6};
        // System.out.println(countPositive(a,0));   
        
        // System.out.println(checkPrime(6, 2));
        System.out.println(gcd(6, 3));
    }
}
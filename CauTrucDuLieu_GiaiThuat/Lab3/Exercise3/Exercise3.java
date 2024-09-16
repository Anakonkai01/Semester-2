package Lab3.Exercise3;

public class Exercise3 {
    
    public static boolean checkPrimeforLoop(int n){
        for(int i = 2; i <= n/2; ++i){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}

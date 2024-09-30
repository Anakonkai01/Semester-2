public class test{


    // static double compute(int n) {
    //     return recur(0, n);
    // }

    // static double recur(double accummulate, int n){
    //     if(n == 0){
    //         return accummulate;
    //     }
    //     return recur(Math.sqrt(n + accummulate),n -1);
    // }
    

    // static double compute(int n){
    //     if(n <= 1) return 1;
    //     return 1/(n * 1.0) + compute(n - 1);
    // }

    static double compute(int n){
        if(n < 1) return 1/2;
        return (n * 1.0)/(n*1.0 + 1) + compute(n-1);
    }


    public static void main(String[] args) {
        int n = 3;
        System.out.println(compute(n));
    }


    
}
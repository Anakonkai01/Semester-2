package Lab6.Test;

public class Main {
    public static int print(int i){
        System.out.println(i);

        if(i < 0){
            return 0;
        }
        System.out.println(i);
        return print(--i);


    }

    public static void main(String[] args) {
        print(10);
    }
}

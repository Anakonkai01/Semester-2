package Lab3.Exercise5;

import java.util.ArrayList;

public class Exercise5 {
    public static int convertDecToBi(int n,ArrayList<Integer> res){
        if(n > 0){
            res.add(n%2);
            convertDecToBi(n/2, res);
        }

        StringBuilder test = new StringBuilder();
        for(int i = res.size() - 1; i >= 0; i--){
            test.append(res.get(i));
        }

        String test1 = test.toString();
        return Integer.parseInt(test1);
    }
    
    public static void main(String[] args) {
        
        System.out.println(convertDecToBi(8, new ArrayList<>()));
    }
}

package Exercise2;

import java.text.CollationElementIterator;
import java.util.*;

class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        double res = s1.getAverageGrade() - s2.getAverageGrade();
        if(res > 0) return 1;
        if(res < 0) return -1;
        return 0;
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        List<Student> myList = new ArrayList<>();
        myList.add(new Student("Nhan", 10, 10, 10));
        myList.add(new Student("THai", 9, 9, 9));
        myList.add(new Student("Khang", 8, 8, 8));


        // System.out.println(myList);
        // Collections.sort(myList, new StudentComparator());
        // System.out.println(myList);

        Comparator<Student> StudentCompare = new Comparator<Student>() {
            @Override 
            public int compare(Student s1, Student s2){
                return Double.compare(s1.getAverageGrade(), s2.getAverageGrade());
            }
        };
        Collections.sort(myList, StudentCompare);
        System.out.println(myList);
    }
}

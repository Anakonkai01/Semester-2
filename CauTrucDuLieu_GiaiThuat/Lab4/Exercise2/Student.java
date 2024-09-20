package Exercise2;

public class Student {
    private String name;
    private double gradeMath;
    private double gradeProgramming;
    private double DSA1;


    
    public Student(String name, double gradeMath, double gradeProgramming, double dSA1) {
        this.name = name;
        this.gradeMath = gradeMath;
        this.gradeProgramming = gradeProgramming;
        DSA1 = dSA1;
    }

    public double getAverageGrade(){
        return (1.0/3 ) *  (this.gradeMath + this.gradeProgramming + this.gradeProgramming);
    }
    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGradeMath() {
        return gradeMath;
    }
    public void setGradeMath(double gradeMath) {
        this.gradeMath = gradeMath;
    }
    public double getGradeProgramming() {
        return gradeProgramming;
    }
    public void setGradeProgramming(double gradeProgramming) {
        this.gradeProgramming = gradeProgramming;
    }
    public double getDSA1() {
        return DSA1;
    }
    public void setDSA1(double dSA1) {
        DSA1 = dSA1;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", gradeMath=" + gradeMath + ", gradeProgramming=" + gradeProgramming
                + ", DSA1=" + DSA1 + ", getAverageGrade()=" + getAverageGrade() + "]";
    }
    

}

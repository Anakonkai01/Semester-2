package Exercise1;


public class Fraction{
    private int numer;
    private int denom;

    public Fraction(){
        this.numer = 0;
        this.denom = 1;
    }

    public Fraction(int x, int y){
        this.numer = x;
        this.denom = y;
    }

    public Fraction(Fraction fraction){
        this.numer = fraction.numer;
        this.denom = fraction.denom;
    }

    @Override
    public String toString() {
        return "Fraction [numer=" + numer + ", denom=" + denom + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }
    
}
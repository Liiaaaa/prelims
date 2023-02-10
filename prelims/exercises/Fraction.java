package prelims.exercises;

public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * constructs a fraction list with numerator set at 0 and denominator at 1
     * */
    public Fraction(){
        numerator = 0;
        denominator = 1;
    }

    /**
     * constructs a fraction list with a given numerator and denominator
     * */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * sets numerator to a given int
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * sets denominator to a given int
     */
    public void setDenominator(int denominator){
        this.denominator = denominator;
    }

    /**
     * returns the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * returns the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDecimal() {
        return (double) numerator/ (double) denominator;
    }

    public Fraction add(Fraction other){
        // Compare if the denominators are different
        // Add if the same
        // else get the denominator and multiply them (LCD)
        // divide LCD to the denominator of fraction 1 and then multiply the quotient to the numerator (X) (X/LCD)
        // divide P to the denominator of fraction 2 and then multiply the quotient to the numerator (Y) (Y/LCD)

        if (this.denominator == other.getDenominator()) {
            return new Fraction(this.numerator + other.getNumerator(), this.denominator);
        }

        int LCD = this.denominator * other.getDenominator();
        int numerator1 = (LCD / this.denominator) * this.numerator;
        Fraction fraction1 = new Fraction(numerator1,LCD);
        int numerator2 = (LCD / other.getDenominator()) * other.getNumerator();
        Fraction fraction2 = new Fraction(numerator2, LCD);
        return fraction1.add(fraction2);
    }

    public void reduce() {
        int GCD = this.computeGCD();
        this.numerator = this.numerator / GCD;
        this.denominator = this.denominator / GCD;
    }

    private int computeGCD() {
        int dividend = this.numerator;
        int divisor = this.denominator;
        if (this.numerator < this.denominator) {
            dividend = this.denominator;
            divisor = this.numerator;
        }

        while (true) {
            int remainder = dividend % divisor;
            if (remainder == 0)
                break;

            dividend = divisor;
            divisor = remainder;

        }
       return divisor;
    }
}



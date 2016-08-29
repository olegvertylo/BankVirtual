package Model;

/**
 * Created by olegvertylo on 04.04.16.
 */
public class Money {

    private double sum;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Money(double sum) {

        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Money{" +
                "sum=" + sum +
                '}';
    }
}

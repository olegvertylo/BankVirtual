package Model;

import javax.persistence.*;

/**
 * Created by olegvertylo on 16.05.16.
 */
@Entity
@Table(name = "CurrencyRate")
public class CurrencyRate {


    @Id
    @GeneratedValue
    @Column(name = "currency", length = 45, nullable = false)
    private Currency currency;

    @Column(name = "rate", length = 10, nullable = false)
    private double rate;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "name", nullable = false)
    private Currency currencyName;

    public CurrencyRate() {
    }

    public CurrencyRate(Currency currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Currency getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(Currency currencyName) {
        this.currencyName = currencyName;
    }
}

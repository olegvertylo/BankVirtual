package Model;

import javax.persistence.*;

/**
 * Created by olegvertylo on 04.04.16.
 */

//just for test

@Entity
@Table(name = "Account")
public class Account implements AccountOperation {

    @Id
    @GeneratedValue
    @Column(name = "number", length = 11, nullable = false)
    private int number;

    @Column(name = "type", length = 35, nullable = false)
    private String type;

    @Column(name = "sum", length = 10, nullable = false)
    private Money sum;

    @Column(name = "currency", length = 15, nullable = false)
    private Currency currency;

    @Column(name = "status", length = 15, nullable = false)
    private AccountStatus status;

    @Column(name = "identingnumber", length = 11, nullable = false)
    private long identingNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "identingnumber", nullable = false)
    private Client client;

    public Account() {
    }

    public Account(String type, int number, Money sum) {
        this.type = type;
        this.number = number;
        this.sum = sum;
    }

    public Account(String type, int number, Money sum, Currency currency, AccountStatus status) {
        this.type = type;
        this.number = number;
        this.sum = sum;
        this.currency = currency;
        this.status = status;
    }

    public Account(String type, int number, Money sum, Currency currency, AccountStatus status, long identingNumber) {
        this.type = type;
        this.number = number;
        this.sum = sum;
        this.currency = currency;
        this.status = status;
        this.identingNumber = identingNumber;
    }


    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public Currency getCurrency() {
        return currency;

    }

    public Money getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Account{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", sum=" + sum +
                ", currency=" + currency +
                ", status=" + status +
                '}';
    }

    public long getIdentingNumber() {
        return identingNumber;
    }

    public AccountStatus getStatus() {
        return status;
    }

    @Override
    public void putMoney(Money money) {
        this.sum.setSum(this.sum.getSum() + money.getSum());


    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public Money takeMoney(Money ammount) {

        this.sum.setSum(this.sum.getSum() - ammount.getSum());
        return ammount;
    }

    public void setIdentingNumber(long identingNumber) {
        this.identingNumber = identingNumber;
    }
}


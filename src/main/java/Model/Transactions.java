package Model;

import javax.persistence.*;

/**
 * Created by olegvertylo on 11.05.16.
 */
@Entity
@Table(name = "Transactions")
public class Transactions {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "identingnumber", length = 11, nullable = false)
    private long identingnumber;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "type", length = 20, nullable = false)
    private String type;

    @Column(name = "currencies", length = 5, nullable = false)
    private Currency currencies;

    @Column(name = "sum", length = 5, nullable = false)
    private Money sum;

    public Transactions() {
    }
}


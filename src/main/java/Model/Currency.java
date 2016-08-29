package Model;

import javax.persistence.*;

/**
 * Created by olegvertylo on 04.04.16.
 */

@Entity
@Table(name = "Currencies")
public enum Currency {
    UAH, USD, EUR;

    @Id
    @GeneratedValue
    @Column(name = "name", length = 5, nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currencies;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "name", nullable = false)
    private Exchange currencyRate;


}

package Model;

/**
 * Created by olegvertylo on 04.04.16.
 */
public interface AccountOperation {

    public void putMoney(Money money);

    public Money takeMoney(Money ammount);


}

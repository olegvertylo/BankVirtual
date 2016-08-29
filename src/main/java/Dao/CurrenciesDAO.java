package Dao;

import Model.Currency;

import java.sql.SQLException;

/**
 * Created by olegvertylo on 11.05.16.
 */
public interface CurrenciesDAO {

    public void updateCurrencyRate(Currency currency, double convertrate) throws SQLException;

    public double getCurrencyRate(Currency currency) throws SQLException;
}

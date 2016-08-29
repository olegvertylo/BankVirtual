package Model;

import java.util.ArrayList;


/**
 * Created by olegvertylo on 04.04.16.
 */

public class Exchange {
    private static ArrayList<CurrencyRate> exchangerate = new ArrayList<>();

    static {

        exchangerate.add(new CurrencyRate(Currency.UAH, 1));
        exchangerate.add(new CurrencyRate(Currency.USD, 0.0402));
        exchangerate.add(new CurrencyRate(Currency.EUR, 0.0360));
    }

    public static double convert(double sum, Currency currency, Currency resultCurrency) {
        int i = 0;
        int j = 0;

        for (int k = 0; k < exchangerate.size(); k++) {
            if (exchangerate.get(k).getCurrency() == currency) {
                i = k;

            }
            if (exchangerate.get(k).getCurrency() == resultCurrency) {
                j = k;
            }

        }
        double hrnsum = 1 / exchangerate.get(i).getRate() * sum;
        sum = hrnsum * exchangerate.get(j).getRate();


        return sum;
    }


}

package Services;

import Dao.AccountsDAO;
import Dao.ClientsDAO;
import Dao.CurrenciesDAO;
import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by olegvertylo on 11.05.16.
 */
public class MyService {

    private AccountsDAO accountsdao;
    private ClientsDAO clientsdao;
    private CurrenciesDAO currenciesdao;

    public AccountsDAO getAccountsdao() {
        return accountsdao;
    }

    public void setAccountsdao(AccountsDAO accountsdao) {
        this.accountsdao = accountsdao;
    }

    public ClientsDAO getClientsdao() {
        return clientsdao;
    }

    public void setClientsdao(ClientsDAO clientsdao) {
        this.clientsdao = clientsdao;
    }

    public CurrenciesDAO getCurrenciesdao() {
        return currenciesdao;
    }

    public void setCurrenciesdao(CurrenciesDAO currenciesdao) {
        this.currenciesdao = currenciesdao;
    }

    public ArrayList<Account> getuserAccout(Client client) throws SQLException {

        return accountsdao.getuserAccout(client);
    }

    public void addAccount(Account account, Client client) throws SQLException {

        accountsdao.addAccount(account, client);

    }

    public void sendMoney(Account account1, Account account2, Money sum) throws SQLException {

        accountsdao.sendMoney(account1, account2, sum);

    }

    public void setAccountStatus(Account account, AccountStatus status) throws SQLException {

        accountsdao.setAccountStatus(account, status);
    }

    public Account getAccountbyNUmber(int numberAcc) throws SQLException {

        return accountsdao.getAccountbyNUmber(numberAcc);
    }

    public Client findClient(long a) throws SQLException {

        return clientsdao.findClient(a);
    }

    public void addClient(Client client) throws SQLException {

        clientsdao.addClient(client);
    }

    public void deleteClient(Client client) throws SQLException {

        clientsdao.deleteClient(client);
    }

    public void updateClient(Client client1, Client client2) throws SQLException {

        clientsdao.updateClient(client1, client2);
    }

    public void updateCurrencyRate(Currency currency, double convertrate) throws SQLException {

        currenciesdao.updateCurrencyRate(currency, convertrate);
    }

    public double getCurrencyRate(Currency currency) throws SQLException {

        return currenciesdao.getCurrencyRate(currency);
    }

}


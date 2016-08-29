package Dao;

import Model.Account;
import Model.AccountStatus;
import Model.Client;
import Model.Money;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by olegvertylo on 11.05.16.
 */
public interface AccountsDAO {

    public ArrayList<Account> getuserAccout(Client client) throws SQLException;

    public void addAccount(Account account, Client client) throws SQLException;

    public void sendMoney(Account account1, Account account2, Money sum) throws SQLException;

    public void setAccountStatus(Account account, AccountStatus status) throws SQLException;

    public Account getAccountbyNUmber(int numberAcc) throws SQLException;

}

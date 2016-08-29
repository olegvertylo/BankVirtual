package DAOJDBCImplementation;

import Dao.AccountsDAO;
import Dao.ClientsDAO;
import Dao.CurrenciesDAO;
import Model.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by olegvertylo on 13.04.16.
 */
public class JdbcWorker implements AccountsDAO, ClientsDAO, CurrenciesDAO {

    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/virtualb_bank";
    static final String DB_USER = "user";
    static final String DB_PASSWORD = "password";

    static Connection conn;
    static ResultSet rs;
    static Statement st;
    static PreparedStatement pst;


    public JdbcWorker() {

        try {
            // create connection
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            st = conn.createStatement();
            initDB();

        } catch (SQLException ex) {
            System.out.println("Error");
        }

    }

    private void initDB() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("CREATE TABLE IF NOT EXISTS Client (`identingnumber` INT(11) NOT NULL,`name` VARCHAR(20) NOT NULL,`surname` VARCHAR(20) NOT NULL,`middlename` VARCHAR(20) NOT NULL,`passportserial` VARCHAR(30) NOT NULL,`passportnumber` INT(11) NOT NULL,`telephone` INT(11) NOT NULL,`password` VARCHAR(30) NOT NULL,PRIMARY KEY (`identingnumber`))");
            st.execute("CREATE TABLE IF NOT EXISTS Account(`number` INT(11) NOT NULL,`type` VARCHAR(35) NOT NULL,`sum` DECIMAL(10,0) NOT NULL,`currency` VARCHAR(15) NOT NULL,`status` VARCHAR(15) NOT NULL,`identingnumber` INT(11) NOT NULL,PRIMARY KEY (`number`))");
            st.execute("CREATE TABLE IF NOT EXISTS CurrencyRate(`name` VARCHAR(45) NOT NULL, `rate` DECIMAL(10,3) NOT NULL,PRIMARY KEY (`name`))");
            st.execute("CREATE TABLE IF NOT EXISTS Currencies (`name` VARCHAR(5) NOT NULL,PRIMARY KEY (`name`))");
            st.execute("CREATE TABLE IF NOT EXISTS Transactions (`date` DATETIME NOT NULL,`type` VARCHAR(20) NOT NULL,`currencies` DECIMAL(5,0) NOT NULL,`sum` DECIMAL(5,0) NOT NULL,`identingnumber` INT(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY (`identingnumber`),INDEX `identingnumber_idx` (`identingnumber` ASC))");

        } finally {
            st.close();
        }

    }

    @Override
    public Client findClient(long a) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Client WHERE `identingnumber`=?");

        try {

            ps.setLong(1, a);
            ps.execute();
            rs = ps.executeQuery();

            Client client = new Client();
            if (rs.next()) {
                client.setIdentingNumber(rs.getLong(1));
                client.setName(rs.getString(2));
                client.setSurname(rs.getString(3));
                client.setMiddleName(rs.getString(4));
                client.setPassportSerial(rs.getString(5));
                client.setPassportNumber(rs.getInt(6));
                client.setTelephone(rs.getInt(7));
                client.setPassword(rs.getString(8));
            }
            return client;
        } finally {
            ps.close();
        }

    }

    @Override
    public void addClient(Client client) throws SQLException {

        try {

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Client (`identingnumber`, `name`, `surname`, `middlename`, `passportserial`, `passportnumber`, `telephone`, `password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setLong(1, client.getIdentingNumber());
            ps.setString(2, client.getName());
            ps.setString(3, client.getSurname());
            ps.setString(4, client.getMiddleName());
            ps.setString(5, client.getPassportSerial());
            ps.setInt(6, client.getPassportNumber());
            ps.setInt(7, client.getTelephone());
            ps.setString(8, client.getPassword());

            ps.execute();

        } catch (SQLException q) {
            System.out.println(q);
        }
    }

    @Override
    public void deleteClient(Client client) throws SQLException {

        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Client WHERE `identingnumber`=?");
            ps.setLong(1, client.getIdentingNumber());
            ps.execute();

        } catch (SQLException q) {
            System.out.println(q);
        }
    }

    @Override
    public void updateClient(Client client1, Client client2) throws SQLException {

        try {

            PreparedStatement ps = conn.prepareStatement("UPDATE Client SET `identingnumber`=?, `name`=?, `surname`=?, `middlename`=?, `passportserial`=?, `passportnumber`=?, `telephone`=?, `password`=? WHERE `identingnumber`=?");
            ps.setLong(1, client1.getIdentingNumber());
            ps.setString(2, client2.getName());
            ps.setString(3, client2.getSurname());
            ps.setString(4, client2.getMiddleName());
            ps.setString(5, client2.getPassportSerial());
            ps.setInt(6, client2.getPassportNumber());
            ps.setInt(7, client2.getTelephone());
            ps.setString(8, client2.getPassword());
            ps.setLong(9, client1.getIdentingNumber());

            ps.execute();
        } catch (SQLException q) {
            System.out.println("Error client update");

        }
    }

    @Override
    public ArrayList<Account> getuserAccout(Client client) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE `identingnumber`=?");
        ArrayList<Account> accountlist = new ArrayList<>();

        try {

            ps.setLong(1, client.getIdentingNumber());
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                int number = rs.getInt(1);
                String type = rs.getString(2);
                double sum = rs.getDouble(3);
                String currency = rs.getString(4);
                String status = rs.getString(5);
                long identingnumber = rs.getLong(6);
                Account account = new Account(type, number, new Money(sum), Currency.valueOf(currency), AccountStatus.valueOf(status), identingnumber);
                accountlist.add(account);

            }

        } catch (SQLException q) {
            System.out.println(q);

        }
        return accountlist;
    }

    @Override
    public void addAccount(Account account, Client client) throws SQLException {

        try {

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Account (`type`, `number`, `sum`, `currency`, `status`, `identingnumber`) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, account.getType());
            ps.setInt(2, account.getNumber());
            ps.setDouble(3, account.getSum().getSum());
            ps.setString(4, account.getCurrency().toString());
            ps.setString(5, account.getStatus().toString());
            ps.setLong(6, client.getIdentingNumber());
            ps.execute();

        } catch (SQLException q) {
            System.out.println(q);

        }
    }

    @Override
    public void sendMoney(Account account1, Account account2, Money sum) throws SQLException {

        try {

            PreparedStatement ps = conn.prepareStatement("UPDATE Account SET `sum`= ? WHERE `number`= ?");
            ps.setDouble(1, account1.getSum().getSum() - sum.getSum());
            ps.setInt(2, account1.getNumber());
            ps.execute();

            double tempSum = Exchange.convert(sum.getSum(), account1.getCurrency(), account2.getCurrency());

            ps = conn.prepareStatement("UPDATE Account SET `sum`= ? WHERE `number`= ?");
            ps.setDouble(1, account2.getSum().getSum() + tempSum);
            ps.setInt(2, account2.getNumber());
            ps.execute();

        } catch (SQLException q) {
            System.out.println(q);

        }
    }

    @Override
    public void setAccountStatus(Account account, AccountStatus status) {
        try {

            PreparedStatement ps = conn.prepareStatement("UPDATE Account SET `status`= ? WHERE `number`= ? ");
            ps.setString(1, status.toString());
            ps.setInt(2, account.getNumber());
            ps.execute();

        } catch (SQLException q) {
            System.out.println(q);
        }
    }

    @Override
    public Account getAccountbyNUmber(int numberAcc) {

        Account account = null;
        try {

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE `number`=?");
            ps.setInt(1, numberAcc);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                int number = rs.getInt(1);
                String type = rs.getString(2);
                double sum = rs.getDouble(3);
                String currency = rs.getString(4);
                String status = rs.getString(5);
                long identingnumber = rs.getLong(6);
                account = new Account(type, number, new Money(sum), Currency.valueOf(currency), AccountStatus.valueOf(status), identingnumber);

            }

        } catch (SQLException q) {
            System.out.println(q);
        }
        return account;
    }

    //for admin
    @Override
    public void updateCurrencyRate(Currency currency, double convertrate) {
        try {

            PreparedStatement ps = conn.prepareStatement("UPDATE CurrencyRate SET `rate`= ? WHERE `name`= ? ");
            ps.setDouble(1, convertrate);
            ps.setString(2, currency.toString());
            ps.execute();


        } catch (SQLException q) {
            System.out.println(q);
        }
    }

    //for admin
    @Override
    public double getCurrencyRate(Currency currency) {

        double rate = 0;
        try {

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CurrencyRate WHERE `name` = ? ");
            ps.setString(1, currency.toString());
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                rate = rs.getDouble(2);
                String name = rs.getString(1);
            }

        } catch (SQLException q) {
            System.out.println(q);

        }
        return rate;
    }

    @Override
    public Client findClientbyNumber(int number) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Client WHERE `telephone`=?");

        try {

            ps.setInt(1, number);
            ps.execute();
            rs = ps.executeQuery();

            Client client = new Client();
            if (rs.next()) {
                client.setIdentingNumber(rs.getLong(1));
                client.setName(rs.getString(2));
                client.setSurname(rs.getString(3));
                client.setMiddleName(rs.getString(4));
                client.setPassportSerial(rs.getString(5));
                client.setPassportNumber(rs.getInt(6));
                client.setTelephone(rs.getInt(7));
                client.setPassword(rs.getString(8));
            }
            return client;
        } finally {
            ps.close();
        }
    }


}


package DAOHibernateImplementation;

import Dao.AccountsDAO;
import Dao.ClientsDAO;
import Dao.CurrenciesDAO;
import Model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by olegvertylo on 16.05.16.
 */

@Repository
public class HibernateWorker implements AccountsDAO, ClientsDAO, CurrenciesDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public Client findClient(long a) {
        Client client = entityManager.find(Client.class, a);
        return client;

    }

    @Override
    public void addClient(Client client) {
        entityManager.getTransaction().begin();

        try {
            entityManager.persist(client);
            entityManager.getTransaction().commit();


        } catch (Exception ex) {
            entityManager.getTransaction().rollback();

        }

    }

    @Override
    public void deleteClient(Client client) {
        entityManager.getTransaction().begin();

        try {
            entityManager.remove(client);
            entityManager.getTransaction().commit();


        } catch (Exception ex) {
            entityManager.getTransaction().rollback();

        }
    }

    @Override
    public void updateClient(Client client1, Client client2) {
        entityManager.merge(client2);


    }

    @Override
    public ArrayList<Account> getuserAccout(Client client) {
        List<Account> list = new ArrayList<Account>();

        Query query;
        query = entityManager.createQuery("select u from Account u where u.identingnumber = :identingnumber", Account.class);
        query.setParameter("identingnumber", client.getIdentingNumber());

        list = (List<Account>) query.getResultList();
        return (ArrayList) list;
    }

    @Override
    public void addAccount(Account account, Client client) {
        Client clientOne = entityManager.find(Client.class, client.getIdentingNumber());
        if (clientOne == null) {
            System.out.println("Uknown client");
            return;
        }
        account.setIdentingNumber(client.getIdentingNumber());

        entityManager.getTransaction().begin();

        try {

            entityManager.persist(account);
            entityManager.getTransaction().commit();


        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public void sendMoney(Account account1, Account account2, Money sum) {
        account1.getSum().setSum(account1.getSum().getSum() - sum.getSum());
        account2.getSum().setSum(account2.getSum().getSum() + sum.getSum());
        entityManager.merge(account1);
        entityManager.merge(account2);


    }

    @Override
    public void setAccountStatus(Account account, AccountStatus status) {

        account.setStatus(status);
        entityManager.merge(account);
    }

    @Override
    public Account getAccountbyNUmber(int numberAcc) {

        Account account = entityManager.find(Account.class, numberAcc);
        return account;
    }

    @Override
    public void updateCurrencyRate(Currency currency, double convertrate) {
        CurrencyRate rate = new CurrencyRate(Currency.EUR, 0.0332);
        entityManager.merge(rate);

    }

    @Override
    public double getCurrencyRate(Currency currency) {
        CurrencyRate rate = entityManager.find(CurrencyRate.class, currency.toString());
        return rate.getRate();

    }

    @Override
    public Client findClientbyNumber(int number) throws SQLException {
        Client client = null;
        try {
            Query query;
            query = entityManager.createQuery("select client from Client client where client.telephone = :telephone", Client.class);
            query.setParameter("telephone", number);
            client = (Client) query.getSingleResult();


        } catch (Exception ex) {
            System.out.println(ex);


        }

        return client;
    }
}

package Dao;

import Model.Client;

import java.sql.SQLException;

/**
 * Created by olegvertylo on 11.05.16.
 */
public interface ClientsDAO {

    public Client findClient(long a) throws SQLException;

    public void addClient(Client client) throws SQLException;

    public void deleteClient(Client client) throws SQLException;

    public void updateClient(Client client1, Client client2) throws SQLException;

    public Client findClientbyNumber(int number) throws SQLException;


}

package Model;

import DAOJDBCImplementation.JdbcWorker;
import Dao.AccountsDAO;
import Dao.ClientsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class MyController {
    static final int DEFAULT_GROUP_ID = -1;

    private JdbcWorker jdbcworker = new JdbcWorker();
    private ClientsDAO clientDao = jdbcworker;
    private AccountsDAO accountDao = jdbcworker;
    private Account account = null;
    private Account accountFrom = null;
    private Account accountTo = null;
    private Client client = null;


    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/bank")
    public String indexBank(Model model) {
        return "index";
    }

    @RequestMapping("/customerRegister")
    public String register(Model model) {
        return "customer-register";
    }


    @RequestMapping(value = "/backToListAccount")
    public ModelAndView backToAccountList() {
        ModelAndView modelAndView = new ModelAndView();
        if (client == null) {
            modelAndView.setViewName("customer-register-error");
            return modelAndView;
        }
        try {
            client.setListAccount(accountDao.getuserAccout(client));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (client.getListAccount().size() <= 0) {
            client.setListAccount(new ArrayList<Account>());
        }
        modelAndView.addObject("list", client.getListAccount());
        modelAndView.setViewName("customer-orders");
        return modelAndView;
    }


    @RequestMapping(value = "/customerOrders", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam(value = "telephone") String telephone, @RequestParam(value = "password") String password) {
        ModelAndView modelAndView = new ModelAndView();

        if (telephone == null || telephone == "") {
            modelAndView.setViewName("customer-register-error");
            return modelAndView;
        }
        int number = Integer.valueOf(telephone);

        if (password == null) {
            modelAndView.setViewName("customer-register-error");
            return modelAndView;
        }
        client = null;
        try {
            client = clientDao.findClientbyNumber(number);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (client == null) {
            modelAndView.setViewName("customer-register-error");
            return modelAndView;
        }

        if (client.getPassword() == null) {
            modelAndView.setViewName("customer-register-error");
            return modelAndView;
        }

        if (client.getPassword().equals(password)) {
            try {
                client.setListAccount(accountDao.getuserAccout(client));
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            if (client.getListAccount().size() <= 0) {
                client.setListAccount(new ArrayList<Account>());
            }

            modelAndView.addObject("list", client.getListAccount());
            modelAndView.setViewName("customer-orders");
        } else {
            modelAndView.setViewName("customer-register-error");

        }


        return modelAndView;
    }

    @RequestMapping(value = "/customerRegisterBegin", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "middleName") String middleName, @RequestParam(value = "passportSerial") String passportSerial, @RequestParam(value = "passportNumber") int passportNumber, @RequestParam(value = "telephone") int telephone, @RequestParam(value = "identingNumber") long identingNumber, @RequestParam(value = "password") String password) {
        client = new Client(name, surname, middleName, passportSerial, passportNumber, telephone, password, identingNumber);
        ModelAndView modelAndView = new ModelAndView();
        Client clientOne = null;

        try {
            clientOne = clientDao.findClientbyNumber(telephone);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (clientOne != null && clientOne.getTelephone() == client.getTelephone()) {
            modelAndView.setViewName("customer-register-error");
        }

        try {
            clientOne = clientDao.findClient(identingNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (clientOne != null && clientOne.getIdentingNumber() == client.getIdentingNumber()) {
            modelAndView.setViewName("customer-register-error");
        }

        try {
            clientDao.addClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        client.setListAccount(new ArrayList<Account>());
        modelAndView.addObject("list", client.getListAccount());
        modelAndView.setViewName("customer-orders");


        return modelAndView;
    }

    @RequestMapping("/customerAccount")
    public ModelAndView customerSettings() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("client", client);
        modelAndView.setViewName("customer-account");
        return modelAndView;

    }

    @RequestMapping(value = "/transferMoney", method = RequestMethod.POST)
    public ModelAndView transfer(@RequestParam(value = "number") int number) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("number", number);
        Account account = null;
        try {
            account = accountDao.getAccountbyNUmber(number);
            accountFrom = account;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("account", account);
        modelAndView.setViewName("customer-order");


        return modelAndView;
    }

    @RequestMapping(value = "/accountTransfer", method = RequestMethod.POST)
    public ModelAndView send(@RequestParam(value = "number") int number) {
        ModelAndView modelAndView = new ModelAndView();
        if (accountFrom != null) {
            modelAndView.addObject("number", accountFrom.getNumber());
            modelAndView.addObject("account", accountFrom);
        }
        accountTo = null;

        try {
            accountTo = accountDao.getAccountbyNUmber(number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (accountTo == null) {
            modelAndView.setViewName("customer-order");
            return modelAndView;
        } else {
            modelAndView.addObject("accountTwo", accountTo);
            modelAndView.setViewName("customer-order");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/moneySend", method = RequestMethod.POST)
    public ModelAndView sendMoney(@RequestParam(value = "ammount") double sum) {
        ModelAndView modelAndView = new ModelAndView();
        if (accountTo == null) {

            modelAndView.addObject("number", accountFrom.getNumber());
            modelAndView.addObject("account", accountFrom);
            modelAndView.setViewName("customer-order");
            return modelAndView;
        }


        try {
            accountDao.sendMoney(accountFrom, accountTo, new Money(sum));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            accountFrom = accountDao.getAccountbyNUmber(accountFrom.getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            accountTo = accountDao.getAccountbyNUmber(accountTo.getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("number", accountFrom.getNumber());
        modelAndView.addObject("account", accountFrom);
        modelAndView.addObject("accountTwo", accountTo);
        modelAndView.setViewName("customer-order");
        return modelAndView;


    }

    @RequestMapping(value = "/clientSettings", method = RequestMethod.POST)
    public ModelAndView clientSettings(@RequestParam(value = "firstname") String firstname, @RequestParam(value = "lastname") String lastname, @RequestParam(value = "middlename") String middlename, @RequestParam(value = "passportSerial") String passportSerial, @RequestParam(value = "passportNumber") int passportNumber, @RequestParam(value = "telephone") int telephone, @RequestParam(value = "password") String password) {
        Client clientOne = new Client(firstname, lastname, middlename, passportSerial, passportNumber, telephone, password, client.getIdentingNumber());
        try {
            clientDao.updateClient(client, clientOne);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        client = clientOne;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("client", client);
        modelAndView.setViewName("customer-account");
        return modelAndView;

    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ModelAndView changePass(@RequestParam(value = "oldPassword") String oldPassword, @RequestParam(value = "newPassword") String newPassword, @RequestParam(value = "confirmPassword") String confirmPassword) {
        ModelAndView modelAndView = new ModelAndView();
        if (client.getPassword().equals(oldPassword)) {
            if (newPassword.equals(confirmPassword)) {
                Client clientOne = new Client(client.getName(), client.getSurname(), client.getMiddleName(), client.getPassportSerial(), client.getPassportNumber(), client.getPassword(), client.getTelephone(), client.getIdentingNumber(), client.getListAccount());
                clientOne.setPassword(newPassword);
                try {
                    clientDao.updateClient(client, clientOne);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                client = clientOne;
            }
        }
        modelAndView.addObject("client", client);
        modelAndView.setViewName("customer-account");
        return modelAndView;


    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam(value = "type") String type, @RequestParam(value = "number") int number, @RequestParam(value = "sum") double sum, @RequestParam(value = "currency") String currency, @RequestParam(value = "status") String status, @RequestParam(value = "identingNumber") long identingNumber) {
        account = new Account(type, number, new Money(sum), Currency.valueOf(currency), AccountStatus.valueOf(status), identingNumber);
        ModelAndView modelAndView = new ModelAndView();
        try {
            accountDao.addAccount(account, client);
            client.getListAccount().add(account);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("list", client.getListAccount());
        modelAndView.setViewName("customer-orders");
        return modelAndView;

    }


    @RequestMapping("/account")
    public String account(Model model) {
        return "create-account";
    }

    @RequestMapping("/status")
    public String status(Model model) {
        return "set-status";
    }


    @RequestMapping(value = "/setNumber", method = RequestMethod.POST)
    public ModelAndView setNumber(@RequestParam(value = "number") int number) {
        try {
            account = accountDao.getAccountbyNUmber(number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("number", account.getNumber());
        modelAndView.addObject("account", account);
        modelAndView.setViewName("set-status");
        return modelAndView;
    }

    @RequestMapping(value = "/setStatus", method = RequestMethod.POST)
    public ModelAndView status(@RequestParam(value = "status") String status) {

        try {
            accountDao.setAccountStatus(account, AccountStatus.valueOf(status));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        account.setStatus(AccountStatus.valueOf(status));
        ModelAndView modelAndView = new ModelAndView();
        try {
            client.setListAccount(accountDao.getuserAccout(client));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (client.getListAccount().size() <= 0) {
            client.setListAccount(new ArrayList<Account>());
        }

        modelAndView.addObject("list", client.getListAccount());
        modelAndView.setViewName("customer-orders");


        return modelAndView;
    }


}
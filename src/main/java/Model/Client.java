package Model;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by olegvertylo on 04.04.16.
 */
@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "identingNumber", length = 11, nullable = false)
    private long identingNumber;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "surname", length = 20, nullable = false)
    private String surname;

    @Column(name = "middlename", length = 20, nullable = false)
    private String middleName;

    @Column(name = "passportserial", length = 30, nullable = false)
    private String passportSerial;

    @Column(name = "passportnumber", length = 11, nullable = false)
    private int passportNumber;

    @Column(name = "telephone", length = 11, nullable = false)
    private int telephone;

    @Column(name = "password", length = 30, nullable = false)
    private String password;


    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "identingnumber", nullable = false)
    private ArrayList<Account> listAccount = new ArrayList<Account>();
    ;


    public Client() {

    }

    public Client(String name, String surname, String middleName, String passportSerial, int passportNumber, String password, int telephone, long identingNumber, ArrayList<Account> listAccount) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.passportSerial = passportSerial;
        this.passportNumber = passportNumber;
        this.password = password;
        this.telephone = telephone;
        this.identingNumber = identingNumber;
        this.listAccount = listAccount;
    }

    public Client(String name, String surname, String middleName, String passportSerial, int passportNumber, int telephone, String password, long identingNumber) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.passportSerial = passportSerial;
        this.passportNumber = passportNumber;
        this.telephone = telephone;
        this.password = password;
        this.identingNumber = identingNumber;
    }

    public void setIdentingNumber(long identingNumber) {
        this.identingNumber = identingNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setListAccount(ArrayList<Account> listAccount) {
        this.listAccount = listAccount;
    }

    public ArrayList<Account> getListAccount() {
        return listAccount;
    }

    public long getIdentingNumber() {
        return identingNumber;


    }

    @Override
    public String
    toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", passportSerial='" + passportSerial + '\'' +
                ", passportNumber=" + passportNumber +
                ", telephone=" + telephone +
                ", password='" + password + '\'' +
                ", identingNumber=" + identingNumber +
                ", listAccount=" + listAccount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return identingNumber == client.identingNumber;

    }

    @Override
    public int hashCode() {
        return (int) (identingNumber ^ (identingNumber >>> 32));
    }


}




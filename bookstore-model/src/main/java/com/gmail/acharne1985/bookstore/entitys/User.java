package com.gmail.acharne1985.bookstore.entitys;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameUser;

    @Column(name = "lastname")
    private String lastnameUser;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (nameUser != null ? !nameUser.equals(user.nameUser) : user.nameUser != null) return false;
        if (lastnameUser != null ? !lastnameUser.equals(user.lastnameUser) : user.lastnameUser != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return address != null ? address.equals(user.address) : user.address == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameUser != null ? nameUser.hashCode() : 0);
        result = 31 * result + (lastnameUser != null ? lastnameUser.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("User [id = ");
        sb.append(id);
        sb.append(", name = ");
        sb.append(nameUser);
        sb.append(", lastmane = ");
        sb.append(lastnameUser);
        sb.append(", login = ");
        sb.append(login);
        sb.append(", password = ");
        sb.append(password);
        sb.append(", address = ");
        sb.append(address);
        sb.append("]");

        return sb.toString();
    }
}

package com.gmail.acharne1985.bookstore.entitys;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameRole;

    @Column(name = "lastname")
    private String lastnameRole;

    @Column(name = "title")
    private String title;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public String getLastnameRole() {
        return lastnameRole;
    }

    public void setLastnameRole(String lastnameRole) {
        this.lastnameRole = lastnameRole;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        if (nameRole != null ? !nameRole.equals(role.nameRole) : role.nameRole != null) return false;
        if (lastnameRole != null ? !lastnameRole.equals(role.lastnameRole) : role.lastnameRole != null) return false;
        return title != null ? title.equals(role.title) : role.title == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameRole != null ? nameRole.hashCode() : 0);
        result = 31 * result + (lastnameRole != null ? lastnameRole.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Role [id = ");
        sb.append(id);
        sb.append(", name = ");
        sb.append(nameRole);
        sb.append(", lastname = ");
        sb.append(lastnameRole);
        sb.append(", title = ");
        sb.append(title);
        sb.append("]");

        return sb.toString();
    }
}

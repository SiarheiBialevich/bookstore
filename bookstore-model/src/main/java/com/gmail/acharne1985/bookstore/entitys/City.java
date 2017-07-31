package com.gmail.acharne1985.bookstore.entitys;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "citys")
public class City extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameCity;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        return nameCity != null ? nameCity.equals(city.nameCity) : city.nameCity == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameCity != null ? nameCity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("City [id = ");
        sb.append(id);
        sb.append(", nameCity = ");
        sb.append(nameCity);
        sb.append("]");

        return sb.toString();
    }
}

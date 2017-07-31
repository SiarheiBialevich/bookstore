package com.gmail.acharne1985.bookstore.entitys;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "diliverys")
public class Dilivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dilivery dilivery = (Dilivery) o;

        if (id != null ? !id.equals(dilivery.id) : dilivery.id != null) return false;
        return shippingMethod != null ? shippingMethod.equals(dilivery.shippingMethod) : dilivery.shippingMethod == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shippingMethod != null ? shippingMethod.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Dilivery [id = ");
        sb.append(id);
        sb.append(", shippingMethod = ");
        sb.append(shippingMethod);
        sb.append(", phone = ");
        sb.append("]");

        return sb.toString();
    }
}

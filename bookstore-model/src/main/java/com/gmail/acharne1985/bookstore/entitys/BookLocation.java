package com.gmail.acharne1985.bookstore.entitys;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "books_locations")
public class BookLocation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "persence")
    private Boolean persence;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPersence() {
        return persence;
    }

    public void setPersence(Boolean persence) {
        this.persence = persence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookLocation that = (BookLocation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return persence != null ? persence.equals(that.persence) : that.persence == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (persence != null ? persence.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("BookLocation [id = ");
        sb.append(id);
        sb.append(", persence = ");
        sb.append(persence);

        return sb.toString();
    }
}

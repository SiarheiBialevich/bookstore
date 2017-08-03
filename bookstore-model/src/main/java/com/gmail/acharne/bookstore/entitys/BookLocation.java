package com.gmail.acharne.bookstore.entitys;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "books_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "locations_id")
    private Location location;

    public BookLocation() {

    }

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookLocation that = (BookLocation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (persence != null ? !persence.equals(that.persence) : that.persence != null) return false;
        if (book != null ? !book.equals(that.book) : that.book != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (persence != null ? persence.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("BookLocation [id = ");
        sb.append(id);
        sb.append(", persence = ");
        sb.append(persence);
        sb.append(", book = ");
        sb.append(book);
        sb.append(", location = ");
        sb.append(location);
        sb.append("]");

        return sb.toString();
    }
}

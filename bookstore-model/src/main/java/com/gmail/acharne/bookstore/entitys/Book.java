package com.gmail.acharne.bookstore.entitys;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "genres_id")
    private Genre genre;

    @ManyToMany
    @JoinTable(name = "books_authors",
        joinColumns = {@JoinColumn(name = "books_id")},
        inverseJoinColumns = {@JoinColumn(name = "authors_id")})
    private List<Author> authors;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookLocation> bookLocations;

    @ManyToMany
    @JoinTable(name = "books_orderings",
            joinColumns = {@JoinColumn(name = "books_id")},
            inverseJoinColumns = {@JoinColumn(name = "orderings_id")})
    private List<Order> orders;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Dilivery> diliveries;

    public Book() {

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<BookLocation> getBookLocations() {
        return bookLocations;
    }

    public void setBookLocations(List<BookLocation> bookLocations) {
        this.bookLocations = bookLocations;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Dilivery> getDiliveries() {
        return diliveries;
    }

    public void setDiliveries(List<Dilivery> diliveries) {
        this.diliveries = diliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (genre != null ? !genre.equals(book.genre) : book.genre != null) return false;
        if (authors != null ? !authors.equals(book.authors) : book.authors != null) return false;
        if (bookLocations != null ? !bookLocations.equals(book.bookLocations) : book.bookLocations != null)
            return false;
        if (orders != null ? !orders.equals(book.orders) : book.orders != null) return false;
        if (diliveries != null ? !diliveries.equals(book.diliveries) : book.diliveries != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (bookLocations != null ? bookLocations.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        result = 31 * result + (diliveries != null ? diliveries.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Books [id = ");
        sb.append(id);
        sb.append(", title = ");
        sb.append(title);
        sb.append(", genre = ");
//        sb.append(genre);
//        sb.append(", authors = ");
//        sb.append(authors);
//        sb.append(", book_locations = ");
//        sb.append(bookLocations);
//        sb.append(", orders = ");
//        sb.append(orders);
//        sb.append(", diliveries = ");
//        sb.append(diliveries);
        sb.append("]");

        return sb.toString();
    }
}

package com.gmail.acharne1985.bookstore.entitys;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "genres")
public class Genre extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameGenre;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private List<Book> books;

    public Genre() {

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != null ? !id.equals(genre.id) : genre.id != null) return false;
        if (nameGenre != null ? !nameGenre.equals(genre.nameGenre) : genre.nameGenre != null) return false;
        if (books != null ? !books.equals(genre.books) : genre.books != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameGenre != null ? nameGenre.hashCode() : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Genre [id = ");
        sb.append(id);
        sb.append(", name = ");
        sb.append(nameGenre);
        sb.append(", books = ");
        sb.append(books);
        sb.append("]");

        return sb.toString();
    }
}

package com.gmail.acharne.bookstore.entitys;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameAuthor;

    @Column(name = "lastname")
    private String lastnameAuthor;

    @Column(name = "d_birth")
    private String birthday;

    @Column(name = "biography")
    private String biography;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getLastnameAuthor() {
        return lastnameAuthor;
    }

    public void setLastnameAuthor(String lastnameAuthor) {
        this.lastnameAuthor = lastnameAuthor;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
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

        Author author = (Author) o;

        if (id != null ? !id.equals(author.id) : author.id != null) return false;
        if (nameAuthor != null ? !nameAuthor.equals(author.nameAuthor) : author.nameAuthor != null) return false;
        if (lastnameAuthor != null ? !lastnameAuthor.equals(author.lastnameAuthor) : author.lastnameAuthor != null)
            return false;
        if (birthday != null ? !birthday.equals(author.birthday) : author.birthday != null) return false;
        if (biography != null ? !biography.equals(author.biography) : author.biography != null) return false;
        if (books != null ? !books.equals(author.books) : author.books != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameAuthor != null ? nameAuthor.hashCode() : 0);
        result = 31 * result + (lastnameAuthor != null ? lastnameAuthor.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (biography != null ? biography.hashCode() : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Authors [id = ");
        sb.append(id);
        sb.append(", name = ");
        sb.append(nameAuthor);
        sb.append(", lastname = ");
        sb.append(lastnameAuthor);
        sb.append(", birthday = ");
        sb.append(birthday);
        sb.append(", biography");
        sb.append(biography);
        sb.append(", books = ");
        sb.append(books);
        sb.append("]");

        return sb.toString();
    }
}

package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"genre", "authors", "bookLocations", "orders", "diliveries"})
@EqualsAndHashCode(callSuper = true, exclude = {"genre", "authors", "bookLocations", "orders", "diliveries"})

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genres_id")
    private Genre genre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "books_authors",
        joinColumns = {@JoinColumn(name = "books_id")},
        inverseJoinColumns = {@JoinColumn(name = "authors_id")})
    private List<Author> authors;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookLocation> bookLocations;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "books_orderings",
            joinColumns = {@JoinColumn(name = "books_id")},
            inverseJoinColumns = {@JoinColumn(name = "orderings_id")})
    private List<Order> orders;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Dilivery> diliveries;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "books")
@EqualsAndHashCode(callSuper = true, exclude = "books")

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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

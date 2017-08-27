package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"books"})
@EqualsAndHashCode(callSuper = true, exclude = {"books"})

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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

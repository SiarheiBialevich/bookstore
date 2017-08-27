package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"books", "user"})
@EqualsAndHashCode(callSuper = true, exclude = {"books", "user"})

@SuppressWarnings("ALL")
@Entity
@Table(name = "orderings")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @ManyToMany(mappedBy = "orders")
    private List<Book> books;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"book", "location"})
@EqualsAndHashCode(callSuper = true, exclude = {"book", "location"})

@SuppressWarnings("ALL")
@Entity
@Table(name = "books_locations")
public class BookLocation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "count")
    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "books_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locations_id")
    private Location location;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

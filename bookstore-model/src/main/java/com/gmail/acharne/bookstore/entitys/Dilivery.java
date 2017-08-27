package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "book")
@EqualsAndHashCode(callSuper = true, exclude = "book")

@SuppressWarnings("ALL")
@Entity
@Table(name = "diliverys")
public class Dilivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "books_id")
    private Book book;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

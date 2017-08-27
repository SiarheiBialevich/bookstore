package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"city", "bookLocations"})
@EqualsAndHashCode(callSuper = true, exclude = {"city", "bookLocations"})

@SuppressWarnings("ALL")
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String titleLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citys_id")
    private City city;

    @OneToMany(mappedBy = "location")
    private List<BookLocation> bookLocations;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

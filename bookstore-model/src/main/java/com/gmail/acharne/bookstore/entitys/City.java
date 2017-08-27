package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "locations")
@EqualsAndHashCode(callSuper = true, exclude = "locations")

@SuppressWarnings("ALL")
@Entity
@Table(name = "citys")
public class City extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameCity;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Location> locations;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

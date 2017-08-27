package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "users")
@EqualsAndHashCode(callSuper = true, exclude = "users")

@SuppressWarnings("ALL")
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameRole;

    @Column(name = "lastname")
    private String lastnameRole;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}

package com.gmail.acharne.bookstore.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"role", "orders"})
@EqualsAndHashCode(callSuper = true, exclude = {"role", "orders"})

@SuppressWarnings("ALL")
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameUser;

    @Column(name = "lastname")
    private String lastnameUser;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}

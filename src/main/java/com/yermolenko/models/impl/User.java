package com.yermolenko.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.yermolenko.models.IUser;

@Entity
@Table(name = "obj_user")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements IUser, Serializable {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    @Column(name = "guid", nullable = false, unique = true)
    private UUID guid;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @NotNull
    //TODO: add constraint
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

}

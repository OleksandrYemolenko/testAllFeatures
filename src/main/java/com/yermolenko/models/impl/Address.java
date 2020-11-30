package com.yermolenko.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

import com.yermolenko.models.IAddress;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "obj_address")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address implements IAddress, Serializable {

    @Id
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAddress;

    @Column(name = "guid", nullable = false, unique = true)
    private UUID guid;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "details", nullable = false, unique = false)
    private String details;
}

package com.yermolenko.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

import com.yermolenko.models.ICharacteristic;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "obj_characteristic")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Characteristic implements ICharacteristic, Serializable {

    @Id
    @Column(name = "id_characteristic")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCharacteristic;

    @Column(name = "guid", nullable = false, unique = true)
    private UUID guid;

    @ManyToOne
    private Item item;

    @OneToOne
    private Filter filter;

    @Column(name = "value", nullable = false, unique = false)
    private String value;
}

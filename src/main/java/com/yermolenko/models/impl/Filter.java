package com.yermolenko.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

import com.yermolenko.models.IFilter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "obj_filter")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Filter implements IFilter, Serializable {

    @Id
    @Column(name = "id_Filter")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFilter;

    @Column(name = "guid", nullable = false, unique = true)
    private UUID guid;

    @OneToOne
    private Category category;

    @OneToOne
    private Characteristic characteristic;

    @Column(name = "value", nullable = false, unique = false)
    private String value;
}

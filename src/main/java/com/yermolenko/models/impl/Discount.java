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

import com.yermolenko.models.IDiscount;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "obj_discount")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Discount implements IDiscount, Serializable {

    @Id
    @Column(name = "id_discount")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDiscount;

    @Column(name = "guid", nullable = false, unique = true)
    private UUID guid;

    @ManyToOne
    private Item item;

    @OneToOne
    private Category category;

    @OneToOne
    private Characteristic characteristic;

    @Column(name = "date_start", nullable = false, unique = false)
    private String dateStart;

    @Column(name = "date_end", nullable = false, unique = false)
    private String dateEnd;

    @Column(name = "value", nullable = false, unique = false)
    private String value;
}

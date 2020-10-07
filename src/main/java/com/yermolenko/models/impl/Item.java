package com.yermolenko.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

import com.yermolenko.models.ICategory;
import com.yermolenko.models.IItem;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "obj_item")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item implements IItem, Serializable {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idItem;

    @ManyToOne
    private Category category;

    @Column(name = "guid", nullable = false, unique = true)
    private UUID guid;

    @Column(name = "details", nullable = false, unique = true)
    private String details;

    @Column(name = "image_url", nullable = false, unique = true)
    private String imageUrl;
}

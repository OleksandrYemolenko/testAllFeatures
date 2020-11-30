package com.yermolenko.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

import com.yermolenko.models.ICategory;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "obj_category")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category implements ICategory, Serializable {

    @Id
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCategory;

    @Column(name = "guid", nullable = false, unique = true)
    private UUID guid;

    @Column(name = "details", nullable = false, unique = true)
    private String details;

    @Column(name = "image_url", nullable = false, unique = true)
    private String imageUrl;

    @Column(name = "id_parent_category", nullable = true, unique = false)
    private int idParentCategory;
}

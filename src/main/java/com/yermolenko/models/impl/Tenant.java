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

import com.yermolenko.models.ITenant;
import com.yermolenko.models.IUser;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "obj_tenant")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tenant implements ITenant, Serializable {

    @Id
    @Column(name = "id_tenant")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTenant;

    @OneToOne
    private User tenantOwner;

    @Column(name = "guid", nullable = false, unique = true)
    private UUID guid;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}

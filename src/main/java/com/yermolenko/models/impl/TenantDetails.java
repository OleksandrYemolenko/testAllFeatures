package com.yermolenko.models.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "o2o_tenant_details")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TenantDetails {

    @Id
    @Column(name = "id_tenant")
    private Long idTenant;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id_tenant", insertable = false, updatable = false)
    private Tenant tenant;

    @Column(name = "description", nullable = false, unique = false)
    private String description;

    @Column(name = "image_url", nullable = false, unique = false)
    private String imageUrl;
}

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
import java.io.Serializable;

import com.yermolenko.models.IUserDetails;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "o2o_user_details")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails implements IUserDetails, Serializable {

    @Id
    @Column(name = "id_user")
    private Long idUser;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @Column(name = "details", nullable = false, unique = false)
    private String details;

    @Column(name = "image_url", nullable = false, unique = false)
    private String imageUrl;
}

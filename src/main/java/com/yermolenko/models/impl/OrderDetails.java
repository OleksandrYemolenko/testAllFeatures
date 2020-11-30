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

import com.yermolenko.models.IOrderDetails;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "o2o_order_details")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails implements IOrderDetails, Serializable {

    @Id
    @Column(name = "id_order")
    private Long idOrder;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id_order", insertable = false, updatable = false)
    private Order order;

    @Column(name = "details", nullable = false, unique = false)
    private String details;

    @Column(name = "date_start", nullable = false, unique = false)
    private String dateStart;

    @Column(name = "date_end", nullable = false, unique = false)
    private String dateEnd;
}

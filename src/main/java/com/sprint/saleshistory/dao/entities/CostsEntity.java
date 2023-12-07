package com.sprint.saleshistory.dao.entities;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "costs")
public class CostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private int prodId;

    @ManyToOne
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id", insertable = false, updatable = false)
    private ProductEntity product;

    @Column(name = "time_id")
    private Date timeId;

    @ManyToOne
    @JoinColumn(name = "promo_id", referencedColumnName = "promo_id", insertable = false, updatable = false)
    private PromoEntity promo;

    @ManyToOne
    @JoinColumn(name = "channel_id", referencedColumnName = "channel_id", insertable = false, updatable = false)
    private ChannelEntity channel;

    @Column(name = "unit_cost", precision = 10, scale = 2)
    private BigDecimal unitCost;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

}
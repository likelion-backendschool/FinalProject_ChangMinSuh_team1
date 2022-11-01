package com.ll.exam.final__2022_10_08.app.order.entity;

import com.ll.exam.final__2022_10_08.app.base.entity.BaseEntity;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class OrderItem extends BaseEntity {

    @ManyToOne(fetch = LAZY)
    private OrderGroup orderGroup;

    @ManyToOne(fetch = LAZY)
    private Product product;
    @Column
    private LocalDateTime payDate;
    @Column
    private Long price;
    @Column
    private Long salePrice;
    @Column
    private Long pgFee;

    @Column
    private Long payPrice;

    @Column
    private Long refundPrice;
    @Column
    private Boolean isPaid;
}

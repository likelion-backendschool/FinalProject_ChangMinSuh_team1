package com.ll.exam.final__2022_10_08.app.cart.entity;

import com.ll.exam.final__2022_10_08.app.base.entity.BaseEntity;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor(access = PROTECTED)
@Table(indexes = @Index(name="unique_memberId_productId", columnList = "member_id, product_id", unique = true))
public class CartItem extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member member;

    @ManyToOne(fetch = LAZY)
    private Product product;
}

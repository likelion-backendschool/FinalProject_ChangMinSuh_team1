package com.ll.exam.final__2022_10_08.app.cash.entity;

import com.ll.exam.final__2022_10_08.app.base.entity.BaseEntity;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;


@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor(access = PROTECTED)
public class CashLog extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member member;

    private Long price;
    private String eventType;
}


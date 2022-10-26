package com.ll.exam.final__2022_10_08.app.postTag.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostTag is a Querydsl query type for PostTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostTag extends EntityPathBase<PostTag> {

    private static final long serialVersionUID = -918089457L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostTag postTag = new QPostTag("postTag");

    public final com.ll.exam.final__2022_10_08.app.base.entity.QBaseEntity _super = new com.ll.exam.final__2022_10_08.app.base.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final com.ll.exam.final__2022_10_08.app.member.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final com.ll.exam.final__2022_10_08.app.post.entity.QPost post;

    public final com.ll.exam.final__2022_10_08.app.postkeyword.entity.QPostKeyword postKeyword;

    public QPostTag(String variable) {
        this(PostTag.class, forVariable(variable), INITS);
    }

    public QPostTag(Path<? extends PostTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostTag(PathMetadata metadata, PathInits inits) {
        this(PostTag.class, metadata, inits);
    }

    public QPostTag(Class<? extends PostTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.ll.exam.final__2022_10_08.app.member.entity.QMember(forProperty("member")) : null;
        this.post = inits.isInitialized("post") ? new com.ll.exam.final__2022_10_08.app.post.entity.QPost(forProperty("post"), inits.get("post")) : null;
        this.postKeyword = inits.isInitialized("postKeyword") ? new com.ll.exam.final__2022_10_08.app.postkeyword.entity.QPostKeyword(forProperty("postKeyword")) : null;
    }

}


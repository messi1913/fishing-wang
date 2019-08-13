package com.ddastudio.fishing.common.audit;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAudit is a Querydsl query type for Audit
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAudit extends BeanPath<Audit> {

    private static final long serialVersionUID = 1271211501L;

    public static final QAudit audit = new QAudit("audit");

    public final DateTimePath<java.time.LocalDateTime> created = createDateTime("created", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updated = createDateTime("updated", java.time.LocalDateTime.class);

    public final StringPath useYn = createString("useYn");

    public QAudit(String variable) {
        super(Audit.class, forVariable(variable));
    }

    public QAudit(Path<? extends Audit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAudit(PathMetadata metadata) {
        super(Audit.class, metadata);
    }

}


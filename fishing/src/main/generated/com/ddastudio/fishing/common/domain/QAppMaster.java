package com.ddastudio.fishing.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppMaster is a Querydsl query type for AppMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppMaster extends EntityPathBase<AppMaster> {

    private static final long serialVersionUID = -1100623820L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppMaster appMaster = new QAppMaster("appMaster");

    public final com.ddastudio.fishing.common.audit.QAudit audit;

    public final DateTimePath<java.time.LocalDateTime> cancelDate = createDateTime("cancelDate", java.time.LocalDateTime.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QAppMaster(String variable) {
        this(AppMaster.class, forVariable(variable), INITS);
    }

    public QAppMaster(Path<? extends AppMaster> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppMaster(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppMaster(PathMetadata metadata, PathInits inits) {
        this(AppMaster.class, metadata, inits);
    }

    public QAppMaster(Class<? extends AppMaster> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.audit = inits.isInitialized("audit") ? new com.ddastudio.fishing.common.audit.QAudit(forProperty("audit")) : null;
    }

}


package com.ddastudio.fishing.common.env;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFishingEnvironment is a Querydsl query type for FishingEnvironment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFishingEnvironment extends EntityPathBase<FishingEnvironment> {

    private static final long serialVersionUID = 1475252421L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFishingEnvironment fishingEnvironment = new QFishingEnvironment("fishingEnvironment");

    public final NumberPath<Integer> appId = createNumber("appId", Integer.class);

    public final com.ddastudio.fishing.common.audit.QAudit audit;

    public final StringPath description = createString("description");

    public final StringPath id = createString("id");

    public final StringPath property = createString("property");

    public QFishingEnvironment(String variable) {
        this(FishingEnvironment.class, forVariable(variable), INITS);
    }

    public QFishingEnvironment(Path<? extends FishingEnvironment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFishingEnvironment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFishingEnvironment(PathMetadata metadata, PathInits inits) {
        this(FishingEnvironment.class, metadata, inits);
    }

    public QFishingEnvironment(Class<? extends FishingEnvironment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.audit = inits.isInitialized("audit") ? new com.ddastudio.fishing.common.audit.QAudit(forProperty("audit")) : null;
    }

}

